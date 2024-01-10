package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.github.scribejava.core.model.OAuthConstants;
import com.google.firebase.messaging.Constants;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.sentry.protocol.Device;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag {
    private static final String[] blockTags;
    private static final String[] emptyTags = {"meta", "link", "base", TypedValues.AttributesType.S_FRAME, "img", "br", "wbr", "embed", "hr", MetricTracker.Object.INPUT, "keygen", "col", "command", Device.TYPE, "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    private static final String[] formListedTags = {"button", "fieldset", MetricTracker.Object.INPUT, "keygen", "object", "output", "select", "textarea"};
    private static final String[] formSubmitTags = {MetricTracker.Object.INPUT, "keygen", "object", "select", "textarea"};
    private static final String[] formatAsInlineTags = {"title", "a", ContextChain.TAG_PRODUCT, "h1", "h2", "h3", "h4", "h5", "h6", "pre", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "li", "th", "td", "script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "ins", "del", "s"};
    private static final String[] inlineTags = {"object", "base", "font", "tt", ContextChain.TAG_INFRA, "b", "u", "big", "small", UserDataStore.EMAIL, "strong", "dfn", OAuthConstants.CODE, "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", MetricTracker.Object.INPUT, "select", "textarea", Constants.ScionAnalytics.PARAM_LABEL, "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", Device.TYPE, "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi"};
    private static final String[] preserveWhitespaceTags = {"pre", "plaintext", "title", "textarea"};
    private static final Map<String, Tag> tags = new HashMap();
    private boolean canContainBlock = true;
    private boolean canContainInline = true;
    private boolean empty = false;
    private boolean formList = false;
    private boolean formSubmit = false;
    private boolean formatAsBlock = true;
    private boolean isBlock = true;
    private boolean preserveWhitespace = false;
    private boolean selfClosing = false;
    private String tagName;

    static {
        String[] strArr = {"html", "head", SDKConstants.PARAM_A2U_BODY, "frameset", "script", "noscript", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "meta", "link", "title", TypedValues.AttributesType.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", ContextChain.TAG_PRODUCT, "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", ShareConstants.FEED_CAPTION_PARAM, "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math"};
        blockTags = strArr;
        for (String tag : strArr) {
            register(new Tag(tag));
        }
        for (String tag2 : inlineTags) {
            Tag tag3 = new Tag(tag2);
            tag3.isBlock = false;
            tag3.canContainBlock = false;
            tag3.formatAsBlock = false;
            register(tag3);
        }
        for (String str : emptyTags) {
            Tag tag4 = tags.get(str);
            Validate.notNull(tag4);
            tag4.canContainBlock = false;
            tag4.canContainInline = false;
            tag4.empty = true;
        }
        for (String str2 : formatAsInlineTags) {
            Tag tag5 = tags.get(str2);
            Validate.notNull(tag5);
            tag5.formatAsBlock = false;
        }
        for (String str3 : preserveWhitespaceTags) {
            Tag tag6 = tags.get(str3);
            Validate.notNull(tag6);
            tag6.preserveWhitespace = true;
        }
        for (String str4 : formListedTags) {
            Tag tag7 = tags.get(str4);
            Validate.notNull(tag7);
            tag7.formList = true;
        }
        for (String str5 : formSubmitTags) {
            Tag tag8 = tags.get(str5);
            Validate.notNull(tag8);
            tag8.formSubmit = true;
        }
    }

    private Tag(String str) {
        this.tagName = str.toLowerCase();
    }

    public String getName() {
        return this.tagName;
    }

    public static Tag valueOf(String str) {
        Validate.notNull(str);
        Tag tag = tags.get(str);
        if (tag != null) {
            return tag;
        }
        String lowerCase = str.trim().toLowerCase();
        Validate.notEmpty(lowerCase);
        Tag tag2 = tags.get(lowerCase);
        if (tag2 != null) {
            return tag2;
        }
        Tag tag3 = new Tag(lowerCase);
        tag3.isBlock = false;
        tag3.canContainBlock = true;
        return tag3;
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public boolean canContainBlock() {
        return this.canContainBlock;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isData() {
        return !this.canContainInline && !isEmpty();
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    /* access modifiers changed from: package-private */
    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (this.tagName.equals(tag.tagName) && this.canContainBlock == tag.canContainBlock && this.canContainInline == tag.canContainInline && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.canContainBlock ? 1 : 0)) * 31) + (this.canContainInline ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public String toString() {
        return this.tagName;
    }

    private static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }
}
