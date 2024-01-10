package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.legacy.app.FragmentCompat;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.OnImagePickedHandler;
import com.trainerfu.utils.Util;
import com.uploadcare.android.widget.controller.UploadcareWidget;
import com.uploadcare.android.widget.controller.UploadcareWidgetResult;
import io.intercom.android.sdk.models.Part;
import io.sentry.Sentry;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutLogFragment extends Fragment implements FragmentCompat.OnRequestPermissionsResultCallback {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private static Drawable addPhotoDrawable = ResourcesCompat.getDrawable(MyApplication.getAppContext().getResources(), R.drawable.media_image_add, (Resources.Theme) null);
    /* access modifiers changed from: private */
    public ArrayAdapter adapter;
    /* access modifiers changed from: private */
    public ImageView addPhotoIV;
    /* access modifiers changed from: private */
    public EditText commentET;
    /* access modifiers changed from: private */
    public ImageView deleteExerciseBtn;
    /* access modifiers changed from: private */
    public JSONArray drills = null;
    /* access modifiers changed from: private */
    public ListView fileListView;
    /* access modifiers changed from: private */
    public JSONArray files = new JSONArray();
    private FileListAdapter filesAdapter;
    /* access modifiers changed from: private */
    public View footerView;
    private boolean forAttachment = false;
    private boolean forceReloadData = false;
    /* access modifiers changed from: private */
    public View headerView;
    /* access modifiers changed from: private */
    public JSONObject history;
    /* access modifiers changed from: private */
    public boolean isSaving;
    /* access modifiers changed from: private */
    public boolean loadedOnce = false;
    private Date logDate;
    private Menu menu;
    /* access modifiers changed from: private */
    public String photoFilePath;
    /* access modifiers changed from: private */
    public ImageView photoIV;
    /* access modifiers changed from: private */
    public FrameLayout photoViewWrapper;
    private MenuItem postItem;
    private Drawable postItemDrawable;
    /* access modifiers changed from: private */
    public int userId;
    private View view;

    public interface EventListener {
        void addExerciseClicked();

        void drillEditClicked(Bundle bundle, JSONObject jSONObject, String str, JSONObject jSONObject2);

        void logSaveCancelled();

        void logSaved();
    }

    public void onCreate(Bundle bundle) {
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.view = layoutInflater.inflate(R.layout.workout_log_view, viewGroup, false);
        this.logDate = DateUtils.getTodaysDate();
        this.userId = getArguments().getInt("user_id");
        final ListView listView = (ListView) this.view.findViewById(R.id.drill_list);
        View inflate = layoutInflater.inflate(R.layout.workout_log_header_view, (ViewGroup) null, false);
        this.headerView = inflate;
        inflate.setVisibility(8);
        listView.addHeaderView(this.headerView);
        View inflate2 = layoutInflater.inflate(R.layout.workout_log_footer_view, (ViewGroup) null, false);
        this.footerView = inflate2;
        inflate2.setVisibility(8);
        listView.addFooterView(this.footerView);
        registerForContextMenu(listView);
        this.adapter = new ArrayAdapter(getActivity());
        this.fileListView = (ListView) this.view.findViewById(R.id.file_list_view);
        FileListAdapter fileListAdapter = new FileListAdapter(getActivity());
        this.filesAdapter = fileListAdapter;
        this.fileListView.setAdapter(fileListAdapter);
        listView.setAdapter(this.adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    JSONObject jSONObject = (JSONObject) listView.getItemAtPosition(i);
                    Bundle bundle = new Bundle();
                    bundle.putInt("drill_id", jSONObject.getInt("drill_id"));
                    bundle.putInt("exercise_id", jSONObject.getInt("exercise_id"));
                    bundle.putString("exercise_name", jSONObject.getString("exercise_name"));
                    bundle.putString(Part.NOTE_MESSAGE_STYLE, jSONObject.getString(Part.NOTE_MESSAGE_STYLE));
                    ((EventListener) WorkoutLogFragment.this.getActivity()).drillEditClicked(bundle, jSONObject.getJSONObject("measures"), jSONObject.getString("rest_time"), WorkoutLogFragment.this.history);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                ((InputMethodManager) WorkoutLogFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(WorkoutLogFragment.this.headerView.findViewById(R.id.commentET).getWindowToken(), 0);
            }
        });
        this.view.findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutLogFragment.this.save();
            }
        });
        ImageView imageView = (ImageView) this.headerView.findViewById(R.id.addPhotoBtn);
        this.addPhotoIV = imageView;
        registerForContextMenu(imageView);
        this.addPhotoIV.setImageDrawable(addPhotoDrawable);
        this.addPhotoIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.showContextMenu();
            }
        });
        this.photoIV = (ImageView) this.headerView.findViewById(R.id.photoIV);
        this.photoViewWrapper = (FrameLayout) this.headerView.findViewById(R.id.photo_view_wrapper);
        registerForContextMenu(this.photoIV);
        this.photoIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.showContextMenu();
            }
        });
        EditText editText = (EditText) this.headerView.findViewById(R.id.commentET);
        this.commentET = editText;
        editText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        ((LinearLayout) this.footerView.findViewById(R.id.addExerciseBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((EventListener) WorkoutLogFragment.this.getActivity()).addExerciseClicked();
            }
        });
        this.commentET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() != 0) {
                    WorkoutLogFragment.this.changePostItemIcon();
                } else {
                    WorkoutLogFragment.this.changePostItemIcon();
                }
            }
        });
        focusEditText(this.commentET);
        return this.view;
    }

    public void focusEditText(View view2) {
        this.commentET.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.commentET, 1);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("photoAdded", Boolean.valueOf(this.photoIV.getVisibility() == 0).booleanValue());
        SparseArray sparseArray = new SparseArray();
        this.headerView.saveHierarchyState(sparseArray);
        bundle.putSparseParcelableArray("headerState", sparseArray);
        SparseArray sparseArray2 = new SparseArray();
        this.footerView.saveHierarchyState(sparseArray2);
        bundle.putSparseParcelableArray("footerState", sparseArray2);
        String str = this.photoFilePath;
        if (str != null) {
            bundle.putString("photoFilePath", str);
        }
        JSONArray jSONArray = this.drills;
        if (jSONArray != null) {
            bundle.putString("drills", jSONArray.toString());
        }
        bundle.putString("logDate", DateUtils.getISOFormattedDate(this.logDate));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.forceReloadData = true;
            if (bundle.containsKey("drills")) {
                try {
                    this.drills = new JSONArray(bundle.getString("drills"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            this.logDate = DateUtils.getDateFromISOFormat(bundle.getString("logDate"));
            if (bundle.getBoolean("photoAdded")) {
                this.addPhotoIV.setVisibility(8);
                this.photoIV.setVisibility(0);
                this.photoViewWrapper.setVisibility(0);
                String string = bundle.getString("photoFilePath");
                this.photoFilePath = string;
                this.photoIV.setImageBitmap(Util.scaleBitmapForStory(string));
            } else {
                this.addPhotoIV.setVisibility(0);
                this.photoIV.setVisibility(8);
                this.photoViewWrapper.setVisibility(8);
                this.addPhotoIV.setVisibility(0);
            }
            this.headerView.restoreHierarchyState(bundle.getSparseParcelableArray("headerState"));
            this.footerView.restoreHierarchyState(bundle.getSparseParcelableArray("footerState"));
            this.headerView.setVisibility(0);
            this.footerView.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.drills == null || this.forceReloadData) {
            boolean z = false;
            this.forceReloadData = false;
            if (this.drills == null) {
                z = true;
            }
            reloadData(z);
        }
        fetchHistory();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (isAdded()) {
            try {
                UploadcareWidgetResult fromIntent = UploadcareWidgetResult.fromIntent(intent);
                if (fromIntent.getException() != null) {
                    Sentry.captureMessage(fromIntent.getException().getMessage());
                    return;
                }
                if (fromIntent != null) {
                    if (this.forAttachment) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (fromIntent.getUploadcareFile() != null) {
                                if (fromIntent.getUploadcareFile().getOriginalFileUrl() != null) {
                                    jSONObject.put("name", fromIntent.getUploadcareFile().getOriginalFilename());
                                    jSONObject.put("url", fromIntent.getUploadcareFile().getOriginalFileUrl().toString());
                                    this.files.put(jSONObject);
                                } else {
                                    jSONObject.put("name", fromIntent.getUploadcareFile().getOriginalFilename());
                                    jSONObject.put("url", "https://ucarecdn.com/" + fromIntent.getUploadcareFile().getUuid() + "/" + fromIntent.getUploadcareFile().getOriginalFilename());
                                    this.files.put(jSONObject);
                                }
                            }
                        } catch (JSONException e) {
                            Util.showToast(getActivity(), R.string.unsupportedFileFormat);
                            e.printStackTrace();
                            Sentry.captureException(e);
                        }
                        this.fileListView.setVisibility(0);
                        this.filesAdapter.notifyDataSetChanged();
                        setListViewHeightBasedOnChildren(this.fileListView);
                    }
                    changePostItemIcon();
                }
                if (i2 == -1) {
                    ImagePickerUtil.onActivityResult(getActivity(), i, i2, intent, false, new OnImagePickedHandler() {
                        public void onImagePicked(final Bitmap bitmap, final String str, File file) {
                            if (WorkoutLogFragment.this.isAdded()) {
                                WorkoutLogFragment.this.getActivity().runOnUiThread(new Runnable() {
                                    public void run() {
                                        WorkoutLogFragment.this.addPhotoIV.setVisibility(8);
                                        WorkoutLogFragment.this.photoIV.setVisibility(0);
                                        WorkoutLogFragment.this.photoViewWrapper.setVisibility(0);
                                        WorkoutLogFragment.this.photoIV.setImageBitmap(bitmap);
                                        String unused = WorkoutLogFragment.this.photoFilePath = str;
                                        WorkoutLogFragment.this.changePostItemIcon();
                                    }
                                });
                            }
                        }
                    });
                }
            } catch (Exception e2) {
                Sentry.captureException(e2);
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.workout_log, menu2);
        this.menu = menu2;
        this.postItem = menu2.findItem(R.id.action_save);
        MenuItem findItem = menu2.findItem(R.id.action_more);
        findItem.setVisible(true);
        this.postItem.setVisible(true);
        Drawable icon = this.postItem.getIcon();
        this.postItemDrawable = icon;
        this.postItemDrawable = DrawableCompat.wrap(icon);
        Drawable wrap = DrawableCompat.wrap(findItem.getIcon());
        DrawableCompat.setTint(wrap, ContextCompat.getColor(getContext(), R.color.iconColor));
        findItem.setIcon(wrap);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        if (view2.getId() == R.id.addPhotoBtn) {
            ImagePickerUtil.showPickPhotoMenu(getActivity(), contextMenu);
        } else if (view2.getId() == R.id.photoIV) {
            new MenuInflater(getActivity()).inflate(R.menu.remove_photo, contextMenu);
        } else if (view2.getId() == R.id.drill_list && ((AdapterView.AdapterContextMenuInfo) contextMenuInfo).position > 0) {
            new MenuInflater(getActivity()).inflate(R.menu.delete_exercise, contextMenu);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (ImagePickerUtil.isImagePickerMenuItem(menuItem)) {
            ImagePickerUtil.onContextItemSelected(menuItem, (Context) getActivity(), (Fragment) this);
        } else if (menuItem.getItemId() == R.id.removePhotoItem) {
            removePhoto();
        } else if (menuItem.getItemId() == R.id.deleteExerciseItem) {
            deleteDrillAtIndex(((AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo()).position - 1);
        }
        return true;
    }

    public void deleteDrillAtIndex(int i) {
        try {
            int i2 = ((JSONObject) this.drills.get(i)).getInt("drill_id");
            new BaseHttpClient(false, getActivity()).delete(String.format("/user_drills/%s", new Object[]{String.valueOf(i2)}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < this.drills.length(); i3++) {
                JSONObject jSONObject = (JSONObject) this.drills.get(i3);
                if (jSONObject.getInt("drill_id") != i2) {
                    jSONArray.put(jSONObject);
                }
            }
            this.drills = jSONArray;
            changePostItemIcon();
            this.adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void reloadData(boolean z) {
        new BaseHttpClient(Boolean.valueOf(z), getActivity()).get(String.format("/users/%s/day_logs/%s", new Object[]{Util.getUserIdForUrl(this.userId), DateUtils.getISOFormattedDate(this.logDate)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!WorkoutLogFragment.this.isAdded()) {
                    return true;
                }
                try {
                    WorkoutLogFragment.this.headerView.setVisibility(0);
                    WorkoutLogFragment.this.footerView.setVisibility(0);
                    JSONArray unused = WorkoutLogFragment.this.drills = jSONObject.getJSONArray("drills");
                    WorkoutLogFragment.this.changePostItemIcon();
                    WorkoutLogFragment.this.adapter.notifyDataSetChanged();
                    if (!WorkoutLogFragment.this.loadedOnce && jSONObject.has(Part.NOTE_MESSAGE_STYLE)) {
                        WorkoutLogFragment.this.commentET.setText(jSONObject.getString(Part.NOTE_MESSAGE_STYLE));
                    }
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void fetchHistory() {
        new BaseHttpClient().get(String.format("users/%s/exercise_stats/all_logged_exercises_history", new Object[]{Util.getUserIdForUrl(this.userId)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!WorkoutLogFragment.this.isAdded()) {
                    return true;
                }
                try {
                    JSONObject unused = WorkoutLogFragment.this.history = jSONObject.getJSONObject("history");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    public void addExerciseToLog(JSONObject jSONObject) {
        int i = this.userId;
        String format = String.format("/users/%s/day_logs/%s/new", new Object[]{i == 0 ? "myself" : Integer.toString(i), DateUtils.getISOFormattedDate(this.logDate)});
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("exercise_id", Integer.valueOf(jSONObject.getInt("id")));
            new BaseHttpClient(true, getActivity()).put(format, hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    WorkoutLogFragment.this.reloadData(false);
                    return true;
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r2 = (android.graphics.drawable.BitmapDrawable) r11.photoIV.getDrawable();
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save() {
        /*
            r11 = this;
            boolean r0 = r11.isSaving
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            org.json.JSONArray r0 = r11.drills
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            r0 = 1
            r11.isSaving = r0
            android.view.View r1 = r11.view
            r2 = 2131363165(0x7f0a055d, float:1.8346131E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.Switch r1 = (android.widget.Switch) r1
            boolean r1 = r1.isChecked()
            android.widget.EditText r2 = r11.commentET
            android.text.Editable r2 = r2.getText()
            java.lang.String r8 = r2.toString()
            android.widget.ImageView r2 = r11.photoIV
            int r2 = r2.getVisibility()
            r9 = 0
            if (r2 != 0) goto L_0x003f
            android.widget.ImageView r2 = r11.photoIV
            android.graphics.drawable.Drawable r2 = r2.getDrawable()
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
            if (r2 == 0) goto L_0x003f
            android.graphics.Bitmap r2 = r2.getBitmap()
            r4 = r2
            goto L_0x0040
        L_0x003f:
            r4 = r9
        L_0x0040:
            java.lang.String r2 = r8.trim()
            int r2 = r2.length()
            if (r2 != 0) goto L_0x008f
            if (r4 != 0) goto L_0x008f
            org.json.JSONArray r2 = r11.drills
            int r2 = r2.length()
            if (r2 != 0) goto L_0x008f
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = new com.afollestad.materialdialogs.MaterialDialog$Builder
            androidx.fragment.app.FragmentActivity r1 = r11.getActivity()
            r0.<init>(r1)
            r1 = 2131951842(0x7f1300e2, float:1.954011E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.title((int) r1)
            r1 = 2131951841(0x7f1300e1, float:1.9540108E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.content((int) r1)
            r1 = 2131951694(0x7f13004e, float:1.953981E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.positiveText((int) r1)
            r1 = 2131951741(0x7f13007d, float:1.9539905E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.negativeText((int) r1)
            com.trainerfu.android.WorkoutLogFragment$15 r1 = new com.trainerfu.android.WorkoutLogFragment$15
            r1.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.onPositive(r1)
            com.trainerfu.android.WorkoutLogFragment$14 r1 = new com.trainerfu.android.WorkoutLogFragment$14
            r1.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r0 = r0.onNegative(r1)
            r0.show()
            return
        L_0x008f:
            com.trainerfu.android.WorkoutLogFragment$16 r10 = new com.trainerfu.android.WorkoutLogFragment$16
            r10.<init>()
            r2 = 0
            if (r4 == 0) goto L_0x00a5
            int r2 = r11.userId
            java.util.Date r3 = r11.logDate
            androidx.fragment.app.FragmentActivity r6 = r11.getActivity()
            r5 = r1
            r7 = r10
            com.trainerfu.utils.WorkoutLogUtil.saveWorkoutLogPhoto(r2, r3, r4, r5, r6, r7)
            r2 = 1
        L_0x00a5:
            java.lang.String r3 = r8.trim()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00cd
            if (r2 == 0) goto L_0x00be
            int r3 = r11.userId
            java.util.Date r4 = r11.logDate
            r6 = 0
            r7 = 0
            r0 = 0
            r5 = r8
            r8 = r0
            com.trainerfu.utils.WorkoutLogUtil.addNoteToWorkoutLog(r3, r4, r5, r6, r7, r8)
            goto L_0x00cd
        L_0x00be:
            int r3 = r11.userId
            java.util.Date r4 = r11.logDate
            r6 = 0
            androidx.fragment.app.FragmentActivity r7 = r11.getActivity()
            r5 = r8
            r8 = r10
            com.trainerfu.utils.WorkoutLogUtil.addNoteToWorkoutLog(r3, r4, r5, r6, r7, r8)
            goto L_0x00ce
        L_0x00cd:
            r0 = r2
        L_0x00ce:
            org.json.JSONArray r2 = r11.drills
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00dd
            int r2 = r11.userId
            java.util.Date r3 = r11.logDate
            com.trainerfu.utils.WorkoutLogUtil.logNewWorkout(r2, r3, r9, r9)
        L_0x00dd:
            if (r0 == 0) goto L_0x00e7
            int r0 = r11.userId
            java.util.Date r2 = r11.logDate
            com.trainerfu.utils.WorkoutLogUtil.updateWorkoutLogVisibility(r1, r0, r2, r9, r9)
            goto L_0x00f2
        L_0x00e7:
            int r0 = r11.userId
            java.util.Date r2 = r11.logDate
            androidx.fragment.app.FragmentActivity r3 = r11.getActivity()
            com.trainerfu.utils.WorkoutLogUtil.updateWorkoutLogVisibility(r1, r0, r2, r3, r10)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.WorkoutLogFragment.save():void");
    }

    public void changeDate(Date date) {
        getActivity().setTitle(DateUtils.getDisplayDate(getActivity(), date));
        ((EditText) this.view.findViewById(R.id.commentET)).setText("");
        removePhoto();
        this.logDate = date;
        reloadData(false);
    }

    public void drillEdited(Bundle bundle, JSONObject jSONObject, String str) {
        int i = bundle.getInt("drill_id");
        int i2 = 0;
        String format = String.format("/user_drills/%s", new Object[]{String.valueOf(i)});
        HashMap hashMap = new HashMap();
        String string = bundle.getString(Part.NOTE_MESSAGE_STYLE);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.getString(next));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        hashMap.put("rest_time", str);
        if (string.equals(JsonLexerKt.NULL)) {
            string = null;
        }
        hashMap.put(Part.NOTE_MESSAGE_STYLE, string);
        new BaseHttpClient(false, getActivity()).post(format, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
        if (this.drills != null) {
            while (i2 < this.drills.length()) {
                try {
                    JSONObject jSONObject2 = (JSONObject) this.drills.get(i2);
                    if (i == jSONObject2.getInt("drill_id")) {
                        jSONObject2.put("measures", jSONObject);
                        jSONObject2.put("rest_time", str);
                        jSONObject2.put(Part.NOTE_MESSAGE_STYLE, bundle.getString(Part.NOTE_MESSAGE_STYLE));
                        this.adapter.notifyDataSetChanged();
                        return;
                    }
                    i2++;
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    private void removePhoto() {
        this.addPhotoIV.setVisibility(0);
        this.photoIV.setVisibility(8);
        this.photoViewWrapper.setVisibility(8);
        this.photoIV.setImageDrawable((Drawable) null);
        changePostItemIcon();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = (android.graphics.drawable.BitmapDrawable) r3.photoIV.getDrawable();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changePostItemIcon() {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.commentET
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            android.widget.ImageView r1 = r3.photoIV
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0021
            android.widget.ImageView r1 = r3.photoIV
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            if (r1 == 0) goto L_0x0021
            android.graphics.Bitmap r1 = r1.getBitmap()
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            android.graphics.drawable.Drawable r2 = r3.postItemDrawable
            if (r2 == 0) goto L_0x0062
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004b
            if (r1 != 0) goto L_0x004b
            org.json.JSONArray r0 = r3.drills
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004b
            android.graphics.drawable.Drawable r0 = r3.postItemDrawable
            android.content.Context r1 = r3.getContext()
            r2 = 2131099848(0x7f0600c8, float:1.781206E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r0, r1)
            goto L_0x005b
        L_0x004b:
            android.graphics.drawable.Drawable r0 = r3.postItemDrawable
            android.content.Context r1 = r3.getContext()
            r2 = 2131100514(0x7f060362, float:1.7813412E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r0, r1)
        L_0x005b:
            android.view.MenuItem r0 = r3.postItem
            android.graphics.drawable.Drawable r1 = r3.postItemDrawable
            r0.setIcon(r1)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.WorkoutLogFragment.changePostItemIcon():void");
    }

    private void selectAttachment() {
        this.forAttachment = true;
        FragmentActivity activity = getActivity();
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (activity.checkSelfPermission("android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
            return;
        }
        try {
            UploadcareWidget.getInstance().selectFile((Fragment) this).storeUponUpload(true).showProgress(true).launch();
        } catch (Exception e) {
            Sentry.captureException(e);
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter2 = listView.getAdapter();
        if (adapter2 != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view2 = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter2.getCount(); i2++) {
                view2 = adapter2.getView(i2, view2, listView);
                view2.measure(makeMeasureSpec, 0);
                i += view2.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i + (listView.getDividerHeight() * (adapter2.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }

    private class ArrayAdapter extends BaseAdapter {
        private Context context;

        public boolean hasStableIds() {
            return false;
        }

        public ArrayAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (WorkoutLogFragment.this.drills == null) {
                return 0;
            }
            return WorkoutLogFragment.this.drills.length();
        }

        public Object getItem(int i) {
            try {
                return WorkoutLogFragment.this.drills.get(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) getItem(i)).getInt("drill_id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.workout_log_drill_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.titleLbl);
            TextView textView2 = (TextView) inflate.findViewById(R.id.detailLbl);
            ImageView unused = WorkoutLogFragment.this.deleteExerciseBtn = (ImageView) inflate.findViewById(R.id.delete_exercise);
            WorkoutLogFragment.this.deleteExerciseBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WorkoutLogFragment.this.deleteDrillAtIndex(i);
                }
            });
            JSONObject jSONObject = (JSONObject) getItem(i);
            try {
                if (jSONObject.getInt("exercise_id") == 1) {
                    textView.setText(WorkoutLogFragment.this.getString(R.string.Workout));
                } else {
                    textView.setText(jSONObject.getString("exercise_name"));
                }
                String detailText = DrillViewHelper.getDetailText(jSONObject, (JSONObject) null, WorkoutLogFragment.this.getContext(), true, false);
                if (detailText == null || detailText.length() <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(detailText);
                }
                return inflate;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class FileListAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return 0;
        }

        public FileListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (WorkoutLogFragment.this.files == null) {
                return 0;
            }
            return WorkoutLogFragment.this.files.length();
        }

        public Object getItem(int i) {
            try {
                return WorkoutLogFragment.this.files.get(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0082 A[Catch:{ JSONException -> 0x00df }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[Catch:{ JSONException -> 0x00df }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(final int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
                r7 = this;
                android.content.Context r9 = r7.context
                java.lang.String r10 = "layout_inflater"
                java.lang.Object r9 = r9.getSystemService(r10)
                android.view.LayoutInflater r9 = (android.view.LayoutInflater) r9
                r10 = 2131558499(0x7f0d0063, float:1.8742316E38)
                r0 = 0
                android.view.View r9 = r9.inflate(r10, r0)
                r10 = 0
                r9.setPadding(r10, r10, r10, r10)
                com.trainerfu.android.WorkoutLogFragment r1 = com.trainerfu.android.WorkoutLogFragment.this     // Catch:{ JSONException -> 0x0060 }
                org.json.JSONArray r1 = r1.files     // Catch:{ JSONException -> 0x0060 }
                java.lang.Object r1 = r1.get(r8)     // Catch:{ JSONException -> 0x0060 }
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0060 }
                r2 = 2131362414(0x7f0a026e, float:1.8344608E38)
                android.view.View r2 = r9.findViewById(r2)     // Catch:{ JSONException -> 0x005a }
                android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ JSONException -> 0x005a }
                r3 = 2131362411(0x7f0a026b, float:1.8344602E38)
                android.view.View r3 = r9.findViewById(r3)     // Catch:{ JSONException -> 0x0055 }
                com.joanzapata.iconify.widget.IconTextView r3 = (com.joanzapata.iconify.widget.IconTextView) r3     // Catch:{ JSONException -> 0x0055 }
                r4 = 2131362532(0x7f0a02e4, float:1.8344847E38)
                android.view.View r4 = r9.findViewById(r4)     // Catch:{ JSONException -> 0x0050 }
                android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ JSONException -> 0x0050 }
                com.trainerfu.android.WorkoutLogFragment r0 = com.trainerfu.android.WorkoutLogFragment.this     // Catch:{ JSONException -> 0x004e }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ JSONException -> 0x004e }
                r5 = 2131231069(0x7f08015d, float:1.8078209E38)
                android.graphics.drawable.Drawable r0 = r0.getDrawable(r5)     // Catch:{ JSONException -> 0x004e }
                r4.setImageDrawable(r0)     // Catch:{ JSONException -> 0x004e }
                goto L_0x0069
            L_0x004e:
                r0 = move-exception
                goto L_0x0066
            L_0x0050:
                r4 = move-exception
                r6 = r4
                r4 = r0
                r0 = r6
                goto L_0x0066
            L_0x0055:
                r3 = move-exception
                r4 = r0
                r0 = r3
                r3 = r4
                goto L_0x0066
            L_0x005a:
                r2 = move-exception
                r3 = r0
                r4 = r3
                r0 = r2
                r2 = r4
                goto L_0x0066
            L_0x0060:
                r1 = move-exception
                r2 = r0
                r3 = r2
                r4 = r3
                r0 = r1
                r1 = r4
            L_0x0066:
                r0.printStackTrace()
            L_0x0069:
                java.lang.String r0 = "name"
                java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x00df }
                r2.setText(r0)     // Catch:{ JSONException -> 0x00df }
                java.lang.String[] r0 = com.trainerfu.utils.Util.getMimeType(r0)     // Catch:{ JSONException -> 0x00df }
                java.lang.String r1 = "{fa-file}"
                r2 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r5 = "image"
                boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00df }
                if (r2 == 0) goto L_0x0085
                java.lang.String r1 = "{fa-file-image-o}"
                goto L_0x00d3
            L_0x0085:
                r2 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r5 = "video"
                boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00df }
                if (r2 == 0) goto L_0x0092
                java.lang.String r1 = "{fa-file-video-o}"
                goto L_0x00d3
            L_0x0092:
                r10 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r2 = "audio"
                boolean r10 = r10.equals(r2)     // Catch:{ JSONException -> 0x00df }
                if (r10 == 0) goto L_0x009f
                java.lang.String r1 = "{fa-file-audio-o}"
                goto L_0x00d3
            L_0x009f:
                r10 = 1
                r2 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r5 = "pdf"
                boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00df }
                if (r2 == 0) goto L_0x00ad
                java.lang.String r1 = "{fa-file-pdf-o}"
                goto L_0x00d3
            L_0x00ad:
                r2 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r5 = "msword"
                boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00df }
                if (r2 == 0) goto L_0x00ba
                java.lang.String r1 = "{fa-file-word-o}"
                goto L_0x00d3
            L_0x00ba:
                r2 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r5 = "vnd.ms-excel"
                boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00df }
                if (r2 == 0) goto L_0x00c7
                java.lang.String r1 = "{fa-file-excel-o}"
                goto L_0x00d3
            L_0x00c7:
                r10 = r0[r10]     // Catch:{ JSONException -> 0x00df }
                java.lang.String r0 = "zip"
                boolean r10 = r10.equals(r0)     // Catch:{ JSONException -> 0x00df }
                if (r10 == 0) goto L_0x00d3
                java.lang.String r1 = "{fa-file-zip-o}"
            L_0x00d3:
                r3.setText(r1)     // Catch:{ JSONException -> 0x00df }
                com.trainerfu.android.WorkoutLogFragment$FileListAdapter$1 r10 = new com.trainerfu.android.WorkoutLogFragment$FileListAdapter$1
                r10.<init>(r8)
                r4.setOnClickListener(r10)
                return r9
            L_0x00df:
                java.lang.RuntimeException r8 = new java.lang.RuntimeException
                java.lang.String r9 = "Invalid File Name"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.WorkoutLogFragment.FileListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }
}
