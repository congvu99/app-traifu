package androidx.compose.ui.semantics;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R#\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020$0#0\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0007R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u001d\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0007R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsProperties;", "", "()V", "CollectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "CollectionItemInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "ContentDescription", "", "", "getContentDescription", "Disabled", "", "getDisabled", "EditableText", "Landroidx/compose/ui/text/AnnotatedString;", "getEditableText", "Error", "getError", "Focused", "", "getFocused", "Heading", "getHeading", "HorizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "ImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "getImeAction", "IndexForKey", "Lkotlin/Function1;", "", "getIndexForKey", "InvisibleToUser", "getInvisibleToUser$annotations", "getInvisibleToUser", "IsDialog", "getIsDialog", "IsPopup", "getIsPopup", "LiveRegion", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "PaneTitle", "getPaneTitle", "Password", "getPassword", "ProgressBarRangeInfo", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "Role", "Landroidx/compose/ui/semantics/Role;", "getRole", "SelectableGroup", "getSelectableGroup", "Selected", "getSelected", "StateDescription", "getStateDescription", "TestTag", "getTestTag", "Text", "getText", "TextSelectionRange", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SemanticsProperties.kt */
public final class SemanticsProperties {
    public static final int $stable = 0;
    private static final SemanticsPropertyKey<CollectionInfo> CollectionInfo = new SemanticsPropertyKey<>("CollectionInfo", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<CollectionItemInfo> CollectionItemInfo = new SemanticsPropertyKey<>("CollectionItemInfo", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<List<String>> ContentDescription = new SemanticsPropertyKey<>("ContentDescription", SemanticsProperties$ContentDescription$1.INSTANCE);
    private static final SemanticsPropertyKey<Unit> Disabled = new SemanticsPropertyKey<>("Disabled", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<AnnotatedString> EditableText = new SemanticsPropertyKey<>("EditableText", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<String> Error = new SemanticsPropertyKey<>("Error", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Boolean> Focused = new SemanticsPropertyKey<>("Focused", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Unit> Heading = new SemanticsPropertyKey<>("Heading", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<ScrollAxisRange> HorizontalScrollAxisRange = new SemanticsPropertyKey<>("HorizontalScrollAxisRange", (Function2) null, 2, (DefaultConstructorMarker) null);
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();
    private static final SemanticsPropertyKey<ImeAction> ImeAction = new SemanticsPropertyKey<>("ImeAction", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Function1<Object, Integer>> IndexForKey = new SemanticsPropertyKey<>("IndexForKey", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Unit> InvisibleToUser = new SemanticsPropertyKey<>("InvisibleToUser", SemanticsProperties$InvisibleToUser$1.INSTANCE);
    private static final SemanticsPropertyKey<Unit> IsDialog = new SemanticsPropertyKey<>("IsDialog", SemanticsProperties$IsDialog$1.INSTANCE);
    private static final SemanticsPropertyKey<Unit> IsPopup = new SemanticsPropertyKey<>("IsPopup", SemanticsProperties$IsPopup$1.INSTANCE);
    private static final SemanticsPropertyKey<LiveRegionMode> LiveRegion = new SemanticsPropertyKey<>("LiveRegion", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<String> PaneTitle = new SemanticsPropertyKey<>("PaneTitle", SemanticsProperties$PaneTitle$1.INSTANCE);
    private static final SemanticsPropertyKey<Unit> Password = new SemanticsPropertyKey<>("Password", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<ProgressBarRangeInfo> ProgressBarRangeInfo = new SemanticsPropertyKey<>("ProgressBarRangeInfo", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Role> Role = new SemanticsPropertyKey<>("Role", SemanticsProperties$Role$1.INSTANCE);
    private static final SemanticsPropertyKey<Unit> SelectableGroup = new SemanticsPropertyKey<>("SelectableGroup", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Boolean> Selected = new SemanticsPropertyKey<>("Selected", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<String> StateDescription = new SemanticsPropertyKey<>("StateDescription", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<String> TestTag = new SemanticsPropertyKey<>("TestTag", SemanticsProperties$TestTag$1.INSTANCE);
    private static final SemanticsPropertyKey<List<AnnotatedString>> Text = new SemanticsPropertyKey<>("Text", SemanticsProperties$Text$1.INSTANCE);
    private static final SemanticsPropertyKey<TextRange> TextSelectionRange = new SemanticsPropertyKey<>("TextSelectionRange", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<ToggleableState> ToggleableState = new SemanticsPropertyKey<>("ToggleableState", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<ScrollAxisRange> VerticalScrollAxisRange = new SemanticsPropertyKey<>("VerticalScrollAxisRange", (Function2) null, 2, (DefaultConstructorMarker) null);

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getInvisibleToUser$annotations() {
    }

    private SemanticsProperties() {
    }

    public final SemanticsPropertyKey<List<String>> getContentDescription() {
        return ContentDescription;
    }

    public final SemanticsPropertyKey<String> getStateDescription() {
        return StateDescription;
    }

    public final SemanticsPropertyKey<ProgressBarRangeInfo> getProgressBarRangeInfo() {
        return ProgressBarRangeInfo;
    }

    public final SemanticsPropertyKey<String> getPaneTitle() {
        return PaneTitle;
    }

    public final SemanticsPropertyKey<Unit> getSelectableGroup() {
        return SelectableGroup;
    }

    public final SemanticsPropertyKey<CollectionInfo> getCollectionInfo() {
        return CollectionInfo;
    }

    public final SemanticsPropertyKey<CollectionItemInfo> getCollectionItemInfo() {
        return CollectionItemInfo;
    }

    public final SemanticsPropertyKey<Unit> getHeading() {
        return Heading;
    }

    public final SemanticsPropertyKey<Unit> getDisabled() {
        return Disabled;
    }

    public final SemanticsPropertyKey<LiveRegionMode> getLiveRegion() {
        return LiveRegion;
    }

    public final SemanticsPropertyKey<Boolean> getFocused() {
        return Focused;
    }

    public final SemanticsPropertyKey<Unit> getInvisibleToUser() {
        return InvisibleToUser;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getHorizontalScrollAxisRange() {
        return HorizontalScrollAxisRange;
    }

    public final SemanticsPropertyKey<ScrollAxisRange> getVerticalScrollAxisRange() {
        return VerticalScrollAxisRange;
    }

    public final SemanticsPropertyKey<Unit> getIsPopup() {
        return IsPopup;
    }

    public final SemanticsPropertyKey<Unit> getIsDialog() {
        return IsDialog;
    }

    public final SemanticsPropertyKey<Role> getRole() {
        return Role;
    }

    public final SemanticsPropertyKey<String> getTestTag() {
        return TestTag;
    }

    public final SemanticsPropertyKey<List<AnnotatedString>> getText() {
        return Text;
    }

    public final SemanticsPropertyKey<AnnotatedString> getEditableText() {
        return EditableText;
    }

    public final SemanticsPropertyKey<TextRange> getTextSelectionRange() {
        return TextSelectionRange;
    }

    public final SemanticsPropertyKey<ImeAction> getImeAction() {
        return ImeAction;
    }

    public final SemanticsPropertyKey<Boolean> getSelected() {
        return Selected;
    }

    public final SemanticsPropertyKey<ToggleableState> getToggleableState() {
        return ToggleableState;
    }

    public final SemanticsPropertyKey<Unit> getPassword() {
        return Password;
    }

    public final SemanticsPropertyKey<String> getError() {
        return Error;
    }

    public final SemanticsPropertyKey<Function1<Object, Integer>> getIndexForKey() {
        return IndexForKey;
    }
}
