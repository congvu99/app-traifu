package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomAdminProfileBinding implements ViewBinding {
    public final Space intercomAvatarSpacer;
    public final ImageView intercomBioIcon;
    public final Space intercomBottomSpacer;
    public final TextView intercomCollapsingBio;
    public final LinearLayout intercomCollapsingBioLayout;
    public final TextView intercomCollapsingLocation;
    public final LinearLayout intercomCollapsingLocationLayout;
    public final TextView intercomCollapsingRole;
    public final LinearLayout intercomCollapsingRoleLayout;
    public final TextView intercomCollapsingSubtitle;
    public final View intercomCollapsingTeammateActiveState;
    public final ImageView intercomCollapsingTeammateAvatar1;
    public final ImageView intercomCollapsingTeammateAvatar2;
    public final ImageView intercomCollapsingTeammateAvatar3;
    public final TextView intercomCollapsingTitle;
    public final TextView intercomCollapsingTitleNameOnly;
    public final LinearLayout intercomGroupAvatarHolder;
    public final LinearLayout intercomGroupConversationsBanner;
    public final TextView intercomGroupConversationsBannerTitle;
    public final ImageView intercomLocationIcon;
    public final ImageView intercomRoleIcon;
    public final View intercomTeammateGroupSeparator;
    public final FrameLayout intercomTeammateProfileContainerView;
    public final ImageView linkedinButton;
    private final FrameLayout rootView;
    public final LinearLayout socialButtonLayout;
    public final ImageView teammateWallpaperImage;
    public final RelativeLayout toolbarContentContainer;
    public final ImageView twitterButton;

    private IntercomAdminProfileBinding(FrameLayout frameLayout, Space space, ImageView imageView, Space space2, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, View view, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView5, TextView textView6, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView7, ImageView imageView5, ImageView imageView6, View view2, FrameLayout frameLayout2, ImageView imageView7, LinearLayout linearLayout6, ImageView imageView8, RelativeLayout relativeLayout, ImageView imageView9) {
        this.rootView = frameLayout;
        this.intercomAvatarSpacer = space;
        this.intercomBioIcon = imageView;
        this.intercomBottomSpacer = space2;
        this.intercomCollapsingBio = textView;
        this.intercomCollapsingBioLayout = linearLayout;
        this.intercomCollapsingLocation = textView2;
        this.intercomCollapsingLocationLayout = linearLayout2;
        this.intercomCollapsingRole = textView3;
        this.intercomCollapsingRoleLayout = linearLayout3;
        this.intercomCollapsingSubtitle = textView4;
        this.intercomCollapsingTeammateActiveState = view;
        this.intercomCollapsingTeammateAvatar1 = imageView2;
        this.intercomCollapsingTeammateAvatar2 = imageView3;
        this.intercomCollapsingTeammateAvatar3 = imageView4;
        this.intercomCollapsingTitle = textView5;
        this.intercomCollapsingTitleNameOnly = textView6;
        this.intercomGroupAvatarHolder = linearLayout4;
        this.intercomGroupConversationsBanner = linearLayout5;
        this.intercomGroupConversationsBannerTitle = textView7;
        this.intercomLocationIcon = imageView5;
        this.intercomRoleIcon = imageView6;
        this.intercomTeammateGroupSeparator = view2;
        this.intercomTeammateProfileContainerView = frameLayout2;
        this.linkedinButton = imageView7;
        this.socialButtonLayout = linearLayout6;
        this.teammateWallpaperImage = imageView8;
        this.toolbarContentContainer = relativeLayout;
        this.twitterButton = imageView9;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomAdminProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomAdminProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_admin_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = io.intercom.android.sdk.R.id.intercom_collapsing_teammate_active_state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        r1 = io.intercom.android.sdk.R.id.intercom_teammate_group_separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomAdminProfileBinding bind(android.view.View r33) {
        /*
            r0 = r33
            int r1 = io.intercom.android.sdk.R.id.intercom_avatar_spacer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.Space r5 = (android.widget.Space) r5
            if (r5 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_bio_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_bottom_spacer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.Space r7 = (android.widget.Space) r7
            if (r7 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_bio
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_bio_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_location
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_location_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_role
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_role_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_teammate_active_state
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_teammate_avatar1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_teammate_avatar2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_teammate_avatar3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_collapsing_title_name_only
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_group_avatar_holder
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.LinearLayout r21 = (android.widget.LinearLayout) r21
            if (r21 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_group_conversations_banner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.LinearLayout r22 = (android.widget.LinearLayout) r22
            if (r22 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_group_conversations_banner_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_location_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.ImageView r24 = (android.widget.ImageView) r24
            if (r24 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_role_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.ImageView r25 = (android.widget.ImageView) r25
            if (r25 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.intercom_teammate_group_separator
            android.view.View r26 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r26 == 0) goto L_0x0141
            r27 = r0
            android.widget.FrameLayout r27 = (android.widget.FrameLayout) r27
            int r1 = io.intercom.android.sdk.R.id.linkedin_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.ImageView r28 = (android.widget.ImageView) r28
            if (r28 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.social_button_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.LinearLayout r29 = (android.widget.LinearLayout) r29
            if (r29 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.teammate_wallpaper_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.ImageView r30 = (android.widget.ImageView) r30
            if (r30 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.toolbar_content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.RelativeLayout r31 = (android.widget.RelativeLayout) r31
            if (r31 == 0) goto L_0x0141
            int r1 = io.intercom.android.sdk.R.id.twitter_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.ImageView r32 = (android.widget.ImageView) r32
            if (r32 == 0) goto L_0x0141
            io.intercom.android.sdk.databinding.IntercomAdminProfileBinding r0 = new io.intercom.android.sdk.databinding.IntercomAdminProfileBinding
            r3 = r0
            r4 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return r0
        L_0x0141:
            android.content.res.Resources r0 = r33.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomAdminProfileBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomAdminProfileBinding");
    }
}
