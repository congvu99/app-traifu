package com.trainerfu.utils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import com.trainerfu.android.R;

public class ProgressDialogFragment extends DialogFragment {
    private static final String ARG_INDETERMINATE = "indeterminate";
    private static final String ARG_MESSAGE = "message";
    public static boolean DIALOG_CANCELABLE = true;
    public static boolean DIALOG_INDETERMINATE = true;
    public static boolean DIALOG_NOT_INDETERMINATE;

    public static ProgressDialogFragment newInstance() {
        return newInstance(R.string.pleaseWait);
    }

    public static ProgressDialogFragment newInstance(int i) {
        return newInstance(i, DIALOG_INDETERMINATE, DIALOG_CANCELABLE);
    }

    public static ProgressDialogFragment newInstance(int i, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putInt("message", i);
        bundle.putBoolean(ARG_INDETERMINATE, z);
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setArguments(bundle);
        progressDialogFragment.setCancelable(z2);
        return progressDialogFragment;
    }

    public static ProgressDialogFragment newInstance(String str, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        bundle.putBoolean(ARG_INDETERMINATE, z);
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setArguments(bundle);
        progressDialogFragment.setCancelable(z2);
        return progressDialogFragment;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        String string = getString(arguments.getInt("message"));
        if (string == null && (string = getString(arguments.getInt("message"))) == null) {
            string = getString(R.string.pleaseWait);
        }
        boolean z = arguments.getBoolean(ARG_INDETERMINATE, DIALOG_NOT_INDETERMINATE);
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(string);
        progressDialog.setIndeterminate(z);
        return progressDialog;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && isAdded()) {
            dismiss();
        }
    }
}
