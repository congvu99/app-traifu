package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H&¨\u0006%"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/PlayerUiController;", "", "addView", "view", "Landroid/view/View;", "enableLiveVideoUi", "enable", "", "getMenu", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/YouTubePlayerMenu;", "removeView", "setCustomAction1", "icon", "Landroid/graphics/drawable/Drawable;", "clickListener", "Landroid/view/View$OnClickListener;", "setCustomAction2", "setFullScreenButtonClickListener", "customFullScreenButtonClickListener", "setMenuButtonClickListener", "customMenuButtonClickListener", "setVideoTitle", "videoTitle", "", "showBufferingProgress", "show", "showCurrentTime", "showCustomAction1", "showCustomAction2", "showDuration", "showFullscreenButton", "showMenuButton", "showPlayPauseButton", "showSeekBar", "showUi", "showVideoTitle", "showYouTubeButton", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PlayerUiController.kt */
public interface PlayerUiController {
    PlayerUiController addView(View view);

    PlayerUiController enableLiveVideoUi(boolean z);

    YouTubePlayerMenu getMenu();

    PlayerUiController removeView(View view);

    PlayerUiController setCustomAction1(Drawable drawable, View.OnClickListener onClickListener);

    PlayerUiController setCustomAction2(Drawable drawable, View.OnClickListener onClickListener);

    PlayerUiController setFullScreenButtonClickListener(View.OnClickListener onClickListener);

    PlayerUiController setMenuButtonClickListener(View.OnClickListener onClickListener);

    PlayerUiController setVideoTitle(String str);

    PlayerUiController showBufferingProgress(boolean z);

    PlayerUiController showCurrentTime(boolean z);

    PlayerUiController showCustomAction1(boolean z);

    PlayerUiController showCustomAction2(boolean z);

    PlayerUiController showDuration(boolean z);

    PlayerUiController showFullscreenButton(boolean z);

    PlayerUiController showMenuButton(boolean z);

    PlayerUiController showPlayPauseButton(boolean z);

    PlayerUiController showSeekBar(boolean z);

    PlayerUiController showUi(boolean z);

    PlayerUiController showVideoTitle(boolean z);

    PlayerUiController showYouTubeButton(boolean z);
}
