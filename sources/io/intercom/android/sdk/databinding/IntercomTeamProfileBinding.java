package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.OfficeHoursTextView;

public final class IntercomTeamProfileBinding implements ViewBinding {
    public final OfficeHoursTextView intercomCollapsingOfficeHours;
    public final ImageView intercomCollapsingTeamAvatar1;
    public final ImageView intercomCollapsingTeamAvatar2;
    public final ImageView intercomCollapsingTeamAvatar3;
    public final TextView intercomCollapsingTeamBio;
    public final TextView intercomCollapsingTeamName1;
    public final TextView intercomCollapsingTeamName2;
    public final TextView intercomCollapsingTeamName3;
    public final TextView intercomCollapsingTitle;
    public final FrameLayout intercomTeamProfile;
    public final LinearLayout intercomTeamProfilesLayout;
    private final FrameLayout rootView;
    public final ImageView teamWallpaperImage;
    public final RelativeLayout toolbarContentContainer;

    private IntercomTeamProfileBinding(FrameLayout frameLayout, OfficeHoursTextView officeHoursTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, FrameLayout frameLayout2, LinearLayout linearLayout, ImageView imageView4, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.intercomCollapsingOfficeHours = officeHoursTextView;
        this.intercomCollapsingTeamAvatar1 = imageView;
        this.intercomCollapsingTeamAvatar2 = imageView2;
        this.intercomCollapsingTeamAvatar3 = imageView3;
        this.intercomCollapsingTeamBio = textView;
        this.intercomCollapsingTeamName1 = textView2;
        this.intercomCollapsingTeamName2 = textView3;
        this.intercomCollapsingTeamName3 = textView4;
        this.intercomCollapsingTitle = textView5;
        this.intercomTeamProfile = frameLayout2;
        this.intercomTeamProfilesLayout = linearLayout;
        this.teamWallpaperImage = imageView4;
        this.toolbarContentContainer = relativeLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomTeamProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomTeamProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_team_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomTeamProfileBinding bind(View view) {
        View view2 = view;
        int i = R.id.intercom_collapsing_office_hours;
        OfficeHoursTextView officeHoursTextView = (OfficeHoursTextView) ViewBindings.findChildViewById(view2, i);
        if (officeHoursTextView != null) {
            i = R.id.intercom_collapsing_team_avatar1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
            if (imageView != null) {
                i = R.id.intercom_collapsing_team_avatar2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView2 != null) {
                    i = R.id.intercom_collapsing_team_avatar3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView3 != null) {
                        i = R.id.intercom_collapsing_team_bio;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView != null) {
                            i = R.id.intercom_collapsing_team_name_1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView2 != null) {
                                i = R.id.intercom_collapsing_team_name_2;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView3 != null) {
                                    i = R.id.intercom_collapsing_team_name_3;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView4 != null) {
                                        i = R.id.intercom_collapsing_title;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView5 != null) {
                                            FrameLayout frameLayout = (FrameLayout) view2;
                                            i = R.id.intercom_team_profiles_layout;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                            if (linearLayout != null) {
                                                i = R.id.team_wallpaper_image;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView4 != null) {
                                                    i = R.id.toolbar_content_container;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (relativeLayout != null) {
                                                        return new IntercomTeamProfileBinding(frameLayout, officeHoursTextView, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, textView5, frameLayout, linearLayout, imageView4, relativeLayout);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
