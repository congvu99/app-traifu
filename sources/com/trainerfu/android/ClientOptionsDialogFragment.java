package com.trainerfu.android;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientOptionsDialogFragment extends BottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public JSONObject client;
    /* access modifiers changed from: private */
    public int position;

    public static ClientOptionsDialogFragment newInstance() {
        return new ClientOptionsDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        final ClientsFragment clientsFragment = (ClientsFragment) getTargetFragment();
        Bundle arguments = getArguments();
        try {
            this.client = new JSONObject(arguments.getString("client"));
            this.position = arguments.getInt(ViewProps.POSITION);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.client_options, viewGroup, false);
        ((LinearLayout) inflate.findViewById(R.id.diary_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.diaryBtnClicked(ClientOptionsDialogFragment.this.client);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.assessment_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.assessmentBtnClicked(ClientOptionsDialogFragment.this.client);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.notes_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.notesBtnClicked(ClientOptionsDialogFragment.this.client);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.track_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.trackWorkoutClicked(ClientOptionsDialogFragment.this.client);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.settings_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.settingsBtnClicked(ClientOptionsDialogFragment.this.client);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.delete_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clientsFragment.deleteBtnClicked(ClientOptionsDialogFragment.this.position);
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.cancel_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClientOptionsDialogFragment.this.dismiss();
            }
        });
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        dialog.setContentView(LayoutInflater.from(getContext()).inflate(R.layout.client_options, (ViewGroup) null));
    }
}
