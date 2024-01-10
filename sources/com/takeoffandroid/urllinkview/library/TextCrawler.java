package com.takeoffandroid.urllinkview.library;

import android.os.AsyncTask;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TextCrawler {
    public static final int ALL = -1;
    public static final int NONE = -2;
    private final String HTTPS_PROTOCOL = "https://";
    private final String HTTP_PROTOCOL = "http://";
    /* access modifiers changed from: private */
    public LinkViewCallback callback;

    public void makePreview(LinkViewCallback linkViewCallback, String str) {
        this.callback = linkViewCallback;
        new GetCode(-1).execute(new String[]{str});
    }

    public void makePreview(LinkViewCallback linkViewCallback, String str, int i) {
        this.callback = linkViewCallback;
        new GetCode(i).execute(new String[]{str});
    }

    public class GetCode extends AsyncTask<String, Void, Void> {
        private int imageQuantity;
        private LinkSourceContent linkSourceContent = new LinkSourceContent();
        private ArrayList<String> urls;

        public GetCode(int i) {
            this.imageQuantity = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (TextCrawler.this.callback != null) {
                TextCrawler.this.callback.onBeforeLoading();
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            if (TextCrawler.this.callback != null) {
                TextCrawler.this.callback.onAfterLoading(this.linkSourceContent, isNull());
            }
            super.onPostExecute(voidR);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            ArrayList<String> matches = Utils.matches(strArr[0]);
            this.urls = matches;
            if (matches.size() > 0) {
                this.linkSourceContent.setFinalUrl(TextCrawler.this.unshortenUrl(TextCrawler.extendedTrim(this.urls.get(0))));
            } else {
                this.linkSourceContent.setFinalUrl("");
            }
            if (!this.linkSourceContent.getFinalUrl().equals("")) {
                if (!TextCrawler.this.isImage(this.linkSourceContent.getFinalUrl()) || this.linkSourceContent.getFinalUrl().contains("dropbox")) {
                    try {
                        Document document = Jsoup.connect(this.linkSourceContent.getFinalUrl()).userAgent("Mozilla").get();
                        this.linkSourceContent.setHtmlCode(TextCrawler.extendedTrim(document.toString()));
                        HashMap access$300 = TextCrawler.this.getMetaTags(this.linkSourceContent.getHtmlCode());
                        this.linkSourceContent.setMetaTags(access$300);
                        this.linkSourceContent.setTitle((String) access$300.get("title"));
                        this.linkSourceContent.setDescription((String) access$300.get("description"));
                        if (this.linkSourceContent.getTitle().equals("")) {
                            String pregMatch = Utils.pregMatch(this.linkSourceContent.getHtmlCode(), Constants.TITLE_PATTERN, 2);
                            if (!pregMatch.equals("")) {
                                this.linkSourceContent.setTitle(TextCrawler.this.htmlDecode(pregMatch));
                            }
                        }
                        if (this.linkSourceContent.getDescription().equals("")) {
                            this.linkSourceContent.setDescription(TextCrawler.this.crawlCode(this.linkSourceContent.getHtmlCode()));
                        }
                        this.linkSourceContent.setDescription(this.linkSourceContent.getDescription().replaceAll(Constants.SCRIPT_PATTERN, ""));
                        if (this.imageQuantity != -2) {
                            if (!((String) access$300.get("image")).equals("")) {
                                this.linkSourceContent.getImages().add(access$300.get("image"));
                            } else {
                                this.linkSourceContent.setImages(TextCrawler.this.getImages(document, this.imageQuantity));
                            }
                        }
                        this.linkSourceContent.setSuccess(true);
                    } catch (Exception unused) {
                        this.linkSourceContent.setSuccess(false);
                    }
                } else {
                    this.linkSourceContent.setSuccess(true);
                    this.linkSourceContent.getImages().add(this.linkSourceContent.getFinalUrl());
                    this.linkSourceContent.setTitle("");
                    this.linkSourceContent.setDescription("");
                }
            }
            this.linkSourceContent.setUrl(this.linkSourceContent.getFinalUrl().split("&")[0]);
            LinkSourceContent linkSourceContent2 = this.linkSourceContent;
            linkSourceContent2.setCannonicalUrl(TextCrawler.this.cannonicalPage(linkSourceContent2.getFinalUrl()));
            LinkSourceContent linkSourceContent3 = this.linkSourceContent;
            linkSourceContent3.setDescription(TextCrawler.this.stripTags(linkSourceContent3.getDescription()));
            return null;
        }

        public boolean isNull() {
            return !this.linkSourceContent.isSuccess() && TextCrawler.extendedTrim(this.linkSourceContent.getHtmlCode()).equals("") && !TextCrawler.this.isImage(this.linkSourceContent.getFinalUrl());
        }
    }

    private String getTagContent(String str, String str2) {
        String str3;
        String str4 = "<" + str + "(.*?)>(.*?)</" + str + ">";
        List<String> pregMatchAll = Utils.pregMatchAll(str2, str4, 2);
        int size = pregMatchAll.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str3 = "";
                break;
            }
            String stripTags = stripTags(pregMatchAll.get(i));
            if (stripTags.length() >= 120) {
                str3 = extendedTrim(stripTags);
                break;
            }
            i++;
        }
        if (str3.equals("")) {
            str3 = extendedTrim(Utils.pregMatch(str2, str4, 2));
        }
        return htmlDecode(str3.replaceAll("&nbsp;", ""));
    }

    public List<String> getImages(Document document, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = document.select("[src]").iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.tagName().equals("img")) {
                arrayList.add(element.attr("abs:src"));
            }
        }
        return i != -1 ? arrayList.subList(0, i) : arrayList;
    }

    /* access modifiers changed from: private */
    public String htmlDecode(String str) {
        return Jsoup.parse(str).text();
    }

    /* access modifiers changed from: private */
    public String crawlCode(String str) {
        String tagContent = getTagContent("span", str);
        String tagContent2 = getTagContent(ContextChain.TAG_PRODUCT, str);
        String tagContent3 = getTagContent("div", str);
        if ((tagContent2.length() <= tagContent.length() || tagContent2.length() < tagContent3.length()) && tagContent2.length() > tagContent.length() && tagContent2.length() < tagContent3.length()) {
            tagContent2 = tagContent3;
        }
        return htmlDecode(tagContent2);
    }

    /* access modifiers changed from: private */
    public String cannonicalPage(String str) {
        if (str.startsWith("http://")) {
            str = str.substring(7);
        } else if (str.startsWith("https://")) {
            str = str.substring(8);
        }
        int length = str.length();
        int i = 0;
        String str2 = "";
        while (i < length && str.charAt(i) != '/') {
            str2 = str2 + str.charAt(i);
            i++;
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public String stripTags(String str) {
        return Jsoup.parse(str).text();
    }

    /* access modifiers changed from: private */
    public boolean isImage(String str) {
        return str.matches(Constants.IMAGE_PATTERN);
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getMetaTags(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", "");
        hashMap.put("title", "");
        hashMap.put("description", "");
        hashMap.put("image", "");
        for (String next : Utils.pregMatchAll(str, Constants.METATAG_PATTERN, 1)) {
            if (next.toLowerCase().contains("property=\"og:url\"") || next.toLowerCase().contains("property='og:url'") || next.toLowerCase().contains("name=\"url\"") || next.toLowerCase().contains("name='url'")) {
                hashMap.put("url", separeMetaTagsContent(next));
            } else if (next.toLowerCase().contains("property=\"og:title\"") || next.toLowerCase().contains("property='og:title'") || next.toLowerCase().contains("name=\"title\"") || next.toLowerCase().contains("name='title'")) {
                hashMap.put("title", separeMetaTagsContent(next));
            } else if (next.toLowerCase().contains("property=\"og:description\"") || next.toLowerCase().contains("property='og:description'") || next.toLowerCase().contains("name=\"description\"") || next.toLowerCase().contains("name='description'")) {
                hashMap.put("description", separeMetaTagsContent(next));
            } else if (next.toLowerCase().contains("property=\"og:image\"") || next.toLowerCase().contains("property='og:image'") || next.toLowerCase().contains("name=\"image\"") || next.toLowerCase().contains("name='image'")) {
                hashMap.put("image", separeMetaTagsContent(next));
            }
        }
        return hashMap;
    }

    private String separeMetaTagsContent(String str) {
        return htmlDecode(Utils.pregMatch(str, Constants.METATAG_CONTENT_PATTERN, 1));
    }

    /* access modifiers changed from: private */
    public String unshortenUrl(String str) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return "";
        }
        URLConnection connectURL = connectURL(str);
        connectURL.getHeaderFields();
        String url = connectURL.getURL().toString();
        URLConnection connectURL2 = connectURL(url);
        connectURL2.getHeaderFields();
        String url2 = connectURL2.getURL().toString();
        while (!url2.equals(url)) {
            url = unshortenUrl(url);
        }
        return url;
    }

    private URLConnection connectURL(String str) {
        try {
            return new URL(str).openConnection();
        } catch (MalformedURLException unused) {
            System.out.println("Please input a valid URL");
            return null;
        } catch (IOException unused2) {
            System.out.println("Can not connect to the URL");
            return null;
        }
    }

    public static String extendedTrim(String str) {
        return str.replaceAll("\\s+", " ").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ").replace("\r", " ").trim();
    }
}
