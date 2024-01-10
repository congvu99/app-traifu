package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0013\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a]\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0014H\u0000\u001a]\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0016\u001aU\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00142\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"applyDiff", "", "oldSize", "", "newSize", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: MyersDiff.kt */
public final class MyersDiffKt {
    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = i;
        int i4 = i2;
        int i5 = ((i3 + i4) + 1) / 2;
        IntStack intStack = new IntStack(i5 * 3);
        IntStack intStack2 = new IntStack(i5 * 4);
        intStack2.pushRange(0, i3, 0, i4);
        int i6 = (i5 * 2) + 1;
        int[] r6 = CenteredArray.m3737constructorimpl(new int[i6]);
        int[] r2 = CenteredArray.m3737constructorimpl(new int[i6]);
        int[] r15 = Snake.m3957constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int pop = intStack2.pop();
            int pop2 = intStack2.pop();
            int pop3 = intStack2.pop();
            int pop4 = intStack2.pop();
            int i7 = pop4;
            int i8 = pop3;
            int[] iArr = r6;
            int[] iArr2 = r6;
            int i9 = pop2;
            int[] iArr3 = r2;
            int[] iArr4 = r2;
            int i10 = pop;
            if (m3871midPointq5eDKzI(pop4, pop3, pop2, pop, diffCallback, iArr, iArr3, r15)) {
                if (Snake.m3960getDiagonalSizeimpl(r15) > 0) {
                    Snake.m3955addDiagonalToStackimpl(r15, intStack);
                }
                intStack2.pushRange(i7, Snake.m3965getStartXimpl(r15), i9, Snake.m3966getStartYimpl(r15));
                intStack2.pushRange(Snake.m3961getEndXimpl(r15), i8, Snake.m3962getEndYimpl(r15), i10);
            }
            int i11 = i;
            r6 = iArr2;
            r2 = iArr4;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i4, 0);
        return intStack;
    }

    private static final void applyDiff(int i, int i2, IntStack intStack, DiffCallback diffCallback) {
        while (intStack.isNotEmpty()) {
            int pop = intStack.pop();
            int pop2 = intStack.pop();
            int pop3 = intStack.pop();
            while (i > pop3) {
                i--;
                diffCallback.remove(i);
            }
            while (i2 > pop2) {
                i2--;
                diffCallback.insert(i, i2);
            }
            while (true) {
                int i3 = pop - 1;
                if (pop > 0) {
                    i--;
                    i2--;
                    diffCallback.same(i, i2);
                    pop = i3;
                }
            }
        }
        while (i > 0) {
            i--;
            diffCallback.remove(i);
        }
        while (i2 > 0) {
            i2--;
            diffCallback.insert(i, i2);
        }
    }

    public static final void executeDiff(int i, int i2, DiffCallback diffCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "callback");
        applyDiff(i, i2, calculateDiff(i, i2, diffCallback), diffCallback);
    }

    /* renamed from: midPoint-q5eDKzI  reason: not valid java name */
    private static final boolean m3871midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i;
        int i6 = i2;
        int i7 = i6 - i5;
        int i8 = i4 - i3;
        if (i7 >= 1 && i8 >= 1) {
            int i9 = ((i7 + i8) + 1) / 2;
            CenteredArray.m3743setimpl(iArr, 1, i5);
            CenteredArray.m3743setimpl(iArr2, 1, i6);
            int i10 = 0;
            while (i10 < i9) {
                int i11 = i10;
                if (m3870forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i10, iArr3) || m3869backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i11, iArr3)) {
                    return true;
                }
                i10 = i11 + 1;
            }
        }
        return false;
    }

    /* renamed from: forward-4l5_RBY  reason: not valid java name */
    private static final boolean m3870forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i4;
        int[] iArr4 = iArr;
        int i11 = i5;
        int i12 = (i9 - i) - (i10 - i3);
        boolean z = Math.abs(i12) % 2 == 1;
        int i13 = -i11;
        for (int i14 = i13; i14 <= i11; i14 += 2) {
            if (i14 == i13 || (i14 != i11 && CenteredArray.m3740getimpl(iArr4, i14 + 1) > CenteredArray.m3740getimpl(iArr4, i14 - 1))) {
                i7 = CenteredArray.m3740getimpl(iArr4, i14 + 1);
                i6 = i7;
            } else {
                i7 = CenteredArray.m3740getimpl(iArr4, i14 - 1);
                i6 = i7 + 1;
            }
            int i15 = (i3 + (i6 - i)) - i14;
            int i16 = (i11 == 0 || i6 != i7) ? i15 : i15 - 1;
            while (true) {
                if (i6 < i9 && i15 < i10) {
                    if (!diffCallback.areItemsTheSame(i6, i15)) {
                        break;
                    }
                    i6++;
                    i15++;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m3743setimpl(iArr4, i14, i6);
            if (!z || (i8 = i12 - i14) < i13 + 1 || i8 > i11 - 1) {
                int[] iArr5 = iArr2;
            } else if (CenteredArray.m3740getimpl(iArr2, i8) <= i6) {
                fillSnake(i7, i16, i6, i15, false, iArr3);
                return true;
            }
        }
        return false;
    }

    /* renamed from: backward-4l5_RBY  reason: not valid java name */
    private static final boolean m3869backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i3;
        int[] iArr4 = iArr2;
        int i11 = i5;
        int i12 = (i2 - i9) - (i4 - i10);
        boolean z = i12 % 2 == 0;
        int i13 = -i11;
        for (int i14 = i13; i14 <= i11; i14 += 2) {
            if (i14 == i13 || (i14 != i11 && CenteredArray.m3740getimpl(iArr4, i14 + 1) < CenteredArray.m3740getimpl(iArr4, i14 - 1))) {
                i7 = CenteredArray.m3740getimpl(iArr4, i14 + 1);
                i6 = i7;
            } else {
                i7 = CenteredArray.m3740getimpl(iArr4, i14 - 1);
                i6 = i7 - 1;
            }
            int i15 = i4 - ((i2 - i6) - i14);
            int i16 = (i11 == 0 || i6 != i7) ? i15 : i15 + 1;
            while (true) {
                if (i6 > i9 && i15 > i10) {
                    if (!diffCallback.areItemsTheSame(i6 - 1, i15 - 1)) {
                        break;
                    }
                    i6--;
                    i15--;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m3743setimpl(iArr4, i14, i6);
            if (!z || (i8 = i12 - i14) < i13 || i8 > i11) {
                int[] iArr5 = iArr;
            } else if (CenteredArray.m3740getimpl(iArr, i8) >= i6) {
                fillSnake(i6, i15, i7, i16, true, iArr3);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, int[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fillSnake(int r1, int r2, int r3, int r4, boolean r5, int[] r6) {
        /*
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r6[r0] = r1
            r1 = 1
            r6[r1] = r2
            r1 = 2
            r6[r1] = r3
            r1 = 3
            r6[r1] = r4
            r1 = 4
            r6[r1] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MyersDiffKt.fillSnake(int, int, int, int, boolean, int[]):void");
    }

    /* access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
