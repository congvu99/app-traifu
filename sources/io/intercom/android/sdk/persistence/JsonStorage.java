package io.intercom.android.sdk.persistence;

import com.google.gson.Gson;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.IoUtils;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private static final Twig TWIG = LumberMill.getLogger();
    private final Gson gson;

    public interface LoadFailureHandler {
        public static final LoadFailureHandler NONE = new LoadFailureHandler() {
            public void onLoadFailed(File file, Exception exc) {
            }
        };

        void onLoadFailed(File file, Exception exc);
    }

    public interface LoadHandler<T> {
        void onLoad(T t);
    }

    public JsonStorage(Gson gson2) {
        this.gson = gson2;
    }

    public <T> void loadThenDelete(File file, Class<T> cls, LoadHandler<T> loadHandler) {
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                loadHandler.onLoad(this.gson.fromJson((Reader) fileReader2, cls));
                IoUtils.safelyDelete(file);
                IoUtils.closeQuietly(fileReader2);
            } catch (Exception unused) {
                fileReader = fileReader2;
                IoUtils.safelyDelete(file);
                IoUtils.closeQuietly(fileReader);
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                IoUtils.safelyDelete(file);
                IoUtils.closeQuietly(fileReader);
                throw th;
            }
        } catch (Exception unused2) {
            IoUtils.safelyDelete(file);
            IoUtils.closeQuietly(fileReader);
        } catch (Throwable th2) {
            th = th2;
            IoUtils.safelyDelete(file);
            IoUtils.closeQuietly(fileReader);
            throw th;
        }
    }

    public <T> void loadFilesInDirectory(File file, Class<T> cls, LoadHandler<List<T>> loadHandler) {
        loadFilesInDirectory(file, cls, loadHandler, LoadFailureHandler.NONE);
    }

    public <T> void loadFilesInDirectory(File file, Class<T> cls, LoadHandler<List<T>> loadHandler, LoadFailureHandler loadFailureHandler) {
        FileReader fileReader;
        Exception e;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList(listFiles.length);
            FileReader fileReader2 = null;
            for (File file2 : listFiles) {
                try {
                    fileReader = new FileReader(file2);
                    try {
                        arrayList.add(this.gson.fromJson((Reader) fileReader, cls));
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    Exception exc = e3;
                    fileReader = fileReader2;
                    e = exc;
                    try {
                        loadFailureHandler.onLoadFailed(file2, e);
                        IoUtils.closeQuietly(fileReader);
                        fileReader2 = fileReader;
                    } catch (Throwable th) {
                        th = th;
                        fileReader2 = fileReader;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeQuietly(fileReader2);
                    throw th;
                }
                IoUtils.closeQuietly(fileReader);
                fileReader2 = fileReader;
            }
            loadHandler.onLoad(arrayList);
        }
    }

    public int getDirectoryFileCount(File file) {
        String[] list = file.list();
        if (list == null) {
            return 0;
        }
        return list.length;
    }

    public void saveToFileAsJson(Object obj, File file) {
        FileWriter fileWriter = null;
        try {
            if (file.exists()) {
                if (!file.delete()) {
                    throw new RuntimeException("Couldn't delete existing file at " + file.getAbsolutePath());
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    throw new RuntimeException("Couldn't create missing parent dir at " + parentFile.getAbsolutePath());
                }
            }
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                this.gson.toJson(obj, (Appendable) fileWriter2);
                IoUtils.closeQuietly(fileWriter2);
            } catch (Exception e) {
                e = e;
                fileWriter = fileWriter2;
                try {
                    Twig twig = TWIG;
                    twig.internal("Couldn't save file to disk: " + e);
                    IoUtils.closeQuietly(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter = fileWriter2;
                IoUtils.closeQuietly(fileWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Twig twig2 = TWIG;
            twig2.internal("Couldn't save file to disk: " + e);
            IoUtils.closeQuietly(fileWriter);
        }
    }
}
