package com.facebook.soloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

public class ElfZipFileChannel implements ElfByteChannel {
    @Nullable
    private InputStream mIs;
    private final long mLength;
    private boolean mOpened = true;
    private long mPos = 0;
    private final ZipEntry mZipEntry;
    private final ZipFile mZipFile;

    public ElfZipFileChannel(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        this.mZipFile = zipFile;
        this.mZipEntry = zipEntry;
        this.mLength = zipEntry.getSize();
        InputStream inputStream = this.mZipFile.getInputStream(this.mZipEntry);
        this.mIs = inputStream;
        if (inputStream == null) {
            throw new IOException(this.mZipEntry.getName() + "'s InputStream is null");
        }
    }

    public long position() throws IOException {
        return this.mPos;
    }

    public ElfByteChannel position(long j) throws IOException {
        if (this.mIs == null) {
            throw new IOException(this.mZipEntry.getName() + "'s InputStream is null");
        } else if (j == this.mPos) {
            return this;
        } else {
            long j2 = this.mLength;
            if (j > j2) {
                j = j2;
            }
            long j3 = this.mPos;
            if (j >= j3) {
                this.mIs.skip(j - j3);
            } else {
                this.mIs.close();
                InputStream inputStream = this.mZipFile.getInputStream(this.mZipEntry);
                this.mIs = inputStream;
                if (inputStream != null) {
                    inputStream.skip(j);
                } else {
                    throw new IOException(this.mZipEntry.getName() + "'s InputStream is null");
                }
            }
            this.mPos = j;
            return this;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return read(byteBuffer, this.mPos);
    }

    public int read(ByteBuffer byteBuffer, long j) throws IOException {
        if (this.mIs != null) {
            int remaining = byteBuffer.remaining();
            long j2 = this.mLength - j;
            if (j2 <= 0) {
                return -1;
            }
            int i = (int) j2;
            if (remaining > i) {
                remaining = i;
            }
            position(j);
            if (byteBuffer.hasArray()) {
                this.mIs.read(byteBuffer.array(), 0, remaining);
                byteBuffer.position(byteBuffer.position() + remaining);
            } else {
                byte[] bArr = new byte[remaining];
                this.mIs.read(bArr, 0, remaining);
                byteBuffer.put(bArr, 0, remaining);
            }
            this.mPos += (long) remaining;
            return remaining;
        }
        throw new IOException("InputStream is null");
    }

    public long size() throws IOException {
        return this.mLength;
    }

    public ElfByteChannel truncate(long j) throws IOException {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support truncate");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }

    public boolean isOpen() {
        return this.mOpened;
    }

    public void close() throws IOException {
        InputStream inputStream = this.mIs;
        if (inputStream != null) {
            inputStream.close();
            this.mOpened = false;
        }
    }
}
