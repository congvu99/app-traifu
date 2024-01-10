package org.apache.commons.codec.language.bm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.http.message.TokenParser;

public class PhoneticEngine {
    private static final Map<NameType, Set<String>> NAME_PREFIXES;
    private final boolean concat;
    private final Lang lang;
    private final NameType nameType;
    private final RuleType ruleType;

    static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(Collections.singleton(new Rule.Phoneme("", languageSet)));
        }

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }

        public PhonemeBuilder append(CharSequence charSequence) {
            HashSet hashSet = new HashSet();
            for (Rule.Phoneme append : this.phonemes) {
                hashSet.add(append.append(charSequence));
            }
            return new PhonemeBuilder(hashSet);
        }

        public PhonemeBuilder apply(Rule.PhonemeExpr phonemeExpr) {
            HashSet hashSet = new HashSet();
            for (Rule.Phoneme next : this.phonemes) {
                for (Rule.Phoneme join : phonemeExpr.getPhonemes()) {
                    Rule.Phoneme join2 = next.join(join);
                    if (!join2.getLanguages().isEmpty()) {
                        hashSet.add(join2);
                    }
                }
            }
            return new PhonemeBuilder(hashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme next : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(next.getPhonemeText());
            }
            return sb.toString();
        }
    }

    private static final class RulesApplication {
        private final List<Rule> finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private PhonemeBuilder phonemeBuilder;

        public RulesApplication(List<Rule> list, CharSequence charSequence, PhonemeBuilder phonemeBuilder2, int i2) {
            if (list != null) {
                this.finalRules = list;
                this.phonemeBuilder = phonemeBuilder2;
                this.input = charSequence;
                this.i = i2;
                return;
            }
            throw new NullPointerException("The finalRules argument must not be null");
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i2;
            int i3 = 0;
            this.found = false;
            Iterator<Rule> it = this.finalRules.iterator();
            while (true) {
                i2 = 1;
                if (!it.hasNext()) {
                    break;
                }
                Rule next = it.next();
                int length = next.getPattern().length();
                if (next.patternAndContextMatches(this.input, this.i)) {
                    this.phonemeBuilder = this.phonemeBuilder.apply(next.getPhoneme());
                    this.found = true;
                    i3 = length;
                    break;
                }
                i3 = length;
            }
            if (this.found) {
                i2 = i3;
            }
            this.i += i2;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"bar", "ben", "da", "de", "van", "von"}))));
        NAME_PREFIXES.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
        NAME_PREFIXES.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
    }

    private static CharSequence cacheSubSequence(final CharSequence charSequence) {
        int length = charSequence.length();
        int[] iArr = new int[2];
        iArr[1] = charSequence.length();
        iArr[0] = length;
        final CharSequence[][] charSequenceArr = (CharSequence[][]) Array.newInstance(CharSequence.class, iArr);
        return new CharSequence() {
            public char charAt(int i) {
                return charSequence.charAt(i);
            }

            public int length() {
                return charSequence.length();
            }

            public CharSequence subSequence(int i, int i2) {
                if (i == i2) {
                    return "";
                }
                int i3 = i2 - 1;
                CharSequence charSequence = charSequenceArr[i][i3];
                if (charSequence != null) {
                    return charSequence;
                }
                CharSequence subSequence = charSequence.subSequence(i, i2);
                charSequenceArr[i][i3] = subSequence;
                return subSequence;
            }
        };
    }

    private static String join(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z) {
        if (ruleType2 != RuleType.RULES) {
            this.nameType = nameType2;
            this.ruleType = ruleType2;
            this.concat = z;
            this.lang = Lang.instance(nameType2);
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, List<Rule> list) {
        if (list == null) {
            throw new NullPointerException("finalRules can not be null");
        } else if (list.isEmpty()) {
            return phonemeBuilder;
        } else {
            TreeSet treeSet = new TreeSet(Rule.Phoneme.COMPARATOR);
            for (Rule.Phoneme next : phonemeBuilder.getPhonemes()) {
                PhonemeBuilder empty = PhonemeBuilder.empty(next.getLanguages());
                CharSequence cacheSubSequence = cacheSubSequence(next.getPhonemeText());
                int i = 0;
                while (i < cacheSubSequence.length()) {
                    RulesApplication invoke = new RulesApplication(list, cacheSubSequence, empty, i).invoke();
                    boolean isFound = invoke.isFound();
                    PhonemeBuilder phonemeBuilder2 = invoke.getPhonemeBuilder();
                    PhonemeBuilder append = !isFound ? phonemeBuilder2.append(cacheSubSequence.subSequence(i, i + 1)) : phonemeBuilder2;
                    i = invoke.getI();
                    empty = append;
                }
                treeSet.addAll(empty.getPhonemes());
            }
            return new PhonemeBuilder(treeSet);
        }
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        String str2;
        List<Rule> instance = Rule.getInstance(this.nameType, RuleType.RULES, languageSet);
        List<Rule> instance2 = Rule.getInstance(this.nameType, this.ruleType, "common");
        List<Rule> instance3 = Rule.getInstance(this.nameType, this.ruleType, languageSet);
        String trim = str.toLowerCase(Locale.ENGLISH).replace('-', TokenParser.SP).trim();
        int i = 0;
        if (this.nameType == NameType.GENERIC) {
            if (trim.length() < 2 || !trim.substring(0, 2).equals("d'")) {
                for (String str3 : NAME_PREFIXES.get(this.nameType)) {
                    if (trim.startsWith(str3 + " ")) {
                        String substring = trim.substring(str3.length() + 1);
                        String str4 = str3 + substring;
                        return "(" + encode(substring) + ")-(" + encode(str4) + ")";
                    }
                }
            } else {
                String substring2 = trim.substring(2);
                String str5 = "d" + substring2;
                return "(" + encode(substring2) + ")-(" + encode(str5) + ")";
            }
        }
        List<String> asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = AnonymousClass2.$SwitchMap$org$apache$commons$codec$language$bm$NameType[this.nameType.ordinal()];
        if (i2 == 1) {
            for (String split : asList) {
                String[] split2 = split.split("'");
                arrayList.add(split2[split2.length - 1]);
            }
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i2 == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i2 == 3) {
            arrayList.addAll(asList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.nameType);
        }
        if (this.concat) {
            str2 = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String encode : arrayList) {
                sb.append("-");
                sb.append(encode(encode));
            }
            return sb.substring(1);
        }
        PhonemeBuilder empty = PhonemeBuilder.empty(languageSet);
        CharSequence cacheSubSequence = cacheSubSequence(str2);
        while (i < cacheSubSequence.length()) {
            RulesApplication invoke = new RulesApplication(instance, cacheSubSequence, empty, i).invoke();
            i = invoke.getI();
            empty = invoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(empty, instance2), instance3).makeString();
    }

    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.codec.language.bm.NameType[] r0 = org.apache.commons.codec.language.bm.NameType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$codec$language$bm$NameType = r0
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.SEPHARDIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$codec$language$bm$NameType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.ASHKENAZI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$codec$language$bm$NameType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.codec.language.bm.NameType r1 = org.apache.commons.codec.language.bm.NameType.GENERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass2.<clinit>():void");
        }
    }

    public Lang getLang() {
        return this.lang;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }
}
