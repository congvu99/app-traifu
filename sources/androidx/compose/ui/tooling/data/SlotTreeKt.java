package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0003\u001a\u0014\u0010+\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010(H\u0003\u001a\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u0006H\u0002\u001a\u001c\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010*H\u0003\u001a\u001a\u00103\u001a\u0004\u0018\u000104*\u0006\u0012\u0002\b\u0003052\u0006\u00106\u001a\u00020\u0006H\u0002\u001a\f\u00107\u001a\u00020\u0019*\u000208H\u0007\u001a\f\u00109\u001a\u00020\u0006*\u00020\u0015H\u0002\u001a\u0016\u0010:\u001a\u00020\u0019*\u00020;2\b\u0010<\u001a\u0004\u0018\u00010*H\u0003\u001a\f\u0010=\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\u0014\u0010>\u001a\u00020\u0014*\u00020\u00152\u0006\u0010?\u001a\u00020\u0006H\u0002\u001a\f\u0010@\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010A\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010B\u001a\u00020\u0014*\u00020\u0015H\u0002\u001a\f\u0010C\u001a\u00020\u0001*\u00020\u0015H\u0002\u001a\f\u0010D\u001a\u00020\u0001*\u00020\u0006H\u0002\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020\u00062\u0006\u0010E\u001a\u00020\u0001H\u0002\u001a\u001c\u0010F\u001a\u00020\u0006*\u00020\u00062\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0002\u001a\u0014\u0010I\u001a\u00020\t*\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\" \u0010\u0018\u001a\u0004\u0018\u00010\u0006*\u00020\u00198GX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u001e\u001a\u00020\u0006*\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006K"}, d2 = {"BITS_PER_SLOT", "", "SLOT_MASK", "STABLE_BITS", "STATIC_BITS", "changedFieldName", "", "defaultFieldName", "emptyBox", "Landroidx/compose/ui/unit/IntRect;", "getEmptyBox", "()Landroidx/compose/ui/unit/IntRect;", "internalFieldPrefix", "jacocoDataField", "parameterPrefix", "parametersInformationTokenizer", "Lkotlin/text/Regex;", "recomposeScopeNameSuffix", "tokenizer", "isANumber", "", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)Z", "isClassName", "position", "Landroidx/compose/ui/tooling/data/Group;", "getPosition$annotations", "(Landroidx/compose/ui/tooling/data/Group;)V", "getPosition", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "text", "getText", "(Lkotlin/text/MatchResult;)Ljava/lang/String;", "boundsOfLayoutNode", "node", "Landroidx/compose/ui/layout/LayoutInfo;", "extractParameterInfo", "", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "data", "", "context", "Landroidx/compose/ui/tooling/data/SourceInformationContext;", "keyPosition", "key", "parseParameters", "Landroidx/compose/ui/tooling/data/Parameter;", "parameters", "sourceInformationContextOf", "information", "parent", "accessibleField", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", "name", "asTree", "Landroidx/compose/runtime/tooling/CompositionData;", "callName", "getGroup", "Landroidx/compose/runtime/tooling/CompositionGroup;", "parentContext", "isCallWithName", "isChar", "c", "isFileName", "isNumber", "isParameterInformation", "number", "parseToInt", "radix", "replacePrefix", "prefix", "replacement", "union", "other", "ui-tooling-data_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlotTree.kt */
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;
    private static final String changedFieldName = "$$changed";
    private static final String defaultFieldName = "$$default";
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);
    private static final String internalFieldPrefix = "$$";
    private static final String jacocoDataField = "$jacoco";
    private static final String parameterPrefix = "$";
    private static final Regex parametersInformationTokenizer = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";
    private static final Regex tokenizer = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");

    @UiToolingDataApi
    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    private static final boolean isNumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final int number(MatchResult matchResult) {
        return parseToInt(matchResult.getGroupValues().get(1));
    }

    private static final String getText(MatchResult matchResult) {
        return matchResult.getGroupValues().get(0);
    }

    private static final boolean isChar(MatchResult matchResult, String str) {
        return Intrinsics.areEqual((Object) getText(matchResult), (Object) str);
    }

    private static final boolean isFileName(MatchResult matchResult) {
        return matchResult.getGroups().get(4) != null;
    }

    private static final boolean isParameterInformation(MatchResult matchResult) {
        return matchResult.getGroups().get(5) != null;
    }

    private static final boolean isCallWithName(MatchResult matchResult) {
        return matchResult.getGroups().get(6) != null;
    }

    private static final String callName(MatchResult matchResult) {
        return matchResult.getGroupValues().get(8);
    }

    private static final boolean isANumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final boolean isClassName(MatchResult matchResult) {
        return matchResult.getGroups().get(2) != null;
    }

    private static final int parseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }

    private static final int parseToInt(String str, int i) {
        try {
            return Integer.parseInt(str, CharsKt.checkRadix(i));
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }

    private static final List<Parameter> parseParameters(String str) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Regex.find$default(parametersInformationTokenizer, str, 0, 2, (Object) null);
        List mutableListOf = CollectionsKt.mutableListOf(0, 1, 2, 3);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = mutableListOf.size() - 1;
        List<Parameter> arrayList = new ArrayList<>();
        try {
            parseParameters$expect(objectRef, "P");
            parseParameters$expect(objectRef, "(");
            while (!parseParameters$isChar(objectRef, ")")) {
                if (parseParameters$isChar(objectRef, "!")) {
                    parseParameters$next(objectRef);
                    int parseParameters$expectNumber = parseParameters$expectNumber(objectRef);
                    parseParameters$ensureIndexes(intRef, mutableListOf, arrayList.size() + parseParameters$expectNumber);
                    for (int i = 0; i < parseParameters$expectNumber; i++) {
                        arrayList.add(new Parameter(((Number) CollectionsKt.first(mutableListOf)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                        mutableListOf.remove(0);
                    }
                } else if (parseParameters$isChar(objectRef, ",")) {
                    parseParameters$next(objectRef);
                } else {
                    int parseParameters$expectNumber2 = parseParameters$expectNumber(objectRef);
                    arrayList.add(new Parameter(parseParameters$expectNumber2, parseParameters$isClassName(objectRef) ? parseParameters$expectClassName(objectRef) : null));
                    parseParameters$ensureIndexes(intRef, mutableListOf, parseParameters$expectNumber2);
                    mutableListOf.remove(Integer.valueOf(parseParameters$expectNumber2));
                }
            }
            parseParameters$expect(objectRef, ")");
            while (mutableListOf.size() > 0) {
                arrayList.add(new Parameter(((Number) CollectionsKt.first(mutableListOf)).intValue(), (String) null, 2, (DefaultConstructorMarker) null));
                mutableListOf.remove(0);
            }
            return arrayList;
        } catch (ParseError unused) {
            return CollectionsKt.emptyList();
        } catch (NumberFormatException unused2) {
            return CollectionsKt.emptyList();
        }
    }

    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isANumber(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        return parseToInt(getText(matchResult));
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isClassName(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        String substring = getText(matchResult).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return replacePrefix(substring, "c#", "androidx.compose.");
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !Intrinsics.areEqual((Object) getText(matchResult), (Object) str)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        return matchResult == null || Intrinsics.areEqual((Object) getText(matchResult), (Object) str);
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        return matchResult != null && isClassName(matchResult);
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef intRef, List<Integer> list, int i) {
        int i2 = i - intRef.element;
        if (i2 > 0) {
            if (i2 < 4) {
                i2 = 4;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                list.add(Integer.valueOf(intRef.element + i3 + 1));
            }
            intRef.element += i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f0  */
    @androidx.compose.ui.tooling.data.UiToolingDataApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.tooling.data.SourceInformationContext sourceInformationContextOf(java.lang.String r14, androidx.compose.ui.tooling.data.SourceInformationContext r15) {
        /*
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.text.Regex r1 = tokenizer
            r2 = r14
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 2
            r5 = 0
            kotlin.text.MatchResult r1 = kotlin.text.Regex.find$default(r1, r2, r3, r4, r5)
            r0.element = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r10 = r1
            java.util.List r10 = (java.util.List) r10
            r1 = -1
            r7 = r5
            r12 = r7
            r11 = -1
            r13 = 0
        L_0x0020:
            T r2 = r0.element
            if (r2 == 0) goto L_0x00e3
            T r2 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            kotlin.text.MatchResult r2 = (kotlin.text.MatchResult) r2
            boolean r4 = isNumber(r2)
            r6 = 1
            if (r4 != 0) goto L_0x00d1
            java.lang.String r4 = "@"
            boolean r4 = isChar(r2, r4)
            if (r4 == 0) goto L_0x003c
            goto L_0x00d1
        L_0x003c:
            java.lang.String r4 = "C"
            boolean r4 = isChar(r2, r4)
            if (r4 == 0) goto L_0x004a
            m4611sourceInformationContextOf$next4(r0)
        L_0x0047:
            r13 = 1
            goto L_0x00da
        L_0x004a:
            boolean r4 = isCallWithName(r2)
            if (r4 == 0) goto L_0x0058
            java.lang.String r7 = callName(r2)
            m4611sourceInformationContextOf$next4(r0)
            goto L_0x0047
        L_0x0058:
            boolean r4 = isParameterInformation(r2)
            if (r4 == 0) goto L_0x006b
            java.lang.String r4 = getText(r2)
            java.util.List r12 = parseParameters(r4)
            m4611sourceInformationContextOf$next4(r0)
            goto L_0x00da
        L_0x006b:
            java.lang.String r4 = "*"
            boolean r4 = isChar(r2, r4)
            if (r4 == 0) goto L_0x007b
            int r11 = r10.size()
            m4611sourceInformationContextOf$next4(r0)
            goto L_0x00da
        L_0x007b:
            java.lang.String r4 = ","
            boolean r4 = isChar(r2, r4)
            if (r4 == 0) goto L_0x0087
            m4611sourceInformationContextOf$next4(r0)
            goto L_0x00da
        L_0x0087:
            boolean r0 = isFileName(r2)
            if (r0 == 0) goto L_0x00e3
            kotlin.ranges.IntRange r0 = r2.getRange()
            int r0 = r0.getLast()
            int r0 = r0 + r6
            java.lang.String r14 = r14.substring(r0)
            java.lang.String r0 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)
            java.lang.String r0 = "#"
            java.lang.String r2 = ""
            java.lang.String r0 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r2)
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x00b3
            r2 = 1
            goto L_0x00b4
        L_0x00b3:
            r2 = 0
        L_0x00b4:
            if (r2 == 0) goto L_0x00e4
            int r2 = r14.length()
            int r4 = r0.length()
            int r2 = r2 - r4
            int r2 = r2 - r6
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r3, (int) r2)
            java.lang.String r14 = kotlin.text.StringsKt.substring((java.lang.String) r14, (kotlin.ranges.IntRange) r2)
            r2 = 36
            int r1 = parseToInt(r0, r2)     // Catch:{ NumberFormatException -> 0x00cf }
            goto L_0x00e4
        L_0x00cf:
            goto L_0x00e4
        L_0x00d1:
            androidx.compose.ui.tooling.data.SourceLocationInfo r4 = sourceInformationContextOf$parseLocation(r0)
            if (r4 == 0) goto L_0x00da
            r10.add(r4)
        L_0x00da:
            T r4 = r0.element
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x0020
            return r5
        L_0x00e3:
            r14 = r5
        L_0x00e4:
            androidx.compose.ui.tooling.data.SourceInformationContext r0 = new androidx.compose.ui.tooling.data.SourceInformationContext
            if (r14 != 0) goto L_0x00f0
            if (r15 == 0) goto L_0x00ee
            java.lang.String r5 = r15.getSourceFile()
        L_0x00ee:
            r8 = r5
            goto L_0x00f1
        L_0x00f0:
            r8 = r14
        L_0x00f1:
            if (r14 == 0) goto L_0x00f4
            goto L_0x00fc
        L_0x00f4:
            if (r15 == 0) goto L_0x00fc
            int r14 = r15.getPackageHash()
            r9 = r14
            goto L_0x00fd
        L_0x00fc:
            r9 = r1
        L_0x00fd:
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.sourceInformationContextOf(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    /* renamed from: sourceInformationContextOf$next-4  reason: not valid java name */
    private static final MatchResult m4611sourceInformationContextOf$next4(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> objectRef) {
        Integer num;
        Integer num2;
        Integer num3;
        try {
            MatchResult matchResult = (MatchResult) objectRef.element;
            if (matchResult == null || !isNumber(matchResult)) {
                num = null;
            } else {
                num = Integer.valueOf(number(matchResult) + 1);
                matchResult = m4611sourceInformationContextOf$next4(objectRef);
            }
            if (matchResult == null || !isChar(matchResult, "@")) {
                num2 = null;
                num3 = null;
            } else {
                MatchResult r1 = m4611sourceInformationContextOf$next4(objectRef);
                if (r1 != null) {
                    if (isNumber(r1)) {
                        num3 = Integer.valueOf(number(r1));
                        MatchResult r3 = m4611sourceInformationContextOf$next4(objectRef);
                        if (r3 == null || !isChar(r3, "L")) {
                            num2 = null;
                        } else {
                            MatchResult r6 = m4611sourceInformationContextOf$next4(objectRef);
                            if (r6 != null) {
                                if (isNumber(r6)) {
                                    num2 = Integer.valueOf(number(r6));
                                }
                            }
                            return null;
                        }
                    }
                }
                return null;
            }
            if (!(num == null || num3 == null || num2 == null)) {
                return new SourceLocationInfo(num, num3, num2);
            }
        } catch (ParseError unused) {
        }
        return null;
    }

    @UiToolingDataApi
    private static final Group getGroup(CompositionGroup compositionGroup, SourceInformationContext sourceInformationContext) {
        List<ModifierInfo> list;
        IntRect intRect;
        Object key = compositionGroup.getKey();
        String sourceInfo = compositionGroup.getSourceInfo();
        SourceInformationContext sourceInformationContextOf = sourceInfo != null ? sourceInformationContextOf(sourceInfo, sourceInformationContext) : null;
        Object node = compositionGroup.getNode();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Collection collection = arrayList;
        CollectionsKt.addAll(collection, compositionGroup.getData());
        for (CompositionGroup group : compositionGroup.getCompositionGroups()) {
            arrayList2.add(getGroup(group, sourceInformationContextOf));
        }
        boolean z = node instanceof LayoutInfo;
        if (z) {
            list = ((LayoutInfo) node).getModifierInfo();
        } else {
            list = CollectionsKt.emptyList();
        }
        if (z) {
            intRect = boundsOfLayoutNode((LayoutInfo) node);
        } else if (arrayList2.isEmpty()) {
            intRect = emptyBox;
        } else {
            Iterable<Group> iterable = arrayList2;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Group box : iterable) {
                arrayList3.add(box.getBox());
            }
            Iterator it = ((List) arrayList3).iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = union((IntRect) it.next(), (IntRect) next);
                }
                intRect = (IntRect) next;
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        }
        boolean z2 = true;
        SourceLocation nextSourceLocation = sourceInformationContextOf != null && sourceInformationContextOf.isCall() ? sourceInformationContext != null ? sourceInformationContext.nextSourceLocation() : null : null;
        if (node != null) {
            return new NodeGroup(key, node, intRect, collection, list, arrayList2);
        }
        String name = sourceInformationContextOf != null ? sourceInformationContextOf.getName() : null;
        CharSequence name2 = sourceInformationContextOf != null ? sourceInformationContextOf.getName() : null;
        if (!(name2 == null || name2.length() == 0)) {
            z2 = false;
        }
        return new CallGroup(key, name, intRect, nextSourceLocation, (z2 || (intRect.getBottom() - intRect.getTop() <= 0 && intRect.getRight() - intRect.getLeft() <= 0)) ? null : compositionGroup.getIdentity(), extractParameterInfo(arrayList, sourceInformationContextOf), collection, arrayList2);
    }

    private static final IntRect boundsOfLayoutNode(LayoutInfo layoutInfo) {
        if (!layoutInfo.isAttached()) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(layoutInfo.getCoordinates());
        long r2 = layoutInfo.getCoordinates().m3611getSizeYbymL2g();
        int roundToInt = MathKt.roundToInt(Offset.m1683getXimpl(positionInWindow));
        int roundToInt2 = MathKt.roundToInt(Offset.m1684getYimpl(positionInWindow));
        return new IntRect(roundToInt, roundToInt2, IntSize.m4864getWidthimpl(r2) + roundToInt, IntSize.m4863getHeightimpl(r2) + roundToInt2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = getGroup(r1, (androidx.compose.ui.tooling.data.SourceInformationContext) null);
     */
    @androidx.compose.ui.tooling.data.UiToolingDataApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.tooling.data.Group asTree(androidx.compose.runtime.tooling.CompositionData r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Iterable r1 = r1.getCompositionGroups()
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            androidx.compose.runtime.tooling.CompositionGroup r1 = (androidx.compose.runtime.tooling.CompositionGroup) r1
            if (r1 == 0) goto L_0x0018
            r0 = 0
            androidx.compose.ui.tooling.data.Group r1 = getGroup(r1, r0)
            if (r1 != 0) goto L_0x001c
        L_0x0018:
            androidx.compose.ui.tooling.data.EmptyGroup r1 = androidx.compose.ui.tooling.data.EmptyGroup.INSTANCE
            androidx.compose.ui.tooling.data.Group r1 = (androidx.compose.ui.tooling.data.Group) r1
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.asTree(androidx.compose.runtime.tooling.CompositionData):androidx.compose.ui.tooling.data.Group");
    }

    public static final IntRect union(IntRect intRect, IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "<this>");
        Intrinsics.checkNotNullParameter(intRect2, "other");
        if (Intrinsics.areEqual((Object) intRect, (Object) emptyBox)) {
            return intRect2;
        }
        if (Intrinsics.areEqual((Object) intRect2, (Object) emptyBox)) {
            return intRect;
        }
        return new IntRect(Math.min(intRect.getLeft(), intRect2.getLeft()), Math.min(intRect.getTop(), intRect2.getTop()), Math.max(intRect.getRight(), intRect2.getRight()), Math.max(intRect.getBottom(), intRect2.getBottom()));
    }

    @UiToolingDataApi
    private static final String keyPosition(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JoinedKey)) {
            return null;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        String keyPosition = keyPosition(joinedKey.getLeft());
        return keyPosition == null ? keyPosition(joinedKey.getRight()) : keyPosition;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e0 A[Catch:{ all -> 0x0197 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0041 A[EDGE_INSN: B:88:0x0041->B:13:0x0041 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00e3 A[SYNTHETIC] */
    @androidx.compose.ui.tooling.data.UiToolingDataApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<androidx.compose.ui.tooling.data.ParameterInformation> extractParameterInfo(java.util.List<? extends java.lang.Object> r22, androidx.compose.ui.tooling.data.SourceInformationContext r23) {
        /*
            java.lang.String r0 = "it.name"
            r1 = r22
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x0197
            r1 = r22
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0016:
            boolean r3 = r1.hasNext()
            r4 = 2
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L_0x0040
            java.lang.Object r3 = r1.next()
            if (r3 == 0) goto L_0x003c
            java.lang.Class r7 = r3.getClass()
            java.lang.String r7 = r7.getName()
            java.lang.String r8 = "it.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r8 = ".RecomposeScopeImpl"
            boolean r7 = kotlin.text.StringsKt.endsWith$default(r7, r8, r6, r4, r5)
            if (r7 == 0) goto L_0x003c
            r7 = 1
            goto L_0x003d
        L_0x003c:
            r7 = 0
        L_0x003d:
            if (r7 == 0) goto L_0x0016
            goto L_0x0041
        L_0x0040:
            r3 = r5
        L_0x0041:
            if (r3 == 0) goto L_0x0197
            java.lang.Class r1 = r3.getClass()     // Catch:{ all -> 0x0197 }
            java.lang.String r7 = "block"
            java.lang.reflect.Field r1 = accessibleField(r1, r7)     // Catch:{ all -> 0x0197 }
            if (r1 == 0) goto L_0x0197
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0197 }
            if (r1 == 0) goto L_0x0197
            java.lang.Class r3 = r1.getClass()     // Catch:{ all -> 0x0197 }
            java.lang.String r7 = "$$default"
            java.lang.reflect.Field r7 = accessibleField(r3, r7)     // Catch:{ all -> 0x0197 }
            java.lang.String r8 = "$$changed"
            java.lang.reflect.Field r8 = accessibleField(r3, r8)     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Int"
            if (r7 == 0) goto L_0x007c
            java.lang.Object r7 = r7.get(r1)     // Catch:{ all -> 0x0197 }
            if (r7 == 0) goto L_0x0076
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x0197 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0197 }
            goto L_0x007d
        L_0x0076:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0197 }
            r0.<init>(r9)     // Catch:{ all -> 0x0197 }
            throw r0     // Catch:{ all -> 0x0197 }
        L_0x007c:
            r7 = 0
        L_0x007d:
            if (r8 == 0) goto L_0x0092
            java.lang.Object r8 = r8.get(r1)     // Catch:{ all -> 0x0197 }
            if (r8 == 0) goto L_0x008c
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0197 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0197 }
            goto L_0x0093
        L_0x008c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0197 }
            r0.<init>(r9)     // Catch:{ all -> 0x0197 }
            throw r0     // Catch:{ all -> 0x0197 }
        L_0x0092:
            r8 = 0
        L_0x0093:
            java.lang.reflect.Field[] r3 = r3.getDeclaredFields()     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = "blockClass.declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x0197 }
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x0197 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0197 }
            r9.<init>()     // Catch:{ all -> 0x0197 }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x0197 }
            int r10 = r3.length     // Catch:{ all -> 0x0197 }
            r11 = 0
        L_0x00a7:
            if (r11 >= r10) goto L_0x00e6
            r12 = r3[r11]     // Catch:{ all -> 0x0197 }
            r13 = r12
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13     // Catch:{ all -> 0x0197 }
            java.lang.String r14 = r13.getName()     // Catch:{ all -> 0x0197 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ all -> 0x0197 }
            java.lang.String r15 = "$"
            boolean r14 = kotlin.text.StringsKt.startsWith$default(r14, r15, r6, r4, r5)     // Catch:{ all -> 0x0197 }
            if (r14 == 0) goto L_0x00dd
            java.lang.String r14 = r13.getName()     // Catch:{ all -> 0x0197 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ all -> 0x0197 }
            java.lang.String r15 = "$$"
            boolean r14 = kotlin.text.StringsKt.startsWith$default(r14, r15, r6, r4, r5)     // Catch:{ all -> 0x0197 }
            if (r14 != 0) goto L_0x00dd
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0197 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x0197 }
            java.lang.String r14 = "$jacoco"
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r13, r14, r6, r4, r5)     // Catch:{ all -> 0x0197 }
            if (r13 != 0) goto L_0x00dd
            r13 = 1
            goto L_0x00de
        L_0x00dd:
            r13 = 0
        L_0x00de:
            if (r13 == 0) goto L_0x00e3
            r9.add(r12)     // Catch:{ all -> 0x0197 }
        L_0x00e3:
            int r11 = r11 + 1
            goto L_0x00a7
        L_0x00e6:
            java.util.List r9 = (java.util.List) r9     // Catch:{ all -> 0x0197 }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x0197 }
            androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1 r0 = new androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1     // Catch:{ all -> 0x0197 }
            r0.<init>()     // Catch:{ all -> 0x0197 }
            java.util.Comparator r0 = (java.util.Comparator) r0     // Catch:{ all -> 0x0197 }
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r9, r0)     // Catch:{ all -> 0x0197 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0197 }
            r3.<init>()     // Catch:{ all -> 0x0197 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0197 }
            if (r23 == 0) goto L_0x0104
            java.util.List r9 = r23.getParameters()     // Catch:{ all -> 0x0197 }
            if (r9 != 0) goto L_0x0108
        L_0x0104:
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0197 }
        L_0x0108:
            int r10 = r0.size()     // Catch:{ all -> 0x0197 }
            r11 = 0
        L_0x010d:
            if (r11 >= r10) goto L_0x0196
            int r12 = r9.size()     // Catch:{ all -> 0x0197 }
            if (r11 >= r12) goto L_0x011c
            java.lang.Object r12 = r9.get(r11)     // Catch:{ all -> 0x0197 }
            androidx.compose.ui.tooling.data.Parameter r12 = (androidx.compose.ui.tooling.data.Parameter) r12     // Catch:{ all -> 0x0197 }
            goto L_0x0121
        L_0x011c:
            androidx.compose.ui.tooling.data.Parameter r12 = new androidx.compose.ui.tooling.data.Parameter     // Catch:{ all -> 0x0197 }
            r12.<init>(r11, r5, r4, r5)     // Catch:{ all -> 0x0197 }
        L_0x0121:
            int r13 = r12.getSortedIndex()     // Catch:{ all -> 0x0197 }
            int r14 = r0.size()     // Catch:{ all -> 0x0197 }
            if (r13 >= r14) goto L_0x0191
            int r13 = r12.getSortedIndex()     // Catch:{ all -> 0x0197 }
            java.lang.Object r13 = r0.get(r13)     // Catch:{ all -> 0x0197 }
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13     // Catch:{ all -> 0x0197 }
            r13.setAccessible(r2)     // Catch:{ all -> 0x0197 }
            java.lang.Object r16 = r13.get(r1)     // Catch:{ all -> 0x0197 }
            int r14 = r2 << r11
            r14 = r14 & r7
            if (r14 == 0) goto L_0x0144
            r17 = 1
            goto L_0x0146
        L_0x0144:
            r17 = 0
        L_0x0146:
            int r14 = r11 * 3
            int r14 = r14 + r2
            r15 = 7
            int r15 = r15 << r14
            r15 = r15 & r8
            int r14 = r15 >> r14
            r15 = r14 & 3
            r4 = 3
            if (r15 != r4) goto L_0x0156
            r18 = 1
            goto L_0x0158
        L_0x0156:
            r18 = 0
        L_0x0158:
            if (r15 != 0) goto L_0x015c
            r4 = 1
            goto L_0x015d
        L_0x015c:
            r4 = 0
        L_0x015d:
            r14 = r14 & 4
            if (r14 != 0) goto L_0x0164
            r21 = 1
            goto L_0x0166
        L_0x0164:
            r21 = 0
        L_0x0166:
            androidx.compose.ui.tooling.data.ParameterInformation r15 = new androidx.compose.ui.tooling.data.ParameterInformation     // Catch:{ all -> 0x0197 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0197 }
            java.lang.String r14 = "field.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x0197 }
            java.lang.String r13 = r13.substring(r2)     // Catch:{ all -> 0x0197 }
            java.lang.String r14 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ all -> 0x0197 }
            if (r4 == 0) goto L_0x0182
            if (r17 != 0) goto L_0x0182
            r19 = 1
            goto L_0x0184
        L_0x0182:
            r19 = 0
        L_0x0184:
            java.lang.String r20 = r12.getInlineClass()     // Catch:{ all -> 0x0197 }
            r14 = r15
            r4 = r15
            r15 = r13
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0197 }
            r3.add(r4)     // Catch:{ all -> 0x0197 }
        L_0x0191:
            int r11 = r11 + 1
            r4 = 2
            goto L_0x010d
        L_0x0196:
            return r3
        L_0x0197:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.extractParameterInfo(java.util.List, androidx.compose.ui.tooling.data.SourceInformationContext):java.util.List");
    }

    @UiToolingDataApi
    public static final String getPosition(Group group) {
        Intrinsics.checkNotNullParameter(group, "<this>");
        return keyPosition(group.getKey());
    }

    private static final Field accessibleField(Class<?> cls, String str) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Object[] objArr = (Object[]) declaredFields;
        int length = objArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = objArr[i];
            if (Intrinsics.areEqual((Object) ((Field) field).getName(), (Object) str)) {
                break;
            }
            i++;
        }
        Field field2 = field;
        if (field2 == null) {
            return null;
        }
        field2.setAccessible(true);
        return field2;
    }

    private static final String replacePrefix(String str, String str2, String str3) {
        if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String substring = str.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }
}
