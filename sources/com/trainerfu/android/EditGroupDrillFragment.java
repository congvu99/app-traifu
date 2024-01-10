package com.trainerfu.android;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.AppEventsConstants;
import io.intercom.android.sdk.models.Part;
import org.json.JSONException;
import org.json.JSONObject;

public class EditGroupDrillFragment extends DialogFragment {

    public interface EventListener {
        void groupDrillEdited(int i, JSONObject jSONObject, String str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        try {
            final int i = arguments.getInt("start_drill_id");
            final JSONObject jSONObject = new JSONObject(arguments.getString("measures"));
            String trim = arguments.getString(Part.NOTE_MESSAGE_STYLE).trim();
            MaterialDialog build = new MaterialDialog.Builder(getActivity()).customView((int) R.layout.group_drill_edit_view, false).positiveText((int) R.string.Save).negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    EditGroupDrillFragment.this.getActivity().getWindow().setSoftInputMode(3);
                    ViewGroup viewGroup = (ViewGroup) materialDialog.getCustomView();
                    EditText editText = (EditText) viewGroup.findViewById(R.id.note_et);
                    String trim = ((EditText) viewGroup.findViewById(R.id.sets_et)).getText().toString().trim();
                    try {
                        JSONObject jSONObject = jSONObject;
                        if (trim.length() == 0) {
                            trim = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        jSONObject.put("8", trim);
                        ((EventListener) EditGroupDrillFragment.this.getActivity()).groupDrillEdited(i, jSONObject, editText.getText().toString().trim());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    EditGroupDrillFragment.this.getActivity().getWindow().setSoftInputMode(3);
                }
            }).build();
            EditText editText = (EditText) build.getCustomView().findViewById(R.id.sets_et);
            String trim2 = jSONObject.getString("8").trim();
            if (!trim2.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                editText.setText(trim2);
                editText.setSelection(trim2.length());
            }
            EditText editText2 = (EditText) build.getCustomView().findViewById(R.id.note_et);
            if (trim.length() > 0) {
                editText2.setText(trim);
                editText2.setSelection(trim.length());
            }
            return build;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
