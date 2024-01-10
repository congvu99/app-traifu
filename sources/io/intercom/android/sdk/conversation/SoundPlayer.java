package io.intercom.android.sdk.conversation;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.SoundPool;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;

public class SoundPlayer {
    static final int NOT_FOUND_ID = -1;
    private static final Twig TWIG = LumberMill.getLogger();
    private final Provider<AppConfig> appConfigProvider;
    final int messageReceivedId;
    boolean messageReceivedLoaded;
    /* access modifiers changed from: private */
    public final int operatorReceivedId;
    /* access modifiers changed from: private */
    public boolean operatorReceivedLoaded;
    final int replyFailedId;
    boolean replyFailedLoaded;
    final int replySentId;
    boolean replySentLoaded;
    private final SoundPool soundPool;

    public SoundPlayer(Context context, Provider<AppConfig> provider) {
        this(context, provider, new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(5).build()).build());
    }

    SoundPlayer(Context context, Provider<AppConfig> provider, SoundPool soundPool2) {
        this.appConfigProvider = provider;
        this.soundPool = soundPool2;
        soundPool2.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                if (i2 != 0) {
                    return;
                }
                if (i == SoundPlayer.this.messageReceivedId) {
                    SoundPlayer.this.messageReceivedLoaded = true;
                } else if (i == SoundPlayer.this.replyFailedId) {
                    SoundPlayer.this.replyFailedLoaded = true;
                } else if (i == SoundPlayer.this.replySentId) {
                    SoundPlayer.this.replySentLoaded = true;
                } else if (i == SoundPlayer.this.operatorReceivedId) {
                    boolean unused = SoundPlayer.this.operatorReceivedLoaded = true;
                }
            }
        });
        this.messageReceivedId = loadSound(context, R.raw.intercom_received);
        this.replyFailedId = loadSound(context, R.raw.intercom_failed);
        this.replySentId = loadSound(context, R.raw.intercom_sent);
        this.operatorReceivedId = loadSound(context, R.raw.intercom_operator);
    }

    private int loadSound(Context context, int i) {
        try {
            return this.soundPool.load(context, i, 1);
        } catch (Resources.NotFoundException e) {
            TWIG.e(e, "Could not play sound", new Object[0]);
            return -1;
        }
    }

    public void playReplyFailedSound() {
        playIfLoaded(this.replyFailedLoaded, this.replyFailedId);
    }

    public void playReplySentSound() {
        playIfLoaded(this.replySentLoaded, this.replySentId);
    }

    public void playMessageReceivedSound() {
        playIfLoaded(this.messageReceivedLoaded, this.messageReceivedId);
    }

    public void playOperatorReceivedSound() {
        playIfLoaded(this.operatorReceivedLoaded, this.operatorReceivedId);
    }

    /* access modifiers changed from: package-private */
    public void playIfLoaded(boolean z, int i) {
        if (z && i != -1 && this.appConfigProvider.get().isAudioEnabled()) {
            this.soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }
}
