package net.hockeyapp.android.listeners;

import net.hockeyapp.android.StringListener;
import net.hockeyapp.android.tasks.DownloadFileTask;

public abstract class DownloadFileListener extends StringListener {
    public void downloadFailed(DownloadFileTask downloadFileTask, Boolean bool) {
    }

    public void downloadSuccessful(DownloadFileTask downloadFileTask) {
    }
}
