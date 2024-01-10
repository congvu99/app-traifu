package net.hockeyapp.android;

public abstract class CrashManagerListener extends StringListener {
    public String getContact() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public String getUserID() {
        return null;
    }

    public boolean ignoreDefaultHandler() {
        return false;
    }

    public boolean includeDeviceData() {
        return true;
    }

    public void onConfirmedCrashesFound() {
    }

    public boolean onCrashesFound() {
        return false;
    }

    public void onCrashesNotSent() {
    }

    public void onCrashesSent() {
    }

    public void onNewCrashesFound() {
    }

    public void onUserDeniedCrashes() {
    }

    public boolean shouldAutoUploadCrashes() {
        return false;
    }
}
