package io.intercom.android.sdk.models;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.m5.home.data.IconType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/models/EmptyState;", "", "title", "", "text", "action", "Lio/intercom/android/sdk/models/EmptyState$Action;", "(Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/models/EmptyState$Action;)V", "getAction", "()Lio/intercom/android/sdk/models/EmptyState$Action;", "getText", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Action", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmptyState.kt */
public final class EmptyState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final EmptyState NULL = new EmptyState((String) null, (String) null, (Action) null, 7, (DefaultConstructorMarker) null);
    @SerializedName("action")
    private final Action action;
    @SerializedName("text")
    private final String text;
    @SerializedName("title")
    private final String title;

    public EmptyState() {
        this((String) null, (String) null, (Action) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EmptyState copy$default(EmptyState emptyState, String str, String str2, Action action2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emptyState.title;
        }
        if ((i & 2) != 0) {
            str2 = emptyState.text;
        }
        if ((i & 4) != 0) {
            action2 = emptyState.action;
        }
        return emptyState.copy(str, str2, action2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.text;
    }

    public final Action component3() {
        return this.action;
    }

    public final EmptyState copy(String str, String str2, Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(action2, "action");
        return new EmptyState(str, str2, action2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyState)) {
            return false;
        }
        EmptyState emptyState = (EmptyState) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) emptyState.title) && Intrinsics.areEqual((Object) this.text, (Object) emptyState.text) && Intrinsics.areEqual((Object) this.action, (Object) emptyState.action);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.text.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "EmptyState(title=" + this.title + ", text=" + this.text + ", action=" + this.action + ')';
    }

    public EmptyState(String str, String str2, Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(action2, "action");
        this.title = str;
        this.text = str2;
        this.action = action2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmptyState(String str, String str2, Action action2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new Action((ActionType) null, (String) null, (IconType) null, 7, (DefaultConstructorMarker) null) : action2);
    }

    public final Action getAction() {
        return this.action;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/models/EmptyState$Action;", "", "type", "Lio/intercom/android/sdk/models/ActionType;", "label", "", "icon", "Lio/intercom/android/sdk/m5/home/data/IconType;", "(Lio/intercom/android/sdk/models/ActionType;Ljava/lang/String;Lio/intercom/android/sdk/m5/home/data/IconType;)V", "getIcon", "()Lio/intercom/android/sdk/m5/home/data/IconType;", "getLabel", "()Ljava/lang/String;", "getType", "()Lio/intercom/android/sdk/models/ActionType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EmptyState.kt */
    public static final class Action {
        @SerializedName("icon")
        private final IconType icon;
        @SerializedName("label")
        private final String label;
        @SerializedName("type")
        private final ActionType type;

        public Action() {
            this((ActionType) null, (String) null, (IconType) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Action copy$default(Action action, ActionType actionType, String str, IconType iconType, int i, Object obj) {
            if ((i & 1) != 0) {
                actionType = action.type;
            }
            if ((i & 2) != 0) {
                str = action.label;
            }
            if ((i & 4) != 0) {
                iconType = action.icon;
            }
            return action.copy(actionType, str, iconType);
        }

        public final ActionType component1() {
            return this.type;
        }

        public final String component2() {
            return this.label;
        }

        public final IconType component3() {
            return this.icon;
        }

        public final Action copy(ActionType actionType, String str, IconType iconType) {
            Intrinsics.checkNotNullParameter(actionType, "type");
            Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
            return new Action(actionType, str, iconType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return this.type == action.type && Intrinsics.areEqual((Object) this.label, (Object) action.label) && this.icon == action.icon;
        }

        public int hashCode() {
            int hashCode = ((this.type.hashCode() * 31) + this.label.hashCode()) * 31;
            IconType iconType = this.icon;
            return hashCode + (iconType == null ? 0 : iconType.hashCode());
        }

        public String toString() {
            return "Action(type=" + this.type + ", label=" + this.label + ", icon=" + this.icon + ')';
        }

        public Action(ActionType actionType, String str, IconType iconType) {
            Intrinsics.checkNotNullParameter(actionType, "type");
            Intrinsics.checkNotNullParameter(str, Constants.ScionAnalytics.PARAM_LABEL);
            this.type = actionType;
            this.label = str;
            this.icon = iconType;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Action(ActionType actionType, String str, IconType iconType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ActionType.MESSAGE : actionType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : iconType);
        }

        public final ActionType getType() {
            return this.type;
        }

        public final String getLabel() {
            return this.label;
        }

        public final IconType getIcon() {
            return this.icon;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/models/EmptyState$Companion;", "", "()V", "NULL", "Lio/intercom/android/sdk/models/EmptyState;", "getNULL", "()Lio/intercom/android/sdk/models/EmptyState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EmptyState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EmptyState getNULL() {
            return EmptyState.NULL;
        }
    }
}
