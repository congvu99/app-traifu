package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: zip.kt */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009d, code lost:
        r4 = readEocdRecord(r12);
        r5 = r12.readUtf8((long) r4.getCommentByteCount());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r12.close();
        r10 = r10 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b3, code lost:
        if (r10 <= r8) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b5, code lost:
        r10 = okio.Okio.buffer(r6.source(r10));
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r11 = (okio.BufferedSource) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cd, code lost:
        if (r11.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cf, code lost:
        r14 = r11.readIntLe();
        r8 = r11.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00db, code lost:
        if (r11.readIntLe() != 1) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00dd, code lost:
        if (r14 != 0) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00df, code lost:
        r7 = okio.Okio.buffer(r6.source(r8));
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r8 = (okio.BufferedSource) r7;
        r11 = r8.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f7, code lost:
        if (r11 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        r4 = readZip64EocdRecord(r8, r4);
        r8 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0127, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0128, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0129, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012c, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0130, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0138, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        r7 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0140, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0143, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0147, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0148, code lost:
        r7 = new java.util.ArrayList();
        r6 = okio.Okio.buffer(r6.source(r4.getCentralDirectoryOffset()));
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r9 = (okio.BufferedSource) r6;
        r10 = r4.getEntryCount();
        r17 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016b, code lost:
        if (0 >= r10) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016d, code lost:
        r17 = r17 + 1;
        r12 = readEntry(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017f, code lost:
        if (r12.getOffset() >= r4.getCentralDirectoryOffset()) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018b, code lost:
        if (r2.invoke(r12).booleanValue() == false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018d, code lost:
        r7.add(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0195, code lost:
        if (r17 < r10) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019f, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a0, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r8);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r7), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01ae, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b3, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b5, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01bc, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(okio.Path r21, okio.FileSystem r22, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r23) throws java.io.IOException {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            okio.FileHandle r3 = r1.openReadOnly(r0)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = 0
            r5 = r4
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6 = r3
            okio.FileHandle r6 = (okio.FileHandle) r6     // Catch:{ all -> 0x01fc }
            r7 = 1
            r8 = 0
            okio.Source r10 = okio.FileHandle.source$default(r6, r8, r7, r4)     // Catch:{ all -> 0x01fc }
            okio.BufferedSource r10 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x01fc }
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ all -> 0x01fc }
            r11 = r4
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x01fc }
            r12 = r10
            okio.BufferedSource r12 = (okio.BufferedSource) r12     // Catch:{ all -> 0x01f3 }
            int r12 = r12.readIntLe()     // Catch:{ all -> 0x01f3 }
            java.lang.String r13 = " but was "
            r14 = 101010256(0x6054b50, float:2.506985E-35)
            r15 = 67324752(0x4034b50, float:1.5433558E-36)
            if (r12 == r15) goto L_0x0073
            if (r12 != r14) goto L_0x004e
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01f3 }
            java.lang.String r1 = "unsupported zip: empty"
            r0.<init>(r1)     // Catch:{ all -> 0x01f3 }
            throw r0     // Catch:{ all -> 0x01f3 }
        L_0x004e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01f3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            r1.<init>()     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = "not a zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = getHex(r15)     // Catch:{ all -> 0x01f3 }
            r1.append(r2)     // Catch:{ all -> 0x01f3 }
            r1.append(r13)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = getHex(r12)     // Catch:{ all -> 0x01f3 }
            r1.append(r2)     // Catch:{ all -> 0x01f3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01f3 }
            r0.<init>(r1)     // Catch:{ all -> 0x01f3 }
            throw r0     // Catch:{ all -> 0x01f3 }
        L_0x0073:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01f3 }
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ all -> 0x01fc }
            long r10 = r6.size()     // Catch:{ all -> 0x01fc }
            r12 = 22
            r16 = r5
            long r4 = (long) r12     // Catch:{ all -> 0x01fc }
            long r10 = r10 - r4
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x01df
            r4 = 65536(0x10000, double:3.2379E-319)
            long r4 = r10 - r4
            long r4 = java.lang.Math.max(r4, r8)     // Catch:{ all -> 0x01fc }
        L_0x008f:
            okio.Source r12 = r6.source(r10)     // Catch:{ all -> 0x01fc }
            okio.BufferedSource r12 = okio.Okio.buffer((okio.Source) r12)     // Catch:{ all -> 0x01fc }
            int r15 = r12.readIntLe()     // Catch:{ all -> 0x01da }
            if (r15 != r14) goto L_0x01bd
            okio.internal.EocdRecord r4 = readEocdRecord(r12)     // Catch:{ all -> 0x01da }
            int r5 = r4.getCommentByteCount()     // Catch:{ all -> 0x01da }
            long r14 = (long) r5     // Catch:{ all -> 0x01da }
            java.lang.String r5 = r12.readUtf8(r14)     // Catch:{ all -> 0x01da }
            r12.close()     // Catch:{ all -> 0x01fc }
            r12 = 20
            long r14 = (long) r12     // Catch:{ all -> 0x01fc }
            long r10 = r10 - r14
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x0148
            okio.Source r10 = r6.source(r10)     // Catch:{ all -> 0x01fc }
            okio.BufferedSource r10 = okio.Okio.buffer((okio.Source) r10)     // Catch:{ all -> 0x01fc }
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch:{ all -> 0x01fc }
            r11 = 0
            r12 = r11
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch:{ all -> 0x01fc }
            r11 = r10
            okio.BufferedSource r11 = (okio.BufferedSource) r11     // Catch:{ all -> 0x013f }
            int r14 = r11.readIntLe()     // Catch:{ all -> 0x013f }
            r15 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r14 != r15) goto L_0x0139
            int r14 = r11.readIntLe()     // Catch:{ all -> 0x013f }
            long r8 = r11.readLongLe()     // Catch:{ all -> 0x013f }
            int r11 = r11.readIntLe()     // Catch:{ all -> 0x013f }
            if (r11 != r7) goto L_0x0131
            if (r14 != 0) goto L_0x0131
            okio.Source r7 = r6.source(r8)     // Catch:{ all -> 0x013f }
            okio.BufferedSource r7 = okio.Okio.buffer((okio.Source) r7)     // Catch:{ all -> 0x013f }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x013f }
            r8 = 0
            r9 = r8
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x013f }
            r8 = r7
            okio.BufferedSource r8 = (okio.BufferedSource) r8     // Catch:{ all -> 0x0128 }
            int r11 = r8.readIntLe()     // Catch:{ all -> 0x0128 }
            r14 = 101075792(0x6064b50, float:2.525793E-35)
            if (r11 != r14) goto L_0x0103
            okio.internal.EocdRecord r4 = readZip64EocdRecord(r8, r4)     // Catch:{ all -> 0x0128 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0128 }
            kotlin.io.CloseableKt.closeFinally(r7, r9)     // Catch:{ all -> 0x013f }
            goto L_0x0139
        L_0x0103:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r1.<init>()     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = getHex(r14)     // Catch:{ all -> 0x0128 }
            r1.append(r2)     // Catch:{ all -> 0x0128 }
            r1.append(r13)     // Catch:{ all -> 0x0128 }
            java.lang.String r2 = getHex(r11)     // Catch:{ all -> 0x0128 }
            r1.append(r2)     // Catch:{ all -> 0x0128 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0128 }
            r0.<init>(r1)     // Catch:{ all -> 0x0128 }
            throw r0     // Catch:{ all -> 0x0128 }
        L_0x0128:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x012b }
        L_0x012b:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r7, r1)     // Catch:{ all -> 0x013f }
            throw r2     // Catch:{ all -> 0x013f }
        L_0x0131:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x013f }
            throw r0     // Catch:{ all -> 0x013f }
        L_0x0139:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x013f }
            kotlin.io.CloseableKt.closeFinally(r10, r12)     // Catch:{ all -> 0x01fc }
            goto L_0x0148
        L_0x013f:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0142 }
        L_0x0142:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r10, r1)     // Catch:{ all -> 0x01fc }
            throw r2     // Catch:{ all -> 0x01fc }
        L_0x0148:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x01fc }
            r7.<init>()     // Catch:{ all -> 0x01fc }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x01fc }
            long r8 = r4.getCentralDirectoryOffset()     // Catch:{ all -> 0x01fc }
            okio.Source r6 = r6.source(r8)     // Catch:{ all -> 0x01fc }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r6)     // Catch:{ all -> 0x01fc }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x01fc }
            r8 = 0
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x01fc }
            r9 = r6
            okio.BufferedSource r9 = (okio.BufferedSource) r9     // Catch:{ all -> 0x01b4 }
            long r10 = r4.getEntryCount()     // Catch:{ all -> 0x01b4 }
            r17 = 0
            int r12 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x01a0
        L_0x016d:
            r12 = 1
            long r17 = r17 + r12
            okio.internal.ZipEntry r12 = readEntry(r9)     // Catch:{ all -> 0x01b4 }
            long r13 = r12.getOffset()     // Catch:{ all -> 0x01b4 }
            long r19 = r4.getCentralDirectoryOffset()     // Catch:{ all -> 0x01b4 }
            int r15 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r15 >= 0) goto L_0x0198
            java.lang.Object r13 = r2.invoke(r12)     // Catch:{ all -> 0x01b4 }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x01b4 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x01b4 }
            if (r13 == 0) goto L_0x0193
            r13 = r7
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ all -> 0x01b4 }
            r13.add(r12)     // Catch:{ all -> 0x01b4 }
        L_0x0193:
            int r12 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x016d
            goto L_0x01a0
        L_0x0198:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01b4 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x01b4 }
            throw r0     // Catch:{ all -> 0x01b4 }
        L_0x01a0:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b4 }
            kotlin.io.CloseableKt.closeFinally(r6, r8)     // Catch:{ all -> 0x01fc }
            java.util.Map r2 = buildIndex(r7)     // Catch:{ all -> 0x01fc }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x01fc }
            r4.<init>(r0, r1, r2, r5)     // Catch:{ all -> 0x01fc }
            r9 = r16
            kotlin.io.CloseableKt.closeFinally(r3, r9)
            return r4
        L_0x01b4:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01b7 }
        L_0x01b7:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ all -> 0x01fc }
            throw r2     // Catch:{ all -> 0x01fc }
        L_0x01bd:
            r17 = r8
            r9 = r16
            r8 = 0
            r12.close()     // Catch:{ all -> 0x01fc }
            r15 = -1
            long r10 = r10 + r15
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x01d2
            r16 = r9
            r8 = r17
            goto L_0x008f
        L_0x01d2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x01fc }
            throw r0     // Catch:{ all -> 0x01fc }
        L_0x01da:
            r0 = move-exception
            r12.close()     // Catch:{ all -> 0x01fc }
            throw r0     // Catch:{ all -> 0x01fc }
        L_0x01df:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = "not a zip: size="
            long r4 = r6.size()     // Catch:{ all -> 0x01fc }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01fc }
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)     // Catch:{ all -> 0x01fc }
            r0.<init>(r1)     // Catch:{ all -> 0x01fc }
            throw r0     // Catch:{ all -> 0x01fc }
        L_0x01f3:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01f6 }
        L_0x01f6:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r10, r1)     // Catch:{ all -> 0x01fc }
            throw r2     // Catch:{ all -> 0x01fc }
        L_0x01fc:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01ff }
        L_0x01ff:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Map<Path, ZipEntry> linkedHashMap = new LinkedHashMap<>();
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new ZipKt$buildIndex$$inlined$sortedBy$1())) {
            if (linkedHashMap.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = linkedHashMap.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry5 = zipEntry3;
                    linkedHashMap.put(parent, zipEntry5);
                    zipEntry5.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry5;
                }
            }
        }
        return linkedHashMap;
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & UShort.MAX_VALUE, bufferedSource.readShortLe() & UShort.MAX_VALUE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    String str = readUtf8;
                    long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? ((long) 8) + 0 : 0;
                    if (longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    long j2 = j;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Long l = dosDateTimeToEpochMillis;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    short s = readShortLe2;
                    String str2 = str;
                    Ref.LongRef longRef4 = longRef3;
                    short s2 = readShortLe5;
                    readExtra(bufferedSource2, readShortLe4, new ZipKt$readEntry$1(booleanRef, j2, longRef2, bufferedSource, longRef, longRef4));
                    if (j2 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(str3), StringsKt.endsWith$default(str3, "/", false, 2, (Object) null), bufferedSource2.readUtf8((long) s2), readIntLe2, longRef.element, longRef2.element, s, l, longRef4.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException(Intrinsics.stringPlus("unsupported zip: too many bytes processed for ", Integer.valueOf(readShortLe)));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fileMetadata == null ? null : fileMetadata.getLastModifiedAtMillis();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.stringPlus("0x", num);
    }
}
