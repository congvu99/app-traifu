package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.HeaderBackdropType;
import io.intercom.android.sdk.models.HeaderBackgroundModel;
import io.intercom.android.sdk.models.HeaderConfig;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.ColorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J%\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/m5/home/topbars/HomeHeaderStateReducer;", "", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "(Lio/intercom/android/sdk/models/TeamPresence;Lio/intercom/android/sdk/identity/AppConfig;)V", "computeInitialHeaderState", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent;", "configModules", "Lio/intercom/android/sdk/models/ConfigModules;", "getHeaderBackdropStyle", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "headerBackgroundModel", "Lio/intercom/android/sdk/models/HeaderBackgroundModel;", "fallbackBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getHeaderBackdropStyle-4WTKRHQ", "(Lio/intercom/android/sdk/models/HeaderBackgroundModel;J)Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "reduce", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "headerEvent", "Lio/intercom/android/sdk/m5/home/topbars/HeaderEvent;", "currentState", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeaderStateReducer.kt */
public final class HomeHeaderStateReducer {
    private final AppConfig appConfig;
    private final TeamPresence teamPresence;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeHeaderStateReducer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HeaderEvent.values().length];
            iArr[HeaderEvent.INITIAL.ordinal()] = 1;
            iArr[HeaderEvent.WAITING_FOR_CONTENT.ordinal()] = 2;
            iArr[HeaderEvent.IMAGE_LOADED.ordinal()] = 3;
            iArr[HeaderEvent.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HeaderBackdropType.values().length];
            iArr2[HeaderBackdropType.SOLID.ordinal()] = 1;
            iArr2[HeaderBackdropType.COLORS.ordinal()] = 2;
            iArr2[HeaderBackdropType.IMAGE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public HomeHeaderStateReducer(TeamPresence teamPresence2, AppConfig appConfig2) {
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        this.teamPresence = teamPresence2;
        this.appConfig = appConfig2;
    }

    public final HeaderState reduce(HeaderEvent headerEvent, HeaderState headerState) {
        HeaderState headerState2;
        Intrinsics.checkNotNullParameter(headerEvent, "headerEvent");
        Intrinsics.checkNotNullParameter(headerState, "currentState");
        ConfigModules configModules = this.appConfig.getConfigModules();
        if (configModules != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[headerEvent.ordinal()];
            if (i == 1 || i == 2) {
                headerState2 = computeInitialHeaderState(configModules);
            } else if (i != 3) {
                if (i == 4) {
                    headerState2 = new HeaderState.HeaderContent.Reduced("", configModules.getCustomization().getHeader().getBackgroundColor(), configModules.getCustomization().getHeader().getForegroundColor());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (headerState instanceof HeaderState.HeaderContent.Expanded) {
                HeaderState.HeaderContent.Expanded expanded = (HeaderState.HeaderContent.Expanded) headerState;
                headerState2 = HeaderState.HeaderContent.Expanded.copy$default(expanded, false, (String) null, HeaderState.ColoredText.copy$default(expanded.getGreeting(), (String) null, configModules.getHome().getHeader().getContent().getGreeting().getColor(), configModules.getHome().getHeader().getContent().getGreeting().getOpacity(), 1, (Object) null), HeaderState.ColoredText.copy$default(expanded.getIntro(), (String) null, configModules.getHome().getHeader().getContent().getIntro().getColor(), configModules.getHome().getHeader().getContent().getIntro().getOpacity(), 1, (Object) null), (HeaderState.HeaderBackdropStyle) null, false, (List) null, new HeaderState.CloseButtonColor(configModules.getHome().getHeader().getContent().getCloseButton().getBackgroundColor(), configModules.getHome().getHeader().getContent().getCloseButton().getForegroundColor(), configModules.getHome().getHeader().getContent().getCloseButton().getBackgroundOpacity()), 115, (Object) null);
            } else if (Intrinsics.areEqual((Object) headerState, (Object) HeaderState.NoHeader.INSTANCE)) {
                headerState2 = HeaderState.NoHeader.INSTANCE;
            } else if (headerState instanceof HeaderState.HeaderContent.Reduced) {
                headerState2 = HeaderState.NoHeader.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (headerState2 != null) {
                return headerState2;
            }
        }
        return HeaderState.NoHeader.INSTANCE;
    }

    private final HeaderState.HeaderContent computeInitialHeaderState(ConfigModules configModules) {
        Pair pair;
        HeaderState.CloseButtonColor closeButtonColor;
        int i = WhenMappings.$EnumSwitchMapping$1[configModules.getHome().getHeader().getBackground().getType().ordinal()];
        if (i == 1 || i == 2) {
            pair = new Pair(new HeaderState.ColoredText(configModules.getHome().getHeader().getContent().getIntro().getText(), configModules.getHome().getHeader().getContent().getIntro().getColor(), configModules.getHome().getHeader().getContent().getIntro().getOpacity()), new HeaderState.ColoredText(configModules.getHome().getHeader().getContent().getGreeting().getText(), configModules.getHome().getHeader().getContent().getGreeting().getColor(), configModules.getHome().getHeader().getContent().getGreeting().getOpacity()));
        } else if (i == 3) {
            pair = new Pair(new HeaderState.ColoredText(configModules.getHome().getHeader().getContent().getIntro().getText(), configModules.getCustomization().getHeader().getForegroundColor(), 1.0f), new HeaderState.ColoredText(configModules.getHome().getHeader().getContent().getGreeting().getText(), configModules.getCustomization().getHeader().getForegroundColor(), 1.0f));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        HeaderState.ColoredText coloredText = (HeaderState.ColoredText) pair.component1();
        HeaderState.ColoredText coloredText2 = (HeaderState.ColoredText) pair.component2();
        int i2 = WhenMappings.$EnumSwitchMapping$1[configModules.getHome().getHeader().getBackground().getType().ordinal()];
        if (i2 == 1 || i2 == 2) {
            closeButtonColor = new HeaderState.CloseButtonColor(configModules.getHome().getHeader().getContent().getCloseButton().getBackgroundColor(), configModules.getHome().getHeader().getContent().getCloseButton().getForegroundColor(), configModules.getHome().getHeader().getContent().getCloseButton().getBackgroundOpacity());
        } else if (i2 == 3) {
            closeButtonColor = new HeaderState.CloseButtonColor("#000000", configModules.getCustomization().getHeader().getForegroundColor(), 0.5f);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        HeaderState.CloseButtonColor closeButtonColor2 = closeButtonColor;
        HeaderConfig header = configModules.getHome().getHeader();
        if (header.getHeaderExpanded()) {
            boolean z = !StringsKt.isBlank(header.getContent().getLogoUrl());
            String logoUrl = header.getContent().getLogoUrl();
            HeaderState.HeaderBackdropStyle r10 = m5234getHeaderBackdropStyle4WTKRHQ(header.getBackground(), ColorExtensionsKt.toComposeColor$default(configModules.getCustomization().getHeader().getBackgroundColor(), 0.0f, 1, (Object) null));
            boolean showAvatars = header.getContent().getShowAvatars();
            List<Participant> activeAdmins = this.teamPresence.getActiveAdmins();
            Intrinsics.checkNotNullExpressionValue(activeAdmins, "teamPresence.activeAdmins");
            Iterable<Participant> take = CollectionsKt.take(activeAdmins, 3);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
            for (Participant avatar : take) {
                arrayList.add(avatar.getAvatar());
            }
            return new HeaderState.HeaderContent.Expanded(z, logoUrl, coloredText2, coloredText, r10, showAvatars, (List) arrayList, closeButtonColor2);
        }
        return new HeaderState.HeaderContent.Reduced(configModules.getHome().getHeader().getContent().getGreeting().getText(), configModules.getCustomization().getHeader().getBackgroundColor(), configModules.getCustomization().getHeader().getForegroundColor());
    }

    /* renamed from: getHeaderBackdropStyle-4WTKRHQ  reason: not valid java name */
    private final HeaderState.HeaderBackdropStyle m5234getHeaderBackdropStyle4WTKRHQ(HeaderBackgroundModel headerBackgroundModel, long j) {
        List list;
        int i = WhenMappings.$EnumSwitchMapping$1[headerBackgroundModel.getType().ordinal()];
        if (i == 1) {
            return new HeaderState.HeaderBackdropStyle.Solid(ColorKt.Color(ColorUtils.parseColor(headerBackgroundModel.getColor())), headerBackgroundModel.getFade(), (DefaultConstructorMarker) null);
        }
        if (i == 2) {
            List<String> gradient = headerBackgroundModel.getGradient();
            if (gradient != null) {
                Iterable<String> iterable = gradient;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String parseColor : iterable) {
                    arrayList.add(Color.m1922boximpl(ColorKt.Color(ColorUtils.parseColor(parseColor))));
                }
                list = (List) arrayList;
            } else {
                list = CollectionsKt.listOf(Color.m1922boximpl(j), Color.m1922boximpl(j));
            }
            return new HeaderState.HeaderBackdropStyle.Gradient(list, headerBackgroundModel.getFade());
        } else if (i == 3) {
            return new HeaderState.HeaderBackdropStyle.Image(j, headerBackgroundModel.getImageUrl(), headerBackgroundModel.getFade(), (DefaultConstructorMarker) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
