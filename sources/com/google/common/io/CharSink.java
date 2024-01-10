package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.stream.Stream;

public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    protected CharSink() {
    }

    public Writer openBufferedStream() throws IOException {
        Writer openStream = openStream();
        return openStream instanceof BufferedWriter ? (BufferedWriter) openStream : new BufferedWriter(openStream);
    }

    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            writer.append(charSequence);
            writer.flush();
            create.close();
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) throws IOException {
        writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        writeLines(iterable.iterator(), str);
    }

    public void writeLines(Stream<? extends CharSequence> stream) throws IOException {
        writeLines(stream, System.getProperty("line.separator"));
    }

    public void writeLines(Stream<? extends CharSequence> stream, String str) throws IOException {
        writeLines((Iterator<? extends CharSequence>) stream.iterator(), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r0 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeLines(java.util.Iterator<? extends java.lang.CharSequence> r3, java.lang.String r4) throws java.io.IOException {
        /*
            r2 = this;
            com.google.common.base.Preconditions.checkNotNull(r4)
            java.io.Writer r0 = r2.openBufferedStream()
        L_0x0007:
            boolean r1 = r3.hasNext()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r3.next()     // Catch:{ all -> 0x0021 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0021 }
            java.io.Writer r1 = r0.append(r1)     // Catch:{ all -> 0x0021 }
            r1.append(r4)     // Catch:{ all -> 0x0021 }
            goto L_0x0007
        L_0x001b:
            if (r0 == 0) goto L_0x0020
            r0.close()
        L_0x0020:
            return
        L_0x0021:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r4 = move-exception
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.CharSink.writeLines(java.util.Iterator, java.lang.String):void");
    }

    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        Closer create = Closer.create();
        try {
            Writer writer = (Writer) create.register(openStream());
            long copy = CharStreams.copy(readable, writer);
            writer.flush();
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
