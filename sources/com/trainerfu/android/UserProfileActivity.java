package com.trainerfu.android;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.joanzapata.iconify.widget.IconTextView;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.OnImagePickedHandler;
import com.trainerfu.utils.Util;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class UserProfileActivity extends BaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */
    public int clientId = 0;
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            try {
                Date parse = new SimpleDateFormat("MM/dd/yyy").parse((i2 + 1) + "/" + i3 + "/" + i);
                String replace = DateFormat.getDateFormat(UserProfileActivity.this.getApplicationContext()).format(parse).replace("/", "-");
                String format = new SimpleDateFormat("yyyy-MM-dd").format(parse);
                UserProfileActivity.this.dob.setText(replace);
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3, instance.get(11), instance.get(12), 0);
                try {
                    JSONObject access$900 = UserProfileActivity.this.userProfile;
                    if (UserProfileActivity.this.dob.getText().toString().equals(JsonLexerKt.NULL) || UserProfileActivity.this.dob.getText().toString().length() <= 0) {
                        format = null;
                    }
                    access$900.put("dob", format);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            } catch (ParseException e2) {
                throw new RuntimeException(e2);
            }
        }
    };
    /* access modifiers changed from: private */
    public TextView dob;
    /* access modifiers changed from: private */
    public EditText email;
    /* access modifiers changed from: private */
    public RadioButton female;
    /* access modifiers changed from: private */
    public EditText firstName;
    private boolean forClient = false;
    /* access modifiers changed from: private */
    public EditText lastName;
    private IconTextView mUpdateBtn;
    /* access modifiers changed from: private */
    public RadioButton male;
    /* access modifiers changed from: private */
    public EditText phone;
    /* access modifiers changed from: private */
    public Bitmap profilePicBitmap;
    private View userPassword;
    /* access modifiers changed from: private */
    public JSONObject userProfile;

    public UserProfileActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("forClient")) {
            boolean z = extras.getBoolean("forClient");
            this.forClient = z;
            if (z) {
                this.clientId = extras.getInt("clientId");
            }
        }
        setContentView((int) R.layout.user_profile);
        ((ImageView) findViewById(R.id.profile_iv)).getDrawable().setColorFilter(Color.argb(255, 240, 240, 240), PorterDuff.Mode.SRC_IN);
        ((ImageView) findViewById(R.id.add_iv)).getDrawable().setColorFilter(Color.argb(255, 59, 139, 191), PorterDuff.Mode.SRC_IN);
        this.userProfile = new JSONObject();
        this.firstName = (EditText) findViewById(R.id.first_name);
        this.lastName = (EditText) findViewById(R.id.last_name);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.dob = (TextView) findViewById(R.id.dob);
        this.userPassword = findViewById(R.id.user_password);
        this.dob.setOnClickListener(this);
        this.userPassword.setOnClickListener(this);
        this.male = (RadioButton) findViewById(R.id.radiomale);
        this.female = (RadioButton) findViewById(R.id.radiofemale);
        IconTextView iconTextView = (IconTextView) findViewById(R.id.profile_updatebtn);
        this.mUpdateBtn = iconTextView;
        iconTextView.setOnClickListener(this);
        if (this.forClient) {
            this.userPassword.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        new BaseHttpClient().get(String.format("users/%s/basic_info", new Object[]{Util.getUserIdForUrl(this.clientId)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    String string = jSONObject.getString("phone_number");
                    if (string != null) {
                        if (!string.equals(JsonLexerKt.NULL)) {
                            UserProfileActivity.this.phone.setText(string);
                        }
                    }
                    String string2 = jSONObject.getString("first_name");
                    if (string2 != null && !string2.equals(JsonLexerKt.NULL)) {
                        UserProfileActivity.this.firstName.setText(string2);
                    }
                    String string3 = jSONObject.getString("last_name");
                    if (string3 != null && !string3.equals(JsonLexerKt.NULL)) {
                        UserProfileActivity.this.lastName.setText(string3);
                    }
                    String string4 = jSONObject.getString("email");
                    if (string4 != null && !string4.equals(JsonLexerKt.NULL)) {
                        UserProfileActivity.this.email.setText(string4);
                    }
                    boolean z = jSONObject.getBoolean("is_male");
                    if (z) {
                        UserProfileActivity.this.male.setChecked(true);
                    } else if (!z) {
                        UserProfileActivity.this.female.setChecked(true);
                    }
                    String string5 = jSONObject.getString("dob");
                    if (string5 != null && !string5.equals(JsonLexerKt.NULL)) {
                        UserProfileActivity.this.dob.setText(DateFormat.getDateFormat(UserProfileActivity.this.getApplicationContext()).format(new SimpleDateFormat("yyyy-MM-dd").parse(string5)).replace("/", "-"));
                    }
                    SmartImageView smartImageView = (SmartImageView) UserProfileActivity.this.findViewById(R.id.profile_iv);
                    if (jSONObject.isNull("photo_id") && UserProfileActivity.this.profilePicBitmap == null) {
                        ImageView imageView = (ImageView) UserProfileActivity.this.findViewById(R.id.add_iv);
                        imageView.setVisibility(0);
                        imageView.setClickable(true);
                        UserProfileActivity.this.registerForContextMenu(imageView);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                UserProfileActivity.this.openContextMenu(view);
                            }
                        });
                    } else if (UserProfileActivity.this.profilePicBitmap != null) {
                        smartImageView.setImageBitmap(UserProfileActivity.this.profilePicBitmap);
                    } else {
                        smartImageView.setImageUrl(Util.getUrlForPhoto(jSONObject.getInt("photo_id")));
                    }
                    smartImageView.setClickable(true);
                    UserProfileActivity.this.registerForContextMenu(smartImageView);
                    smartImageView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            UserProfileActivity.this.openContextMenu(view);
                        }
                    });
                    return true;
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radiofemale /*2131363022*/:
                if (isChecked) {
                    try {
                        this.userProfile.put("is_male", false);
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    return;
                }
            case R.id.radiomale /*2131363023*/:
                if (isChecked) {
                    try {
                        this.userProfile.put("is_male", true);
                        return;
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dob) {
            showDialog(0);
        } else if (id == R.id.profile_updatebtn) {
            try {
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                HashMap hashMap = new HashMap();
                hashMap.put("first_name", this.firstName.getText().toString());
                hashMap.put("last_name", this.lastName.getText().toString());
                hashMap.put("phone_number", this.phone.getText().toString().length() > 0 ? this.phone.getText().toString() : "");
                hashMap.put("email", this.email.getText().toString());
                if (!this.userProfile.has("dob")) {
                    hashMap.put("dob", (Object) null);
                } else {
                    hashMap.put("dob", this.userProfile.get("dob"));
                }
                if (!this.userProfile.has("is_male")) {
                    hashMap.put("is_male", (Object) null);
                } else {
                    hashMap.put("is_male", this.userProfile.get("is_male"));
                }
                baseHttpClient.post(String.format("users/%s/basic_info", new Object[]{Util.getUserIdForUrl(this.clientId)}), hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        Util.showToast(UserProfileActivity.this.getApplicationContext(), R.string.profile_update_success);
                        return true;
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (id == R.id.user_password) {
            startActivity(new Intent(getApplicationContext(), ChangePassword.class));
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        ImagePickerUtil.showPickPhotoMenu(this, contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return ImagePickerUtil.onContextItemSelected(menuItem, (Context) this, (Activity) this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        ImagePickerUtil.onRequestPermissionsResult(i, strArr, iArr, (Activity) this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ImagePickerUtil.onActivityResult(this, i, i2, intent, true, new OnImagePickedHandler() {
            public void onImagePicked(final Bitmap bitmap, String str, File file) {
                UserProfileActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Bitmap unused = UserProfileActivity.this.profilePicBitmap = bitmap;
                        ((SmartImageView) UserProfileActivity.this.findViewById(R.id.profile_iv)).setImageBitmap(bitmap);
                        UserProfileActivity.this.findViewById(R.id.add_iv).setVisibility(8);
                        Util.savePhoto(UserProfileActivity.this.clientId, 1, bitmap, (String) null, false, (Runnable) null);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        int i2;
        int i3;
        int i4;
        if (this.dob.getText().toString().length() <= 0) {
            Calendar instance = Calendar.getInstance();
            i2 = instance.get(5);
            i3 = instance.get(2);
            i4 = instance.get(1);
        } else {
            Calendar instance2 = Calendar.getInstance();
            try {
                instance2.setTime(new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateFormat(getApplicationContext())).toLocalizedPattern()).parse(this.dob.getText().toString().replace("-", "/")));
                int i5 = instance2.get(1);
                i2 = instance2.get(5);
                i3 = instance2.get(2);
                i4 = i5;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return new DatePickerDialog(this, this.datePickerListener, i4, i3, i2);
    }
}
