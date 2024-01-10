package io.intercom.android.sdk.post;

import io.intercom.android.sdk.utilities.TimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/utilities/TimeFormatter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
final class PostActivityV2$timeFormatter$2 extends Lambda implements Function0<TimeFormatter> {
    final /* synthetic */ PostActivityV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostActivityV2$timeFormatter$2(PostActivityV2 postActivityV2) {
        super(0);
        this.this$0 = postActivityV2;
    }

    public final TimeFormatter invoke() {
        PostActivityV2 postActivityV2 = this.this$0;
        return new TimeFormatter(postActivityV2, postActivityV2.getInjector().getTimeProvider());
    }
}
