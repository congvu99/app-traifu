package io.intercom.android.sdk.tickets;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketCard.kt */
final class BigTicketCardKt$BigTicketCard$1 extends Lambda implements Function1<Integer, Integer> {
    public static final BigTicketCardKt$BigTicketCard$1 INSTANCE = new BigTicketCardKt$BigTicketCard$1();

    BigTicketCardKt$BigTicketCard$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        return Integer.valueOf(-i);
    }
}
