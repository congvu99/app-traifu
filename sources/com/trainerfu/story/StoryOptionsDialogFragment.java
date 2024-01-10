package com.trainerfu.story;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.trainerfu.android.R;

public class StoryOptionsDialogFragment extends BottomSheetDialogFragment {
    private int myUserId;
    /* access modifiers changed from: private */
    public int storyId;
    /* access modifiers changed from: private */
    public int userId;

    public static StoryOptionsDialogFragment newInstance() {
        return new StoryOptionsDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.storyId = getArguments().getInt("storyId");
        this.userId = getArguments().getInt("userId");
        this.myUserId = getArguments().getInt("myUserId");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        final StoryListFragment storyListFragment = (StoryListFragment) getTargetFragment();
        Bundle arguments = getArguments();
        String string = arguments.getString("postPrivacy");
        String string2 = arguments.getString("postPin");
        arguments.getString("postVisible");
        Boolean valueOf = Boolean.valueOf(arguments.getBoolean("amITrainer"));
        View inflate = layoutInflater.inflate(R.layout.story_options, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.postPrivacy)).setText(string);
        ((TextView) inflate.findViewById(R.id.postPin)).setText(string2);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.post_privacy_view);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.post_pin_view);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.post_delete_view);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.flag_post_view);
        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.report_user_view);
        LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.block_user_view);
        LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.cancel_view);
        if (!valueOf.booleanValue()) {
            linearLayout2.setVisibility(8);
            if (this.myUserId != this.userId) {
                linearLayout.setVisibility(8);
                linearLayout3.setVisibility(8);
                linearLayout4.setVisibility(0);
                linearLayout5.setVisibility(0);
                linearLayout6.setVisibility(0);
            }
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                storyListFragment.togglePrivacy(StoryOptionsDialogFragment.this.storyId);
                StoryOptionsDialogFragment.this.dismiss();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                storyListFragment.togglePinned(StoryOptionsDialogFragment.this.storyId);
                StoryOptionsDialogFragment.this.dismiss();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                storyListFragment.delete(StoryOptionsDialogFragment.this.storyId);
                StoryOptionsDialogFragment.this.dismiss();
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new MaterialDialog.Builder(StoryOptionsDialogFragment.this.getActivity()).title((int) R.string.flagPost).content((CharSequence) String.format(StoryOptionsDialogFragment.this.getString(R.string.flagPostConfirmation), new Object[0])).positiveText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.Yes)).negativeText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.No)).onNegative(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).onPositive(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        storyListFragment.flagPost(StoryOptionsDialogFragment.this.storyId);
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).build().show();
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new MaterialDialog.Builder(StoryOptionsDialogFragment.this.getActivity()).title((int) R.string.reportUser).content((CharSequence) String.format(StoryOptionsDialogFragment.this.getString(R.string.reportUserConfirmation), new Object[0])).positiveText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.Yes)).negativeText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.No)).onNegative(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).onPositive(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        storyListFragment.reportUser(StoryOptionsDialogFragment.this.userId);
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).build().show();
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new MaterialDialog.Builder(StoryOptionsDialogFragment.this.getActivity()).title((int) R.string.flagPost).content((CharSequence) String.format(StoryOptionsDialogFragment.this.getString(R.string.blockUserConfirmation), new Object[0])).positiveText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.Yes)).negativeText((CharSequence) StoryOptionsDialogFragment.this.getString(R.string.No)).onNegative(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).onPositive(new MaterialDialog.SingleButtonCallback() {
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        storyListFragment.blockUser(StoryOptionsDialogFragment.this.userId);
                        StoryOptionsDialogFragment.this.dismiss();
                    }
                }).build().show();
            }
        });
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoryOptionsDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        dialog.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.story_options, (ViewGroup) null));
    }
}
