package com.trainerfu.android;

public class DateSelectedEvent {
    public String date;
    public String info;
    public int requestCode;

    public DateSelectedEvent(int i, String str, String str2) {
        this.requestCode = i;
        this.date = str2;
        this.info = str;
    }
}
