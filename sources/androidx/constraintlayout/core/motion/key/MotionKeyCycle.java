package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class MotionKeyCycle extends MotionKey {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private float mAlpha = Float.NaN;
    private int mCurveFit = 0;
    private String mCustomWaveShape = null;
    private float mElevation = Float.NaN;
    private float mProgress = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTransitionEasing = null;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePeriod = Float.NaN;
    private float mWavePhase = 0.0f;
    private int mWaveShape = -1;

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public MotionKey clone() {
        return null;
    }

    public MotionKeyCycle() {
        this.mType = 4;
        this.mCustom = new HashMap();
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public boolean setValue(int i, int i2) {
        if (i == 401) {
            this.mCurveFit = i2;
            return true;
        } else if (i == 421) {
            this.mWaveShape = i2;
            return true;
        } else if (setValue(i, (float) i2)) {
            return true;
        } else {
            return super.setValue(i, i2);
        }
    }

    public boolean setValue(int i, String str) {
        if (i == 420) {
            this.mTransitionEasing = str;
            return true;
        } else if (i != 422) {
            return super.setValue(i, str);
        } else {
            this.mCustomWaveShape = str;
            return true;
        }
    }

    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.mProgress = f;
            return true;
        } else if (i == 403) {
            this.mAlpha = f;
            return true;
        } else if (i != 416) {
            switch (i) {
                case 304:
                    this.mTranslationX = f;
                    return true;
                case 305:
                    this.mTranslationY = f;
                    return true;
                case 306:
                    this.mTranslationZ = f;
                    return true;
                case 307:
                    this.mElevation = f;
                    return true;
                case 308:
                    this.mRotationX = f;
                    return true;
                case 309:
                    this.mRotationY = f;
                    return true;
                case 310:
                    this.mRotation = f;
                    return true;
                case 311:
                    this.mScaleX = f;
                    return true;
                case 312:
                    this.mScaleY = f;
                    return true;
                default:
                    switch (i) {
                        case 423:
                            this.mWavePeriod = f;
                            return true;
                        case 424:
                            this.mWaveOffset = f;
                            return true;
                        case TypedValues.CycleType.TYPE_WAVE_PHASE /*425*/:
                            this.mWavePhase = f;
                            return true;
                        default:
                            return super.setValue(i, f);
                    }
            }
        } else {
            this.mTransitionPathRotate = f;
            return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float getValue(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x009f;
                case -1249320805: goto L_0x0094;
                case -1249320804: goto L_0x0089;
                case -1225497657: goto L_0x007d;
                case -1225497656: goto L_0x0071;
                case -1225497655: goto L_0x0065;
                case -1019779949: goto L_0x005a;
                case -1001078227: goto L_0x004e;
                case -908189618: goto L_0x0043;
                case -908189617: goto L_0x0038;
                case -4379043: goto L_0x002d;
                case 92909918: goto L_0x0022;
                case 106629499: goto L_0x0015;
                case 803192288: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00aa
        L_0x0009:
            java.lang.String r0 = "pathRotate"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 5
            goto L_0x00ab
        L_0x0015:
            java.lang.String r0 = "phase"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 12
            goto L_0x00ab
        L_0x0022:
            java.lang.String r0 = "alpha"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 0
            goto L_0x00ab
        L_0x002d:
            java.lang.String r0 = "elevation"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 1
            goto L_0x00ab
        L_0x0038:
            java.lang.String r0 = "scaleY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 7
            goto L_0x00ab
        L_0x0043:
            java.lang.String r0 = "scaleX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 6
            goto L_0x00ab
        L_0x004e:
            java.lang.String r0 = "progress"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 13
            goto L_0x00ab
        L_0x005a:
            java.lang.String r0 = "offset"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 11
            goto L_0x00ab
        L_0x0065:
            java.lang.String r0 = "translationZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 10
            goto L_0x00ab
        L_0x0071:
            java.lang.String r0 = "translationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 9
            goto L_0x00ab
        L_0x007d:
            java.lang.String r0 = "translationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 8
            goto L_0x00ab
        L_0x0089:
            java.lang.String r0 = "rotationZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 2
            goto L_0x00ab
        L_0x0094:
            java.lang.String r0 = "rotationY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 4
            goto L_0x00ab
        L_0x009f:
            java.lang.String r0 = "rotationX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00aa
            r2 = 3
            goto L_0x00ab
        L_0x00aa:
            r2 = -1
        L_0x00ab:
            switch(r2) {
                case 0: goto L_0x00d8;
                case 1: goto L_0x00d5;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00cf;
                case 4: goto L_0x00cc;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00c3;
                case 8: goto L_0x00c0;
                case 9: goto L_0x00bd;
                case 10: goto L_0x00ba;
                case 11: goto L_0x00b7;
                case 12: goto L_0x00b4;
                case 13: goto L_0x00b1;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            r2 = 2143289344(0x7fc00000, float:NaN)
            return r2
        L_0x00b1:
            float r2 = r1.mProgress
            return r2
        L_0x00b4:
            float r2 = r1.mWavePhase
            return r2
        L_0x00b7:
            float r2 = r1.mWaveOffset
            return r2
        L_0x00ba:
            float r2 = r1.mTranslationZ
            return r2
        L_0x00bd:
            float r2 = r1.mTranslationY
            return r2
        L_0x00c0:
            float r2 = r1.mTranslationX
            return r2
        L_0x00c3:
            float r2 = r1.mScaleY
            return r2
        L_0x00c6:
            float r2 = r1.mScaleX
            return r2
        L_0x00c9:
            float r2 = r1.mTransitionPathRotate
            return r2
        L_0x00cc:
            float r2 = r1.mRotationY
            return r2
        L_0x00cf:
            float r2 = r1.mRotationX
            return r2
        L_0x00d2:
            float r2 = r1.mRotation
            return r2
        L_0x00d5:
            float r2 = r1.mElevation
            return r2
        L_0x00d8:
            float r2 = r1.mAlpha
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyCycle.getValue(java.lang.String):float");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getId(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = -1
            switch(r0) {
                case -1581616630: goto L_0x00f9;
                case -1310311125: goto L_0x00ee;
                case -1249320806: goto L_0x00e3;
                case -1249320805: goto L_0x00d8;
                case -1249320804: goto L_0x00cc;
                case -1225497657: goto L_0x00c1;
                case -1225497656: goto L_0x00b6;
                case -1225497655: goto L_0x00ab;
                case -1019779949: goto L_0x00a0;
                case -1001078227: goto L_0x0094;
                case -991726143: goto L_0x0087;
                case -987906986: goto L_0x007a;
                case -987906985: goto L_0x006d;
                case -908189618: goto L_0x0060;
                case -908189617: goto L_0x0053;
                case 92909918: goto L_0x0048;
                case 106629499: goto L_0x003b;
                case 579057826: goto L_0x0030;
                case 803192288: goto L_0x0023;
                case 1532805160: goto L_0x0016;
                case 1941332754: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0104
        L_0x000a:
            java.lang.String r0 = "visibility"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 1
            goto L_0x0105
        L_0x0016:
            java.lang.String r0 = "waveShape"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 17
            goto L_0x0105
        L_0x0023:
            java.lang.String r0 = "pathRotate"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 14
            goto L_0x0105
        L_0x0030:
            java.lang.String r0 = "curveFit"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 0
            goto L_0x0105
        L_0x003b:
            java.lang.String r0 = "phase"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 18
            goto L_0x0105
        L_0x0048:
            java.lang.String r0 = "alpha"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 2
            goto L_0x0105
        L_0x0053:
            java.lang.String r0 = "scaleY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 10
            goto L_0x0105
        L_0x0060:
            java.lang.String r0 = "scaleX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 9
            goto L_0x0105
        L_0x006d:
            java.lang.String r0 = "pivotY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 12
            goto L_0x0105
        L_0x007a:
            java.lang.String r0 = "pivotX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 11
            goto L_0x0105
        L_0x0087:
            java.lang.String r0 = "period"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 16
            goto L_0x0105
        L_0x0094:
            java.lang.String r0 = "progress"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 13
            goto L_0x0105
        L_0x00a0:
            java.lang.String r0 = "offset"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 19
            goto L_0x0105
        L_0x00ab:
            java.lang.String r0 = "translationZ"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 5
            goto L_0x0105
        L_0x00b6:
            java.lang.String r0 = "translationY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 4
            goto L_0x0105
        L_0x00c1:
            java.lang.String r0 = "translationX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 3
            goto L_0x0105
        L_0x00cc:
            java.lang.String r0 = "rotationZ"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 8
            goto L_0x0105
        L_0x00d8:
            java.lang.String r0 = "rotationY"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 7
            goto L_0x0105
        L_0x00e3:
            java.lang.String r0 = "rotationX"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 6
            goto L_0x0105
        L_0x00ee:
            java.lang.String r0 = "easing"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 15
            goto L_0x0105
        L_0x00f9:
            java.lang.String r0 = "customWave"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0104
            r3 = 20
            goto L_0x0105
        L_0x0104:
            r3 = -1
        L_0x0105:
            switch(r3) {
                case 0: goto L_0x0145;
                case 1: goto L_0x0142;
                case 2: goto L_0x013f;
                case 3: goto L_0x013c;
                case 4: goto L_0x0139;
                case 5: goto L_0x0136;
                case 6: goto L_0x0133;
                case 7: goto L_0x0130;
                case 8: goto L_0x012d;
                case 9: goto L_0x012a;
                case 10: goto L_0x0127;
                case 11: goto L_0x0124;
                case 12: goto L_0x0121;
                case 13: goto L_0x011e;
                case 14: goto L_0x011b;
                case 15: goto L_0x0118;
                case 16: goto L_0x0115;
                case 17: goto L_0x0112;
                case 18: goto L_0x010f;
                case 19: goto L_0x010c;
                case 20: goto L_0x0109;
                default: goto L_0x0108;
            }
        L_0x0108:
            return r1
        L_0x0109:
            r3 = 422(0x1a6, float:5.91E-43)
            return r3
        L_0x010c:
            r3 = 424(0x1a8, float:5.94E-43)
            return r3
        L_0x010f:
            r3 = 425(0x1a9, float:5.96E-43)
            return r3
        L_0x0112:
            r3 = 421(0x1a5, float:5.9E-43)
            return r3
        L_0x0115:
            r3 = 423(0x1a7, float:5.93E-43)
            return r3
        L_0x0118:
            r3 = 420(0x1a4, float:5.89E-43)
            return r3
        L_0x011b:
            r3 = 416(0x1a0, float:5.83E-43)
            return r3
        L_0x011e:
            r3 = 315(0x13b, float:4.41E-43)
            return r3
        L_0x0121:
            r3 = 314(0x13a, float:4.4E-43)
            return r3
        L_0x0124:
            r3 = 313(0x139, float:4.39E-43)
            return r3
        L_0x0127:
            r3 = 312(0x138, float:4.37E-43)
            return r3
        L_0x012a:
            r3 = 311(0x137, float:4.36E-43)
            return r3
        L_0x012d:
            r3 = 310(0x136, float:4.34E-43)
            return r3
        L_0x0130:
            r3 = 309(0x135, float:4.33E-43)
            return r3
        L_0x0133:
            r3 = 308(0x134, float:4.32E-43)
            return r3
        L_0x0136:
            r3 = 306(0x132, float:4.29E-43)
            return r3
        L_0x0139:
            r3 = 305(0x131, float:4.27E-43)
            return r3
        L_0x013c:
            r3 = 304(0x130, float:4.26E-43)
            return r3
        L_0x013f:
            r3 = 403(0x193, float:5.65E-43)
            return r3
        L_0x0142:
            r3 = 402(0x192, float:5.63E-43)
            return r3
        L_0x0145:
            r3 = 401(0x191, float:5.62E-43)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyCycle.getId(java.lang.String):int");
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        HashMap<String, KeyCycleOscillator> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                CustomVariable customVariable = (CustomVariable) this.mCustom.get(next.substring(7));
                if (!(customVariable == null || customVariable.getType() != 901 || (keyCycleOscillator2 = hashMap2.get(next)) == null)) {
                    keyCycleOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, customVariable.getValueToInterpolate(), customVariable);
                }
            } else {
                float value = getValue(next);
                if (!Float.isNaN(value) && (keyCycleOscillator = hashMap2.get(next)) != null) {
                    keyCycleOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    public void dump() {
        PrintStream printStream = System.out;
        printStream.println("MotionKeyCycle{mWaveShape=" + this.mWaveShape + ", mWavePeriod=" + this.mWavePeriod + ", mWaveOffset=" + this.mWaveOffset + ", mWavePhase=" + this.mWavePhase + ", mRotation=" + this.mRotation + JsonLexerKt.END_OBJ);
    }

    public void printAttributes() {
        HashSet hashSet = new HashSet();
        getAttributeNames(hashSet);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.mWaveShape + ", Period=" + this.mWavePeriod + ", Offset=" + this.mWaveOffset + ", Phase=" + this.mWavePhase + JsonLexerKt.END_OBJ);
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            TypedValues.AttributesType.CC.getId(strArr[i]);
            Utils.log(strArr[i] + CertificateUtil.DELIMITER + getValue(strArr[i]));
        }
    }
}
