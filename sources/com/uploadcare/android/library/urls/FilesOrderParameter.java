package com.uploadcare.android.library.urls;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/uploadcare/android/library/urls/FilesOrderParameter;", "Lcom/uploadcare/android/library/urls/UrlParameter;", "order", "Lcom/uploadcare/android/library/urls/Order;", "(Lcom/uploadcare/android/library/urls/Order;)V", "getParam", "", "getValue", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlParameters.kt */
public final class FilesOrderParameter implements UrlParameter {
    private final Order order;

    public String getParam() {
        return "ordering";
    }

    public FilesOrderParameter(Order order2) {
        Intrinsics.checkNotNullParameter(order2, "order");
        this.order = order2;
    }

    public String getValue() {
        return this.order.getRawValue();
    }
}
