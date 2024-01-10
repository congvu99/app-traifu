package com.trainerfu.android;

import android.app.Dialog;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.greenrobot.eventbus.EventBus;

public class EditTextDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        String str = "";
        String trim = arguments.getString("text") == null ? str : arguments.getString("text").trim();
        if (arguments.getString(ViewHierarchyConstants.HINT_KEY) != null) {
            str = arguments.getString(ViewHierarchyConstants.HINT_KEY).trim();
        }
        final String string = arguments.getString("info");
        final int i = arguments.getInt("request_code");
        MaterialDialog build = new MaterialDialog.Builder(getActivity()).customView((int) R.layout.edittext_dialog, false).positiveText((int) R.string.Save).negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).onPositive(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                EditTextDialogFragment.this.getActivity().getWindow().setSoftInputMode(3);
                EventBus.getDefault().post(new TextEditedEvent(i, string, ((EditText) materialDialog.getCustomView().findViewById(R.id.et_view)).getText().toString().trim()));
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                EditTextDialogFragment.this.getActivity().getWindow().setSoftInputMode(3);
            }
        }).build();
        if (trim != null) {
            EditText editText = (EditText) build.getCustomView().findViewById(R.id.et_view);
            editText.setText(trim);
            editText.setSelection(trim.length());
            editText.setHint(str);
        }
        ((EditText) build.getCustomView().findViewById(R.id.et_view)).requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
        return build;
    }

    public void dismiss() {
        super.dismiss();
        getActivity().getWindow().setSoftInputMode(3);
    }
}
