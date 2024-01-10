package io.intercom.android.sdk.helpcenter.search;

import android.text.Editable;
import android.text.Html;
import android.text.style.StyleSpan;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xml.sax.XMLReader;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HighlightTagHandler;", "Landroid/text/Html$TagHandler;", "()V", "endIndex", "", "startIndex", "applyColorSpan", "", "text", "Landroid/text/Editable;", "handleTag", "opening", "", "tag", "", "output", "xmlReader", "Lorg/xml/sax/XMLReader;", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HighlightTagHandler.kt */
public final class HighlightTagHandler implements Html.TagHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SPAN_FLAG = 33;
    private int endIndex;
    private int startIndex;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/HighlightTagHandler$Companion;", "", "()V", "SPAN_FLAG", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HighlightTagHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(editable, "output");
        Intrinsics.checkNotNullParameter(xMLReader, "xmlReader");
        if (!StringsKt.equals(str, "highlight", true)) {
            return;
        }
        if (z) {
            this.startIndex = editable.length();
            return;
        }
        this.endIndex = editable.length();
        applyColorSpan(editable);
    }

    private final void applyColorSpan(Editable editable) {
        editable.setSpan(new StyleSpan(1), this.startIndex, this.endIndex, 33);
    }
}
