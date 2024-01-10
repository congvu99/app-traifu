package com.uploadcare.android.library.urls;

import com.uploadcare.android.library.api.UploadcareFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fJ\u001e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\r\u0010\u001b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001cJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0000J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010&\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010'\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\u0000J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/uploadcare/android/library/urls/CdnPathBuilder;", "", "file", "Lcom/uploadcare/android/library/api/UploadcareFile;", "(Lcom/uploadcare/android/library/api/UploadcareFile;)V", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "blur", "strength", "", "build", "", "crop", "width", "height", "cropCenter", "cropCenterColor", "color", "cropColor", "dimensionGuard", "", "dim", "dimensionsGuard", "flip", "format", "Lcom/uploadcare/android/library/urls/ImageFormat;", "getUUID", "getUUID$library_release", "grayscale", "invert", "mirror", "preview", "quality", "Lcom/uploadcare/android/library/urls/ImageQuality;", "resize", "resizeHeight", "resizeWidth", "scaleCrop", "scaleCropCenter", "sharp", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: CdnPathBuilder.kt */
public final class CdnPathBuilder {
    private final UploadcareFile file;
    private final StringBuilder sb;

    public CdnPathBuilder(UploadcareFile uploadcareFile) {
        Intrinsics.checkNotNullParameter(uploadcareFile, "file");
        this.file = uploadcareFile;
        StringBuilder sb2 = new StringBuilder("/");
        this.sb = sb2;
        sb2.append(this.file.getUuid());
    }

    public final String getUUID$library_release() {
        return this.file.getUuid();
    }

    private final void dimensionGuard(int i) {
        if (i < 1 || i > 7680) {
            throw new IllegalArgumentException("Dimensions must be in the range 1-7680");
        }
    }

    private final void dimensionsGuard(int i, int i2) {
        dimensionGuard(i);
        dimensionGuard(i2);
        if (i > 7680 && i2 > 7680) {
            throw new IllegalArgumentException("At least one dimension must be less than 7680");
        }
    }

    public final CdnPathBuilder crop(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        return this;
    }

    public final CdnPathBuilder cropCenter(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("/center");
        return this;
    }

    public final CdnPathBuilder cropColor(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "color");
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("/");
        sb2.append(str);
        return this;
    }

    public final CdnPathBuilder cropCenterColor(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "color");
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("/center/");
        sb2.append(str);
        return this;
    }

    public final CdnPathBuilder resizeWidth(int i) {
        dimensionGuard(i);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/resize/");
        sb2.append(i);
        sb2.append("x");
        return this;
    }

    public final CdnPathBuilder resizeHeight(int i) {
        dimensionGuard(i);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/resize/x");
        sb2.append(i);
        return this;
    }

    public final CdnPathBuilder resize(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/resize/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        return this;
    }

    public final CdnPathBuilder scaleCrop(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/scale_crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        return this;
    }

    public final CdnPathBuilder scaleCropCenter(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/scale_crop/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("/center");
        return this;
    }

    public final CdnPathBuilder flip() {
        this.sb.append("/-/flip");
        return this;
    }

    public final CdnPathBuilder grayscale() {
        this.sb.append("/-/grayscale");
        return this;
    }

    public final CdnPathBuilder invert() {
        this.sb.append("/-/invert");
        return this;
    }

    public final CdnPathBuilder mirror() {
        this.sb.append("/-/effect/mirror");
        return this;
    }

    public final CdnPathBuilder blur() {
        this.sb.append("/-/blur");
        return this;
    }

    public final CdnPathBuilder blur(int i) {
        if (i < 0 || i > 5000) {
            i = 10;
        }
        StringBuilder sb2 = this.sb;
        sb2.append("/-/blur/");
        sb2.append(i);
        return this;
    }

    public final CdnPathBuilder sharp() {
        this.sb.append("/-/sharp");
        return this;
    }

    public final CdnPathBuilder sharp(int i) {
        if (i < 0 || i > 20) {
            i = 5;
        }
        StringBuilder sb2 = this.sb;
        sb2.append("/-/sharp/");
        sb2.append(i);
        return this;
    }

    public final CdnPathBuilder preview(int i, int i2) {
        dimensionsGuard(i, i2);
        StringBuilder sb2 = this.sb;
        sb2.append("/-/preview/");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        return this;
    }

    public final CdnPathBuilder format(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "format");
        StringBuilder sb2 = this.sb;
        sb2.append("/-/format/");
        sb2.append(imageFormat.getRawValue());
        return this;
    }

    public final CdnPathBuilder quality(ImageQuality imageQuality) {
        Intrinsics.checkNotNullParameter(imageQuality, "quality");
        StringBuilder sb2 = this.sb;
        sb2.append("/-/quality/");
        sb2.append(imageQuality.getRawValue());
        return this;
    }

    public final String build() {
        StringBuilder sb2 = this.sb;
        sb2.append("/");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.append(\"/\").toString()");
        return sb3;
    }
}
