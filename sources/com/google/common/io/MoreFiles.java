package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.io.ByteSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class MoreFiles {
    private static final SuccessorsFunction<Path> FILE_TREE = new SuccessorsFunction<Path>() {
        public Iterable<Path> successors(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    };

    private MoreFiles() {
    }

    public static ByteSource asByteSource(Path path, OpenOption... openOptionArr) {
        return new PathByteSource(path, openOptionArr);
    }

    private static final class PathByteSource extends ByteSource {
        private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
        private final boolean followLinks;
        private final OpenOption[] options;
        /* access modifiers changed from: private */
        public final Path path;

        private PathByteSource(Path path2, OpenOption... openOptionArr) {
            this.path = (Path) Preconditions.checkNotNull(path2);
            OpenOption[] openOptionArr2 = (OpenOption[]) openOptionArr.clone();
            this.options = openOptionArr2;
            this.followLinks = followLinks(openOptionArr2);
        }

        private static boolean followLinks(OpenOption[] openOptionArr) {
            for (LinkOption linkOption : openOptionArr) {
                if (linkOption == LinkOption.NOFOLLOW_LINKS) {
                    return false;
                }
            }
            return true;
        }

        public InputStream openStream() throws IOException {
            return Files.newInputStream(this.path, this.options);
        }

        private BasicFileAttributes readAttributes() throws IOException {
            return Files.readAttributes(this.path, BasicFileAttributes.class, this.followLinks ? FOLLOW_LINKS : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }

        public Optional<Long> sizeIfKnown() {
            try {
                BasicFileAttributes readAttributes = readAttributes();
                if (readAttributes.isDirectory() || readAttributes.isSymbolicLink()) {
                    return Optional.absent();
                }
                return Optional.of(Long.valueOf(readAttributes.size()));
            } catch (IOException unused) {
                return Optional.absent();
            }
        }

        public long size() throws IOException {
            BasicFileAttributes readAttributes = readAttributes();
            if (readAttributes.isDirectory()) {
                throw new IOException("can't read: is a directory");
            } else if (!readAttributes.isSymbolicLink()) {
                return readAttributes.size();
            } else {
                throw new IOException("can't read: is a symbolic link");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            if (r0 != null) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            r1.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
            r2 = move-exception;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] read() throws java.io.IOException {
            /*
                r4 = this;
                java.nio.file.Path r0 = r4.path
                java.nio.file.OpenOption[] r1 = r4.options
                java.nio.channels.SeekableByteChannel r0 = java.nio.file.Files.newByteChannel(r0, r1)
                java.io.InputStream r1 = java.nio.channels.Channels.newInputStream(r0)     // Catch:{ all -> 0x001a }
                long r2 = r0.size()     // Catch:{ all -> 0x001a }
                byte[] r1 = com.google.common.io.Files.readFile(r1, r2)     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0019
                r0.close()
            L_0x0019:
                return r1
            L_0x001a:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x001c }
            L_0x001c:
                r2 = move-exception
                if (r0 == 0) goto L_0x0027
                r0.close()     // Catch:{ all -> 0x0023 }
                goto L_0x0027
            L_0x0023:
                r0 = move-exception
                r1.addSuppressed(r0)
            L_0x0027:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.PathByteSource.read():byte[]");
        }

        public CharSource asCharSource(Charset charset) {
            if (this.options.length == 0) {
                return new ByteSource.AsCharSource(charset) {
                    public Stream<String> lines() throws IOException {
                        return Files.lines(PathByteSource.this.path, this.charset);
                    }
                };
            }
            return super.asCharSource(charset);
        }

        public String toString() {
            return "MoreFiles.asByteSource(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static ByteSink asByteSink(Path path, OpenOption... openOptionArr) {
        return new PathByteSink(path, openOptionArr);
    }

    private static final class PathByteSink extends ByteSink {
        private final OpenOption[] options;
        private final Path path;

        private PathByteSink(Path path2, OpenOption... openOptionArr) {
            this.path = (Path) Preconditions.checkNotNull(path2);
            this.options = (OpenOption[]) openOptionArr.clone();
        }

        public OutputStream openStream() throws IOException {
            return Files.newOutputStream(this.path, this.options);
        }

        public String toString() {
            return "MoreFiles.asByteSink(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static CharSource asCharSource(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSource(path, openOptionArr).asCharSource(charset);
    }

    public static CharSink asCharSink(Path path, Charset charset, OpenOption... openOptionArr) {
        return asByteSink(path, openOptionArr).asCharSink(charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
        if (r2 != null) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001b, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.collect.ImmutableList<java.nio.file.Path> listFiles(java.nio.file.Path r2) throws java.io.IOException {
        /*
            java.nio.file.DirectoryStream r2 = java.nio.file.Files.newDirectoryStream(r2)     // Catch:{ DirectoryIteratorException -> 0x001c }
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.copyOf(r2)     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x000d
            r2.close()     // Catch:{ DirectoryIteratorException -> 0x001c }
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r1 = move-exception
            if (r2 == 0) goto L_0x001b
            r2.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ DirectoryIteratorException -> 0x001c }
        L_0x001b:
            throw r1     // Catch:{ DirectoryIteratorException -> 0x001c }
        L_0x001c:
            r2 = move-exception
            java.io.IOException r2 = r2.getCause()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.listFiles(java.nio.file.Path):com.google.common.collect.ImmutableList");
    }

    @Deprecated
    public static TreeTraverser<Path> directoryTreeTraverser() {
        return DirectoryTreeTraverser.INSTANCE;
    }

    private static final class DirectoryTreeTraverser extends TreeTraverser<Path> {
        /* access modifiers changed from: private */
        public static final DirectoryTreeTraverser INSTANCE = new DirectoryTreeTraverser();

        private DirectoryTreeTraverser() {
        }

        public Iterable<Path> children(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    }

    public static Traverser<Path> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    /* access modifiers changed from: private */
    public static Iterable<Path> fileTreeChildren(Path path) {
        if (!Files.isDirectory(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            return ImmutableList.of();
        }
        try {
            return listFiles(path);
        } catch (IOException e) {
            throw new DirectoryIteratorException(e);
        }
    }

    public static Predicate<Path> isDirectory(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() {
            public /* synthetic */ boolean test(@NullableDecl T t) {
                return Predicate.CC.$default$test(this, t);
            }

            public boolean apply(Path path) {
                return Files.isDirectory(path, linkOptionArr2);
            }

            public String toString() {
                return "MoreFiles.isDirectory(" + Arrays.toString(linkOptionArr2) + ")";
            }
        };
    }

    private static boolean isDirectory(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) throws IOException {
        return ((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, linkOptionArr)).readAttributes().isDirectory();
    }

    public static Predicate<Path> isRegularFile(LinkOption... linkOptionArr) {
        final LinkOption[] linkOptionArr2 = (LinkOption[]) linkOptionArr.clone();
        return new Predicate<Path>() {
            public /* synthetic */ boolean test(@NullableDecl T t) {
                return Predicate.CC.$default$test(this, t);
            }

            public boolean apply(Path path) {
                return Files.isRegularFile(path, linkOptionArr2);
            }

            public String toString() {
                return "MoreFiles.isRegularFile(" + Arrays.toString(linkOptionArr2) + ")";
            }
        };
    }

    public static boolean equal(Path path, Path path2) throws IOException {
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(path2);
        if (Files.isSameFile(path, path2)) {
            return true;
        }
        ByteSource asByteSource = asByteSource(path, new OpenOption[0]);
        ByteSource asByteSource2 = asByteSource(path2, new OpenOption[0]);
        long longValue = asByteSource.sizeIfKnown().or(0L).longValue();
        long longValue2 = asByteSource2.sizeIfKnown().or(0L).longValue();
        if (longValue == 0 || longValue2 == 0 || longValue == longValue2) {
            return asByteSource.contentEquals(asByteSource2);
        }
        return false;
    }

    public static void touch(Path path) throws IOException {
        Preconditions.checkNotNull(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
        } catch (NoSuchFileException unused) {
            try {
                Files.createFile(path, new FileAttribute[0]);
            } catch (FileAlreadyExistsException unused2) {
            }
        }
    }

    public static void createParentDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Path parent = path.toAbsolutePath().normalize().getParent();
        if (parent != null && !Files.isDirectory(parent, new LinkOption[0])) {
            Files.createDirectories(parent, fileAttributeArr);
            if (!Files.isDirectory(parent, new LinkOption[0])) {
                throw new IOException("Unable to create parent directories of " + path);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r3 = r3.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileExtension(java.nio.file.Path r3) {
        /*
            java.nio.file.Path r3 = r3.getFileName()
            java.lang.String r0 = ""
            if (r3 != 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.String r3 = r3.toString()
            r1 = 46
            int r1 = r3.lastIndexOf(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0017
            goto L_0x001d
        L_0x0017:
            int r1 = r1 + 1
            java.lang.String r0 = r3.substring(r1)
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.getFileExtension(java.nio.file.Path):java.lang.String");
    }

    public static String getNameWithoutExtension(Path path) {
        Path fileName = path.getFileName();
        if (fileName == null) {
            return "";
        }
        String path2 = fileName.toString();
        int lastIndexOf = path2.lastIndexOf(46);
        return lastIndexOf == -1 ? path2 : path2.substring(0, lastIndexOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void deleteRecursively(java.nio.file.Path r5, com.google.common.io.RecursiveDeleteOption... r6) throws java.io.IOException {
        /*
            java.nio.file.Path r0 = getParentPath(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0046
            r2 = 0
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r0)     // Catch:{ IOException -> 0x0039 }
            boolean r3 = r0 instanceof java.nio.file.SecureDirectoryStream     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001c
            r2 = 1
            r3 = r0
            java.nio.file.SecureDirectoryStream r3 = (java.nio.file.SecureDirectoryStream) r3     // Catch:{ all -> 0x002b }
            java.nio.file.Path r4 = r5.getFileName()     // Catch:{ all -> 0x002b }
            java.util.Collection r1 = deleteRecursivelySecure(r3, r4)     // Catch:{ all -> 0x002b }
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0021:
            if (r2 != 0) goto L_0x003f
            checkAllowsInsecure(r5, r6)     // Catch:{ IOException -> 0x0039 }
            java.util.Collection r1 = deleteRecursivelyInsecure(r5)     // Catch:{ IOException -> 0x0039 }
            goto L_0x003f
        L_0x002b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x002d }
        L_0x002d:
            r2 = move-exception
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r6.addSuppressed(r0)     // Catch:{ IOException -> 0x0039 }
        L_0x0038:
            throw r2     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r6 = move-exception
            if (r1 == 0) goto L_0x0045
            r1.add(r6)
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            throwDeleteFailed(r5, r1)
        L_0x0044:
            return
        L_0x0045:
            throw r6
        L_0x0046:
            java.nio.file.FileSystemException r6 = new java.nio.file.FileSystemException
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "can't delete recursively"
            r6.<init>(r5, r1, r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.deleteRecursively(java.nio.file.Path, com.google.common.io.RecursiveDeleteOption[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void deleteDirectoryContents(java.nio.file.Path r3, com.google.common.io.RecursiveDeleteOption... r4) throws java.io.IOException {
        /*
            r0 = 0
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r3)     // Catch:{ IOException -> 0x002d }
            boolean r2 = r1 instanceof java.nio.file.SecureDirectoryStream     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x0011
            r4 = r1
            java.nio.file.SecureDirectoryStream r4 = (java.nio.file.SecureDirectoryStream) r4     // Catch:{ all -> 0x001f }
            java.util.Collection r4 = deleteDirectoryContentsSecure(r4)     // Catch:{ all -> 0x001f }
            goto L_0x0018
        L_0x0011:
            checkAllowsInsecure(r3, r4)     // Catch:{ all -> 0x001f }
            java.util.Collection r4 = deleteDirectoryContentsInsecure(r1)     // Catch:{ all -> 0x001f }
        L_0x0018:
            r0 = r4
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0033
        L_0x001f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r2 = move-exception
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ IOException -> 0x002d }
        L_0x002c:
            throw r2     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r4 = move-exception
            if (r0 == 0) goto L_0x0039
            r0.add(r4)
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            throwDeleteFailed(r3, r0)
        L_0x0038:
            return
        L_0x0039:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.deleteDirectoryContents(java.nio.file.Path, com.google.common.io.RecursiveDeleteOption[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r0 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        throw r6;
     */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Collection<java.io.IOException> deleteRecursivelySecure(java.nio.file.SecureDirectoryStream<java.nio.file.Path> r5, java.nio.file.Path r6) {
        /*
            r0 = 1
            r1 = 0
            java.nio.file.LinkOption[] r2 = new java.nio.file.LinkOption[r0]     // Catch:{ IOException -> 0x003a }
            java.nio.file.LinkOption r3 = java.nio.file.LinkOption.NOFOLLOW_LINKS     // Catch:{ IOException -> 0x003a }
            r4 = 0
            r2[r4] = r3     // Catch:{ IOException -> 0x003a }
            boolean r2 = isDirectory(r5, r6, r2)     // Catch:{ IOException -> 0x003a }
            if (r2 == 0) goto L_0x0036
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]     // Catch:{ IOException -> 0x003a }
            java.nio.file.LinkOption r2 = java.nio.file.LinkOption.NOFOLLOW_LINKS     // Catch:{ IOException -> 0x003a }
            r0[r4] = r2     // Catch:{ IOException -> 0x003a }
            java.nio.file.SecureDirectoryStream r0 = r5.newDirectoryStream(r6, r0)     // Catch:{ IOException -> 0x003a }
            java.util.Collection r1 = deleteDirectoryContentsSecure(r0)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ IOException -> 0x003a }
        L_0x0022:
            if (r1 != 0) goto L_0x0039
            r5.deleteDirectory(r6)     // Catch:{ IOException -> 0x003a }
            goto L_0x0039
        L_0x0028:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002a }
        L_0x002a:
            r6 = move-exception
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r5.addSuppressed(r0)     // Catch:{ IOException -> 0x003a }
        L_0x0035:
            throw r6     // Catch:{ IOException -> 0x003a }
        L_0x0036:
            r5.deleteFile(r6)     // Catch:{ IOException -> 0x003a }
        L_0x0039:
            return r1
        L_0x003a:
            r5 = move-exception
            java.util.Collection r5 = addException(r1, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.deleteRecursivelySecure(java.nio.file.SecureDirectoryStream, java.nio.file.Path):java.util.Collection");
    }

    @NullableDecl
    private static Collection<IOException> deleteDirectoryContentsSecure(SecureDirectoryStream<Path> secureDirectoryStream) {
        Collection<IOException> collection = null;
        try {
            for (Path fileName : secureDirectoryStream) {
                collection = concat(collection, deleteRecursivelySecure(secureDirectoryStream, fileName.getFileName()));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            return addException((Collection<IOException>) null, e.getCause());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        throw r2;
     */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Collection<java.io.IOException> deleteRecursivelyInsecure(java.nio.file.Path r4) {
        /*
            r0 = 1
            r1 = 0
            java.nio.file.LinkOption[] r0 = new java.nio.file.LinkOption[r0]     // Catch:{ IOException -> 0x0031 }
            r2 = 0
            java.nio.file.LinkOption r3 = java.nio.file.LinkOption.NOFOLLOW_LINKS     // Catch:{ IOException -> 0x0031 }
            r0[r2] = r3     // Catch:{ IOException -> 0x0031 }
            boolean r0 = java.nio.file.Files.isDirectory(r4, r0)     // Catch:{ IOException -> 0x0031 }
            if (r0 == 0) goto L_0x002b
            java.nio.file.DirectoryStream r0 = java.nio.file.Files.newDirectoryStream(r4)     // Catch:{ IOException -> 0x0031 }
            java.util.Collection r1 = deleteDirectoryContentsInsecure(r0)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x002b
        L_0x001d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001f }
        L_0x001f:
            r2 = move-exception
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r4.addSuppressed(r0)     // Catch:{ IOException -> 0x0031 }
        L_0x002a:
            throw r2     // Catch:{ IOException -> 0x0031 }
        L_0x002b:
            if (r1 != 0) goto L_0x0030
            java.nio.file.Files.delete(r4)     // Catch:{ IOException -> 0x0031 }
        L_0x0030:
            return r1
        L_0x0031:
            r4 = move-exception
            java.util.Collection r4 = addException(r1, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.MoreFiles.deleteRecursivelyInsecure(java.nio.file.Path):java.util.Collection");
    }

    @NullableDecl
    private static Collection<IOException> deleteDirectoryContentsInsecure(DirectoryStream<Path> directoryStream) {
        Collection<IOException> collection = null;
        try {
            for (Path deleteRecursivelyInsecure : directoryStream) {
                collection = concat(collection, deleteRecursivelyInsecure(deleteRecursivelyInsecure));
            }
            return collection;
        } catch (DirectoryIteratorException e) {
            return addException((Collection<IOException>) null, e.getCause());
        }
    }

    @NullableDecl
    private static Path getParentPath(Path path) {
        Path parent = path.getParent();
        if (parent != null) {
            return parent;
        }
        if (path.getNameCount() == 0) {
            return null;
        }
        return path.getFileSystem().getPath(".", new String[0]);
    }

    private static void checkAllowsInsecure(Path path, RecursiveDeleteOption[] recursiveDeleteOptionArr) throws InsecureRecursiveDeleteException {
        if (!Arrays.asList(recursiveDeleteOptionArr).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
            throw new InsecureRecursiveDeleteException(path.toString());
        }
    }

    private static Collection<IOException> addException(@NullableDecl Collection<IOException> collection, IOException iOException) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(iOException);
        return collection;
    }

    @NullableDecl
    private static Collection<IOException> concat(@NullableDecl Collection<IOException> collection, @NullableDecl Collection<IOException> collection2) {
        if (collection == null) {
            return collection2;
        }
        if (collection2 != null) {
            collection.addAll(collection2);
        }
        return collection;
    }

    private static void throwDeleteFailed(Path path, Collection<IOException> collection) throws FileSystemException {
        FileSystemException fileSystemException = new FileSystemException(path.toString(), (String) null, "failed to delete one or more files; see suppressed exceptions for details");
        for (IOException addSuppressed : collection) {
            fileSystemException.addSuppressed(addSuppressed);
        }
        throw fileSystemException;
    }
}
