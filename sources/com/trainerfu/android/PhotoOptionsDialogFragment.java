package com.trainerfu.android;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class PhotoOptionsDialogFragment extends BottomSheetDialogFragment {
    private int storyId;

    public static PhotoOptionsDialogFragment newInstance() {
        return new PhotoOptionsDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.storyId = getArguments().getInt("storyId");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        final ProgressPhotosFragment progressPhotosFragment = (ProgressPhotosFragment) getTargetFragment();
        View inflate = layoutInflater.inflate(R.layout.photo_options, viewGroup, false);
        ((LinearLayout) inflate.findViewById(R.id.take_picture_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressPhotosFragment.takePicture();
                PhotoOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.choose_picture_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressPhotosFragment.choosePicture();
                PhotoOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.cancel_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PhotoOptionsDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }
}
