package io.intercom.android.sdk.m5.helpcenter;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterScreen.kt */
final class HelpCenterScreenKt$HelpCenterNavGraph$1 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ Context $context;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ HelpCenterViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterScreenKt$HelpCenterNavGraph$1(HelpCenterViewModel helpCenterViewModel, List<String> list, NavHostController navHostController, Context context) {
        super(1);
        this.$viewModel = helpCenterViewModel;
        this.$collectionIds = list;
        this.$navController = navHostController;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavGraphBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$NavHost");
        String name = HelpCenterDestination.COLLECTIONS.name();
        final HelpCenterViewModel helpCenterViewModel = this.$viewModel;
        final List<String> list = this.$collectionIds;
        final NavHostController navHostController = this.$navController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, name, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(346249008, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                HelpCenterViewModel helpCenterViewModel = helpCenterViewModel;
                List<String> list = list;
                final NavHostController navHostController = navHostController;
                final NavHostController navHostController2 = navHostController;
                HelpCenterCollectionListScreenKt.HelpCenterCollectionListScreen(helpCenterViewModel, list, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "collectionId");
                        NavController.navigate$default(navHostController, HelpCenterDestination.COLLECTION.name() + '/' + str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
                    }
                }, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "collectionId");
                        NavHostController navHostController = navHostController2;
                        navHostController.navigate(HelpCenterDestination.COLLECTION.name() + '/' + str, (Function1<? super NavOptionsBuilder, Unit>) AnonymousClass1.INSTANCE);
                    }
                }, composer, 72);
            }
        }), 6, (Object) null);
        List listOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument("id", AnonymousClass2.INSTANCE));
        final HelpCenterViewModel helpCenterViewModel2 = this.$viewModel;
        final Context context = this.$context;
        NavGraphBuilderKt.composable$default(navGraphBuilder, HelpCenterDestination.COLLECTION.name() + "/{id}", listOf, (List) null, ComposableLambdaKt.composableLambdaInstance(369134119, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                String str;
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                Bundle arguments = navBackStackEntry.getArguments();
                if (arguments == null || (str = arguments.getString("id")) == null) {
                    str = "";
                }
                final HelpCenterViewModel helpCenterViewModel = helpCenterViewModel2;
                final Context context = context;
                HelpCenterSectionListScreenKt.HelpCenterSectionListScreen(helpCenterViewModel, str, new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "articleId");
                        helpCenterViewModel.onArticleClicked(str);
                        context.startActivity(ArticleActivity.Companion.buildIntent(context, new ArticleActivity.ArticleActivityArguments(str, MetricTracker.Place.COLLECTION_LIST, false)));
                    }
                }, composer, 8, 0);
            }
        }), 4, (Object) null);
        String name2 = HelpCenterDestination.COLLECTION.name();
        final HelpCenterViewModel helpCenterViewModel3 = this.$viewModel;
        final List<String> list2 = this.$collectionIds;
        final Context context2 = this.$context;
        NavGraphBuilderKt.composable$default(navGraphBuilder, name2, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(1879155944, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                final HelpCenterViewModel helpCenterViewModel = helpCenterViewModel3;
                final Context context = context2;
                HelpCenterSectionListScreenKt.HelpCenterSectionListScreen(helpCenterViewModel3, (String) CollectionsKt.first(list2), new Function1<String, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "articleId");
                        helpCenterViewModel.onArticleClicked(str);
                        context.startActivity(ArticleActivity.Companion.buildIntent(context, new ArticleActivity.ArticleActivityArguments(str, MetricTracker.Place.COLLECTION_LIST, false)));
                    }
                }, composer, 8, 0);
            }
        }), 6, (Object) null);
    }
}
