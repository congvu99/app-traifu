package io.intercom.android.sdk.survey.block;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u0006HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\tJ4\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lio/intercom/android/sdk/survey/block/SuffixText;", "", "text", "", "ttsText", "color", "Landroidx/compose/ui/graphics/Color;", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getText", "()Ljava/lang/String;", "getTtsText", "component1", "component2", "component3", "component3-0d7_KjU", "copy", "copy-mxwnekA", "(Ljava/lang/String;Ljava/lang/String;J)Lio/intercom/android/sdk/survey/block/SuffixText;", "equals", "", "other", "hashCode", "", "toString", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextBlock.kt */
public final class SuffixText {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SuffixText NO_SUFFIX = new SuffixText("", "", Color.Companion.m1958getBlack0d7_KjU(), (DefaultConstructorMarker) null);
    private final long color;
    private final String text;
    private final String ttsText;

    public /* synthetic */ SuffixText(String str, String str2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j);
    }

    /* renamed from: copy-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ SuffixText m5302copymxwnekA$default(SuffixText suffixText, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suffixText.text;
        }
        if ((i & 2) != 0) {
            str2 = suffixText.ttsText;
        }
        if ((i & 4) != 0) {
            j = suffixText.color;
        }
        return suffixText.m5304copymxwnekA(str, str2, j);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.ttsText;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m5303component30d7_KjU() {
        return this.color;
    }

    /* renamed from: copy-mxwnekA  reason: not valid java name */
    public final SuffixText m5304copymxwnekA(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "ttsText");
        return new SuffixText(str, str2, j, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuffixText)) {
            return false;
        }
        SuffixText suffixText = (SuffixText) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) suffixText.text) && Intrinsics.areEqual((Object) this.ttsText, (Object) suffixText.ttsText) && Color.m1933equalsimpl0(this.color, suffixText.color);
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.ttsText.hashCode()) * 31) + Color.m1939hashCodeimpl(this.color);
    }

    public String toString() {
        return "SuffixText(text=" + this.text + ", ttsText=" + this.ttsText + ", color=" + Color.m1940toStringimpl(this.color) + ')';
    }

    private SuffixText(String str, String str2, long j) {
        this.text = str;
        this.ttsText = str2;
        this.color = j;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTtsText() {
        return this.ttsText;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m5305getColor0d7_KjU() {
        return this.color;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/block/SuffixText$Companion;", "", "()V", "NO_SUFFIX", "Lio/intercom/android/sdk/survey/block/SuffixText;", "getNO_SUFFIX", "()Lio/intercom/android/sdk/survey/block/SuffixText;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextBlock.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SuffixText getNO_SUFFIX() {
            return SuffixText.NO_SUFFIX;
        }
    }
}
