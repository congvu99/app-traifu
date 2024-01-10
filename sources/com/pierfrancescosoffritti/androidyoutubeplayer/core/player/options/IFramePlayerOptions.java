package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "", "playerOptions", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getOrigin", "", "getOrigin$core_release", "toString", "Builder", "Companion", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: IFramePlayerOptions.kt */
public final class IFramePlayerOptions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: default  reason: not valid java name */
    public static final IFramePlayerOptions f32default = new Builder().build();
    private final JSONObject playerOptions;

    private IFramePlayerOptions(JSONObject jSONObject) {
        this.playerOptions = jSONObject;
    }

    public /* synthetic */ IFramePlayerOptions(JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Companion;", "", "()V", "default", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "getDefault", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "core_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IFramePlayerOptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IFramePlayerOptions getDefault() {
            return IFramePlayerOptions.f32default;
        }
    }

    public String toString() {
        String jSONObject = this.playerOptions.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "playerOptions.toString()");
        return jSONObject;
    }

    public final String getOrigin$core_release() {
        String string = this.playerOptions.getString("origin");
        Intrinsics.checkExpressionValueIsNotNull(string, "playerOptions.getString(Builder.ORIGIN)");
        return string;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder;", "", "()V", "builderOptions", "Lorg/json/JSONObject;", "addInt", "", "key", "", "value", "", "addString", "build", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "ccLoadPolicy", "controls", "ivLoadPolicy", "langPref", "languageCode", "origin", "rel", "Companion", "core_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: IFramePlayerOptions.kt */
    public static final class Builder {
        private static final String AUTO_PLAY = "autoplay";
        private static final String CC_LANG_PREF = "cc_lang_pref";
        private static final String CC_LOAD_POLICY = "cc_load_policy";
        private static final String CONTROLS = "controls";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String ENABLE_JS_API = "enablejsapi";
        private static final String FS = "fs";
        private static final String IV_LOAD_POLICY = "iv_load_policy";
        private static final String MODEST_BRANDING = "modestbranding";
        public static final String ORIGIN = "origin";
        private static final String REL = "rel";
        private static final String SHOW_INFO = "showinfo";
        private final JSONObject builderOptions = new JSONObject();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder$Companion;", "", "()V", "AUTO_PLAY", "", "CC_LANG_PREF", "CC_LOAD_POLICY", "CONTROLS", "ENABLE_JS_API", "FS", "IV_LOAD_POLICY", "MODEST_BRANDING", "ORIGIN", "REL", "SHOW_INFO", "core_release"}, k = 1, mv = {1, 1, 15})
        /* compiled from: IFramePlayerOptions.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Builder() {
            addInt(AUTO_PLAY, 0);
            addInt("controls", 0);
            addInt(ENABLE_JS_API, 1);
            addInt(FS, 0);
            addString("origin", "https://www.youtube.com");
            addInt(REL, 0);
            addInt(SHOW_INFO, 0);
            addInt(IV_LOAD_POLICY, 3);
            addInt(MODEST_BRANDING, 1);
            addInt(CC_LOAD_POLICY, 0);
        }

        public final IFramePlayerOptions build() {
            return new IFramePlayerOptions(this.builderOptions, (DefaultConstructorMarker) null);
        }

        public final Builder controls(int i) {
            addInt("controls", i);
            return this;
        }

        public final Builder rel(int i) {
            addInt(REL, i);
            return this;
        }

        public final Builder ivLoadPolicy(int i) {
            addInt(IV_LOAD_POLICY, i);
            return this;
        }

        public final Builder langPref(String str) {
            Intrinsics.checkParameterIsNotNull(str, "languageCode");
            addString(CC_LANG_PREF, str);
            return this;
        }

        public final Builder ccLoadPolicy(int i) {
            addInt(CC_LOAD_POLICY, i);
            return this;
        }

        public final Builder origin(String str) {
            Intrinsics.checkParameterIsNotNull(str, "origin");
            addString("origin", str);
            return this;
        }

        private final void addString(String str, String str2) {
            try {
                this.builderOptions.put(str, str2);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + str2);
            }
        }

        private final void addInt(String str, int i) {
            try {
                this.builderOptions.put(str, i);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + i);
            }
        }
    }
}
