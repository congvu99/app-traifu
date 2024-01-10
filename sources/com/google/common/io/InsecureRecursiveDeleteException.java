package com.google.common.io;

import java.nio.file.FileSystemException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(@NullableDecl String str) {
        super(str, (String) null, "unable to guarantee security of recursive delete");
    }
}
