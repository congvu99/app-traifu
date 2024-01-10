package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.legacy.app.FragmentCompat;
import com.anggrayudi.storage.file.MimeType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ProgressPhotosFragment extends Fragment implements FragmentCompat.OnRequestPermissionsResultCallback {
    /* access modifiers changed from: private */
    public int COMPOSE_POST_REQUEST_CODE = 11111;
    private ActionBar actionBar;
    private StableArrayAdapter adapter;
    private JSONObject assessmentData;
    private LinearLayout emptyView;
    private GridView gridView;
    /* access modifiers changed from: private */
    public EventListener mCallback;
    private Menu menu;
    private int myUserId = 0;
    private ArrayList<CellDefinition> pickerList = new ArrayList<>();
    /* access modifiers changed from: private */
    public JSONArray progressPhotos;
    /* access modifiers changed from: private */
    public JSONObject progressPhotosData;
    /* access modifiers changed from: private */
    public HashMap selectedImages = new HashMap();
    /* access modifiers changed from: private */
    public HashSet<Integer> selectedItemsPosition = new HashSet<>();
    /* access modifiers changed from: private */
    public boolean showCheckbox;
    /* access modifiers changed from: private */
    public int userId;
    private boolean viewedByTrainer;

    public interface EventListener {
        void onAddNewPhoto();

        void onDeleteAssessmentType(int i);

        void onDeletePhoto(boolean z);

        void onProgressPhotoClicked(JSONObject jSONObject);
    }

    private static class CellDefinition {
        public int cellType;
        public Object data;

        public CellDefinition(int i, Object obj) {
            this.cellType = i;
            this.data = obj;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        setHasOptionsMenu(true);
        View inflate = layoutInflater.inflate(R.layout.progress_photos_view, viewGroup, false);
        this.gridView = (GridView) inflate.findViewById(R.id.progress_photos_list);
        this.emptyView = (LinearLayout) inflate.findViewById(R.id.empty_view);
        registerForContextMenu(this.gridView);
        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(getActivity());
        this.adapter = stableArrayAdapter;
        this.gridView.setAdapter(stableArrayAdapter);
        this.mCallback = (EventListener) getActivity();
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!ProgressPhotosFragment.this.showCheckbox) {
                    try {
                        ProgressPhotosFragment.this.mCallback.onProgressPhotoClicked(ProgressPhotosFragment.this.progressPhotos.getJSONObject(i));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        this.actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        reloadData(true);
        this.adapter.notifyDataSetChanged();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            try {
                this.userId = bundle.getInt("user_id");
                this.assessmentData = new JSONObject(bundle.getString("assessment_data"));
                this.viewedByTrainer = bundle.getBoolean("viewed_by_trainer");
                this.adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("user_id", this.userId);
        bundle.putString("assessment_data", this.assessmentData.toString());
        bundle.putBoolean("viewed_by_trainer", this.viewedByTrainer);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getActivity().getMenuInflater().inflate(R.menu.lv_list_menu, contextMenu);
        AnonymousClass2 r4 = new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                ProgressPhotosFragment.this.onContextItemSelected(menuItem);
                return true;
            }
        };
        int size = contextMenu.size();
        for (int i = 0; i < size; i++) {
            contextMenu.getItem(i).setOnMenuItemClickListener(r4);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (menuItem.getItemId() != R.id.lv_list_menu_delete) {
            return true;
        }
        try {
            deletePhoto(this.progressPhotos.getJSONObject(adapterContextMenuInfo.position).getInt("photo_id"));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (isAdded()) {
            ImagePickerUtil.onRequestPermissionsResult(i, strArr, iArr, (Fragment) this);
        }
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menu2.clear();
        if (this.selectedItemsPosition.size() == 0) {
            menuInflater.inflate(R.menu.add_menu, menu2);
            this.menu = menu2;
            menu2.findItem(R.id.add_item).setVisible(true);
        } else {
            menuInflater.inflate(R.menu.progress_photo_menu, menu2);
            this.menu = menu2;
            MenuItem findItem = menu2.findItem(R.id.share_item);
            MenuItem findItem2 = menu2.findItem(R.id.delete_item);
            findItem.getIcon().setTint(getResources().getColor(R.color.iconColor));
            findItem2.getIcon().setTint(getResources().getColor(R.color.iconColor));
        }
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.add_item) {
            Bundle bundle = new Bundle();
            PhotoOptionsDialogFragment newInstance = PhotoOptionsDialogFragment.newInstance();
            newInstance.setArguments(bundle);
            newInstance.setTargetFragment(this, 1);
            newInstance.show(getActivity().getSupportFragmentManager(), "bottomSheet");
        }
        if (itemId == R.id.share_item) {
            shareImages();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void takePicture() {
        EasyImage.openCamera((Fragment) this, 1);
    }

    public void choosePicture() {
        EasyImage.openGallery((Fragment) this, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            EasyImage.handleActivityResult(i, i2, intent, getActivity(), new DefaultCallback() {
                public void onImagePickerError(Exception exc, EasyImage.ImageSource imageSource, int i) {
                }

                public void onImagesPicked(List<File> list, EasyImage.ImageSource imageSource, int i) {
                    Intent intent = new Intent(ProgressPhotosFragment.this.getActivity(), ComposeActivity.class);
                    intent.putExtra("compose_type", ComposeType.PROGRESS_PHOTO.getMask());
                    intent.putExtra("photo_file_path", list.get(0).getAbsolutePath());
                    intent.putExtra("client_id", ProgressPhotosFragment.this.userId);
                    ProgressPhotosFragment progressPhotosFragment = ProgressPhotosFragment.this;
                    progressPhotosFragment.startActivityForResult(intent, progressPhotosFragment.COMPOSE_POST_REQUEST_CODE);
                }
            });
            if (i == this.COMPOSE_POST_REQUEST_CODE && intent.getStringExtra("action").equals("compose_object_saved")) {
                ((EventListener) getActivity()).onAddNewPhoto();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: private */
    public void reloadData(boolean z) {
        new BaseHttpClient(Boolean.valueOf(z), getActivity()).get(String.format("/users/%d/progress_photos", new Object[]{Integer.valueOf(this.userId)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONObject unused = ProgressPhotosFragment.this.progressPhotosData = jSONObject;
                ProgressPhotosFragment progressPhotosFragment = ProgressPhotosFragment.this;
                progressPhotosFragment.createProgressPhotosData(progressPhotosFragment.progressPhotosData);
                return true;
            }
        });
    }

    public void setData(int i, JSONObject jSONObject, boolean z) {
        this.userId = i;
        this.assessmentData = jSONObject;
        this.viewedByTrainer = z;
        if (isAdded()) {
            reloadData(true);
        }
    }

    /* access modifiers changed from: private */
    public void createProgressPhotosData(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("progress_photos");
            this.progressPhotos = jSONArray;
            if (jSONArray.length() == 0) {
                this.emptyView.setVisibility(0);
            } else {
                this.emptyView.setVisibility(8);
            }
            this.adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void setTitle() {
        if (this.selectedItemsPosition.size() > 0) {
            this.actionBar.setTitle((CharSequence) String.format("%d selected", new Object[]{Integer.valueOf(this.selectedItemsPosition.size())}));
        } else {
            this.actionBar.setTitle((int) R.string.progressPhotos);
            this.showCheckbox = false;
            this.adapter.notifyDataSetChanged();
        }
        getActivity().invalidateOptionsMenu();
    }

    public void shareImages() {
        if (this.selectedImages.size() != 0) {
            ArrayList arrayList = new ArrayList(this.selectedImages.values());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putExtra("android.intent.extra.STREAM", arrayList);
            intent.setType(MimeType.IMAGE);
            startActivity(Intent.createChooser(intent, "Share Image"));
        }
    }

    private void deletePhoto(int i) {
        new BaseHttpClient(true, getActivity()).delete(String.format("/users_photos/%d", new Object[]{Integer.valueOf(i)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                ProgressPhotosFragment.this.reloadData(true);
                ((EventListener) ProgressPhotosFragment.this.getActivity()).onDeletePhoto(false);
                return true;
            }
        });
    }

    public Uri getLocalBitmapUri(ImageView imageView) {
        if (!(imageView.getDrawable() instanceof Drawable)) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        try {
            File externalFilesDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File file = new File(externalFilesDir, "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.close();
            return FileProvider.getUriForFile(getActivity(), "com.trainerfu.android.provider", file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class StableArrayAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return false;
        }

        public StableArrayAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (ProgressPhotosFragment.this.progressPhotos != null) {
                return ProgressPhotosFragment.this.progressPhotos.length();
            }
            return 0;
        }

        public Object getItem(int i) {
            try {
                return ProgressPhotosFragment.this.progressPhotos.get(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            String str;
            LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.progress_photo_single_row_view, (ViewGroup) null);
            final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.progress_photo);
            TextView textView = (TextView) linearLayout.findViewById(R.id.date_view);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.progress_photo_detail);
            final View findViewById = linearLayout.findViewById(R.id.image_overlay);
            CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.photo_cb);
            JSONObject jSONObject = (JSONObject) getItem(i);
            StringBuilder sb = new StringBuilder();
            try {
                String string = jSONObject.getString("date");
                String string2 = jSONObject.getString("weight");
                String string3 = jSONObject.getString("bfp");
                if (jSONObject.has("photo_id")) {
                    str = Util.getUrlForPhoto(jSONObject.getInt("photo_id"));
                } else {
                    str = Util.getUrlForPhoto(jSONObject.getInt("id"));
                }
                ((RequestBuilder) Glide.with(ProgressPhotosFragment.this.getContext()).load(str).fitCenter()).into(imageView);
                if (DateUtils.getDateFromISOFormat(string) == DateUtils.getTodaysDate()) {
                    textView.setText("Today");
                } else {
                    textView.setText(DateUtils.getFeedDisplayDate(DateUtils.getDateFromISOFormat(string)));
                }
                if (string2 != null) {
                    if (!string2.equals(JsonLexerKt.NULL)) {
                        sb.append(String.format("Weight: %s", new Object[]{string2}));
                    }
                }
                if (string3 != null && !string3.equals(JsonLexerKt.NULL)) {
                    sb.append(" • ");
                    sb.append(String.format("BF: %s%%", new Object[]{string3}));
                }
                textView2.setText(sb);
                if (ProgressPhotosFragment.this.showCheckbox) {
                    findViewById.setVisibility(0);
                    checkBox.setVisibility(0);
                    if (ProgressPhotosFragment.this.selectedItemsPosition.contains(Integer.valueOf(i))) {
                        checkBox.setChecked(true);
                        findViewById.setBackgroundColor(ProgressPhotosFragment.this.getResources().getColor(R.color.imageOverlayColorDark));
                    }
                    final ImageView imageView2 = imageView;
                    final CheckBox checkBox2 = checkBox;
                    final int i2 = i;
                    final View view2 = findViewById;
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Uri localBitmapUri = ProgressPhotosFragment.this.getLocalBitmapUri(imageView2);
                            if (checkBox2.isChecked()) {
                                ProgressPhotosFragment.this.selectedImages.remove(Integer.valueOf(i2));
                                ProgressPhotosFragment.this.selectedItemsPosition.remove(Integer.valueOf(i2));
                                checkBox2.setChecked(false);
                                view2.setBackgroundColor(ProgressPhotosFragment.this.getResources().getColor(R.color.imageOverlayColorLight));
                                ProgressPhotosFragment.this.setTitle();
                                return;
                            }
                            ProgressPhotosFragment.this.selectedImages.put(Integer.valueOf(i2), localBitmapUri);
                            ProgressPhotosFragment.this.selectedItemsPosition.add(Integer.valueOf(i2));
                            checkBox2.setChecked(true);
                            view2.setBackgroundColor(ProgressPhotosFragment.this.getResources().getColor(R.color.imageOverlayColorDark));
                            ProgressPhotosFragment.this.setTitle();
                        }
                    });
                }
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (compoundButton.isPressed()) {
                            Uri localBitmapUri = ProgressPhotosFragment.this.getLocalBitmapUri(imageView);
                            if (z) {
                                ProgressPhotosFragment.this.selectedImages.put(Integer.valueOf(i), localBitmapUri);
                                ProgressPhotosFragment.this.selectedItemsPosition.add(Integer.valueOf(i));
                                findViewById.setBackgroundColor(ProgressPhotosFragment.this.getResources().getColor(R.color.imageOverlayColorDark));
                                ProgressPhotosFragment.this.setTitle();
                                return;
                            }
                            ProgressPhotosFragment.this.selectedImages.remove(Integer.valueOf(i));
                            ProgressPhotosFragment.this.selectedItemsPosition.remove(Integer.valueOf(i));
                            findViewById.setBackgroundColor(ProgressPhotosFragment.this.getResources().getColor(R.color.imageOverlayColorLight));
                            ProgressPhotosFragment.this.setTitle();
                        }
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return linearLayout;
        }
    }
}
