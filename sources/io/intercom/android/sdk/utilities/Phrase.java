package io.intercom.android.sdk.utilities;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Phrase {
    private static final int EOF = 0;
    private char curChar;
    private int curCharIndex;
    private CharSequence formatted;
    private Token head;
    private final Set<String> keys = new HashSet();
    private final Map<String, CharSequence> keysToValues = new HashMap();
    private final CharSequence pattern;

    public static Phrase from(Fragment fragment, int i) {
        return from(fragment.getResources(), i);
    }

    public static Phrase from(View view, int i) {
        return from(view.getResources(), i);
    }

    public static Phrase from(Context context, int i) {
        return from(context.getResources(), i);
    }

    public static Phrase from(Resources resources, int i) {
        return from(resources.getText(i));
    }

    public static Phrase from(CharSequence charSequence) {
        return new Phrase(charSequence);
    }

    public Phrase put(String str, CharSequence charSequence) {
        if (!this.keys.contains(str)) {
            throw new IllegalArgumentException("Key '" + str + "' not found in '" + this.pattern + "'");
        } else if (charSequence != null) {
            this.keysToValues.put(str, charSequence);
            this.formatted = null;
            return this;
        } else {
            throw new IllegalArgumentException("Null value for '" + str + "' in '" + this.pattern + "'");
        }
    }

    public Phrase put(String str, int i) {
        return put(str, (CharSequence) Integer.toString(i));
    }

    public Phrase putOptional(String str, CharSequence charSequence) {
        return this.keys.contains(str) ? put(str, charSequence) : this;
    }

    public Phrase putOptional(String str, int i) {
        return this.keys.contains(str) ? put(str, i) : this;
    }

    public CharSequence format() {
        if (this.formatted == null) {
            if (this.keysToValues.keySet().containsAll(this.keys)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.pattern);
                for (Token token = this.head; token != null; token = token.next) {
                    token.expand(spannableStringBuilder, this.keysToValues);
                }
                this.formatted = spannableStringBuilder;
            } else {
                HashSet hashSet = new HashSet(this.keys);
                hashSet.removeAll(this.keysToValues.keySet());
                throw new IllegalArgumentException("Missing keys: " + hashSet + " in '" + this.pattern + "'");
            }
        }
        return this.formatted;
    }

    public void into(TextView textView) {
        if (textView != null) {
            textView.setText(format());
            return;
        }
        throw new IllegalArgumentException("TextView must not be null.");
    }

    public String toString() {
        return this.pattern.toString();
    }

    private Phrase(CharSequence charSequence) {
        this.curChar = charSequence.length() > 0 ? charSequence.charAt(0) : 0;
        this.pattern = charSequence;
        Token token = null;
        while (true) {
            token = token(token);
            if (token == null) {
                return;
            }
            if (this.head == null) {
                this.head = token;
            }
        }
    }

    private Token token(Token token) {
        char c = this.curChar;
        if (c == 0) {
            return null;
        }
        if (c != '{') {
            return text(token);
        }
        char lookahead = lookahead();
        if (lookahead == '{') {
            return leftCurlyBracket(token);
        }
        if (lookahead >= 'a' && lookahead <= 'z') {
            return key(token);
        }
        throw new IllegalArgumentException("Unexpected character '" + lookahead + "'; expected key in '" + this.pattern + "'");
    }

    private KeyToken key(Token token) {
        char c;
        char c2;
        StringBuilder sb = new StringBuilder();
        consume();
        while (true) {
            char c3 = this.curChar;
            if ((c3 >= 'a' && c3 <= 'z') || (((c = this.curChar) >= 'A' && c <= 'Z') || (c2 = this.curChar) == '_' || (c2 >= '0' && c2 <= '9'))) {
                sb.append(this.curChar);
                consume();
            }
        }
        if (this.curChar == '}') {
            consume();
            if (sb.length() != 0) {
                String sb2 = sb.toString();
                this.keys.add(sb2);
                return new KeyToken(token, sb2);
            }
            throw new IllegalArgumentException("Empty key: {} in '" + this.pattern + "'");
        }
        throw new IllegalArgumentException("Missing closing brace: } in '" + this.pattern + "'");
    }

    private TextToken text(Token token) {
        int i = this.curCharIndex;
        while (true) {
            char c = this.curChar;
            if (c != '{' && c != 0) {
                consume();
            }
        }
        return new TextToken(token, this.curCharIndex - i);
    }

    private LeftCurlyBracketToken leftCurlyBracket(Token token) {
        consume();
        consume();
        return new LeftCurlyBracketToken(token);
    }

    private char lookahead() {
        if (this.curCharIndex < this.pattern.length() - 1) {
            return this.pattern.charAt(this.curCharIndex + 1);
        }
        return 0;
    }

    private void consume() {
        int i = this.curCharIndex + 1;
        this.curCharIndex = i;
        this.curChar = i == this.pattern.length() ? 0 : this.pattern.charAt(this.curCharIndex);
    }

    private static abstract class Token {
        Token next;
        private final Token prev;

        /* access modifiers changed from: package-private */
        public abstract void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map);

        /* access modifiers changed from: package-private */
        public abstract int getFormattedLength();

        protected Token(Token token) {
            this.prev = token;
            if (token != null) {
                token.next = this;
            }
        }

        /* access modifiers changed from: package-private */
        public final int getFormattedStart() {
            Token token = this.prev;
            if (token == null) {
                return 0;
            }
            return token.getFormattedStart() + this.prev.getFormattedLength();
        }
    }

    private static class TextToken extends Token {
        private final int textLength;

        /* access modifiers changed from: package-private */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
        }

        TextToken(Token token, int i) {
            super(token);
            this.textLength = i;
        }

        /* access modifiers changed from: package-private */
        public int getFormattedLength() {
            return this.textLength;
        }
    }

    private static class LeftCurlyBracketToken extends Token {
        /* access modifiers changed from: package-private */
        public int getFormattedLength() {
            return 1;
        }

        LeftCurlyBracketToken(Token token) {
            super(token);
        }

        /* access modifiers changed from: package-private */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
            int formattedStart = getFormattedStart();
            spannableStringBuilder.replace(formattedStart, formattedStart + 2, "{");
        }
    }

    private static class KeyToken extends Token {
        private final String key;
        private CharSequence value;

        KeyToken(Token token, String str) {
            super(token);
            this.key = str;
        }

        /* access modifiers changed from: package-private */
        public void expand(SpannableStringBuilder spannableStringBuilder, Map<String, CharSequence> map) {
            this.value = map.get(this.key);
            int formattedStart = getFormattedStart();
            spannableStringBuilder.replace(formattedStart, this.key.length() + formattedStart + 2, this.value);
        }

        /* access modifiers changed from: package-private */
        public int getFormattedLength() {
            return this.value.length();
        }
    }
}
