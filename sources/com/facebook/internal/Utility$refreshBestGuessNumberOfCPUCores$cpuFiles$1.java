package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "fileName", "", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: Utility.kt */
final class Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1 implements FilenameFilter {
    public static final Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1 INSTANCE = new Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1();

    Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1() {
    }

    public final boolean accept(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }
}
