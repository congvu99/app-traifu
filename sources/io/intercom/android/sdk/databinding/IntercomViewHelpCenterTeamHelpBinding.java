package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import io.intercom.android.sdk.R;

public final class IntercomViewHelpCenterTeamHelpBinding implements ViewBinding {
    public final IntercomViewHelpCenterTeamHelpAvatarsBinding helpCenterArticleAvatars;
    public final View helpCenterArticleContactDivider;
    public final TextView helpCenterArticleContactTitle;
    public final MaterialButton helpCenterArticleSendMessage;
    private final ConstraintLayout rootView;

    private IntercomViewHelpCenterTeamHelpBinding(ConstraintLayout constraintLayout, IntercomViewHelpCenterTeamHelpAvatarsBinding intercomViewHelpCenterTeamHelpAvatarsBinding, View view, TextView textView, MaterialButton materialButton) {
        this.rootView = constraintLayout;
        this.helpCenterArticleAvatars = intercomViewHelpCenterTeamHelpAvatarsBinding;
        this.helpCenterArticleContactDivider = view;
        this.helpCenterArticleContactTitle = textView;
        this.helpCenterArticleSendMessage = materialButton;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomViewHelpCenterTeamHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomViewHelpCenterTeamHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_view_help_center_team_help, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomViewHelpCenterTeamHelpBinding bind(View view) {
        int i = R.id.help_center_article_avatars;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            IntercomViewHelpCenterTeamHelpAvatarsBinding bind = IntercomViewHelpCenterTeamHelpAvatarsBinding.bind(findChildViewById);
            i = R.id.help_center_article_contact_divider;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                i = R.id.help_center_article_contact_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.help_center_article_send_message;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton != null) {
                        return new IntercomViewHelpCenterTeamHelpBinding((ConstraintLayout) view, bind, findChildViewById2, textView, materialButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
