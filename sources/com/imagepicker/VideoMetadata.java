package com.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoMetadata extends Metadata {
    private int bitrate;
    private int duration;

    public VideoMetadata(Uri uri, Context context) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, uri);
        Bitmap bitmap = getBitmap(uri, context, mediaMetadataRetriever);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(20);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(5);
        if (extractMetadata != null) {
            this.duration = Math.round(Float.parseFloat(extractMetadata)) / 1000;
        }
        if (extractMetadata2 != null) {
            this.bitrate = Integer.parseInt(extractMetadata2);
        }
        if (extractMetadata3 != null) {
            this.datetime = getDateTimeInUTC(extractMetadata3.substring(0, extractMetadata3.indexOf(".")).replace(ExifInterface.GPS_DIRECTION_TRUE, " "), "yyyyMMdd HHmmss");
        }
        if (bitmap != null) {
            this.width = bitmap.getWidth();
            this.height = bitmap.getHeight();
        }
        try {
            mediaMetadataRetriever.release();
        } catch (IOException e) {
            Log.e("VideoMetadata", "IO error releasing metadataRetriever", e);
        }
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getDateTime() {
        return this.datetime;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private Bitmap getBitmap(Uri uri, Context context, MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            mediaMetadataRetriever.setDataSource(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()).getFD());
            return mediaMetadataRetriever.getFrameAtTime();
        } catch (IOException | RuntimeException e) {
            Log.e("RNIP", "Could not retrieve width and height from video: " + e.getMessage());
            return null;
        }
    }
}
