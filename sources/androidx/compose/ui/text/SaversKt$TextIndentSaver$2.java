package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/style/TextIndent;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextIndentSaver$2 extends Lambda implements Function1<Object, TextIndent> {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    SaversKt$TextIndentSaver$2() {
        super(1);
    }

    public final TextIndent invoke(Object obj) {
        TextUnit textUnit;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        TextUnit textUnit2 = null;
        if (!Intrinsics.areEqual(obj2, (Object) false) && obj2 != null) {
            textUnit = saver.restore(obj2);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r2 = textUnit.m4894unboximpl();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(TextUnit.Companion);
        if (!Intrinsics.areEqual(obj3, (Object) false) && obj3 != null) {
            textUnit2 = saver2.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnit2);
        return new TextIndent(r2, textUnit2.m4894unboximpl(), (DefaultConstructorMarker) null);
    }
}
