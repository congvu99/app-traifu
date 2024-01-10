package com.loopj.android.image;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import java.io.InputStream;

public class ContactImage implements SmartImage {
    private long contactId;

    public ContactImage(long j) {
        this.contactId = j;
    }

    public Bitmap getBitmap(Context context) {
        try {
            InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(context.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.contactId));
            if (openContactPhotoInputStream != null) {
                return BitmapFactory.decodeStream(openContactPhotoInputStream);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
