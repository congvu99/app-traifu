package com.takeoffandroid.urllinkview.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinkSourceContent {
    private String cannonicalUrl = "";
    private String description = "";
    private String finalUrl = "";
    private String htmlCode = "";
    private List<String> images = new ArrayList();
    private HashMap<String, String> metaTags = new HashMap<>();
    private String raw = "";
    private boolean success = false;
    private String title = "";
    private String url = "";
    private String[] urlData = new String[2];

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getHtmlCode() {
        return this.htmlCode;
    }

    public void setHtmlCode(String str) {
        this.htmlCode = str;
    }

    public String getRaw() {
        return this.raw;
    }

    public void setRaw(String str) {
        this.raw = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getFinalUrl() {
        return this.finalUrl;
    }

    public void setFinalUrl(String str) {
        this.finalUrl = str;
    }

    public String getCannonicalUrl() {
        return this.cannonicalUrl;
    }

    public void setCannonicalUrl(String str) {
        this.cannonicalUrl = str;
    }

    public HashMap<String, String> getMetaTags() {
        return this.metaTags;
    }

    public void setMetaTags(HashMap<String, String> hashMap) {
        this.metaTags = hashMap;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public String[] getUrlData() {
        return this.urlData;
    }

    public void setUrlData(String[] strArr) {
        this.urlData = strArr;
    }
}
