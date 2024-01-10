package io.intercom.android.sdk.survey.ui.models;

import io.intercom.android.sdk.utilities.TimeFormatter;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer;", "", "()V", "getLength", "", "DateTimeAnswer", "MultipleAnswer", "NoAnswer", "SingleAnswer", "Lio/intercom/android/sdk/survey/ui/models/Answer$DateTimeAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$SingleAnswer;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Answer.kt */
public abstract class Answer {
    public /* synthetic */ Answer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getLength();

    private Answer() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$DateTimeAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "date", "", "hours", "", "minutes", "(JII)V", "getDate", "()J", "getHours", "()I", "getMinutes", "component1", "component2", "component3", "copy", "equals", "", "other", "", "formatTime", "", "time", "getAnswer", "getDateAsString", "getLength", "getLocalTime", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Answer.kt */
    public static final class DateTimeAnswer extends Answer {
        public static final int $stable = 0;
        private final long date;
        private final int hours;
        private final int minutes;

        public static /* synthetic */ DateTimeAnswer copy$default(DateTimeAnswer dateTimeAnswer, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j = dateTimeAnswer.date;
            }
            if ((i3 & 2) != 0) {
                i = dateTimeAnswer.hours;
            }
            if ((i3 & 4) != 0) {
                i2 = dateTimeAnswer.minutes;
            }
            return dateTimeAnswer.copy(j, i, i2);
        }

        public final long component1() {
            return this.date;
        }

        public final int component2() {
            return this.hours;
        }

        public final int component3() {
            return this.minutes;
        }

        public final DateTimeAnswer copy(long j, int i, int i2) {
            return new DateTimeAnswer(j, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DateTimeAnswer)) {
                return false;
            }
            DateTimeAnswer dateTimeAnswer = (DateTimeAnswer) obj;
            return this.date == dateTimeAnswer.date && this.hours == dateTimeAnswer.hours && this.minutes == dateTimeAnswer.minutes;
        }

        public int hashCode() {
            return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.date) * 31) + this.hours) * 31) + this.minutes;
        }

        public String toString() {
            return "DateTimeAnswer(date=" + this.date + ", hours=" + this.hours + ", minutes=" + this.minutes + ')';
        }

        public DateTimeAnswer(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.date = j;
            this.hours = i;
            this.minutes = i2;
        }

        public final long getDate() {
            return this.date;
        }

        public final int getHours() {
            return this.hours;
        }

        public final int getMinutes() {
            return this.minutes;
        }

        public int getLength() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.date);
            sb.append(this.hours);
            sb.append(this.minutes);
            return sb.toString().length();
        }

        public final String getLocalTime() {
            int i;
            int i2 = this.hours;
            if (i2 == -1 || (i = this.minutes) == -1) {
                return "";
            }
            String formatFromUtcTime = TimeFormatter.formatFromUtcTime(i2, i);
            Intrinsics.checkNotNullExpressionValue(formatFromUtcTime, "formatFromUtcTime(hours, minutes)");
            return formatFromUtcTime;
        }

        public final String getDateAsString() {
            long j = this.date;
            if (j == -1) {
                return "";
            }
            String formatTimeInMillisAsDate = TimeFormatter.formatTimeInMillisAsDate(j, "YYYY-MM-dd");
            Intrinsics.checkNotNullExpressionValue(formatTimeInMillisAsDate, "formatTimeInMillisAsDate(date, \"YYYY-MM-dd\")");
            return formatTimeInMillisAsDate;
        }

        public final String getAnswer() {
            return getDateAsString() + 'T' + formatTime(this.hours) + JsonLexerKt.COLON + formatTime(this.minutes) + ":00Z";
        }

        private final String formatTime(int i) {
            String format = new DecimalFormat("00").format(Integer.valueOf(RangesKt.coerceAtLeast(i, 0)));
            Intrinsics.checkNotNullExpressionValue(format, "formatter.format(time.coerceAtLeast(0))");
            return format;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$SingleAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "answer", "", "(Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getLength", "", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Answer.kt */
    public static final class SingleAnswer extends Answer {
        public static final int $stable = 0;
        private final String answer;

        public static /* synthetic */ SingleAnswer copy$default(SingleAnswer singleAnswer, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = singleAnswer.answer;
            }
            return singleAnswer.copy(str);
        }

        public final String component1() {
            return this.answer;
        }

        public final SingleAnswer copy(String str) {
            Intrinsics.checkNotNullParameter(str, "answer");
            return new SingleAnswer(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SingleAnswer) && Intrinsics.areEqual((Object) this.answer, (Object) ((SingleAnswer) obj).answer);
        }

        public int hashCode() {
            return this.answer.hashCode();
        }

        public String toString() {
            return "SingleAnswer(answer=" + this.answer + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleAnswer(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "answer");
            this.answer = str;
        }

        public final String getAnswer() {
            return this.answer;
        }

        public int getLength() {
            return this.answer.length();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u000e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "answers", "", "", "otherAnswer", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "(Ljava/util/Set;Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;)V", "getAnswers", "()Ljava/util/Set;", "getOtherAnswer", "()Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "component1", "component2", "copy", "copyWithAnswerToggled", "answer", "copyWithOther", "equals", "", "other", "", "", "getLength", "", "hashCode", "toString", "OtherAnswer", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Answer.kt */
    public static final class MultipleAnswer extends Answer {
        public static final int $stable = 8;
        private final Set<String> answers;
        private final OtherAnswer otherAnswer;

        public static /* synthetic */ MultipleAnswer copy$default(MultipleAnswer multipleAnswer, Set<String> set, OtherAnswer otherAnswer2, int i, Object obj) {
            if ((i & 1) != 0) {
                set = multipleAnswer.answers;
            }
            if ((i & 2) != 0) {
                otherAnswer2 = multipleAnswer.otherAnswer;
            }
            return multipleAnswer.copy(set, otherAnswer2);
        }

        public final Set<String> component1() {
            return this.answers;
        }

        public final OtherAnswer component2() {
            return this.otherAnswer;
        }

        public final MultipleAnswer copy(Set<String> set, OtherAnswer otherAnswer2) {
            Intrinsics.checkNotNullParameter(set, "answers");
            Intrinsics.checkNotNullParameter(otherAnswer2, "otherAnswer");
            return new MultipleAnswer(set, otherAnswer2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultipleAnswer)) {
                return false;
            }
            MultipleAnswer multipleAnswer = (MultipleAnswer) obj;
            return Intrinsics.areEqual((Object) this.answers, (Object) multipleAnswer.answers) && Intrinsics.areEqual((Object) this.otherAnswer, (Object) multipleAnswer.otherAnswer);
        }

        public int hashCode() {
            return (this.answers.hashCode() * 31) + this.otherAnswer.hashCode();
        }

        public String toString() {
            return "MultipleAnswer(answers=" + this.answers + ", otherAnswer=" + this.otherAnswer + ')';
        }

        /* renamed from: getAnswers  reason: collision with other method in class */
        public final Set<String> m5315getAnswers() {
            return this.answers;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MultipleAnswer(Set set, OtherAnswer otherAnswer2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(set, (i & 2) != 0 ? OtherAnswer.NotSelected.INSTANCE : otherAnswer2);
        }

        public final OtherAnswer getOtherAnswer() {
            return this.otherAnswer;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "", "()V", "toString", "", "NotSelected", "SelectedNoText", "SelectedWithText", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$NotSelected;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$SelectedNoText;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$SelectedWithText;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Answer.kt */
        public static abstract class OtherAnswer {
            public static final int $stable = 0;

            public /* synthetic */ OtherAnswer(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public String toString() {
                return "";
            }

            private OtherAnswer() {
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$NotSelected;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: Answer.kt */
            public static final class NotSelected extends OtherAnswer {
                public static final int $stable = 0;
                public static final NotSelected INSTANCE = new NotSelected();

                private NotSelected() {
                    super((DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$SelectedNoText;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: Answer.kt */
            public static final class SelectedNoText extends OtherAnswer {
                public static final int $stable = 0;
                public static final SelectedNoText INSTANCE = new SelectedNoText();

                private SelectedNoText() {
                    super((DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer$SelectedWithText;", "Lio/intercom/android/sdk/survey/ui/models/Answer$MultipleAnswer$OtherAnswer;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: Answer.kt */
            public static final class SelectedWithText extends OtherAnswer {
                public static final int $stable = 0;
                private final String text;

                public static /* synthetic */ SelectedWithText copy$default(SelectedWithText selectedWithText, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = selectedWithText.text;
                    }
                    return selectedWithText.copy(str);
                }

                public final String component1() {
                    return this.text;
                }

                public final SelectedWithText copy(String str) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    return new SelectedWithText(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof SelectedWithText) && Intrinsics.areEqual((Object) this.text, (Object) ((SelectedWithText) obj).text);
                }

                public int hashCode() {
                    return this.text.hashCode();
                }

                public final String getText() {
                    return this.text;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public SelectedWithText(String str) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "text");
                    this.text = str;
                }

                public String toString() {
                    return this.text;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultipleAnswer(Set<String> set, OtherAnswer otherAnswer2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, "answers");
            Intrinsics.checkNotNullParameter(otherAnswer2, "otherAnswer");
            this.answers = set;
            this.otherAnswer = otherAnswer2;
        }

        public final Answer copyWithAnswerToggled(String str) {
            Intrinsics.checkNotNullParameter(str, "answer");
            Set mutableSet = CollectionsKt.toMutableSet(this.answers);
            if (this.answers.contains(str)) {
                mutableSet.remove(str);
            } else {
                mutableSet.add(str);
            }
            return (!mutableSet.isEmpty() || !(this.otherAnswer instanceof OtherAnswer.NotSelected)) ? copy$default(this, mutableSet, (OtherAnswer) null, 2, (Object) null) : NoAnswer.ResetNoAnswer.INSTANCE;
        }

        public final Answer copyWithOther(OtherAnswer otherAnswer2) {
            Intrinsics.checkNotNullParameter(otherAnswer2, "otherAnswer");
            return (!this.answers.isEmpty() || !(otherAnswer2 instanceof OtherAnswer.NotSelected)) ? copy$default(this, (Set) null, otherAnswer2, 1, (Object) null) : NoAnswer.ResetNoAnswer.INSTANCE;
        }

        public final List<String> getAnswers() {
            List createListBuilder = CollectionsKt.createListBuilder();
            createListBuilder.addAll(CollectionsKt.toList(this.answers));
            OtherAnswer otherAnswer2 = this.otherAnswer;
            if (!Intrinsics.areEqual((Object) otherAnswer2, (Object) OtherAnswer.NotSelected.INSTANCE)) {
                if (Intrinsics.areEqual((Object) otherAnswer2, (Object) OtherAnswer.SelectedNoText.INSTANCE)) {
                    createListBuilder.add("Other");
                } else if (otherAnswer2 instanceof OtherAnswer.SelectedWithText) {
                    createListBuilder.add(((OtherAnswer.SelectedWithText) this.otherAnswer).getText());
                }
            }
            return CollectionsKt.build(createListBuilder);
        }

        public int getLength() {
            return CollectionsKt.joinToString$default(this.answers, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Answer$MultipleAnswer$getLength$1.INSTANCE, 31, (Object) null).length();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "()V", "getLength", "", "InitialNoAnswer", "ResetNoAnswer", "Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer$InitialNoAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer$ResetNoAnswer;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Answer.kt */
    public static abstract class NoAnswer extends Answer {
        public static final int $stable = 0;

        public /* synthetic */ NoAnswer(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public int getLength() {
            return 0;
        }

        private NoAnswer() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer$InitialNoAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Answer.kt */
        public static final class InitialNoAnswer extends NoAnswer {
            public static final int $stable = 0;
            public static final InitialNoAnswer INSTANCE = new InitialNoAnswer();

            private InitialNoAnswer() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer$ResetNoAnswer;", "Lio/intercom/android/sdk/survey/ui/models/Answer$NoAnswer;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Answer.kt */
        public static final class ResetNoAnswer extends NoAnswer {
            public static final int $stable = 0;
            public static final ResetNoAnswer INSTANCE = new ResetNoAnswer();

            private ResetNoAnswer() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
