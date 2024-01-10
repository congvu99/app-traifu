package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreen;
import io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent;

public final class IntercomActivityArticleSearchBinding implements ViewBinding {
    public final ImageButton clearSearch;
    private final ConstraintLayout rootView;
    public final EditText searchBar;
    public final TextView searchError;
    public final TeamPresenceComponent searchErrorTeamHelp;
    public final Group searchErrors;
    public final HelpCenterLoadingScreen searchLoading;
    public final RecyclerView searchResultRecyclerView;
    public final Toolbar toolbar;
    public final View toolbarDivider;

    private IntercomActivityArticleSearchBinding(ConstraintLayout constraintLayout, ImageButton imageButton, EditText editText, TextView textView, TeamPresenceComponent teamPresenceComponent, Group group, HelpCenterLoadingScreen helpCenterLoadingScreen, RecyclerView recyclerView, Toolbar toolbar2, View view) {
        this.rootView = constraintLayout;
        this.clearSearch = imageButton;
        this.searchBar = editText;
        this.searchError = textView;
        this.searchErrorTeamHelp = teamPresenceComponent;
        this.searchErrors = group;
        this.searchLoading = helpCenterLoadingScreen;
        this.searchResultRecyclerView = recyclerView;
        this.toolbar = toolbar2;
        this.toolbarDivider = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityArticleSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityArticleSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_article_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = io.intercom.android.sdk.R.id.toolbar_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding bind(android.view.View r13) {
        /*
            int r0 = io.intercom.android.sdk.R.id.clear_search
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r4 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_error_team_help
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent r7 = (io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent) r7
            if (r7 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_errors
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            androidx.constraintlayout.widget.Group r8 = (androidx.constraintlayout.widget.Group) r8
            if (r8 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreen r9 = (io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreen) r9
            if (r9 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.search_result_recycler_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            androidx.appcompat.widget.Toolbar r11 = (androidx.appcompat.widget.Toolbar) r11
            if (r11 == 0) goto L_0x006a
            int r0 = io.intercom.android.sdk.R.id.toolbar_divider
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r12 == 0) goto L_0x006a
            io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding r0 = new io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding");
    }
}
