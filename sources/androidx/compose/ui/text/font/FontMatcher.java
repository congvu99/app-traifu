package androidx.compose.ui.text.font;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u000fJ7\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0011JF\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\b\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FontMatcher.kt */
public final class FontMatcher {
    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3, int i, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i & 8) != 0) {
            fontWeight3 = null;
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        int size = list.size();
        FontWeight fontWeight5 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i2)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i2++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Object obj2 = list.get(i3);
            if (Intrinsics.areEqual((Object) ((Font) obj2).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public final List<Font> filterByClosestWeight$ui_text_release(List<? extends Font> list, FontWeight fontWeight, boolean z, FontWeight fontWeight2, FontWeight fontWeight3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i++;
        }
        if (!z ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = list.get(i2);
            if (Intrinsics.areEqual((Object) ((Font) obj).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m4302matchFontRetOiIg(FontFamily fontFamily, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, ViewProps.FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        if (fontFamily instanceof FontListFontFamily) {
            return m4303matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m4303matchFontRetOiIg(FontListFontFamily fontListFontFamily, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontListFontFamily, ViewProps.FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, ViewProps.FONT_WEIGHT);
        return m4304matchFontRetOiIg((List<? extends Font>) fontListFontFamily.getFonts(), fontWeight, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.util.List<? extends androidx.compose.ui.text.font.Font>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.util.List<? extends androidx.compose.ui.text.font.Font>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<androidx.compose.ui.text.font.Font> m4304matchFontRetOiIg(java.util.List<? extends androidx.compose.ui.text.font.Font> r9, androidx.compose.ui.text.font.FontWeight r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "fontList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "fontWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.size()
            r0.<init>(r1)
            int r1 = r9.size()
            r2 = 0
            r3 = 0
        L_0x0019:
            r4 = 1
            if (r3 >= r1) goto L_0x0044
            java.lang.Object r5 = r9.get(r3)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            androidx.compose.ui.text.font.FontWeight r7 = r6.getWeight()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r10)
            if (r7 == 0) goto L_0x0038
            int r6 = r6.m4281getStyle_LCdwA()
            boolean r6 = androidx.compose.ui.text.font.FontStyle.m4308equalsimpl0(r6, r11)
            if (r6 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r4 = 0
        L_0x0039:
            if (r4 == 0) goto L_0x0041
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r5)
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0044:
            java.util.List r0 = (java.util.List) r0
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0051
            return r0
        L_0x0051:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.size()
            r0.<init>(r1)
            int r1 = r9.size()
            r3 = 0
        L_0x0061:
            if (r3 >= r1) goto L_0x007d
            java.lang.Object r4 = r9.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.m4281getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m4308equalsimpl0(r5, r11)
            if (r5 == 0) goto L_0x007a
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            r5.add(r4)
        L_0x007a:
            int r3 = r3 + 1
            goto L_0x0061
        L_0x007d:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r9 = r0
        L_0x0089:
            java.util.List r9 = (java.util.List) r9
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW400()
            int r11 = r10.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            r0 = 0
            if (r11 >= 0) goto L_0x00fe
            int r11 = r9.size()
            r1 = r0
            r3 = 0
        L_0x009e:
            if (r3 >= r11) goto L_0x00ce
            java.lang.Object r4 = r9.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.FontWeight r4 = r4.getWeight()
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 >= 0) goto L_0x00ba
            if (r0 == 0) goto L_0x00b8
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r5 <= 0) goto L_0x00c9
        L_0x00b8:
            r0 = r4
            goto L_0x00c9
        L_0x00ba:
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 <= 0) goto L_0x00cc
            if (r1 == 0) goto L_0x00c8
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r1)
            if (r5 >= 0) goto L_0x00c9
        L_0x00c8:
            r1 = r4
        L_0x00c9:
            int r3 = r3 + 1
            goto L_0x009e
        L_0x00cc:
            r0 = r4
            r1 = r0
        L_0x00ce:
            if (r0 != 0) goto L_0x00d1
            r0 = r1
        L_0x00d1:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x00de:
            if (r2 >= r11) goto L_0x00fa
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x00f7
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x00f7:
            int r2 = r2 + 1
            goto L_0x00de
        L_0x00fa:
            java.util.List r10 = (java.util.List) r10
            goto L_0x0265
        L_0x00fe:
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r11 = r10.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r11 <= 0) goto L_0x0171
            int r11 = r9.size()
            r1 = r0
            r3 = 0
        L_0x0110:
            if (r3 >= r11) goto L_0x0140
            java.lang.Object r4 = r9.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.FontWeight r4 = r4.getWeight()
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 >= 0) goto L_0x012c
            if (r0 == 0) goto L_0x012a
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r5 <= 0) goto L_0x013b
        L_0x012a:
            r0 = r4
            goto L_0x013b
        L_0x012c:
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r5 <= 0) goto L_0x013e
            if (r1 == 0) goto L_0x013a
            int r5 = r4.compareTo((androidx.compose.ui.text.font.FontWeight) r1)
            if (r5 >= 0) goto L_0x013b
        L_0x013a:
            r1 = r4
        L_0x013b:
            int r3 = r3 + 1
            goto L_0x0110
        L_0x013e:
            r0 = r4
            r1 = r0
        L_0x0140:
            if (r1 != 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r0 = r1
        L_0x0144:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x0151:
            if (r2 >= r11) goto L_0x016d
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x016a
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x016a:
            int r2 = r2 + 1
            goto L_0x0151
        L_0x016d:
            java.util.List r10 = (java.util.List) r10
            goto L_0x0265
        L_0x0171:
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r1 = r9.size()
            r4 = r0
            r5 = r4
            r3 = 0
        L_0x017e:
            if (r3 >= r1) goto L_0x01b6
            java.lang.Object r6 = r9.get(r3)
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            androidx.compose.ui.text.font.FontWeight r6 = r6.getWeight()
            if (r11 == 0) goto L_0x0192
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r7 > 0) goto L_0x01b1
        L_0x0192:
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r7 >= 0) goto L_0x01a2
            if (r4 == 0) goto L_0x01a0
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r4)
            if (r7 <= 0) goto L_0x01b1
        L_0x01a0:
            r4 = r6
            goto L_0x01b1
        L_0x01a2:
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r7 <= 0) goto L_0x01b4
            if (r5 == 0) goto L_0x01b0
            int r7 = r6.compareTo((androidx.compose.ui.text.font.FontWeight) r5)
            if (r7 >= 0) goto L_0x01b1
        L_0x01b0:
            r5 = r6
        L_0x01b1:
            int r3 = r3 + 1
            goto L_0x017e
        L_0x01b4:
            r4 = r6
            r5 = r4
        L_0x01b6:
            if (r5 != 0) goto L_0x01b9
            goto L_0x01ba
        L_0x01b9:
            r4 = r5
        L_0x01ba:
            java.util.ArrayList r11 = new java.util.ArrayList
            int r1 = r9.size()
            r11.<init>(r1)
            int r1 = r9.size()
            r3 = 0
        L_0x01c8:
            if (r3 >= r1) goto L_0x01e4
            java.lang.Object r5 = r9.get(r3)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            androidx.compose.ui.text.font.FontWeight r6 = r6.getWeight()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x01e1
            r6 = r11
            java.util.Collection r6 = (java.util.Collection) r6
            r6.add(r5)
        L_0x01e1:
            int r3 = r3 + 1
            goto L_0x01c8
        L_0x01e4:
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x0262
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r11 = r11.getW500()
            int r1 = r9.size()
            r3 = r0
            r4 = 0
        L_0x01fa:
            if (r4 >= r1) goto L_0x0232
            java.lang.Object r5 = r9.get(r4)
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            androidx.compose.ui.text.font.FontWeight r5 = r5.getWeight()
            if (r11 == 0) goto L_0x020e
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r11)
            if (r6 < 0) goto L_0x022d
        L_0x020e:
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r6 >= 0) goto L_0x021e
            if (r0 == 0) goto L_0x021c
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r0)
            if (r6 <= 0) goto L_0x022d
        L_0x021c:
            r0 = r5
            goto L_0x022d
        L_0x021e:
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r10)
            if (r6 <= 0) goto L_0x0230
            if (r3 == 0) goto L_0x022c
            int r6 = r5.compareTo((androidx.compose.ui.text.font.FontWeight) r3)
            if (r6 >= 0) goto L_0x022d
        L_0x022c:
            r3 = r5
        L_0x022d:
            int r4 = r4 + 1
            goto L_0x01fa
        L_0x0230:
            r0 = r5
            r3 = r0
        L_0x0232:
            if (r3 != 0) goto L_0x0235
            goto L_0x0236
        L_0x0235:
            r0 = r3
        L_0x0236:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = r9.size()
            r10.<init>(r11)
            int r11 = r9.size()
        L_0x0243:
            if (r2 >= r11) goto L_0x025f
            java.lang.Object r1 = r9.get(r2)
            r3 = r1
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.FontWeight r3 = r3.getWeight()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x025c
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3
            r3.add(r1)
        L_0x025c:
            int r2 = r2 + 1
            goto L_0x0243
        L_0x025f:
            r11 = r10
            java.util.List r11 = (java.util.List) r11
        L_0x0262:
            r10 = r11
            java.util.List r10 = (java.util.List) r10
        L_0x0265:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontMatcher.m4304matchFontRetOiIg(java.util.List, androidx.compose.ui.text.font.FontWeight, int):java.util.List");
    }
}
