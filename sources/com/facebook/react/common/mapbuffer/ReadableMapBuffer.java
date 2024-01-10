package com.facebook.react.common.mapbuffer;

import com.facebook.jni.HybridData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class ReadableMapBuffer implements Iterable<MapBufferEntry> {
    private static final int ALIGNMENT = 254;
    private static final int BUCKET_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int INT_SIZE = 4;
    private static final int KEY_SIZE = 2;
    private static final short SHORT_ONE = 1;
    private static final int SHORT_SIZE = 2;
    ByteBuffer mBuffer = null;
    private short mCount = 0;
    private HybridData mHybridData;
    private int mSizeOfData = 0;

    /* access modifiers changed from: private */
    public int getKeyOffsetForBucketIndex(int i) {
        return (i * 10) + 8;
    }

    private native ByteBuffer importByteBuffer();

    private native ByteBuffer importByteBufferAllocateDirect();

    static {
        ReadableMapBufferSoLoader.staticInit();
    }

    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
        readHeader();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            hybridData.resetNative();
        }
    }

    private int getValueOffsetForKey(short s) {
        importByteBufferAndReadHeader();
        int bucketIndexForKey = getBucketIndexForKey(s);
        if (bucketIndexForKey != -1) {
            assertKeyExists(s, bucketIndexForKey);
            return getKeyOffsetForBucketIndex(bucketIndexForKey) + 2;
        }
        throw new IllegalArgumentException("Unable to find key: " + s);
    }

    private int getOffsetForDynamicData() {
        return getKeyOffsetForBucketIndex(this.mCount);
    }

    private int getBucketIndexForKey(short s) {
        short count = (short) (getCount() - 1);
        short s2 = 0;
        while (s2 <= count) {
            short s3 = (short) ((s2 + count) >>> 1);
            short readKey = readKey(getKeyOffsetForBucketIndex(s3));
            if (readKey < s) {
                s2 = (short) (s3 + 1);
            } else if (readKey <= s) {
                return s3;
            } else {
                count = (short) (s3 - 1);
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public short readKey(int i) {
        return this.mBuffer.getShort(i);
    }

    /* access modifiers changed from: private */
    public double readDoubleValue(int i) {
        return this.mBuffer.getDouble(i);
    }

    /* access modifiers changed from: private */
    public int readIntValue(int i) {
        return this.mBuffer.getInt(i);
    }

    /* access modifiers changed from: private */
    public boolean readBooleanValue(int i) {
        return readIntValue(i) == 1;
    }

    /* access modifiers changed from: private */
    public String readStringValue(int i) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.mBuffer.getInt(i);
        int i2 = this.mBuffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i2];
        this.mBuffer.position(offsetForDynamicData + 4);
        this.mBuffer.get(bArr, 0, i2);
        return new String(bArr);
    }

    /* access modifiers changed from: private */
    public ReadableMapBuffer readMapBufferValue(int i) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.mBuffer.getInt(i);
        int i2 = this.mBuffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i2];
        this.mBuffer.position(offsetForDynamicData + 4);
        this.mBuffer.get(bArr, 0, i2);
        return new ReadableMapBuffer(ByteBuffer.wrap(bArr));
    }

    private void readHeader() {
        if (this.mBuffer.getShort() != ALIGNMENT) {
            this.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.mCount = this.mBuffer.getShort();
        this.mSizeOfData = this.mBuffer.getInt();
    }

    public boolean hasKey(short s) {
        return getBucketIndexForKey(s) != -1;
    }

    public short getCount() {
        importByteBufferAndReadHeader();
        return this.mCount;
    }

    public int getInt(short s) {
        return readIntValue(getValueOffsetForKey(s));
    }

    public double getDouble(short s) {
        return readDoubleValue(getValueOffsetForKey(s));
    }

    public String getString(short s) {
        return readStringValue(getValueOffsetForKey(s));
    }

    public boolean getBoolean(short s) {
        return readBooleanValue(getValueOffsetForKey(s));
    }

    public ReadableMapBuffer getMapBuffer(short s) {
        return readMapBufferValue(getValueOffsetForKey(s));
    }

    private ByteBuffer importByteBufferAndReadHeader() {
        ByteBuffer byteBuffer = this.mBuffer;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        this.mBuffer = importByteBuffer();
        readHeader();
        return this.mBuffer;
    }

    private void assertKeyExists(short s, int i) {
        short s2 = this.mBuffer.getShort(getKeyOffsetForBucketIndex(i));
        if (s2 != s) {
            throw new IllegalStateException("Stored key doesn't match parameter - expected: " + s + " - found: " + s2);
        }
    }

    public int hashCode() {
        ByteBuffer importByteBufferAndReadHeader = importByteBufferAndReadHeader();
        importByteBufferAndReadHeader.rewind();
        return importByteBufferAndReadHeader.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer importByteBufferAndReadHeader = importByteBufferAndReadHeader();
        ByteBuffer importByteBufferAndReadHeader2 = ((ReadableMapBuffer) obj).importByteBufferAndReadHeader();
        if (importByteBufferAndReadHeader == importByteBufferAndReadHeader2) {
            return true;
        }
        importByteBufferAndReadHeader.rewind();
        importByteBufferAndReadHeader2.rewind();
        return importByteBufferAndReadHeader.equals(importByteBufferAndReadHeader2);
    }

    public Iterator<MapBufferEntry> iterator() {
        return new Iterator<MapBufferEntry>() {
            short current = 0;
            short last = ((short) (ReadableMapBuffer.this.getCount() - 1));

            public boolean hasNext() {
                return this.current <= this.last;
            }

            public MapBufferEntry next() {
                ReadableMapBuffer readableMapBuffer = ReadableMapBuffer.this;
                short s = this.current;
                this.current = (short) (s + 1);
                return new MapBufferEntry(readableMapBuffer.getKeyOffsetForBucketIndex(s));
            }
        };
    }

    public class MapBufferEntry {
        private final int mBucketOffset;

        private MapBufferEntry(int i) {
            this.mBucketOffset = i;
        }

        public short getKey() {
            return ReadableMapBuffer.this.readKey(this.mBucketOffset);
        }

        public double getDouble(double d) {
            return ReadableMapBuffer.this.readDoubleValue(this.mBucketOffset + 2);
        }

        public int getInt(int i) {
            return ReadableMapBuffer.this.readIntValue(this.mBucketOffset + 2);
        }

        public boolean getBoolean(boolean z) {
            return ReadableMapBuffer.this.readBooleanValue(this.mBucketOffset + 2);
        }

        public String getString() {
            return ReadableMapBuffer.this.readStringValue(this.mBucketOffset + 2);
        }

        public ReadableMapBuffer getReadableMapBuffer() {
            return ReadableMapBuffer.this.readMapBufferValue(this.mBucketOffset + 2);
        }
    }
}
