package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "invoke", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
final class ComposeViewAdapter$findDesignInfoProviders$1$1 extends Lambda implements Function1<Group, Boolean> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$findDesignInfoProviders$1$1(ComposeViewAdapter composeViewAdapter) {
        super(1);
        this.this$0 = composeViewAdapter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075 A[EDGE_INSN: B:34:0x0075->B:31:0x0075 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.tooling.data.Group r7) {
        /*
            r6 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.Collection r7 = r7.getChildren()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            androidx.compose.ui.tooling.ComposeViewAdapter r0 = r6.this$0
            boolean r1 = r7 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001e
        L_0x001c:
            r2 = 0
            goto L_0x0075
        L_0x001e:
            java.util.Iterator r7 = r7.iterator()
        L_0x0022:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r7.next()
            androidx.compose.ui.tooling.data.Group r1 = (androidx.compose.ui.tooling.data.Group) r1
            java.lang.String r4 = r1.getName()
            java.lang.String r5 = "remember"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0072
            java.util.Collection r1 = r1.getData()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L_0x0050
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0050
        L_0x004e:
            r1 = 0
            goto L_0x006e
        L_0x0050:
            java.util.Iterator r1 = r1.iterator()
        L_0x0054:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r1.next()
            if (r4 == 0) goto L_0x0065
            java.lang.reflect.Method r4 = r0.getDesignInfoMethodOrNull(r4)
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            if (r4 == 0) goto L_0x006a
            r4 = 1
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x0054
            r1 = 1
        L_0x006e:
            if (r1 == 0) goto L_0x0072
            r1 = 1
            goto L_0x0073
        L_0x0072:
            r1 = 0
        L_0x0073:
            if (r1 == 0) goto L_0x0022
        L_0x0075:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1.invoke(androidx.compose.ui.tooling.data.Group):java.lang.Boolean");
    }
}
