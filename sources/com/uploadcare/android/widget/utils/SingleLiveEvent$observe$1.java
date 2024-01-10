package com.uploadcare.android.widget.utils;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: SingleLiveEvent.kt */
final class SingleLiveEvent$observe$1<T> implements Observer<T> {
    final /* synthetic */ Function0 $observer;

    SingleLiveEvent$observe$1(Function0 function0) {
        this.$observer = function0;
    }

    public final void onChanged(T t) {
        this.$observer.invoke();
    }
}
