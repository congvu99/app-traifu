package com.trainerfu.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.trainerfu.android.CommentDialogHandler;
import com.trainerfu.android.R;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class CommentUtil {
    public static void showCommentDialog(Context context, final CommentDialogHandler commentDialogHandler) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.comment_dialog, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.comment_et);
        final AlertDialog show = new AlertDialog.Builder(context).setTitle(R.string.Comment).setView(inflate).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String trim = editText.getText().toString().trim();
                if (trim.length() == 0) {
                    commentDialogHandler.commentCancelled();
                } else {
                    commentDialogHandler.commentAdded(trim);
                }
            }
        }).setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                commentDialogHandler.commentCancelled();
            }
        }).show();
        show.getButton(-1).setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editText.getText().toString().trim().length() == 0) {
                    show.getButton(-1).setEnabled(false);
                } else {
                    show.getButton(-1).setEnabled(true);
                }
            }
        });
    }

    public static void addCommentToWorkoutLog(int i, Date date, final String str, boolean z, final CommentDialogHandler commentDialogHandler) {
        String format = String.format("/users/%s/day_logs/%s/comments/new", new Object[]{i <= 0 ? "myself" : String.valueOf(i), DateUtils.getISOFormattedDate(date)});
        HashMap hashMap = new HashMap();
        hashMap.put("comment", str);
        hashMap.put("is_featured", Boolean.valueOf(z));
        new BaseHttpClient().put(format, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                CommentDialogHandler commentDialogHandler = commentDialogHandler;
                if (commentDialogHandler == null) {
                    return true;
                }
                commentDialogHandler.commentAdded(str);
                return true;
            }
        });
    }

    public static void addCommentToPhoto(int i, final String str, final CommentDialogHandler commentDialogHandler) {
        String format = String.format("/users_photos/%s/comments/new", new Object[]{Integer.valueOf(i)});
        HashMap hashMap = new HashMap();
        hashMap.put("comment", str);
        new BaseHttpClient().put(format, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                CommentDialogHandler commentDialogHandler = commentDialogHandler;
                if (commentDialogHandler == null) {
                    return true;
                }
                commentDialogHandler.commentAdded(str);
                return true;
            }
        });
    }
}
