package com.trainerfu.android;

public class TextEditedEvent {
    public String info;
    public int requestCode;
    public String text;

    public TextEditedEvent(int i, String str, String str2) {
        this.requestCode = i;
        this.text = str2;
        this.info = str;
    }
}
