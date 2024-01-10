package org.apache.http.message;

import kotlin.text.Typography;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i <= i2) {
            this.lowerBound = i;
            this.upperBound = i2;
            this.pos = i;
        } else {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getPos() {
        return this.pos;
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.lowerBound);
        } else if (i <= this.upperBound) {
            this.pos = i;
        } else {
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.upperBound);
        }
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public String toString() {
        return JsonLexerKt.BEGIN_LIST + Integer.toString(this.lowerBound) + Typography.greater + Integer.toString(this.pos) + Typography.greater + Integer.toString(this.upperBound) + JsonLexerKt.END_LIST;
    }
}
