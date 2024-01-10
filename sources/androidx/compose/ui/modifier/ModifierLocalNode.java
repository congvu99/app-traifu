package androidx.compose.ui.modifier;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.DelegatableNode;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModifierLocalNode.kt */
public interface ModifierLocalNode extends ModifierLocalReadScope, DelegatableNode {
    <T> T getCurrent(ModifierLocal<T> modifierLocal);

    ModifierLocalMap getProvidedValues();

    <T> void provide(ModifierLocal<T> modifierLocal, T t);

    /* renamed from: androidx.compose.ui.modifier.ModifierLocalNode$-CC  reason: invalid class name */
    /* compiled from: ModifierLocalNode.kt */
    public final /* synthetic */ class CC {
        public static ModifierLocalMap $default$getProvidedValues(ModifierLocalNode _this) {
            return EmptyMap.INSTANCE;
        }

        public static <T> void $default$provide(ModifierLocalNode _this, ModifierLocal modifierLocal, Object obj) {
            Intrinsics.checkNotNullParameter(modifierLocal, SDKConstants.PARAM_KEY);
            if (_this.getProvidedValues() != EmptyMap.INSTANCE) {
                _this.getProvidedValues().set$ui_release(modifierLocal, obj);
                return;
            }
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
            r2 = r0.getNodes$ui_release();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <T> java.lang.Object $default$getCurrent(androidx.compose.ui.modifier.ModifierLocalNode r5, androidx.compose.ui.modifier.ModifierLocal r6) {
            /*
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                androidx.compose.ui.Modifier$Node r0 = r5.getNode()
                boolean r0 = r0.isAttached()
                if (r0 == 0) goto L_0x008f
                r0 = r5
                androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
                androidx.compose.ui.node.Nodes r1 = androidx.compose.ui.node.Nodes.INSTANCE
                int r1 = r1.m3938getLocalsOLwlOKw()
                androidx.compose.ui.Modifier$Node r2 = r0.getNode()
                boolean r2 = r2.isAttached()
                if (r2 == 0) goto L_0x0083
                androidx.compose.ui.Modifier$Node r2 = r0.getNode()
                androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
            L_0x002e:
                if (r0 == 0) goto L_0x007a
                androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
                androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
                int r3 = r3.getAggregateChildKindSet$ui_release()
                r3 = r3 & r1
                if (r3 == 0) goto L_0x0067
            L_0x003f:
                if (r2 == 0) goto L_0x0067
                int r3 = r2.getKindSet$ui_release()
                r3 = r3 & r1
                if (r3 == 0) goto L_0x0062
                boolean r3 = r2 instanceof androidx.compose.ui.modifier.ModifierLocalNode
                if (r3 == 0) goto L_0x0062
                r3 = r2
                androidx.compose.ui.modifier.ModifierLocalNode r3 = (androidx.compose.ui.modifier.ModifierLocalNode) r3
                androidx.compose.ui.modifier.ModifierLocalMap r4 = r3.getProvidedValues()
                boolean r4 = r4.contains$ui_release(r6)
                if (r4 == 0) goto L_0x0062
                androidx.compose.ui.modifier.ModifierLocalMap r0 = r3.getProvidedValues()
                java.lang.Object r6 = r0.get$ui_release(r6)
                return r6
            L_0x0062:
                androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
                goto L_0x003f
            L_0x0067:
                androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
                if (r0 == 0) goto L_0x0078
                androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
                if (r2 == 0) goto L_0x0078
                androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
                goto L_0x002e
            L_0x0078:
                r2 = 0
                goto L_0x002e
            L_0x007a:
                kotlin.jvm.functions.Function0 r6 = r6.getDefaultFactory$ui_release()
                java.lang.Object r6 = r6.invoke()
                return r6
            L_0x0083:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r6.<init>(r0)
                throw r6
            L_0x008f:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Failed requirement."
                java.lang.String r0 = r0.toString()
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.modifier.ModifierLocalNode.CC.$default$getCurrent(androidx.compose.ui.modifier.ModifierLocalNode, androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
        }
    }
}
