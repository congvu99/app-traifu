package com.trainerfu.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.legacy.app.FragmentCompat;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.loopj.android.image.SmartImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.takeoffandroid.urllinkview.library.LinkSourceContent;
import com.takeoffandroid.urllinkview.library.LinkViewCallback;
import com.takeoffandroid.urllinkview.library.TextCrawler;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.OnImagePickedHandler;
import com.trainerfu.utils.Util;
import com.uploadcare.android.library.api.RequestHelper;
import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.UploadFileCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.upload.FileUploader;
import io.sentry.Sentry;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComposeFragment extends Fragment implements FragmentCompat.OnRequestPermissionsResultCallback, LinkViewCallback, CompoundButton.OnCheckedChangeListener {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    /* access modifiers changed from: private */
    public static int REQUEST_CODE = 45683;
    /* access modifiers changed from: private */
    public static int REQUEST_CODE_PICK_FILE = 36784;
    private static int SS_REQUEST_CODE = 23642;
    private static Drawable addPhotoDrawable;
    private AppCompatActivity act;
    private ActionBar actionBar;
    /* access modifiers changed from: private */
    public GroupsAdapter adapter;
    private LinearLayout addAttachmentBtn;
    private LinearLayout addPhotoBtn;
    /* access modifiers changed from: private */
    public ImageView addPhotoIV;
    private LinearLayout advancedBtn;
    private LinearLayout advancedView;
    private RelativeLayout bottomOptions;
    /* access modifiers changed from: private */
    public int clientId;
    /* access modifiers changed from: private */
    public ComposeType composeType;
    /* access modifiers changed from: private */
    public int coverHeight;
    /* access modifiers changed from: private */
    public String coverUrl;
    /* access modifiers changed from: private */
    public int coverWidth;
    private Switch everyOneCb;
    private TextView everyoneHint;
    /* access modifiers changed from: private */
    public ListView fileListView;
    /* access modifiers changed from: private */
    public JSONArray files = new JSONArray();
    /* access modifiers changed from: private */
    public FileListAdapter filesAdapter;
    /* access modifiers changed from: private */
    public boolean forAttachment = false;
    /* access modifiers changed from: private */
    public GestureDetector gestureScanner;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> groups = new ArrayList<>();
    /* access modifiers changed from: private */
    public ListView groupsList;
    private View groupsViewWrapper;
    /* access modifiers changed from: private */
    public boolean isSaving;
    private boolean isTrainer = false;
    private Menu menu;
    private String myFirstName = "";
    private EditText noteView;
    private TextWatcher noteViewWatcher;
    private View notificationWrapper;
    private RelativeLayout parentView;
    private String photoFilePath;
    /* access modifiers changed from: private */
    public ImageView photoView;
    /* access modifiers changed from: private */
    public View photoViewWrapper;
    private Switch pinCB;
    private View pinCBWrapper;
    private View pmViewWrapper;
    private ImageView postBtn;
    private LinearLayout postBtnWrapper;
    private MenuItem postItemText;
    private LinearLayout postView;
    /* access modifiers changed from: private */
    public ProgressDialog progress;
    private ArrayList<Integer> segments = new ArrayList<>();
    /* access modifiers changed from: private */
    public JSONArray selectedGroups = new JSONArray();
    private View sendInAppNotifCBWrapper;
    private Switch sendInAppNotifCb;
    private Switch sendPushNotifCB;
    private View sendPushNotifCBWrapper;
    private Switch shareCB;
    public final SimpleStorageHelper storageHelper = new SimpleStorageHelper((Fragment) this);
    private TextView subTitleView;
    private TextCrawler textCrawler;
    private TextView titleView;
    private Toolbar toolbar;
    private String url = null;
    private Switch workoutShareCB;
    private LinearLayout workoutShareWrapper;

    public interface EventListener {
        void composeCancelled();

        void composeObjectSaved();
    }

    public void onBeforeLoading() {
    }

    static {
        Context appContext = MyApplication.getAppContext();
        Drawable drawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.media_image_add, (Resources.Theme) null);
        addPhotoDrawable = drawable;
        drawable.setColorFilter(ContextCompat.getColor(appContext, R.color.lightGrayColor), PorterDuff.Mode.SRC_IN);
    }

    public void onCreate(Bundle bundle) {
        setHasOptionsMenu(true);
        this.gestureScanner = new GestureDetector(getActivity(), new GestureDetector.OnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            public void onLongPress(MotionEvent motionEvent) {
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent.getY() <= motionEvent2.getY()) {
                    return true;
                }
                Util.hideKeyboard(ComposeFragment.this.getActivity());
                return true;
            }
        });
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.create_post_view, viewGroup, false);
        Bundle arguments = getArguments();
        this.isTrainer = arguments.getBoolean("is_trainer");
        ComposeType composeType2 = ComposeType.getComposeType(arguments.getInt("compose_type"));
        this.composeType = composeType2;
        if (composeType2 == ComposeType.LINK_STORY) {
            this.url = arguments.getString("url");
            this.textCrawler = new TextCrawler();
        } else if (this.composeType == ComposeType.POST_STORY) {
            this.myFirstName = arguments.getString("first_name");
        } else if (this.composeType == ComposeType.PROGRESS_PHOTO) {
            this.clientId = arguments.getInt("client_id");
            this.photoFilePath = arguments.getString("photo_file_path");
        } else {
            this.clientId = arguments.getInt("client_id");
        }
        this.photoViewWrapper = inflate.findViewById(R.id.photo_view_wrapper);
        this.postBtnWrapper = (LinearLayout) inflate.findViewById(R.id.post_btn_wrapper);
        this.photoView = (ImageView) inflate.findViewById(R.id.photo_view);
        View findViewById = inflate.findViewById(R.id.link_view);
        this.noteView = (EditText) inflate.findViewById(R.id.note_view);
        this.groupsList = (ListView) inflate.findViewById(R.id.groups_list);
        GroupsAdapter groupsAdapter = new GroupsAdapter(getActivity());
        this.adapter = groupsAdapter;
        this.groupsList.setAdapter(groupsAdapter);
        this.fileListView = (ListView) inflate.findViewById(R.id.file_list_view);
        FileListAdapter fileListAdapter = new FileListAdapter(getActivity());
        this.filesAdapter = fileListAdapter;
        this.fileListView.setAdapter(fileListAdapter);
        this.addPhotoIV = (ImageView) inflate.findViewById(R.id.addPhotoBtn);
        this.addPhotoBtn = (LinearLayout) inflate.findViewById(R.id.add_photo_btn);
        registerForContextMenu(this.addPhotoIV);
        registerForContextMenu(this.addPhotoBtn);
        this.addPhotoIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.showContextMenu();
            }
        });
        if (this.composeType == ComposeType.POST_STORY || this.composeType == ComposeType.WORKOUT_FEEDBACK || this.composeType == ComposeType.PROGRESS_PHOTO) {
            final TextView textView = (TextView) inflate.findViewById(R.id.pm_view);
            textView.setText(String.format(getString(R.string.xyzAddedANewPost), new Object[]{this.myFirstName}));
            this.shareCB = (Switch) inflate.findViewById(R.id.share_cb);
            this.pinCB = (Switch) inflate.findViewById(R.id.pin_cb);
            this.sendInAppNotifCb = (Switch) inflate.findViewById(R.id.send_inapp_notif_cb);
            this.sendPushNotifCB = (Switch) inflate.findViewById(R.id.send_push_notif_cb);
            this.everyOneCb = (Switch) inflate.findViewById(R.id.everyone_cb);
            this.workoutShareCB = (Switch) inflate.findViewById(R.id.workout_share_cb);
            this.sendInAppNotifCb.setOnCheckedChangeListener(this);
            this.sendPushNotifCB.setOnCheckedChangeListener(this);
            this.pinCB.setOnCheckedChangeListener(this);
            this.shareCB.setOnCheckedChangeListener(this);
            this.everyOneCb.setOnCheckedChangeListener(this);
            this.pinCBWrapper = inflate.findViewById(R.id.pin_cb_wrapper);
            this.sendInAppNotifCBWrapper = inflate.findViewById(R.id.send_inapp_notif_cb_wrapper);
            this.sendPushNotifCBWrapper = inflate.findViewById(R.id.send_push_notif_cb_wrapper);
            this.notificationWrapper = inflate.findViewById(R.id.notification_wrapper);
            this.pmViewWrapper = inflate.findViewById(R.id.pm_wrapper);
            this.groupsViewWrapper = inflate.findViewById(R.id.groups_view_wrapper);
            this.workoutShareWrapper = (LinearLayout) inflate.findViewById(R.id.workout_share_wrapper);
            this.parentView = (RelativeLayout) inflate.findViewById(R.id.parent_view);
            this.postView = (LinearLayout) inflate.findViewById(R.id.post_view);
            this.bottomOptions = (RelativeLayout) inflate.findViewById(R.id.bottom_options_view);
            this.advancedView = (LinearLayout) inflate.findViewById(R.id.advanced_layout_view);
            this.postBtn = (ImageView) inflate.findViewById(R.id.postBtn);
            this.bottomOptions.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.everyoneHint = (TextView) inflate.findViewById(R.id.everyone_hint);
            this.pmViewWrapper.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("info", "");
                    bundle.putString("text", textView.getText().toString());
                    bundle.putString(ViewHierarchyConstants.HINT_KEY, ComposeFragment.this.getString(R.string.Comment));
                    bundle.putInt("request_code", ComposeFragment.REQUEST_CODE);
                    EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
                    editTextDialogFragment.setArguments(bundle);
                    editTextDialogFragment.show(ComposeFragment.this.getFragmentManager(), "acf");
                }
            });
            AnonymousClass5 r1 = new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    ComposeFragment.this.changePostItemIcon();
                }
            };
            this.noteViewWatcher = r1;
            this.noteView.addTextChangedListener(r1);
            this.postBtnWrapper.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ComposeFragment.this.save();
                }
            });
        }
        if (this.composeType == ComposeType.LINK_STORY) {
            findViewById.setVisibility(0);
            this.photoViewWrapper.setVisibility(8);
            this.noteView.setHint(getString(R.string.SaySomethingAboutThis));
        } else if (this.composeType == ComposeType.PROGRESS_PHOTO) {
            getActivity().getWindow().setSoftInputMode(16);
            findViewById.setVisibility(8);
            this.noteView.setHint(getString(R.string.note));
            this.photoView.setVisibility(0);
            this.addPhotoBtn = (LinearLayout) inflate.findViewById(R.id.add_photo_btn);
            this.addPhotoIV.setVisibility(8);
            this.photoView.setImageBitmap(Util.scaleBitmapForStory(this.photoFilePath));
            this.photoViewWrapper.setVisibility(0);
            this.workoutShareWrapper.setVisibility(0);
            this.workoutShareCB.setChecked(false);
            this.bottomOptions.setVisibility(8);
        } else if (this.composeType == ComposeType.WORKOUT_FEEDBACK) {
            this.workoutShareWrapper.setVisibility(0);
            this.noteView.setHint(getResources().getString(R.string.howDidItGo));
            this.photoView.setVisibility(0);
            this.bottomOptions.setVisibility(8);
            this.addPhotoIV.setVisibility(0);
            this.addPhotoBtn = (LinearLayout) inflate.findViewById(R.id.add_photo_btn);
            this.noteView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return ComposeFragment.this.gestureScanner.onTouchEvent(motionEvent);
                }
            });
            this.postView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return ComposeFragment.this.gestureScanner.onTouchEvent(motionEvent);
                }
            });
        } else {
            this.workoutShareWrapper.setVisibility(8);
            findViewById.setVisibility(8);
            if (this.composeType == ComposeType.POST_STORY) {
                getActivity().getWindow().setSoftInputMode(16);
                this.noteView.setHint(getString(R.string.whatsOnYourMind));
            } else {
                this.noteView.setHint(getString(R.string.howDidItGo));
            }
            this.addPhotoBtn = (LinearLayout) inflate.findViewById(R.id.add_photo_btn);
            this.addAttachmentBtn = (LinearLayout) inflate.findViewById(R.id.add_attachment_btn);
            this.advancedBtn = (LinearLayout) inflate.findViewById(R.id.advanced_btn);
            registerForContextMenu(this.addPhotoBtn);
            this.addPhotoBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view.showContextMenu();
                }
            });
            this.addAttachmentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    boolean unused = ComposeFragment.this.forAttachment = true;
                    ComposeFragment.this.getActivity();
                    try {
                        ComposeFragment.this.storageHelper.openFilePicker(ComposeFragment.REQUEST_CODE_PICK_FILE, new String[0]);
                    } catch (Exception e) {
                        Sentry.captureException(e);
                    }
                }
            });
            this.advancedBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ComposeFragment.this.showAdvancedOptions();
                }
            });
        }
        registerForContextMenu(this.photoView);
        this.photoView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.showContextMenu();
            }
        });
        ((TextView) inflate.findViewById(R.id.submit_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ComposeFragment.this.save();
            }
        });
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        this.actionBar = supportActionBar;
        supportActionBar.setHomeButtonEnabled(true);
        return inflate;
    }

    public void setupSimpleStorage(Bundle bundle) {
        if (bundle != null) {
            this.storageHelper.onRestoreInstanceState(bundle);
        }
        this.storageHelper.setOnStorageAccessGranted(new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return ComposeFragment.this.lambda$setupSimpleStorage$0$ComposeFragment((Integer) obj, (DocumentFile) obj2);
            }
        });
        this.storageHelper.setOnFileSelected(new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return ComposeFragment.this.lambda$setupSimpleStorage$1$ComposeFragment((Integer) obj, (List) obj2);
            }
        });
    }

    public /* synthetic */ Unit lambda$setupSimpleStorage$0$ComposeFragment(Integer num, DocumentFile documentFile) {
        String absolutePath = DocumentFileUtils.getAbsolutePath(documentFile, getContext());
        Toast.makeText(getContext(), getString(R.string.ss_selecting_root_path_success_without_open_folder_picker, absolutePath), 0).show();
        return null;
    }

    public /* synthetic */ Unit lambda$setupSimpleStorage$1$ComposeFragment(Integer num, List list) {
        FileUploader store = new FileUploader(new UploadcareClient(getString(R.string.uploadcare_public_key), getString(R.string.uploadcare_private_key)), ((DocumentFile) list.get(0)).getUri(), getContext()).store(true);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.progress = progressDialog;
        progressDialog.setMessage("Uploading File");
        this.progress.setProgressStyle(1);
        this.progress.setIndeterminate(true);
        this.progress.setProgressNumberFormat((String) null);
        this.progress.setProgressPercentFormat((NumberFormat) null);
        this.progress.show();
        store.uploadAsync(new UploadFileCallback() {
            public void onProgressUpdate(long j, long j2, double d) {
            }

            public void onFailure(UploadcareApiException uploadcareApiException) {
                Sentry.captureException(uploadcareApiException);
            }

            public void onSuccess(UploadcareFile uploadcareFile) {
                ComposeFragment.this.progress.hide();
                JSONObject jSONObject = new JSONObject();
                if (uploadcareFile != null) {
                    try {
                        if (uploadcareFile.getOriginalFileUrl() != null) {
                            jSONObject.put("name", uploadcareFile.getOriginalFilename());
                            jSONObject.put("url", uploadcareFile.getOriginalFileUrl().toString());
                            ComposeFragment.this.files.put(jSONObject);
                        } else {
                            jSONObject.put("name", uploadcareFile.getOriginalFilename());
                            jSONObject.put("url", "https://ucarecdn.com/" + uploadcareFile.getUuid() + "/" + uploadcareFile.getOriginalFilename());
                            ComposeFragment.this.files.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        Util.showToast(ComposeFragment.this.getActivity(), R.string.unsupportedFileFormat);
                        e.printStackTrace();
                        Sentry.captureException(e);
                    }
                }
                ComposeFragment.this.fileListView.setVisibility(0);
                ComposeFragment.this.filesAdapter.notifyDataSetChanged();
                ComposeFragment.setListViewHeightBasedOnChildren(ComposeFragment.this.fileListView);
                ComposeFragment.this.changePostItemIcon();
            }
        });
        return null;
    }

    public void focusEditText(View view) {
        this.noteView.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.noteView, 1);
    }

    public boolean onBackPressed() {
        if (this.advancedView.getVisibility() != 0) {
            return false;
        }
        hideAdvancedOptions();
        return true;
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.create_post_menu, menu2);
        this.menu = menu2;
        MenuItem findItem = menu2.findItem(R.id.mark_done_item);
        this.postItemText = menu2.findItem(R.id.post_item_text);
        findItem.setVisible(false);
        if (this.composeType == ComposeType.POST_STORY) {
            SpannableString spannableString = new SpannableString(RequestHelper.REQUEST_POST);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.lightBlack)), 0, spannableString.length(), 0);
            this.postItemText.setTitle(spannableString);
            this.postItemText.setVisible(true);
        } else {
            this.postItemText.setVisible(false);
        }
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.mark_done_item) {
            hideAdvancedOptions();
        }
        if (itemId == R.id.post_item) {
            save();
        }
        if (itemId == R.id.post_item_text) {
            save();
        }
        if (itemId == 16908332 && this.advancedView.getVisibility() == 0) {
            resetAdvancedOptions();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter2 = listView.getAdapter();
        if (adapter2 != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter2.getCount(); i2++) {
                view = adapter2.getView(i2, view, listView);
                view.measure(makeMeasureSpec, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i + (listView.getDividerHeight() * (adapter2.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void showAdvancedOptions() {
        this.parentView.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        this.parentView.setPadding(0, 0, 0, 0);
        this.postView.setVisibility(8);
        this.bottomOptions.setVisibility(8);
        this.actionBar.setTitle((CharSequence) "Advanced");
        this.advancedView.setVisibility(0);
        if (!this.isTrainer) {
            this.pinCB.setVisibility(8);
            this.pinCBWrapper.setVisibility(8);
            this.notificationWrapper.setVisibility(8);
            this.groupsViewWrapper.setVisibility(8);
            getView().findViewById(R.id.empty_view).setVisibility(0);
        }
        this.menu.findItem(R.id.mark_done_item).setVisible(true);
        this.postItemText.setVisible(false);
        this.actionBar.setSubtitle((CharSequence) null);
        this.actionBar.setLogo((int) R.drawable.actionbar_space_between_icon_and_title);
        Util.hideKeyboardFrom(getActivity(), getView());
    }

    private void hideAdvancedOptions() {
        boolean isChecked = this.everyOneCb.isChecked();
        this.parentView.setBackgroundColor(getResources().getColor(R.color.white));
        this.advancedView.setVisibility(8);
        this.postView.setVisibility(0);
        this.bottomOptions.setVisibility(0);
        this.actionBar.setTitle((CharSequence) "New Post");
        this.menu.findItem(R.id.mark_done_item).setVisible(false);
        this.postItemText.setVisible(true);
        if (this.selectedGroups.length() <= 0 || isChecked) {
            this.actionBar.setSubtitle((CharSequence) getString(R.string.visibleToEveryone));
        } else {
            String str = "Visible to ";
            for (int i = 0; i < this.selectedGroups.length(); i++) {
                try {
                    str = str + this.selectedGroups.getJSONObject(i).getString("name") + ", ";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.actionBar.setSubtitle((CharSequence) str);
        }
        if (!this.shareCB.isChecked()) {
            this.actionBar.setSubtitle((CharSequence) "Visible only to Trainers");
        }
        this.noteView.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.noteView, 1);
        this.actionBar.setLogo(17170445);
    }

    private void resetAdvancedOptions() {
        hideAdvancedOptions();
        this.shareCB.setChecked(true);
        this.pinCB.setChecked(false);
        this.sendInAppNotifCb.setChecked(false);
        this.sendPushNotifCB.setChecked(false);
        this.everyOneCb.setChecked(true);
        this.actionBar.setSubtitle((CharSequence) getString(R.string.visibleToEveryone));
        this.selectedGroups = new JSONArray();
        this.adapter.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        if (this.composeType == ComposeType.LINK_STORY) {
            ((TextView) getView().findViewById(R.id.url_view)).setText(this.url);
            this.textCrawler.makePreview(this, this.url);
        }
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void handleTextEditedEvent(TextEditedEvent textEditedEvent) {
        if (textEditedEvent.requestCode == REQUEST_CODE && isAdded()) {
            String trim = textEditedEvent.text.trim();
            if (trim.length() > 0) {
                ((TextView) getView().findViewById(R.id.pm_view)).setText(trim);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.composeType != ComposeType.LINK_STORY) {
            bundle.putBoolean("photoAdded", this.photoViewWrapper.getVisibility() == 0);
            String str = this.photoFilePath;
            if (str != null) {
                bundle.putString("photoFilePath", str);
            }
            bundle.putString("push_message", ((TextView) getView().findViewById(R.id.pm_view)).getText().toString());
            bundle.putIntegerArrayList("segments", this.segments);
            bundle.putBoolean("for_attachment", this.forAttachment);
            String str2 = this.coverUrl;
            if (str2 != null) {
                bundle.putString("cover_url", str2);
                bundle.putInt("cover_height", this.coverHeight);
                bundle.putInt("cover_width", this.coverWidth);
            }
            JSONArray jSONArray = this.files;
            if (jSONArray != null && jSONArray.length() > 0) {
                bundle.putString("files", this.files.toString());
            }
            this.noteView.removeTextChangedListener(this.noteViewWatcher);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!(bundle == null || this.composeType == ComposeType.LINK_STORY)) {
            if (bundle.getBoolean("photoAdded")) {
                this.photoViewWrapper.setVisibility(0);
                this.photoView.setVisibility(0);
                this.photoFilePath = bundle.getString("photoFilePath");
                this.coverUrl = bundle.getString("cover_url");
                this.coverHeight = bundle.getInt("cover_height");
                this.coverWidth = bundle.getInt("cover_width");
                Picasso.get().load(Uri.parse(this.coverUrl)).into(this.photoView);
            } else {
                this.photoView.setVisibility(8);
                this.addPhotoBtn.setVisibility(0);
            }
            this.segments = bundle.getIntegerArrayList("segments");
            ((TextView) getView().findViewById(R.id.pm_view)).setText(bundle.getString("push_message"));
            this.forAttachment = bundle.getBoolean("for_attachment");
            if (bundle.containsKey("files")) {
                try {
                    this.files = new JSONArray(bundle.getString("files"));
                    this.fileListView.setVisibility(0);
                    this.filesAdapter.notifyDataSetChanged();
                    setListViewHeightBasedOnChildren(this.fileListView);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (this.isTrainer && this.groups.size() == 0 && this.composeType != ComposeType.WORKOUT_FEEDBACK) {
            new BaseHttpClient(false, getActivity()).get("/segments", (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("segments");
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            boolean z = jSONObject2.getBoolean("is_default");
                            if (!(jSONObject2.has("for_tm_only") ? jSONObject2.getBoolean("for_tm_only") : false) || z) {
                                arrayList.add(jSONObject2);
                            }
                        }
                        ArrayList unused = ComposeFragment.this.groups = new ArrayList(arrayList);
                        ComposeFragment.this.adapter.notifyDataSetChanged();
                        ComposeFragment.setListViewHeightBasedOnChildren(ComposeFragment.this.groupsList);
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (view.getId() == R.id.add_photo_btn) {
            ImagePickerUtil.showPickPhotoMenu(getActivity(), contextMenu);
        } else if (view.getId() == R.id.addPhotoBtn) {
            ImagePickerUtil.showPickPhotoMenu(getActivity(), contextMenu);
        } else if (view.getId() == R.id.photo_view) {
            new MenuInflater(getActivity()).inflate(R.menu.remove_photo, contextMenu);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (ImagePickerUtil.isImagePickerMenuItem(menuItem)) {
            ImagePickerUtil.onContextItemSelected(menuItem, (Context) getActivity(), (Fragment) this);
            return true;
        } else if (menuItem.getItemId() != R.id.removePhotoItem) {
            return true;
        } else {
            removePhoto();
            return true;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (isAdded()) {
            ImagePickerUtil.onRequestPermissionsResult(i, strArr, iArr, (Fragment) this);
            if (i != 100) {
                return;
            }
            if (iArr[0] != 0) {
                Util.showToast(getActivity(), R.string.cameraPermissionDenied);
            } else if (this.forAttachment) {
                this.storageHelper.openFilePicker(REQUEST_CODE_PICK_FILE, new String[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x028c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save() {
        /*
            r13 = this;
            boolean r0 = r13.isSaving
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            r13.isSaving = r0
            android.view.View r1 = r13.getView()
            r2 = 2131363165(0x7f0a055d, float:1.8346131E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            android.widget.Switch r3 = r13.everyOneCb
            boolean r3 = r3.isChecked()
            boolean r2 = r2.isChecked()
            com.trainerfu.android.ComposeType r4 = r13.composeType
            com.trainerfu.android.ComposeType r5 = com.trainerfu.android.ComposeType.WORKOUT_FEEDBACK
            if (r4 == r5) goto L_0x002b
            com.trainerfu.android.ComposeType r4 = r13.composeType
            com.trainerfu.android.ComposeType r5 = com.trainerfu.android.ComposeType.PROGRESS_PHOTO
            if (r4 != r5) goto L_0x0031
        L_0x002b:
            android.widget.Switch r2 = r13.workoutShareCB
            boolean r2 = r2.isChecked()
        L_0x0031:
            r4 = 2131362874(0x7f0a043a, float:1.834554E38)
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = r4.trim()
            com.trainerfu.android.ComposeType r4 = r13.composeType
            com.trainerfu.android.ComposeType r5 = com.trainerfu.android.ComposeType.LINK_STORY
            java.lang.String r6 = "/stories2/new"
            java.lang.String r7 = "story_type"
            java.lang.String r8 = "date"
            java.lang.String r9 = "is_public"
            java.lang.String r11 = "note"
            if (r4 != r5) goto L_0x009b
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.trainerfu.story.StoryType r3 = com.trainerfu.story.StoryType.LINK
            int r3 = r3.getMask()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.put(r7, r3)
            r1.put(r11, r10)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.put(r9, r2)
            java.util.Date r2 = com.trainerfu.utils.DateUtils.getTodaysDate()
            java.lang.String r2 = com.trainerfu.utils.DateUtils.getISOFormattedDate(r2)
            r1.put(r8, r2)
            java.lang.String r2 = r13.url
            java.lang.String r3 = "url"
            r1.put(r3, r2)
            com.trainerfu.utils.BaseHttpClient r2 = new com.trainerfu.utils.BaseHttpClient
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            r2.<init>(r0, r3)
            com.trainerfu.android.ComposeFragment$16 r0 = new com.trainerfu.android.ComposeFragment$16
            r0.<init>()
            r2.put(r6, r1, r0)
            goto L_0x0299
        L_0x009b:
            com.trainerfu.android.ComposeType r4 = r13.composeType
            com.trainerfu.android.ComposeType r5 = com.trainerfu.android.ComposeType.POST_STORY
            r12 = 0
            if (r4 != r5) goto L_0x01b9
            android.view.View r4 = r13.photoViewWrapper
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x00ac
            r4 = 1
            goto L_0x00ad
        L_0x00ac:
            r4 = 0
        L_0x00ad:
            if (r4 != 0) goto L_0x00c0
            int r4 = r10.length()
            if (r4 != 0) goto L_0x00c0
            org.json.JSONArray r4 = r13.files
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00c0
            r13.isSaving = r12
            return
        L_0x00c0:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.trainerfu.story.StoryType r5 = com.trainerfu.story.StoryType.POST
            int r5 = r5.getMask()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r7, r5)
            r4.put(r11, r10)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            r4.put(r9, r5)
            java.util.Date r5 = com.trainerfu.utils.DateUtils.getTodaysDate()
            java.lang.String r5 = com.trainerfu.utils.DateUtils.getISOFormattedDate(r5)
            r4.put(r8, r5)
            org.json.JSONArray r5 = r13.files
            java.lang.String r7 = "files"
            r4.put(r7, r5)
            java.lang.String r5 = r13.coverUrl
            if (r5 == 0) goto L_0x010d
            java.lang.String r7 = "image_url"
            r4.put(r7, r5)
            int r5 = r13.coverHeight
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "image_height"
            r4.put(r7, r5)
            int r5 = r13.coverWidth
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "image_width"
            r4.put(r7, r5)
        L_0x010d:
            org.json.JSONArray r5 = r13.selectedGroups
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0140
            if (r3 != 0) goto L_0x0140
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
        L_0x011c:
            org.json.JSONArray r5 = r13.selectedGroups
            int r5 = r5.length()
            if (r12 >= r5) goto L_0x013b
            org.json.JSONArray r5 = r13.selectedGroups     // Catch:{ JSONException -> 0x0134 }
            org.json.JSONObject r5 = r5.getJSONObject(r12)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r7 = "id"
            int r5 = r5.getInt(r7)     // Catch:{ JSONException -> 0x0134 }
            r3.put(r5)     // Catch:{ JSONException -> 0x0134 }
            goto L_0x0138
        L_0x0134:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0138:
            int r12 = r12 + 1
            goto L_0x011c
        L_0x013b:
            java.lang.String r5 = "for_segments"
            r4.put(r5, r3)
        L_0x0140:
            if (r2 == 0) goto L_0x01a2
            r2 = 2131362938(0x7f0a047a, float:1.834567E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            boolean r2 = r2.isChecked()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r3 = "pinned"
            r4.put(r3, r2)
            r2 = 2131363150(0x7f0a054e, float:1.83461E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            boolean r2 = r2.isChecked()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            java.lang.String r5 = "send_notification"
            r4.put(r5, r3)
            if (r2 == 0) goto L_0x01a2
            r2 = 2131363153(0x7f0a0551, float:1.8346107E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.Switch r1 = (android.widget.Switch) r1
            boolean r1 = r1.isChecked()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            java.lang.String r3 = "send_push_notification"
            r4.put(r3, r2)
            if (r1 == 0) goto L_0x01a2
            android.view.View r1 = r13.getView()
            r2 = 2131362952(0x7f0a0488, float:1.83457E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "push_notification_message"
            r4.put(r2, r1)
        L_0x01a2:
            com.trainerfu.utils.BaseHttpClient r1 = new com.trainerfu.utils.BaseHttpClient
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            androidx.fragment.app.FragmentActivity r2 = r13.getActivity()
            r1.<init>(r0, r2)
            com.trainerfu.android.ComposeFragment$17 r0 = new com.trainerfu.android.ComposeFragment$17
            r0.<init>()
            r1.put(r6, r4, r0)
            goto L_0x0299
        L_0x01b9:
            com.trainerfu.android.ComposeType r1 = r13.composeType
            com.trainerfu.android.ComposeType r3 = com.trainerfu.android.ComposeType.PROGRESS_PHOTO
            if (r1 != r3) goto L_0x0224
            android.widget.ImageView r1 = r13.photoView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0299
            android.widget.ImageView r1 = r13.photoView
            android.graphics.drawable.Drawable r1 = r1.getDrawable()
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            com.trainerfu.utils.BaseHttpClient r3 = new com.trainerfu.utils.BaseHttpClient
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            androidx.fragment.app.FragmentActivity r5 = r13.getActivity()
            r3.<init>(r4, r5)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r10.length()
            if (r5 <= 0) goto L_0x01ea
            r4.put(r11, r10)
        L_0x01ea:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4.put(r9, r2)
            java.util.Date r2 = com.trainerfu.utils.DateUtils.getTodaysDate()
            java.lang.String r2 = com.trainerfu.utils.DateUtils.getISOFormattedDate(r2)
            r4.put(r8, r2)
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r5 = "photo_type"
            r4.put(r5, r2)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            int r2 = r13.clientId
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0[r12] = r2
            java.lang.String r2 = "/users/%s/photos/new"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            android.graphics.Bitmap r1 = r1.getBitmap()
            com.trainerfu.android.ComposeFragment$18 r2 = new com.trainerfu.android.ComposeFragment$18
            r2.<init>()
            r3.postWithImage(r0, r4, r1, r2)
            goto L_0x0299
        L_0x0224:
            com.trainerfu.android.ComposeFragment$19 r1 = new com.trainerfu.android.ComposeFragment$19
            r1.<init>()
            android.view.View r3 = r13.photoViewWrapper
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0233
            r3 = 1
            goto L_0x0234
        L_0x0233:
            r3 = 0
        L_0x0234:
            if (r3 == 0) goto L_0x0252
            android.widget.ImageView r3 = r13.photoView
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            android.graphics.drawable.BitmapDrawable r3 = (android.graphics.drawable.BitmapDrawable) r3
            int r4 = r13.clientId
            java.util.Date r5 = com.trainerfu.utils.DateUtils.getTodaysDate()
            android.graphics.Bitmap r6 = r3.getBitmap()
            androidx.fragment.app.FragmentActivity r8 = r13.getActivity()
            r7 = r2
            r9 = r1
            com.trainerfu.utils.WorkoutLogUtil.saveWorkoutLogPhoto(r4, r5, r6, r7, r8, r9)
            r12 = 1
        L_0x0252:
            java.lang.String r3 = r10.trim()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x027e
            if (r12 == 0) goto L_0x026d
            int r5 = r13.clientId
            java.util.Date r6 = com.trainerfu.utils.DateUtils.getTodaysDate()
            r8 = 1
            r9 = 0
            r0 = 0
            r7 = r10
            r10 = r0
            com.trainerfu.utils.WorkoutLogUtil.addNoteToWorkoutLog(r5, r6, r7, r8, r9, r10)
            goto L_0x027e
        L_0x026d:
            int r5 = r13.clientId
            java.util.Date r6 = com.trainerfu.utils.DateUtils.getTodaysDate()
            r8 = 1
            androidx.fragment.app.FragmentActivity r9 = r13.getActivity()
            r7 = r10
            r10 = r1
            com.trainerfu.utils.WorkoutLogUtil.addNoteToWorkoutLog(r5, r6, r7, r8, r9, r10)
            goto L_0x027f
        L_0x027e:
            r0 = r12
        L_0x027f:
            if (r0 == 0) goto L_0x028c
            int r0 = r13.clientId
            java.util.Date r1 = com.trainerfu.utils.DateUtils.getTodaysDate()
            r3 = 0
            com.trainerfu.utils.WorkoutLogUtil.updateWorkoutLogVisibility(r2, r0, r1, r3, r3)
            goto L_0x0299
        L_0x028c:
            int r0 = r13.clientId
            java.util.Date r3 = com.trainerfu.utils.DateUtils.getTodaysDate()
            androidx.fragment.app.FragmentActivity r4 = r13.getActivity()
            com.trainerfu.utils.WorkoutLogUtil.updateWorkoutLogVisibility(r2, r0, r3, r4, r1)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.ComposeFragment.save():void");
    }

    private void cancel() {
        if (this.composeType == ComposeType.WORKOUT_FEEDBACK) {
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", Integer.valueOf(this.clientId));
            baseHttpClient.put("/tasks/new/process_workout_log_stories_task", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    if (!ComposeFragment.this.isAdded()) {
                        return true;
                    }
                    ((EventListener) ComposeFragment.this.getActivity()).composeCancelled();
                    return true;
                }

                public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    if (!ComposeFragment.this.isAdded()) {
                        return true;
                    }
                    ((EventListener) ComposeFragment.this.getActivity()).composeCancelled();
                    return true;
                }
            });
            return;
        }
        ((EventListener) getActivity()).composeCancelled();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!isAdded() || i2 != -1) {
            return;
        }
        if (i == SS_REQUEST_CODE) {
            int[] intArrayExtra = intent.getIntArrayExtra("segmentIds");
            this.segments.clear();
            for (int valueOf : intArrayExtra) {
                this.segments.add(Integer.valueOf(valueOf));
            }
            return;
        }
        ImagePickerUtil.onActivityResult(getActivity(), i, i2, intent, false, new OnImagePickedHandler() {
            public void onImagePicked(Bitmap bitmap, String str, File file) {
                if (ComposeFragment.this.composeType == ComposeType.POST_STORY) {
                    FileUploader store = new FileUploader(new UploadcareClient(ComposeFragment.this.getString(R.string.uploadcare_public_key), ComposeFragment.this.getString(R.string.uploadcare_private_key)), file).store(true);
                    ProgressDialog unused = ComposeFragment.this.progress = new ProgressDialog(ComposeFragment.this.getContext());
                    ComposeFragment.this.progress.setMessage("Uploading Image");
                    ComposeFragment.this.progress.setProgressStyle(1);
                    ComposeFragment.this.progress.setIndeterminate(true);
                    ComposeFragment.this.progress.setProgressNumberFormat((String) null);
                    ComposeFragment.this.progress.setProgressPercentFormat((NumberFormat) null);
                    ComposeFragment.this.progress.show();
                    store.uploadAsync(new UploadFileCallback() {
                        public void onProgressUpdate(long j, long j2, double d) {
                        }

                        public void onFailure(UploadcareApiException uploadcareApiException) {
                            Log.e("upload error", uploadcareApiException.toString());
                        }

                        public void onSuccess(UploadcareFile uploadcareFile) {
                            String str;
                            ComposeFragment.this.progress.hide();
                            if (uploadcareFile != null) {
                                if (uploadcareFile.getOriginalFileUrl() != null) {
                                    str = uploadcareFile.getOriginalFileUrl().toString();
                                } else {
                                    str = "https://ucarecdn.com/" + uploadcareFile.getUuid() + "/" + uploadcareFile.getOriginalFilename();
                                }
                                Picasso.get().load(Uri.parse(str)).into((Target) new Target() {
                                    public void onBitmapFailed(Exception exc, Drawable drawable) {
                                    }

                                    public void onPrepareLoad(Drawable drawable) {
                                    }

                                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                                        int unused = ComposeFragment.this.coverWidth = bitmap.getWidth();
                                        int unused2 = ComposeFragment.this.coverHeight = bitmap.getHeight();
                                    }
                                });
                                Picasso.get().load(Uri.parse(str)).error((int) R.drawable.profile).into(ComposeFragment.this.photoView);
                                ComposeFragment.this.photoViewWrapper.setVisibility(0);
                                ComposeFragment.this.photoView.setVisibility(0);
                                String unused = ComposeFragment.this.coverUrl = str;
                                ComposeFragment.this.changePostItemIcon();
                            }
                        }
                    });
                    return;
                }
                ComposeFragment.this.addPhotoIV.setVisibility(8);
                ComposeFragment.this.photoViewWrapper.setVisibility(0);
                ComposeFragment.this.photoView.setVisibility(0);
                ComposeFragment.this.photoView.setImageBitmap(bitmap);
            }
        });
    }

    private void removePhoto() {
        if (this.composeType == ComposeType.PROGRESS_PHOTO || this.composeType == ComposeType.WORKOUT_FEEDBACK) {
            this.addPhotoIV.setVisibility(0);
        }
        this.photoView.setVisibility(8);
        this.photoViewWrapper.setVisibility(8);
        this.photoView.setImageDrawable((Drawable) null);
        this.coverUrl = null;
        changePostItemIcon();
    }

    /* access modifiers changed from: private */
    public void changePostItemIcon() {
        String trim = this.noteView.getText().toString().trim();
        boolean z = this.photoViewWrapper.getVisibility() == 0;
        SpannableString spannableString = new SpannableString(RequestHelper.REQUEST_POST);
        if (!z && trim.length() == 0 && this.files.length() == 0) {
            ImageViewCompat.setImageTintList(this.postBtn, ColorStateList.valueOf(getResources().getColor(R.color.lightBlack)));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.lightBlack)), 0, spannableString.length(), 0);
        } else {
            ImageViewCompat.setImageTintList(this.postBtn, ColorStateList.valueOf(getResources().getColor(R.color.tintColor)));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 0, spannableString.length(), 0);
        }
        MenuItem menuItem = this.postItemText;
        if (menuItem != null) {
            menuItem.setTitle(spannableString);
        }
    }

    private void setTitle(String str) {
        this.titleView.setText(str);
    }

    private void setSubTitle(String str) {
        this.subTitleView.setText(str);
    }

    public void onAfterLoading(LinkSourceContent linkSourceContent, boolean z) {
        if (isAdded()) {
            TextView textView = (TextView) getView().findViewById(R.id.link_title_view);
            textView.setText(linkSourceContent.getTitle());
            textView.setVisibility(0);
            TextView textView2 = (TextView) getView().findViewById(R.id.link_description_view);
            textView2.setText(linkSourceContent.getDescription());
            textView2.setVisibility(0);
            List<String> images = linkSourceContent.getImages();
            if (images != null && images.size() > 0) {
                SmartImageView smartImageView = (SmartImageView) getView().findViewById(R.id.link_image_view);
                smartImageView.setImageUrl(images.get(0));
                smartImageView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        View view = getView();
        if (this.isTrainer && this.composeType == ComposeType.POST_STORY) {
            if (compoundButton.getId() == R.id.share_cb) {
                if (z) {
                    this.pinCB.setVisibility(0);
                    this.sendInAppNotifCb.setVisibility(0);
                    this.pinCBWrapper.setVisibility(0);
                    this.sendInAppNotifCBWrapper.setVisibility(0);
                    this.notificationWrapper.setVisibility(0);
                    return;
                }
                this.pinCB.setVisibility(8);
                this.pinCB.setChecked(false);
                this.pinCBWrapper.setVisibility(8);
                this.sendInAppNotifCb.setVisibility(8);
                this.sendInAppNotifCb.setChecked(false);
                this.sendInAppNotifCBWrapper.setVisibility(8);
                this.sendPushNotifCB.setVisibility(8);
                this.sendPushNotifCB.setChecked(false);
                this.notificationWrapper.setVisibility(8);
                this.pmViewWrapper.setVisibility(8);
            } else if (compoundButton.getId() == R.id.send_inapp_notif_cb) {
                if (z) {
                    this.sendPushNotifCB.setVisibility(0);
                    this.sendPushNotifCBWrapper.setVisibility(0);
                    return;
                }
                this.sendPushNotifCB.setVisibility(8);
                this.sendPushNotifCB.setChecked(false);
                this.sendPushNotifCBWrapper.setVisibility(8);
                this.pmViewWrapper.setVisibility(8);
            } else if (compoundButton.getId() == R.id.send_push_notif_cb) {
                if (z) {
                    this.pmViewWrapper.setVisibility(0);
                    final TextView textView = (TextView) view.findViewById(R.id.pm_view);
                    textView.setText(String.format(getString(R.string.xyzAddedANewPost), new Object[]{this.myFirstName}));
                    view.findViewById(R.id.pm_wrapper).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putString("info", "");
                            bundle.putString("text", textView.getText().toString());
                            bundle.putString(ViewHierarchyConstants.HINT_KEY, ComposeFragment.this.getString(R.string.Comment));
                            bundle.putInt("request_code", ComposeFragment.REQUEST_CODE);
                            EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
                            editTextDialogFragment.setArguments(bundle);
                            editTextDialogFragment.show(ComposeFragment.this.getFragmentManager(), "acf");
                        }
                    });
                    return;
                }
                this.pmViewWrapper.setVisibility(8);
            } else if (compoundButton.getId() != R.id.everyone_cb) {
            } else {
                if (!z) {
                    this.everyoneHint.setText(R.string.selectEveryoneHint);
                    this.groupsList.setVisibility(0);
                    return;
                }
                this.everyoneHint.setText(R.string.groupSelectionHint);
                this.groupsList.setVisibility(8);
            }
        }
    }

    private class GroupsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
        private Context context;

        public long getItemId(int i) {
            return 0;
        }

        public int getItemViewType(int i) {
            return i;
        }

        public GroupsAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            return ComposeFragment.this.groups.size();
        }

        public Object getItem(int i) {
            return ComposeFragment.this.groups.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.checkbox_item, (ViewGroup) null);
            try {
                JSONObject jSONObject = (JSONObject) getItem(i);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.group_cb);
                checkBox.setTag(Integer.valueOf(i));
                checkBox.setOnCheckedChangeListener(this);
                int i2 = 0;
                checkBox.setChecked(false);
                ((TextView) inflate.findViewById(R.id.group_name)).setText(jSONObject.getString("name"));
                while (true) {
                    if (i2 >= ComposeFragment.this.selectedGroups.length()) {
                        break;
                    } else if (ComposeFragment.this.selectedGroups.getJSONObject(i2).getInt("id") == jSONObject.getInt("id")) {
                        checkBox.setChecked(true);
                        break;
                    } else {
                        i2++;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return inflate;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                JSONObject jSONObject = (JSONObject) getItem(((Integer) compoundButton.getTag()).intValue());
                try {
                    int i = jSONObject.getInt("id");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= ComposeFragment.this.selectedGroups.length()) {
                            i2 = -1;
                            break;
                        } else if (ComposeFragment.this.selectedGroups.getJSONObject(i2).getInt("id") == i) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 == -1) {
                        ComposeFragment.this.selectedGroups.put(jSONObject);
                    } else {
                        ComposeFragment.this.selectedGroups.remove(i2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
            if (ComposeFragment.this.files == null) {
                return 0;
            }
            return ComposeFragment.this.files.length();
        }

        public Object getItem(int i) {
            try {
                return ComposeFragment.this.files.get(i);
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
                com.trainerfu.android.ComposeFragment r1 = com.trainerfu.android.ComposeFragment.this     // Catch:{ JSONException -> 0x0060 }
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
                com.trainerfu.android.ComposeFragment r0 = com.trainerfu.android.ComposeFragment.this     // Catch:{ JSONException -> 0x004e }
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
                com.trainerfu.android.ComposeFragment$FileListAdapter$1 r10 = new com.trainerfu.android.ComposeFragment$FileListAdapter$1
                r10.<init>(r8)
                r4.setOnClickListener(r10)
                return r9
            L_0x00df:
                java.lang.RuntimeException r8 = new java.lang.RuntimeException
                java.lang.String r9 = "Invalid File Name"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.ComposeFragment.FileListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }
}
