package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.divider.MaterialDivider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent;
import io.intercom.android.sdk.views.IntercomShimmerLayout;

public final class IntercomFragmentHelpCenterArticleBinding implements ViewBinding {
    public final LinearLayout articleContents;
    public final TextView articleErrorTextView;
    public final Group articleErrorViews;
    public final IntercomShimmerLayout articleLoadingView;
    public final IntercomViewHelpCenterReactionBinding articleReactions;
    public final TextView articleRetryButton;
    public final NestedScrollView articleScrollview;
    public final TeamPresenceComponent articleTeamHelp;
    public final Toolbar articleToolbar;
    public final MaterialDivider articleToolbarDivider;
    public final WebView articleWebView;
    private final ConstraintLayout rootView;

    private IntercomFragmentHelpCenterArticleBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, Group group, IntercomShimmerLayout intercomShimmerLayout, IntercomViewHelpCenterReactionBinding intercomViewHelpCenterReactionBinding, TextView textView2, NestedScrollView nestedScrollView, TeamPresenceComponent teamPresenceComponent, Toolbar toolbar, MaterialDivider materialDivider, WebView webView) {
        this.rootView = constraintLayout;
        this.articleContents = linearLayout;
        this.articleErrorTextView = textView;
        this.articleErrorViews = group;
        this.articleLoadingView = intercomShimmerLayout;
        this.articleReactions = intercomViewHelpCenterReactionBinding;
        this.articleRetryButton = textView2;
        this.articleScrollview = nestedScrollView;
        this.articleTeamHelp = teamPresenceComponent;
        this.articleToolbar = toolbar;
        this.articleToolbarDivider = materialDivider;
        this.articleWebView = webView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomFragmentHelpCenterArticleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomFragmentHelpCenterArticleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_fragment_help_center_article, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = io.intercom.android.sdk.R.id.article_reactions;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding bind(android.view.View r15) {
        /*
            int r0 = io.intercom.android.sdk.R.id.article_contents
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_error_text_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_error_views
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_loading_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            io.intercom.android.sdk.views.IntercomShimmerLayout r7 = (io.intercom.android.sdk.views.IntercomShimmerLayout) r7
            if (r7 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_reactions
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r1 == 0) goto L_0x0084
            io.intercom.android.sdk.databinding.IntercomViewHelpCenterReactionBinding r8 = io.intercom.android.sdk.databinding.IntercomViewHelpCenterReactionBinding.bind(r1)
            int r0 = io.intercom.android.sdk.R.id.article_retry_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_scrollview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            androidx.core.widget.NestedScrollView r10 = (androidx.core.widget.NestedScrollView) r10
            if (r10 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_team_help
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent r11 = (io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent) r11
            if (r11 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            androidx.appcompat.widget.Toolbar r12 = (androidx.appcompat.widget.Toolbar) r12
            if (r12 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_toolbar_divider
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            com.google.android.material.divider.MaterialDivider r13 = (com.google.android.material.divider.MaterialDivider) r13
            if (r13 == 0) goto L_0x0084
            int r0 = io.intercom.android.sdk.R.id.article_web_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.webkit.WebView r14 = (android.webkit.WebView) r14
            if (r14 == 0) goto L_0x0084
            io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding r0 = new io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0084:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding");
    }
}
