package io.intercom.android.sdk.post;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.IntercomBaseActivity;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.TimeFormatter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002R?\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lio/intercom/android/sdk/post/PostActivityV2;", "Lio/intercom/android/sdk/activities/IntercomBaseActivity;", "()V", "appConfigProvider", "Lio/intercom/android/sdk/Provider;", "Lio/intercom/android/sdk/identity/AppConfig;", "kotlin.jvm.PlatformType", "getAppConfigProvider", "()Lio/intercom/android/sdk/Provider;", "appConfigProvider$delegate", "Lkotlin/Lazy;", "injector", "Lio/intercom/android/sdk/Injector;", "getInjector", "()Lio/intercom/android/sdk/Injector;", "injector$delegate", "timeFormatter", "Lio/intercom/android/sdk/utilities/TimeFormatter;", "getTimeFormatter", "()Lio/intercom/android/sdk/utilities/TimeFormatter;", "timeFormatter$delegate", "getCOnversationId", "", "getPart", "Lio/intercom/android/sdk/models/Part;", "getUserStatus", "isComposerVisible", "", "isPreview", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openConversation", "sendPostAsRead", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
public final class PostActivityV2 extends IntercomBaseActivity {
    private static final String COMPOSER_IS_VISIBLE = "composer_is_visible";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LAST_PARTICIPANT = "last_participant";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_PART = "parcel_part";
    private static final String POST_PREVIEW = "is_post_preview";
    private final Lazy appConfigProvider$delegate = LazyKt.lazy(new PostActivityV2$appConfigProvider$2(this));
    private final Lazy injector$delegate = LazyKt.lazy(PostActivityV2$injector$2.INSTANCE);
    private final Lazy timeFormatter$delegate = LazyKt.lazy(new PostActivityV2$timeFormatter$2(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/post/PostActivityV2$Companion;", "", "()V", "COMPOSER_IS_VISIBLE", "", "LAST_PARTICIPANT", "PARCEL_CONVERSATION_ID", "PARCEL_PART", "POST_PREVIEW", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PostActivityV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final Injector getInjector() {
        return (Injector) this.injector$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Provider<AppConfig> getAppConfigProvider() {
        return (Provider) this.appConfigProvider$delegate.getValue();
    }

    private final TimeFormatter getTimeFormatter() {
        return (TimeFormatter) this.timeFormatter$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1329969746, true, new PostActivityV2$onCreate$1(this)), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void openConversation() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        String string = extras.getString(PARCEL_CONVERSATION_ID, "");
        LastParticipatingAdmin lastParticipatingAdmin = (LastParticipatingAdmin) extras.getParcelable(LAST_PARTICIPANT);
        if (lastParticipatingAdmin == null) {
            lastParticipatingAdmin = LastParticipatingAdmin.NULL;
        }
        getInjector().getMetricTracker().openedConversationFromFull(string, getPart().getId());
        startActivity(IntercomConversationActivity.Companion.openConversation(this, string, lastParticipatingAdmin));
        finish();
    }

    /* access modifiers changed from: private */
    public final Part getPart() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            if (extras.containsKey(PARCEL_PART)) {
                Part part = (Part) extras.getParcelable(PARCEL_PART);
                if (part != null) {
                    return part;
                }
                Part part2 = Part.NULL;
                Intrinsics.checkNotNullExpressionValue(part2, "NULL");
                return part2;
            }
        }
        Part part3 = Part.NULL;
        Intrinsics.checkNotNullExpressionValue(part3, "NULL");
        return part3;
    }

    /* access modifiers changed from: private */
    public final String getUserStatus() {
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey(LAST_PARTICIPANT)) {
            return "";
        }
        LastParticipatingAdmin lastParticipatingAdmin = (LastParticipatingAdmin) extras.getParcelable(LAST_PARTICIPANT);
        if (LastParticipatingAdmin.isNull(lastParticipatingAdmin)) {
            return "";
        }
        TimeFormatter timeFormatter = getTimeFormatter();
        Intrinsics.checkNotNull(lastParticipatingAdmin);
        timeFormatter.getAdminActiveStatus(lastParticipatingAdmin, getAppConfigProvider());
        return "";
    }

    /* access modifiers changed from: private */
    public final void sendPostAsRead() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(PARCEL_CONVERSATION_ID)) {
            String string = extras.getString(PARCEL_CONVERSATION_ID, "");
            getInjector().getStore().dispatch(Actions.conversationMarkedAsRead(string));
            getInjector().getApi().markConversationAsRead(string);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isComposerVisible() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean(COMPOSER_IS_VISIBLE, true);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean isPreview() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        return extras.getBoolean(POST_PREVIEW, false);
    }

    /* access modifiers changed from: private */
    public final String getCOnversationId() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        String string = extras.getString(PARCEL_CONVERSATION_ID, "");
        Intrinsics.checkNotNullExpressionValue(string, "data.getString(PARCEL_CONVERSATION_ID, \"\")");
        return string;
    }
}
