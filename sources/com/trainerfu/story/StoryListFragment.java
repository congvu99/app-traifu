package com.trainerfu.story;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.PeriodicWorkRequest;
import coil.util.Utils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.trainerfu.android.ClientManagementActivity;
import com.trainerfu.android.ComposeActivity;
import com.trainerfu.android.ComposeType;
import com.trainerfu.android.ContentType;
import com.trainerfu.android.EditTextDialogFragment;
import com.trainerfu.android.LikesNamesFragment;
import com.trainerfu.android.LocalDB;
import com.trainerfu.android.R;
import com.trainerfu.android.RNEntryRoute;
import com.trainerfu.android.RNHostActivity;
import com.trainerfu.android.TextEditedEvent;
import com.trainerfu.android.WorkoutLogActivity;
import com.trainerfu.story.HeaderView;
import com.trainerfu.story.LikeCountBinder;
import com.trainerfu.story.LikesDetailBinder;
import com.trainerfu.story.ShowAchievementDetailsBinder;
import com.trainerfu.story.ShowMealDetailsBinder;
import com.trainerfu.story.ShowMoreCommentsBinder;
import com.trainerfu.story.ShowWorkoutDetailsBinder;
import com.trainerfu.story.StoryTitleView;
import com.trainerfu.story.ToolbarView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.Util;
import com.trainerfu.utils.ZipUtil;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class StoryListFragment extends Fragment implements ShowWorkoutDetailsBinder.EventHandler, ToolbarView.EventListener, LikeCountBinder.EventListener, AdapterView.OnItemLongClickListener, ShowMealDetailsBinder.EventListener, HeaderView.EventListener, SwipeRefreshLayout.OnRefreshListener, StoryTitleView.EventListener, ShowAchievementDetailsBinder.EventHandler, ShowMoreCommentsBinder.EventListener, LikesDetailBinder.EventListener, View.OnClickListener {
    private static int PROGRESS_PHOTO_CONTEXT_MENU = 1;
    private static int STORY_MORE_OPTIONS_CONTEXT_MENU = 2;
    public static boolean hasNewDiaryEntries = false;
    public static boolean hasNewNews = false;
    static List<Class<? extends SectionPartView>> supportedPartViewTypes;
    /* access modifiers changed from: private */
    public int COMPOSE_POST_REQUEST_CODE = 11111;
    private int LOG_WORKOUT_REQUEST_CODE = 44794;
    private boolean amITrainer = false;
    private Calendar calendar = Calendar.getInstance();
    private String contact = null;
    /* access modifiers changed from: private */
    public int diaryUserId = 0;
    private boolean didSeeProgressPhotoTooltip = true;
    private boolean isNewsModerated = false;
    private long lastRefreshTimeInMillis = 0;
    /* access modifiers changed from: private */
    public ListAdapter listAdapter;
    /* access modifiers changed from: private */
    public ListView listView;
    private String myFirstName = null;
    private int myUserId = 0;
    private int openContextMenuForType = STORY_MORE_OPTIONS_CONTEXT_MENU;
    /* access modifiers changed from: private */
    public List<List<SectionPartDefinition>> partDefinitions;
    private int pendingShareStoryId = -1;
    private int refStoryId = 0;
    private int segmentIdFilter = -2;
    private String shareCredit = null;
    private int singleStoryId = 0;
    /* access modifiers changed from: private */
    public JSONObject state;
    private JSONArray storyIdsArr = new JSONArray();
    private StoryListViewType storyListViewType = StoryListViewType.NEWS_VIEW;
    private StoryType storyTypeFilter = null;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout swipeRefreshView;
    private int trainerIdFilter = -2;
    private JSONObject trainers = null;
    private JSONArray userIdsArr = new JSONArray();
    /* access modifiers changed from: private */
    public List<SectionBaseViewModel> viewModels;

    static {
        ArrayList arrayList = new ArrayList();
        supportedPartViewTypes = arrayList;
        arrayList.add(SeparatorView.class);
        supportedPartViewTypes.add(StoryTitleView.class);
        supportedPartViewTypes.add(SectionTextView.class);
        supportedPartViewTypes.add(PhotoView.class);
        supportedPartViewTypes.add(H3View.class);
        supportedPartViewTypes.add(H4View.class);
        supportedPartViewTypes.add(H4ViewLight.class);
        supportedPartViewTypes.add(RecordView.class);
        supportedPartViewTypes.add(ClickableLabel.class);
        supportedPartViewTypes.add(DividerView.class);
        supportedPartViewTypes.add(AchievementView.class);
        supportedPartViewTypes.add(ToolbarView.class);
        supportedPartViewTypes.add(SectionIconTextView.class);
        supportedPartViewTypes.add(CommentView.class);
        supportedPartViewTypes.add(BeforeAfterView.class);
        supportedPartViewTypes.add(AssessmentProgressView.class);
        supportedPartViewTypes.add(GoalView.class);
        supportedPartViewTypes.add(LinkView.class);
        supportedPartViewTypes.add(HeaderView.class);
        supportedPartViewTypes.add(EmptyView.class);
        supportedPartViewTypes.add(DownloadFileView.class);
        supportedPartViewTypes.add(CheckinView.class);
        supportedPartViewTypes.add(RecentCheckinView.class);
        supportedPartViewTypes.add(AssessmentDetailView.class);
        supportedPartViewTypes.add(AchievementSummaryView.class);
        supportedPartViewTypes.add(MealHeaderView.class);
        supportedPartViewTypes.add(MealTotalView.class);
        supportedPartViewTypes.add(MealGoalView.class);
        supportedPartViewTypes.add(PRView.class);
    }

    public abstract class StoryUpdater {
        public abstract void update(StoryBaseViewModel storyBaseViewModel);

        public StoryUpdater() {
        }

        public void execute(int i) {
            int access$000 = StoryListFragment.this.findStoryViewModelIndex(i);
            StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) StoryListFragment.this.viewModels.get(access$000);
            update(storyBaseViewModel);
            StoryListFragment.this.partDefinitions.set(access$000, storyBaseViewModel.getParts());
            StoryListFragment.this.listAdapter.notifyDataSetChanged();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("story_list_view_type")) {
                StoryListViewType storyListViewType2 = StoryListViewType.getStoryListViewType(arguments.getInt("story_list_view_type"));
                this.storyListViewType = storyListViewType2;
                if (storyListViewType2 == StoryListViewType.DIARY_VIEW || this.storyListViewType == StoryListViewType.CHECKINS_VIEW) {
                    this.diaryUserId = arguments.getInt("diary_user_id");
                } else if (this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
                    this.singleStoryId = arguments.getInt("story_id");
                } else if (this.storyListViewType == StoryListViewType.PROGRESS_PHOTOS_VIEW) {
                    this.diaryUserId = arguments.getInt("diary_user_id");
                }
            }
            if (arguments.containsKey("story_type_filter")) {
                this.storyTypeFilter = StoryType.getStoryType(arguments.getInt("story_type_filter"));
            }
        }
        View inflate = layoutInflater.inflate(R.layout.stories_view, viewGroup, false);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.swipe_refresh_view);
        this.swipeRefreshView = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.listView = (ListView) inflate.findViewById(R.id.list_view);
        ListAdapter listAdapter2 = new ListAdapter(getActivity());
        this.listAdapter = listAdapter2;
        this.listView.setAdapter(listAdapter2);
        registerForContextMenu(this.listView);
        this.listView.setOnItemLongClickListener(this);
        if (this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            ((ImageView) inflate.findViewById(R.id.icon_send)).setOnClickListener(this);
            ((RelativeLayout) inflate.findViewById(R.id.add_comment_view)).setVisibility(0);
            ((EditText) inflate.findViewById(R.id.commentET)).setVisibility(0);
            this.swipeRefreshView.setPadding(0, 0, 0, Util.sizeInPx(getActivity(), 50));
        } else {
            this.swipeRefreshView.setPadding(0, 0, 0, 0);
        }
        this.didSeeProgressPhotoTooltip = LocalDB.didSeeProgressPhotoTooltip(getActivity());
        try {
            this.storyIdsArr = new JSONArray(Util.getStoryIds(getContext()));
            this.userIdsArr = new JSONArray(Util.getUserIds(getContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("state")) {
            try {
                byte[] byteArray = bundle.getByteArray("state");
                this.state = null;
                if (byteArray != null) {
                    try {
                        this.state = new JSONObject(ZipUtil.decompress(byteArray));
                    } catch (IOException unused) {
                    }
                }
                this.trainerIdFilter = bundle.getInt("trainer_id_filter");
                this.segmentIdFilter = bundle.getInt("segment_id_filter");
                if (bundle.containsKey("story_type_filter")) {
                    this.storyTypeFilter = StoryType.getStoryType(bundle.getInt("story_type_filter"));
                }
                if (this.state != null) {
                    createOrRestoreFromState(this.state);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
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

    public void onPause() {
        super.onPause();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshView;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            this.swipeRefreshView.destroyDrawingCache();
            this.swipeRefreshView.clearAnimation();
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        int i = this.openContextMenuForType;
        if (i == STORY_MORE_OPTIONS_CONTEXT_MENU) {
            onCreateMoreContextMenu(contextMenu, view, contextMenuInfo);
        } else if (i == PROGRESS_PHOTO_CONTEXT_MENU) {
            ImagePickerUtil.showPickPhotoMenu(getActivity(), contextMenu);
        }
    }

    private void onCreateMoreContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex(this.refStoryId));
        new MenuInflater(getActivity()).inflate(R.menu.story_options, contextMenu);
        MenuItem findItem = contextMenu.findItem(R.id.toggle_privacy_item);
        if (storyBaseViewModel.isPublic()) {
            findItem.setTitle(getString(R.string.makeThisPostPrivate));
        } else {
            findItem.setTitle(getString(R.string.makeThisPostPublic));
        }
        MenuItem findItem2 = contextMenu.findItem(R.id.toggle_pinned_item);
        if (this.amITrainer) {
            findItem2.setVisible(true);
            if (storyBaseViewModel.isPinned()) {
                findItem2.setTitle(getString(R.string.unpinFromTop));
            } else {
                findItem2.setTitle(getString(R.string.pinToTop));
            }
        } else {
            findItem2.setVisible(false);
        }
        MenuItem findItem3 = contextMenu.findItem(R.id.toggle_publish_item);
        if (!this.amITrainer || !this.isNewsModerated) {
            findItem3.setVisible(false);
            return;
        }
        findItem3.setVisible(true);
        if (storyBaseViewModel.showToEveryone()) {
            findItem3.setTitle(getString(R.string.hideFromClientsNewsFeed));
        } else {
            findItem3.setTitle(getString(R.string.publishOnClientsNewsFeed));
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.toggle_privacy_item) {
            togglePrivacy(this.refStoryId);
        } else if (menuItem.getItemId() == R.id.toggle_pinned_item) {
            togglePinned(this.refStoryId);
        } else if (menuItem.getItemId() == R.id.toggle_publish_item) {
            togglePublished(this.refStoryId);
        } else if (menuItem.getItemId() == R.id.delete_post) {
            delete(this.refStoryId);
        } else if (ImagePickerUtil.isImagePickerMenuItem(menuItem)) {
            ImagePickerUtil.onContextItemSelected(menuItem, (Context) getActivity(), (Fragment) this);
        }
        this.refStoryId = 0;
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == this.COMPOSE_POST_REQUEST_CODE) {
                String stringExtra = intent.getStringExtra("action");
                if (this.state != null && stringExtra.equals("compose_object_saved")) {
                    triggerSwipeRefresh(false, true);
                }
            } else if (i == this.LOG_WORKOUT_REQUEST_CODE) {
                String stringExtra2 = intent.getStringExtra("action");
                if (this.state != null && stringExtra2.equals("workout_log_saved")) {
                    triggerSwipeRefresh(false, true);
                }
            } else {
                EasyImage.handleActivityResult(i, i2, intent, getActivity(), new DefaultCallback() {
                    public void onImagePickerError(Exception exc, EasyImage.ImageSource imageSource, int i) {
                    }

                    public void onImagesPicked(List<File> list, EasyImage.ImageSource imageSource, int i) {
                        Intent intent = new Intent(StoryListFragment.this.getActivity(), ComposeActivity.class);
                        intent.putExtra("compose_type", ComposeType.PROGRESS_PHOTO.getMask());
                        intent.putExtra("photo_file_path", list.get(0).getAbsolutePath());
                        intent.putExtra("client_id", StoryListFragment.this.diaryUserId);
                        StoryListFragment storyListFragment = StoryListFragment.this;
                        storyListFragment.startActivityForResult(intent, storyListFragment.COMPOSE_POST_REQUEST_CODE);
                    }
                });
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.trainerfu.story.WorkoutStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.trainerfu.story.WorkoutStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.trainerfu.story.MealStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: com.trainerfu.story.CheckinStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: com.trainerfu.story.CheckinStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: com.trainerfu.story.PostStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: com.trainerfu.story.LinkStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: com.trainerfu.story.AssessmentStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: com.trainerfu.story.ProgressPhotoStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: com.trainerfu.story.ProgressPhotoStoryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: com.trainerfu.story.WorkoutStoryViewModel} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x022f A[Catch:{ JSONException -> 0x0337 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0230 A[Catch:{ JSONException -> 0x0337 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x023a A[Catch:{ JSONException -> 0x0337 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createOrRestoreFromState(org.json.JSONObject r14) {
        /*
            r13 = this;
            java.lang.String r0 = "contact"
            java.lang.String r1 = "can_other_clients_see_comments"
            boolean r1 = r14.getBoolean(r1)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r2 = "can_other_clients_see_workouts"
            boolean r2 = r14.getBoolean(r2)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r3 = "is_trainer"
            boolean r3 = r14.getBoolean(r3)     // Catch:{ JSONException -> 0x0337 }
            r13.amITrainer = r3     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r3 = "is_news_moderated"
            boolean r3 = r14.getBoolean(r3)     // Catch:{ JSONException -> 0x0337 }
            r13.isNewsModerated = r3     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r3 = "my_user_id"
            int r3 = r14.getInt(r3)     // Catch:{ JSONException -> 0x0337 }
            r13.myUserId = r3     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r3 = "my_first_name"
            java.lang.String r3 = r14.getString(r3)     // Catch:{ JSONException -> 0x0337 }
            r13.myFirstName = r3     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r3 = "progress_photos"
            org.json.JSONObject r3 = r14.getJSONObject(r3)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r4 = "trainers"
            org.json.JSONObject r4 = r14.getJSONObject(r4)     // Catch:{ JSONException -> 0x0337 }
            r13.trainers = r4     // Catch:{ JSONException -> 0x0337 }
            boolean r4 = r14.isNull(r0)     // Catch:{ JSONException -> 0x0337 }
            if (r4 != 0) goto L_0x0048
            java.lang.String r0 = r14.getString(r0)     // Catch:{ JSONException -> 0x0337 }
            r13.contact = r0     // Catch:{ JSONException -> 0x0337 }
        L_0x0048:
            java.lang.String r0 = "stories"
            org.json.JSONArray r14 = r14.getJSONArray(r0)     // Catch:{ JSONException -> 0x0337 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0337 }
            r0.<init>()     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r0 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r4 = com.trainerfu.story.StoryListViewType.DIARY_VIEW     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r5 = "user_id"
            r6 = 1
            r7 = 0
            if (r0 != r4) goto L_0x0060
            r4 = r14
            goto L_0x00f2
        L_0x0060:
            org.json.JSONArray r0 = r13.storyIdsArr     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0337 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0337 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0337 }
            r13.storyIdsArr = r4     // Catch:{ JSONException -> 0x0337 }
            org.json.JSONArray r0 = r13.userIdsArr     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0337 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0337 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0337 }
            r13.userIdsArr = r4     // Catch:{ JSONException -> 0x0337 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0337 }
            r0.<init>()     // Catch:{ JSONException -> 0x0337 }
            r4 = 0
        L_0x0080:
            int r8 = r14.length()     // Catch:{ JSONException -> 0x0337 }
            if (r4 >= r8) goto L_0x00b1
            org.json.JSONObject r8 = r14.getJSONObject(r4)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r9 = r8.getString(r5)     // Catch:{ JSONException -> 0x0337 }
            r10 = 0
        L_0x008f:
            org.json.JSONArray r11 = r13.userIdsArr     // Catch:{ JSONException -> 0x0337 }
            int r11 = r11.length()     // Catch:{ JSONException -> 0x0337 }
            if (r10 >= r11) goto L_0x00a8
            org.json.JSONArray r11 = r13.userIdsArr     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r11 = r11.getString(r10)     // Catch:{ JSONException -> 0x0337 }
            boolean r11 = r9.equals(r11)     // Catch:{ JSONException -> 0x0337 }
            if (r11 == 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a9
        L_0x00a5:
            int r10 = r10 + 1
            goto L_0x008f
        L_0x00a8:
            r9 = 0
        L_0x00a9:
            if (r9 != 0) goto L_0x00ae
            r0.add(r8)     // Catch:{ JSONException -> 0x0337 }
        L_0x00ae:
            int r4 = r4 + 1
            goto L_0x0080
        L_0x00b1:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0337 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0337 }
            r0.clear()     // Catch:{ JSONException -> 0x0337 }
            r8 = 0
        L_0x00ba:
            int r9 = r4.length()     // Catch:{ JSONException -> 0x0337 }
            if (r8 >= r9) goto L_0x00ed
            org.json.JSONObject r9 = r4.getJSONObject(r8)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r10 = "story_id"
            java.lang.String r10 = r9.getString(r10)     // Catch:{ JSONException -> 0x0337 }
            r11 = 0
        L_0x00cb:
            org.json.JSONArray r12 = r13.storyIdsArr     // Catch:{ JSONException -> 0x0337 }
            int r12 = r12.length()     // Catch:{ JSONException -> 0x0337 }
            if (r11 >= r12) goto L_0x00e4
            org.json.JSONArray r12 = r13.storyIdsArr     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r12 = r12.getString(r11)     // Catch:{ JSONException -> 0x0337 }
            boolean r12 = r10.equals(r12)     // Catch:{ JSONException -> 0x0337 }
            if (r12 == 0) goto L_0x00e1
            r10 = 1
            goto L_0x00e5
        L_0x00e1:
            int r11 = r11 + 1
            goto L_0x00cb
        L_0x00e4:
            r10 = 0
        L_0x00e5:
            if (r10 != 0) goto L_0x00ea
            r0.add(r9)     // Catch:{ JSONException -> 0x0337 }
        L_0x00ea:
            int r8 = r8 + 1
            goto L_0x00ba
        L_0x00ed:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0337 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0337 }
        L_0x00f2:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0337 }
            r0.<init>()     // Catch:{ JSONException -> 0x0337 }
            r13.viewModels = r0     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r0 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r8 = com.trainerfu.story.StoryListViewType.SINGLE_STORY_VIEW     // Catch:{ JSONException -> 0x0337 }
            if (r0 == r8) goto L_0x0109
            com.trainerfu.story.StoryListViewType r0 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r8 = com.trainerfu.story.StoryListViewType.NEWS_VIEW     // Catch:{ JSONException -> 0x0337 }
            if (r0 != r8) goto L_0x010f
            boolean r0 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            if (r0 != 0) goto L_0x010f
        L_0x0109:
            com.trainerfu.story.StoryListViewType r0 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r8 = com.trainerfu.story.StoryListViewType.NEWS_VIEW     // Catch:{ JSONException -> 0x0337 }
            if (r0 != r8) goto L_0x0121
        L_0x010f:
            com.trainerfu.story.HeaderViewModel r0 = new com.trainerfu.story.HeaderViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r8 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r9 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            boolean r10 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            r0.<init>(r8, r9, r13, r10)     // Catch:{ JSONException -> 0x0337 }
            java.util.List<com.trainerfu.story.SectionBaseViewModel> r8 = r13.viewModels     // Catch:{ JSONException -> 0x0337 }
            r8.add(r0)     // Catch:{ JSONException -> 0x0337 }
        L_0x0121:
            com.trainerfu.story.EmptyViewModel r0 = new com.trainerfu.story.EmptyViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r8 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryType r9 = r13.storyTypeFilter     // Catch:{ JSONException -> 0x0337 }
            r0.<init>(r8, r9)     // Catch:{ JSONException -> 0x0337 }
            int r8 = r14.length()     // Catch:{ JSONException -> 0x0337 }
            if (r8 != 0) goto L_0x0137
            java.util.List<com.trainerfu.story.SectionBaseViewModel> r8 = r13.viewModels     // Catch:{ JSONException -> 0x0337 }
            r8.add(r0)     // Catch:{ JSONException -> 0x0337 }
        L_0x0137:
            r0 = 0
            r8 = 0
        L_0x0139:
            int r9 = r4.length()     // Catch:{ JSONException -> 0x0337 }
            if (r0 >= r9) goto L_0x0271
            org.json.JSONObject r9 = r4.getJSONObject(r0)     // Catch:{ JSONException -> 0x0337 }
            boolean r10 = r13.canUnderstandStory(r9)     // Catch:{ JSONException -> 0x0337 }
            if (r10 == 0) goto L_0x026d
            r10 = 0
            java.lang.String r11 = "story_type"
            int r11 = r9.getInt(r11)     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryType r11 = com.trainerfu.story.StoryType.getStoryType(r11)     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.WORKOUT_LOG     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x0182
            com.trainerfu.story.WorkoutStoryViewModel r10 = new com.trainerfu.story.WorkoutStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
            boolean r11 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            if (r11 != 0) goto L_0x0176
            if (r2 != 0) goto L_0x0176
            int r11 = r9.getInt(r5)     // Catch:{ JSONException -> 0x0337 }
            int r12 = r13.myUserId     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x0174
            goto L_0x0176
        L_0x0174:
            r11 = 0
            goto L_0x0177
        L_0x0176:
            r11 = 1
        L_0x0177:
            r10.setShowWorkout(r11)     // Catch:{ JSONException -> 0x0337 }
            r10.setShowWorkoutDetailsEventHandler(r13)     // Catch:{ JSONException -> 0x0337 }
            r10.setShowAchievementDetailsEventHandler(r13)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x0182:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.PROGRESS_PHOTO     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x01a8
            com.trainerfu.story.ProgressPhotoStoryViewModel r10 = new com.trainerfu.story.ProgressPhotoStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r3, r12)     // Catch:{ JSONException -> 0x0337 }
            boolean r11 = r13.didSeeProgressPhotoTooltip     // Catch:{ JSONException -> 0x0337 }
            if (r11 != 0) goto L_0x01a4
            if (r8 != 0) goto L_0x01a4
            boolean r11 = r10.hasNext()     // Catch:{ JSONException -> 0x0337 }
            if (r11 == 0) goto L_0x01a4
            r10.setShowProgressPhotoTooltip(r6)     // Catch:{ JSONException -> 0x0337 }
            r8 = 1
            goto L_0x0204
        L_0x01a4:
            r10.setShowProgressPhotoTooltip(r7)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x01a8:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.ASSESSMENT     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x01ba
            com.trainerfu.story.AssessmentStoryViewModel r10 = new com.trainerfu.story.AssessmentStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x01ba:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.LINK     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x01cc
            com.trainerfu.story.LinkStoryViewModel r10 = new com.trainerfu.story.LinkStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x01cc:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.POST     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x01de
            com.trainerfu.story.PostStoryViewModel r10 = new com.trainerfu.story.PostStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x01de:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.MEAL_LOG     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x01f3
            com.trainerfu.story.MealStoryViewModel r10 = new com.trainerfu.story.MealStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
            r10.setShowMealDetailsListener(r13)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0204
        L_0x01f3:
            com.trainerfu.story.StoryType r12 = com.trainerfu.story.StoryType.CHECKIN     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x0204
            com.trainerfu.story.CheckinStoryViewModel r10 = new com.trainerfu.story.CheckinStoryViewModel     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r11 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.os.Bundle r12 = r13.getArguments()     // Catch:{ JSONException -> 0x0337 }
            r10.<init>(r11, r9, r12)     // Catch:{ JSONException -> 0x0337 }
        L_0x0204:
            if (r10 == 0) goto L_0x0267
            boolean r11 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            if (r11 != 0) goto L_0x0217
            if (r1 != 0) goto L_0x0217
            int r11 = r9.getInt(r5)     // Catch:{ JSONException -> 0x0337 }
            int r12 = r13.myUserId     // Catch:{ JSONException -> 0x0337 }
            if (r11 != r12) goto L_0x0215
            goto L_0x0217
        L_0x0215:
            r11 = 0
            goto L_0x0218
        L_0x0217:
            r11 = 1
        L_0x0218:
            r10.setCommentsEnabled(r11)     // Catch:{ JSONException -> 0x0337 }
            boolean r11 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            if (r11 != 0) goto L_0x0232
            int r11 = r13.myUserId     // Catch:{ JSONException -> 0x0337 }
            int r12 = r9.getInt(r5)     // Catch:{ JSONException -> 0x0337 }
            if (r11 == r12) goto L_0x0232
            java.lang.String r11 = "primary_trainer"
            boolean r11 = r9.isNull(r11)     // Catch:{ JSONException -> 0x0337 }
            if (r11 == 0) goto L_0x0230
            goto L_0x0232
        L_0x0230:
            r11 = 0
            goto L_0x0233
        L_0x0232:
            r11 = 1
        L_0x0233:
            r10.setSharingEnabled(r11)     // Catch:{ JSONException -> 0x0337 }
            boolean r11 = r13.amITrainer     // Catch:{ JSONException -> 0x0337 }
            if (r11 != 0) goto L_0x0240
            int r11 = r13.myUserId     // Catch:{ JSONException -> 0x0337 }
            int r9 = r9.getInt(r5)     // Catch:{ JSONException -> 0x0337 }
        L_0x0240:
            r10.setHasMoreOptions(r6)     // Catch:{ JSONException -> 0x0337 }
            boolean r9 = r13.isNewsModerated     // Catch:{ JSONException -> 0x0337 }
            r10.setIsNewsModerated(r9)     // Catch:{ JSONException -> 0x0337 }
            int r9 = r13.myUserId     // Catch:{ JSONException -> 0x0337 }
            r10.setMyUserId(r9)     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r9 = r13.myFirstName     // Catch:{ JSONException -> 0x0337 }
            r10.setMyFirstName(r9)     // Catch:{ JSONException -> 0x0337 }
            r10.setToolbarEventListener(r13)     // Catch:{ JSONException -> 0x0337 }
            r10.setLikeCountEventListener(r13)     // Catch:{ JSONException -> 0x0337 }
            r10.setStoryTitleViewEventListener(r13)     // Catch:{ JSONException -> 0x0337 }
            r10.setShowMoreCommentsListener(r13)     // Catch:{ JSONException -> 0x0337 }
            r10.setLikeDetailBinderListener(r13)     // Catch:{ JSONException -> 0x0337 }
            java.util.List<com.trainerfu.story.SectionBaseViewModel> r9 = r13.viewModels     // Catch:{ JSONException -> 0x0337 }
            r9.add(r10)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x026d
        L_0x0267:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException     // Catch:{ JSONException -> 0x0337 }
            r14.<init>()     // Catch:{ JSONException -> 0x0337 }
            throw r14     // Catch:{ JSONException -> 0x0337 }
        L_0x026d:
            int r0 = r0 + 1
            goto L_0x0139
        L_0x0271:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0337 }
            r0.<init>()     // Catch:{ JSONException -> 0x0337 }
            r13.partDefinitions = r0     // Catch:{ JSONException -> 0x0337 }
            r0 = 0
        L_0x0279:
            java.util.List<com.trainerfu.story.SectionBaseViewModel> r1 = r13.viewModels     // Catch:{ JSONException -> 0x0337 }
            int r1 = r1.size()     // Catch:{ JSONException -> 0x0337 }
            if (r0 >= r1) goto L_0x0295
            java.util.List<java.util.List<com.trainerfu.story.SectionPartDefinition>> r1 = r13.partDefinitions     // Catch:{ JSONException -> 0x0337 }
            java.util.List<com.trainerfu.story.SectionBaseViewModel> r2 = r13.viewModels     // Catch:{ JSONException -> 0x0337 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.SectionBaseViewModel r2 = (com.trainerfu.story.SectionBaseViewModel) r2     // Catch:{ JSONException -> 0x0337 }
            java.util.List r2 = r2.getParts()     // Catch:{ JSONException -> 0x0337 }
            r1.add(r2)     // Catch:{ JSONException -> 0x0337 }
            int r0 = r0 + 1
            goto L_0x0279
        L_0x0295:
            android.view.View r0 = r13.getView()     // Catch:{ JSONException -> 0x0337 }
            r1 = 2131362133(0x7f0a0155, float:1.8344038E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ JSONException -> 0x0337 }
            android.widget.EditText r0 = (android.widget.EditText) r0     // Catch:{ JSONException -> 0x0337 }
            android.view.View r1 = r13.getView()     // Catch:{ JSONException -> 0x0337 }
            r2 = 2131362325(0x7f0a0215, float:1.8344427E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ JSONException -> 0x0337 }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ JSONException -> 0x0337 }
            android.view.View r2 = r13.getView()     // Catch:{ JSONException -> 0x0337 }
            r3 = 2131361897(0x7f0a0069, float:1.834356E38)
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ JSONException -> 0x0337 }
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2     // Catch:{ JSONException -> 0x0337 }
            android.view.View r3 = r13.getView()     // Catch:{ JSONException -> 0x0337 }
            r4 = 2131362352(0x7f0a0230, float:1.8344482E38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ JSONException -> 0x0337 }
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListFragment$ListAdapter r4 = r13.listAdapter     // Catch:{ JSONException -> 0x0337 }
            r4.notifyDataSetChanged()     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r4 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            android.content.Intent r4 = r4.getIntent()     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r5 = "focusCommentView"
            boolean r4 = r4.getBooleanExtra(r5, r7)     // Catch:{ JSONException -> 0x0337 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r5 = r13.storyListViewType     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListViewType r8 = com.trainerfu.story.StoryListViewType.SINGLE_STORY_VIEW     // Catch:{ JSONException -> 0x0337 }
            if (r5 != r8) goto L_0x0336
            int r14 = r14.length()     // Catch:{ JSONException -> 0x0337 }
            r5 = 8
            if (r14 != 0) goto L_0x02fa
            r2.setVisibility(r5)     // Catch:{ JSONException -> 0x0337 }
            r3.setVisibility(r7)     // Catch:{ JSONException -> 0x0337 }
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r14 = r13.swipeRefreshView     // Catch:{ JSONException -> 0x0337 }
            r14.setVisibility(r5)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0336
        L_0x02fa:
            r2.setVisibility(r7)     // Catch:{ JSONException -> 0x0337 }
            r3.setVisibility(r5)     // Catch:{ JSONException -> 0x0337 }
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r14 = r13.swipeRefreshView     // Catch:{ JSONException -> 0x0337 }
            r14.setVisibility(r7)     // Catch:{ JSONException -> 0x0337 }
            boolean r14 = r4.booleanValue()     // Catch:{ JSONException -> 0x0337 }
            if (r14 != 0) goto L_0x0324
            r1.requestFocus()     // Catch:{ JSONException -> 0x0337 }
            r0.clearFocus()     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.utils.Util.hideKeyboard(r14)     // Catch:{ JSONException -> 0x0337 }
            android.widget.ListView r14 = r13.listView     // Catch:{ JSONException -> 0x0337 }
            com.trainerfu.story.StoryListFragment$ListAdapter r0 = r13.listAdapter     // Catch:{ JSONException -> 0x0337 }
            int r0 = r0.getCount()     // Catch:{ JSONException -> 0x0337 }
            r14.smoothScrollToPosition(r0)     // Catch:{ JSONException -> 0x0337 }
            goto L_0x0336
        L_0x0324:
            r0.requestFocus()     // Catch:{ JSONException -> 0x0337 }
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()     // Catch:{ JSONException -> 0x0337 }
            java.lang.String r1 = "input_method"
            java.lang.Object r14 = r14.getSystemService(r1)     // Catch:{ JSONException -> 0x0337 }
            android.view.inputmethod.InputMethodManager r14 = (android.view.inputmethod.InputMethodManager) r14     // Catch:{ JSONException -> 0x0337 }
            r14.showSoftInput(r0, r6)     // Catch:{ JSONException -> 0x0337 }
        L_0x0336:
            return
        L_0x0337:
            r14 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.story.StoryListFragment.createOrRestoreFromState(org.json.JSONObject):void");
    }

    private boolean canUnderstandStory(JSONObject jSONObject) throws JSONException {
        return StoryType.getStoryType(jSONObject.getInt("story_type")) != StoryType.UNKNOWN;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JSONObject jSONObject = this.state;
        if (jSONObject != null) {
            try {
                bundle.putByteArray("state", ZipUtil.compress(jSONObject.toString()));
                bundle.putInt("trainer_id_filter", this.trainerIdFilter);
                bundle.putInt("segment_id_filter", this.segmentIdFilter);
                StoryType storyType = this.storyTypeFilter;
                if (storyType != null) {
                    bundle.putInt("story_type_filter", storyType.getMask());
                }
            } catch (IOException unused) {
            }
        }
    }

    public void onResume() {
        super.onResume();
        triggerSwipeRefresh(false, false);
        if (this.state == null) {
            Bundle arguments = getArguments();
            if (arguments != null && !arguments.containsKey("segmentIdFilter")) {
                refreshData(true);
            }
        } else if (hasNewNews && this.storyListViewType == StoryListViewType.NEWS_VIEW) {
            triggerSwipeRefresh();
        } else if (!hasNewDiaryEntries || this.storyListViewType != StoryListViewType.DIARY_VIEW) {
            long timeInMillis = this.calendar.getTimeInMillis();
            if (this.lastRefreshTimeInMillis == 0) {
                this.lastRefreshTimeInMillis = timeInMillis;
            }
            if (timeInMillis - this.lastRefreshTimeInMillis > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                refreshData(false);
            }
        } else {
            triggerSwipeRefresh();
        }
    }

    public void onRefresh() {
        refreshData(false);
    }

    public void refreshData(boolean z) {
        if (this.storyListViewType == StoryListViewType.NEWS_VIEW) {
            hasNewNews = false;
        }
        if (this.storyListViewType == StoryListViewType.DIARY_VIEW) {
            hasNewDiaryEntries = false;
        }
        this.lastRefreshTimeInMillis = this.calendar.getTimeInMillis();
        BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(z), getActivity());
        HashMap hashMap = new HashMap();
        if (this.storyListViewType == StoryListViewType.DIARY_VIEW || this.storyListViewType == StoryListViewType.CHECKINS_VIEW) {
            hashMap.put("diary_user_id", Integer.valueOf(this.diaryUserId));
            StoryType storyType = this.storyTypeFilter;
            if (storyType != null) {
                hashMap.put("story_type", Integer.valueOf(storyType.getMask()));
            }
        } else if (this.storyListViewType == StoryListViewType.NEWS_VIEW) {
            int i = this.trainerIdFilter;
            if (i != -2) {
                hashMap.put("trained_by", Integer.valueOf(i));
                int i2 = this.segmentIdFilter;
                if (i2 != -1) {
                    hashMap.put("segment_id", Integer.valueOf(i2));
                }
            }
        } else if (this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            hashMap.put("story_id", Integer.valueOf(this.singleStoryId));
        } else if (this.storyListViewType == StoryListViewType.PROGRESS_PHOTOS_VIEW) {
            hashMap.put("diary_user_id", Integer.valueOf(this.diaryUserId));
            hashMap.put("story_type", Integer.valueOf(StoryType.PROGRESS_PHOTO.getMask()));
        }
        hashMap.put("limit", 100);
        baseHttpClient.get("/stories2", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!StoryListFragment.this.isAdded()) {
                    return true;
                }
                StoryListFragment.this.swipeRefreshView.setRefreshing(false);
                JSONObject unused = StoryListFragment.this.state = jSONObject;
                StoryListFragment storyListFragment = StoryListFragment.this;
                storyListFragment.createOrRestoreFromState(storyListFragment.state);
                return true;
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                StoryListFragment.this.swipeRefreshView.setRefreshing(false);
                return super.handleFailure(i, headerArr, th, jSONObject);
            }
        });
    }

    public void setFilter(int i, int i2) {
        this.trainerIdFilter = i;
        this.segmentIdFilter = i2;
        triggerSwipeRefresh();
    }

    public void setStoryTypeFilter(StoryType storyType) {
        this.storyTypeFilter = storyType;
        triggerSwipeRefresh();
    }

    public void triggerSwipeRefresh() {
        this.swipeRefreshView.post(new Runnable() {
            public void run() {
                StoryListFragment.this.refreshData(false);
                StoryListFragment.this.swipeRefreshView.setRefreshing(true);
            }
        });
    }

    public void triggerSwipeRefresh(final boolean z, final boolean z2) {
        this.swipeRefreshView.post(new Runnable() {
            public void run() {
                StoryListFragment.this.refreshData(z2);
                StoryListFragment.this.swipeRefreshView.setRefreshing(z);
            }
        });
    }

    public void onShowWorkoutDetails(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        WorkoutStoryViewModel workoutStoryViewModel = (WorkoutStoryViewModel) this.viewModels.get(findStoryViewModelIndex);
        workoutStoryViewModel.setShowWorkoutDetails(!workoutStoryViewModel.showWorkoutDetails());
        this.partDefinitions.set(findStoryViewModelIndex, workoutStoryViewModel.getParts());
        this.listAdapter.notifyDataSetChanged();
    }

    public void onShowAchievementDetails(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        WorkoutStoryViewModel workoutStoryViewModel = (WorkoutStoryViewModel) this.viewModels.get(findStoryViewModelIndex);
        workoutStoryViewModel.setShowAchievementDetails(!workoutStoryViewModel.showAchievementDetails());
        this.partDefinitions.set(findStoryViewModelIndex, workoutStoryViewModel.getParts());
        this.listAdapter.notifyDataSetChanged();
    }

    public void onShowMealDetails(int i) {
        new StoryUpdater() {
            public void update(StoryBaseViewModel storyBaseViewModel) {
                MealStoryViewModel mealStoryViewModel = (MealStoryViewModel) storyBaseViewModel;
                mealStoryViewModel.setShowMealDetails(!mealStoryViewModel.showMealDetails());
            }
        }.execute(i);
    }

    public void onShowMoreComments(int i, Boolean bool) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        storyBaseViewModel.setExpandComments(true);
        this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
        this.listAdapter.notifyDataSetChanged();
    }

    public void onShowLikes(JSONArray jSONArray) {
        LikesNamesFragment likesNamesFragment = new LikesNamesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("likes", jSONArray.toString());
        likesNamesFragment.setArguments(bundle);
        likesNamesFragment.show(getActivity().getSupportFragmentManager(), "lnf");
    }

    private int findFirstStoryViewModelIndex() {
        for (int i = 0; i < this.viewModels.size(); i++) {
            if (this.viewModels.get(i) instanceof StoryBaseViewModel) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int findStoryViewModelIndex(int i) {
        for (int i2 = 0; i2 < this.viewModels.size(); i2++) {
            SectionBaseViewModel sectionBaseViewModel = this.viewModels.get(i2);
            if ((sectionBaseViewModel instanceof StoryBaseViewModel) && ((StoryBaseViewModel) sectionBaseViewModel).getStoryId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void onLikeStory(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        JSONArray likes = storyBaseViewModel.getLikes();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_id", this.myUserId);
            jSONObject.put("first_name", this.myFirstName);
            likes.put(jSONObject);
            new BaseHttpClient(false, getActivity()).put(String.format("/stories2/%d/likes/new", new Object[]{Integer.valueOf(storyBaseViewModel.getStoryId())}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
            this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
            this.listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void onUnlikeStory(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        JSONArray likes = storyBaseViewModel.getLikes();
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= likes.length()) {
                    i2 = -1;
                    break;
                } else if (likes.getJSONObject(i2).getInt("user_id") == this.myUserId) {
                    break;
                } else {
                    i2++;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (i2 > -1) {
            likes.remove(i2);
            this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
            this.listAdapter.notifyDataSetChanged();
            new BaseHttpClient(false, getActivity()).delete(String.format("/stories2/%d/likes/%d", new Object[]{Integer.valueOf(storyBaseViewModel.getStoryId()), Integer.valueOf(this.myUserId)}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    return true;
                }
            });
        }
    }

    private int getEventRequestCode() {
        if (this.storyListViewType == StoryListViewType.NEWS_VIEW) {
            return 3461;
        }
        return (this.storyListViewType == StoryListViewType.DIARY_VIEW || this.storyListViewType == StoryListViewType.CHECKINS_VIEW) ? 3462 : 3463;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.icon_send) {
            addComment(this.singleStoryId, ((EditText) getView().findViewById(R.id.commentET)).getText().toString());
        }
    }

    public void onAddComment(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("info", String.valueOf(i));
        bundle.putString("text", "");
        bundle.putString(ViewHierarchyConstants.HINT_KEY, getString(R.string.Comment));
        bundle.putInt("request_code", getEventRequestCode());
        EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
        editTextDialogFragment.setArguments(bundle);
        editTextDialogFragment.show(getActivity().getSupportFragmentManager(), "acf");
    }

    @Subscribe
    public void handleTextEditedEvent(TextEditedEvent textEditedEvent) {
        if (textEditedEvent.requestCode == getEventRequestCode()) {
            addComment(Integer.valueOf(textEditedEvent.info).intValue(), textEditedEvent.text);
        }
    }

    private void addComment(int i, String str) {
        if (str.trim().length() > 0) {
            int findStoryViewModelIndex = findStoryViewModelIndex(i);
            StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("user_id", this.myUserId);
                jSONObject.put("first_name", this.myFirstName);
                jSONObject.put("comment", str);
                storyBaseViewModel.setExpandComments(true);
                storyBaseViewModel.getComments().put(jSONObject);
                this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
                this.listAdapter.notifyDataSetChanged();
                if (this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
                    ((EditText) getView().findViewById(R.id.commentET)).setText("");
                    Util.hideKeyboard(getActivity());
                    this.listView.smoothScrollToPosition(this.listAdapter.getCount());
                }
                BaseHttpClient baseHttpClient = new BaseHttpClient(false, getActivity());
                String format = String.format("/stories2/%d/comments/new", new Object[]{Integer.valueOf(i)});
                HashMap hashMap = new HashMap();
                hashMap.put("comment", str);
                baseHttpClient.put(format, hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onLikeCountLabelClicked(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        storyBaseViewModel.setExpandLikes(true);
        this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
        this.listAdapter.notifyDataSetChanged();
    }

    public void onShare(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        if (storyBaseViewModel instanceof LinkStoryViewModel) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            try {
                intent.putExtra("android.intent.extra.SUBJECT", "Sharing Page");
                intent.putExtra("android.intent.extra.TEXT", storyBaseViewModel.getMeta().getString("url"));
                startActivity(Intent.createChooser(intent, "Share URL"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.pendingShareStoryId = i;
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2341);
        } else {
            this.pendingShareStoryId = -1;
            List<Integer> partIndexesForSharing = storyBaseViewModel.partIndexesForSharing();
            int i2 = 0;
            for (int i3 = 0; i3 < findStoryViewModelIndex; i3++) {
                i2 += this.partDefinitions.get(i3).size();
            }
            final ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < partIndexesForSharing.size(); i4++) {
                View view = this.listAdapter.getView(partIndexesForSharing.get(i4).intValue() + i2, (View) null, this.listView);
                view.measure(View.MeasureSpec.makeMeasureSpec(this.listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                arrayList.add(view);
            }
            Integer myPrimaryTrainerId = storyBaseViewModel.getMyPrimaryTrainerId();
            if (myPrimaryTrainerId != null) {
                CreditView creditView = new CreditView(getActivity());
                try {
                    JSONObject jSONObject = this.trainers.getJSONObject(String.valueOf(myPrimaryTrainerId));
                    int i5 = jSONObject.isNull("photo_id") ? 0 : jSONObject.getInt("photo_id");
                    String str = this.contact;
                    if (str == null) {
                        str = String.format(getString(R.string.askXAboutY), new Object[]{storyBaseViewModel.getUserFirstName(), jSONObject.getString("first_name")});
                    }
                    creditView.setCredit(jSONObject.getString("first_name"), jSONObject.getString("last_name"), str, Integer.valueOf(i5));
                    creditView.measure(View.MeasureSpec.makeMeasureSpec(this.listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    creditView.layout(0, 0, creditView.getMeasuredWidth(), creditView.getMeasuredHeight());
                    arrayList.add(creditView);
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (View view : arrayList) {
                        view.setDrawingCacheEnabled(true);
                        view.buildDrawingCache();
                        arrayList.add(view.getDrawingCache());
                        i += view.getMeasuredHeight();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(StoryListFragment.this.listView.getMeasuredWidth(), i, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = new Paint();
                    int i2 = 0;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Bitmap bitmap = (Bitmap) arrayList.get(i3);
                        canvas.drawBitmap(bitmap, 0.0f, (float) i2, paint);
                        i2 += bitmap.getHeight();
                        bitmap.recycle();
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", "title");
                    contentValues.put("mime_type", Utils.MIME_TYPE_JPEG);
                    Uri insert = StoryListFragment.this.getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    try {
                        OutputStream openOutputStream = StoryListFragment.this.getActivity().getContentResolver().openOutputStream(insert);
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
                        openOutputStream.close();
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType(Utils.MIME_TYPE_JPEG);
                        intent.putExtra("android.intent.extra.STREAM", insert);
                        StoryListFragment.this.startActivity(Intent.createChooser(intent, "Share Image"));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }, 100);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2;
        if (i != 2341) {
            ImagePickerUtil.onRequestPermissionsResult(i, strArr, iArr, (Fragment) this);
        } else if (iArr.length > 0 && iArr[0] == 0 && (i2 = this.pendingShareStoryId) != -1) {
            onShare(i2);
        }
    }

    public void onGoPrev(int i) {
        new StoryUpdater() {
            public void update(StoryBaseViewModel storyBaseViewModel) {
                ((ProgressPhotoStoryViewModel) storyBaseViewModel).goPrev();
            }
        }.execute(i);
    }

    public void onGoNext(int i) {
        if (!this.didSeeProgressPhotoTooltip) {
            this.didSeeProgressPhotoTooltip = true;
            LocalDB.userDidSeeProgressPhotoTooltip(getActivity());
        }
        new StoryUpdater() {
            public void update(StoryBaseViewModel storyBaseViewModel) {
                ProgressPhotoStoryViewModel progressPhotoStoryViewModel = (ProgressPhotoStoryViewModel) storyBaseViewModel;
                progressPhotoStoryViewModel.goNext();
                progressPhotoStoryViewModel.setShowProgressPhotoTooltip(false);
            }
        }.execute(i);
    }

    public void onShowMoreOptions(int i, int i2) {
        String str;
        String str2;
        this.openContextMenuForType = STORY_MORE_OPTIONS_CONTEXT_MENU;
        this.refStoryId = i;
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex(i));
        if (storyBaseViewModel.isPublic()) {
            str = getString(R.string.makeThisPostPrivate);
        } else {
            str = getString(R.string.makeThisPostPublic);
        }
        String str3 = "";
        if (this.amITrainer) {
            str2 = storyBaseViewModel.isPinned() ? getString(R.string.unpinFromTop) : getString(R.string.pinToTop);
        } else {
            str2 = str3;
        }
        if (this.amITrainer && this.isNewsModerated) {
            str3 = storyBaseViewModel.showToEveryone() ? getString(R.string.hideFromClientsNewsFeed) : getString(R.string.publishOnClientsNewsFeed);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("story_id", i);
        bundle.putString("postPrivacy", str);
        bundle.putString("postPin", str2);
        bundle.putString("postVisible", str3);
        bundle.putInt("storyId", i);
        bundle.putInt("userId", i2);
        bundle.putInt("myUserId", this.myUserId);
        bundle.putBoolean("amITrainer", this.amITrainer);
        StoryOptionsDialogFragment newInstance = StoryOptionsDialogFragment.newInstance();
        newInstance.setArguments(bundle);
        newInstance.setTargetFragment(this, 1);
        newInstance.show(getActivity().getSupportFragmentManager(), "bottomSheet");
    }

    public void onNameClick(int i, String str) {
        if (!this.amITrainer) {
            return;
        }
        if (this.storyListViewType == StoryListViewType.NEWS_VIEW || this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            Intent intent = new Intent(getActivity(), ClientManagementActivity.class);
            intent.putExtra("client_id", i);
            intent.putExtra("client_first_name", str);
            intent.putExtra("selectedTabIndex", 1);
            startActivity(intent);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        getActivity().closeContextMenu();
        return true;
    }

    public void togglePrivacy(final int i) {
        new StoryUpdater() {
            public void update(StoryBaseViewModel storyBaseViewModel) {
                boolean z = !storyBaseViewModel.isPublic();
                storyBaseViewModel.setIsPublic(z);
                if (!z) {
                    storyBaseViewModel.setIsPinned(false);
                    storyBaseViewModel.setShowToEveryone(false);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("is_public", Boolean.valueOf(z));
                StoryListFragment.this.updateServerStory(i, hashMap);
            }
        }.execute(i);
    }

    public void togglePinned(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        StoryBaseViewModel storyBaseViewModel = (StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex);
        if (storyBaseViewModel.isPinned()) {
            storyBaseViewModel.setIsPinned(false);
            this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
            this.listAdapter.notifyDataSetChanged();
        } else {
            storyBaseViewModel.setIsPinned(true);
            storyBaseViewModel.setIsPublic(true);
            storyBaseViewModel.setShowToEveryone(true);
            this.partDefinitions.set(findStoryViewModelIndex, storyBaseViewModel.getParts());
            int findFirstStoryViewModelIndex = findFirstStoryViewModelIndex();
            if (findFirstStoryViewModelIndex != findStoryViewModelIndex) {
                StoryBaseViewModel storyBaseViewModel2 = (StoryBaseViewModel) this.viewModels.get(findFirstStoryViewModelIndex);
                storyBaseViewModel2.setIsPinned(false);
                this.partDefinitions.set(findFirstStoryViewModelIndex, storyBaseViewModel2.getParts());
            }
            this.viewModels.remove(findStoryViewModelIndex);
            this.partDefinitions.remove(findStoryViewModelIndex);
            this.viewModels.add(findFirstStoryViewModelIndex, storyBaseViewModel);
            this.partDefinitions.add(findFirstStoryViewModelIndex, storyBaseViewModel.getParts());
            this.listView.smoothScrollToPosition(0);
            this.listAdapter.notifyDataSetChanged();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pinned", Boolean.valueOf(storyBaseViewModel.isPinned()));
        updateServerStory(i, hashMap);
    }

    public void reportUser(int i) {
        this.userIdsArr.put(i);
        Util.storeUserIds(getContext(), this.userIdsArr.toString());
        createOrRestoreFromState(this.state);
        HashMap hashMap = new HashMap();
        hashMap.put("subject", "A user is flagged");
        hashMap.put("details", "User with id " + i + " is flagged");
        new BaseHttpClient().put("gack", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public void flagPost(int i) {
        this.storyIdsArr.put(i);
        Util.storeStoryIds(getContext(), this.storyIdsArr.toString());
        createOrRestoreFromState(this.state);
        HashMap hashMap = new HashMap();
        hashMap.put("subject", "A news feed post is flagged");
        hashMap.put("details", "Story with id " + i + " is flagged");
        new BaseHttpClient().put("gack", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public void blockUser(int i) {
        this.userIdsArr.put(i);
        Util.storeUserIds(getContext(), this.userIdsArr.toString());
        createOrRestoreFromState(this.state);
    }

    private void togglePublished(final int i) {
        new StoryUpdater() {
            public void update(StoryBaseViewModel storyBaseViewModel) {
                boolean z = !storyBaseViewModel.showToEveryone();
                storyBaseViewModel.setShowToEveryone(z);
                if (!z) {
                    storyBaseViewModel.setIsPinned(false);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("show_to_everyone", Boolean.valueOf(z));
                StoryListFragment.this.updateServerStory(i, hashMap);
            }
        }.execute(i);
    }

    public void delete(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        this.viewModels.remove(findStoryViewModelIndex);
        this.partDefinitions.remove(findStoryViewModelIndex);
        this.listAdapter.notifyDataSetChanged();
        HashMap hashMap = new HashMap();
        hashMap.put("archive", true);
        updateServerStory(i, hashMap);
    }

    /* access modifiers changed from: private */
    public void updateServerStory(int i, Map<String, Object> map) {
        new BaseHttpClient(false, getActivity()).post(String.format("/stories2/%d", new Object[]{Integer.valueOf(i)}), map, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public Bitmap getBitmapForSharingStory(int i) {
        int findStoryViewModelIndex = findStoryViewModelIndex(i);
        List<Integer> partIndexesForSharing = ((StoryBaseViewModel) this.viewModels.get(findStoryViewModelIndex)).partIndexesForSharing();
        int i2 = 0;
        for (int i3 = 0; i3 < findStoryViewModelIndex; i3++) {
            i2 += this.partDefinitions.get(i3).size();
        }
        List list = this.partDefinitions.get(findStoryViewModelIndex);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        for (int i5 = 0; i5 < partIndexesForSharing.size(); i5++) {
            View view = this.listAdapter.getView(partIndexesForSharing.get(i5).intValue() + i2, (View) null, this.listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            arrayList.add(view.getDrawingCache());
            i4 += view.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.listView.getMeasuredWidth(), i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i7);
            canvas.drawBitmap(bitmap, 0.0f, (float) i6, paint);
            i6 += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap;
    }

    public void onNewPostClicked() {
        Intent intent = new Intent(getActivity(), ComposeActivity.class);
        intent.putExtra("compose_type", ComposeType.POST_STORY.getMask());
        intent.putExtra("is_trainer", this.amITrainer);
        intent.putExtra("first_name", this.myFirstName);
        startActivityForResult(intent, this.COMPOSE_POST_REQUEST_CODE);
    }

    public void onLogWorkoutClicked() {
        Intent intent = new Intent(getActivity(), WorkoutLogActivity.class);
        intent.putExtra("user_id", this.diaryUserId);
        intent.putExtra("is_viewed_by_trainer", this.amITrainer);
        startActivityForResult(intent, this.LOG_WORKOUT_REQUEST_CODE);
    }

    public void onAddANewProgressPhotoClicked() {
        this.openContextMenuForType = PROGRESS_PHOTO_CONTEXT_MENU;
        getActivity().openContextMenu(this.listView);
    }

    public void onAssignHabitClicked() {
        Intent intent = new Intent(getActivity(), RNHostActivity.class);
        intent.putExtra("entryRoute", RNEntryRoute.CONTENT_VIEW.getMask());
        Bundle bundle = new Bundle();
        bundle.putInt("type", ContentType.HABIT.getMask());
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        startActivity(intent);
    }

    private class ListAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return false;
        }

        public ListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (StoryListFragment.this.partDefinitions == null) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < StoryListFragment.this.partDefinitions.size(); i2++) {
                i += ((List) StoryListFragment.this.partDefinitions.get(i2)).size();
            }
            return i;
        }

        public Object getItem(int i) {
            return getPart(i);
        }

        public int getViewTypeCount() {
            return StoryListFragment.supportedPartViewTypes.size();
        }

        public int getItemViewType(int i) {
            Class<? extends SectionPartView> partViewClass = getPart(i).getPartViewClass();
            for (int i2 = 0; i2 < StoryListFragment.supportedPartViewTypes.size(); i2++) {
                if (StoryListFragment.supportedPartViewTypes.get(i2) == partViewClass) {
                    return i2;
                }
            }
            throw new RuntimeException("Unsupported part view class type");
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            SectionPartView sectionPartView;
            SectionPartDefinition part = getPart(i);
            SectionPartBinder partBinder = part.getPartBinder();
            if (view == null) {
                try {
                    sectionPartView = (SectionPartView) part.getPartViewClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.context});
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException(e4);
                }
            } else {
                sectionPartView = (SectionPartView) view;
                partBinder.unbind(sectionPartView);
            }
            partBinder.bind(sectionPartView);
            return sectionPartView;
        }

        private SectionPartDefinition getPart(int i) {
            for (int i2 = 0; i2 < StoryListFragment.this.partDefinitions.size(); i2++) {
                if (((List) StoryListFragment.this.partDefinitions.get(i2)).size() > i) {
                    return (SectionPartDefinition) ((List) StoryListFragment.this.partDefinitions.get(i2)).get(i);
                }
                i -= ((List) StoryListFragment.this.partDefinitions.get(i2)).size();
            }
            throw new RuntimeException("Part definition not found");
        }
    }

    public int onBackPressed() {
        if (this.storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            return this.singleStoryId;
        }
        return 0;
    }
}
