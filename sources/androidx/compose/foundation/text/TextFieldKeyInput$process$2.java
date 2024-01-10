package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
final class TextFieldKeyInput$process$2 extends Lambda implements Function1<TextFieldPreparedSelection, Unit> {
    final /* synthetic */ KeyCommand $command;
    final /* synthetic */ Ref.BooleanRef $consumed;
    final /* synthetic */ TextFieldKeyInput this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextFieldKeyInput.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            iArr[KeyCommand.COPY.ordinal()] = 1;
            iArr[KeyCommand.PASTE.ordinal()] = 2;
            iArr[KeyCommand.CUT.ordinal()] = 3;
            iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            iArr[KeyCommand.UP.ordinal()] = 10;
            iArr[KeyCommand.DOWN.ordinal()] = 11;
            iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            iArr[KeyCommand.LINE_START.ordinal()] = 14;
            iArr[KeyCommand.LINE_END.ordinal()] = 15;
            iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            iArr[KeyCommand.HOME.ordinal()] = 18;
            iArr[KeyCommand.END.ordinal()] = 19;
            iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            iArr[KeyCommand.TAB.ordinal()] = 27;
            iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            iArr[KeyCommand.DESELECT.ordinal()] = 45;
            iArr[KeyCommand.UNDO.ordinal()] = 46;
            iArr[KeyCommand.REDO.ordinal()] = 47;
            iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKeyInput$process$2(KeyCommand keyCommand, TextFieldKeyInput textFieldKeyInput, Ref.BooleanRef booleanRef) {
        super(1);
        this.$command = keyCommand;
        this.this$0 = textFieldKeyInput;
        this.$consumed = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldPreparedSelection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
        TextFieldValue undo;
        TextFieldValue redo;
        Intrinsics.checkNotNullParameter(textFieldPreparedSelection, "$this$commandExecutionContext");
        switch (WhenMappings.$EnumSwitchMapping$0[this.$command.ordinal()]) {
            case 1:
                this.this$0.getSelectionManager().copy$foundation_release(false);
                return;
            case 2:
                this.this$0.getSelectionManager().paste$foundation_release();
                return;
            case 3:
                this.this$0.getSelectionManager().cut$foundation_release();
                return;
            case 4:
                textFieldPreparedSelection.collapseLeftOr(AnonymousClass1.INSTANCE);
                return;
            case 5:
                textFieldPreparedSelection.collapseRightOr(AnonymousClass2.INSTANCE);
                return;
            case 6:
                textFieldPreparedSelection.moveCursorLeftByWord();
                return;
            case 7:
                textFieldPreparedSelection.moveCursorRightByWord();
                return;
            case 8:
                textFieldPreparedSelection.moveCursorPrevByParagraph();
                return;
            case 9:
                textFieldPreparedSelection.moveCursorNextByParagraph();
                return;
            case 10:
                textFieldPreparedSelection.moveCursorUpByLine();
                return;
            case 11:
                textFieldPreparedSelection.moveCursorDownByLine();
                return;
            case 12:
                textFieldPreparedSelection.moveCursorUpByPage();
                return;
            case 13:
                textFieldPreparedSelection.moveCursorDownByPage();
                return;
            case 14:
                textFieldPreparedSelection.moveCursorToLineStart();
                return;
            case 15:
                textFieldPreparedSelection.moveCursorToLineEnd();
                return;
            case 16:
                textFieldPreparedSelection.moveCursorToLineLeftSide();
                return;
            case 17:
                textFieldPreparedSelection.moveCursorToLineRightSide();
                return;
            case 18:
                textFieldPreparedSelection.moveCursorToHome();
                return;
            case 19:
                textFieldPreparedSelection.moveCursorToEnd();
                return;
            case 20:
                List<EditCommand> deleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass3.INSTANCE);
                if (deleteIfSelectedOr != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                    return;
                }
                return;
            case 21:
                List<EditCommand> deleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass4.INSTANCE);
                if (deleteIfSelectedOr2 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                    return;
                }
                return;
            case 22:
                List<EditCommand> deleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass5.INSTANCE);
                if (deleteIfSelectedOr3 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                    return;
                }
                return;
            case 23:
                List<EditCommand> deleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass6.INSTANCE);
                if (deleteIfSelectedOr4 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                    return;
                }
                return;
            case 24:
                List<EditCommand> deleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass7.INSTANCE);
                if (deleteIfSelectedOr5 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                    return;
                }
                return;
            case 25:
                List<EditCommand> deleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass8.INSTANCE);
                if (deleteIfSelectedOr6 != null) {
                    this.this$0.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                    return;
                }
                return;
            case 26:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, 1));
                    return;
                } else {
                    this.$consumed.element = false;
                    return;
                }
            case 27:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply((EditCommand) new CommitTextCommand("\t", 1));
                    return;
                } else {
                    this.$consumed.element = false;
                    return;
                }
            case 28:
                textFieldPreparedSelection.selectAll();
                return;
            case 29:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorLeft()).selectMovement();
                return;
            case 30:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorRight()).selectMovement();
                return;
            case 31:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorLeftByWord()).selectMovement();
                return;
            case 32:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorRightByWord()).selectMovement();
                return;
            case 33:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorPrevByParagraph()).selectMovement();
                return;
            case 34:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorNextByParagraph()).selectMovement();
                return;
            case 35:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineStart()).selectMovement();
                return;
            case 36:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineEnd()).selectMovement();
                return;
            case 37:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineLeftSide()).selectMovement();
                return;
            case 38:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToLineRightSide()).selectMovement();
                return;
            case 39:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorUpByLine()).selectMovement();
                return;
            case 40:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorDownByLine()).selectMovement();
                return;
            case 41:
                textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                return;
            case 42:
                textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                return;
            case 43:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToHome()).selectMovement();
                return;
            case 44:
                ((TextFieldPreparedSelection) textFieldPreparedSelection.moveCursorToEnd()).selectMovement();
                return;
            case 45:
                textFieldPreparedSelection.deselect();
                return;
            case 46:
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.makeSnapshot(textFieldPreparedSelection.getValue());
                }
                UndoManager undoManager2 = this.this$0.getUndoManager();
                if (undoManager2 != null && (undo = undoManager2.undo()) != null) {
                    this.this$0.onValueChange.invoke(undo);
                    return;
                }
                return;
            case 47:
                UndoManager undoManager3 = this.this$0.getUndoManager();
                if (undoManager3 != null && (redo = undoManager3.redo()) != null) {
                    this.this$0.onValueChange.invoke(redo);
                    return;
                }
                return;
            case 48:
                KeyEventHelpers_androidKt.showCharacterPalette();
                return;
            default:
                return;
        }
    }
}
