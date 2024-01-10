package com.trainerfu.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.anggrayudi.storage.file.MimeType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class ProgressPhotoViewFragment extends Fragment {
    private ActionBar actionBar;
    private String bfp;
    private Menu menu;
    private JSONObject photo;
    private String photoDate;
    private String photoUrl;
    private ImageView photoView;
    private int userId;
    private String weight;

    public interface EventListener {
        void onDeletePhoto(boolean z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.userId = getArguments().getInt("userId");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.progress_photo_view, viewGroup, false);
        this.photoView = (ImageView) inflate.findViewById(R.id.progress_photo);
        try {
            this.photoDate = this.photo.getString("date");
            this.weight = this.photo.getString("weight");
            this.bfp = this.photo.getString("bfp");
            if (this.photo.has("photo_id")) {
                this.photoUrl = Util.getUrlForPhoto(this.photo.getInt("photo_id"));
            } else {
                this.photoUrl = Util.getUrlForPhoto(this.photo.getInt("id"));
            }
            ((RequestBuilder) Glide.with(getContext()).load(this.photoUrl).fitCenter()).into(this.photoView);
            this.actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            setActionBarTitle();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        menu2.clear();
        menuInflater.inflate(R.menu.progress_photo_menu, menu2);
        this.menu = menu2;
        MenuItem findItem = menu2.findItem(R.id.share_item);
        MenuItem findItem2 = menu2.findItem(R.id.delete_item);
        findItem.getIcon().setTint(getResources().getColor(R.color.white));
        findItem2.getIcon().setTint(getResources().getColor(R.color.white));
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.share_item) {
            shareItem();
        }
        if (itemId == R.id.delete_item) {
            try {
                if (this.photo.has("photo_id")) {
                    deletePhoto(this.photo.getInt("photo_id"));
                } else {
                    deletePhoto(this.photo.getInt("id"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        this.actionBar.setSubtitle((CharSequence) "");
    }

    public void setActionBarTitle() {
        String feedDisplayDate = DateUtils.getFeedDisplayDate(DateUtils.getDateFromISOFormat(this.photoDate));
        SpannableString spannableString = new SpannableString(feedDisplayDate);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, feedDisplayDate.length(), 33);
        this.actionBar.setTitle((CharSequence) spannableString);
        StringBuilder sb = new StringBuilder();
        String str = this.weight;
        if (str != null && !str.equals(JsonLexerKt.NULL)) {
            sb.append(String.format("Weight: %s", new Object[]{this.weight}));
        }
        String str2 = this.bfp;
        if (str2 != null && !str2.equals(JsonLexerKt.NULL)) {
            sb.append(" • ");
            sb.append(String.format("BF: %s%%", new Object[]{this.bfp}));
        }
        SpannableString spannableString2 = new SpannableString(sb);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.chalkWhite)), 0, sb.length(), 33);
        spannableString2.setSpan(new AbsoluteSizeSpan(16, true), 0, sb.length(), 33);
        this.actionBar.setSubtitle((CharSequence) spannableString2);
        this.actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.textColor)));
        this.actionBar.setElevation(0.0f);
    }

    public void setData(JSONObject jSONObject) {
        this.userId = this.userId;
        this.photo = jSONObject;
    }

    public void shareItem() {
        Uri localBitmapUri = getLocalBitmapUri(this.photoView);
        if (localBitmapUri != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", localBitmapUri);
            intent.setType(MimeType.IMAGE);
            intent.addFlags(3);
            startActivity(Intent.createChooser(intent, "Share Image"));
        }
    }

    private void deletePhoto(int i) {
        new BaseHttpClient(true, getActivity()).delete(String.format("/users_photos/%d", new Object[]{Integer.valueOf(i)}), new HashMap(), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                ((EventListener) ProgressPhotoViewFragment.this.getActivity()).onDeletePhoto(true);
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
            return FileProvider.getUriForFile(getActivity(), "com.trainerfu.android.fileprovider", file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
