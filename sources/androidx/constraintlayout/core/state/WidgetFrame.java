package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Set;

public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha = Float.NaN;
    public int bottom = 0;
    public float interpolatedPos = Float.NaN;
    public int left = 0;
    public final HashMap<String, CustomVariable> mCustom = new HashMap<>();
    public String name = null;
    public float pivotX = Float.NaN;
    public float pivotY = Float.NaN;
    public int right = 0;
    public float rotationX = Float.NaN;
    public float rotationY = Float.NaN;
    public float rotationZ = Float.NaN;
    public float scaleX = Float.NaN;
    public float scaleY = Float.NaN;
    public int top = 0;
    public float translationX = Float.NaN;
    public float translationY = Float.NaN;
    public float translationZ = Float.NaN;
    public int visibility = 0;
    public ConstraintWidget widget = null;

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public WidgetFrame() {
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.mCustom.clear();
        if (widgetFrame != null) {
            for (CustomVariable next : widgetFrame.mCustom.values()) {
                this.mCustom.put(next.getName(), next.copy());
            }
        }
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        float f2;
        int i3;
        int i4;
        float f3;
        float f4;
        int i5;
        float f5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        WidgetFrame widgetFrame4 = widgetFrame;
        WidgetFrame widgetFrame5 = widgetFrame2;
        WidgetFrame widgetFrame6 = widgetFrame3;
        Transition transition2 = transition;
        float f6 = 100.0f * f;
        int i12 = (int) f6;
        int i13 = widgetFrame5.left;
        int i14 = widgetFrame5.top;
        int i15 = widgetFrame6.left;
        int i16 = widgetFrame6.top;
        int i17 = widgetFrame6.right - i15;
        int i18 = widgetFrame5.right - i13;
        int i19 = widgetFrame6.bottom - i16;
        int i20 = widgetFrame5.bottom - i14;
        float f7 = widgetFrame5.alpha;
        float f8 = widgetFrame6.alpha;
        float f9 = f6;
        if (widgetFrame5.visibility == 8) {
            i13 = (int) (((float) i13) - (((float) i17) / 2.0f));
            i14 = (int) (((float) i14) - (((float) i19) / 2.0f));
            if (Float.isNaN(f7)) {
                i3 = i19;
                i4 = i17;
                f2 = 0.0f;
            } else {
                f2 = f7;
                i4 = i17;
                i3 = i19;
            }
        } else {
            i4 = i18;
            f2 = f7;
            i3 = i20;
        }
        if (widgetFrame6.visibility == 8) {
            i15 = (int) (((float) i15) - (((float) i4) / 2.0f));
            i16 = (int) (((float) i16) - (((float) i3) / 2.0f));
            i17 = i4;
            i19 = i3;
            if (Float.isNaN(f8)) {
                f8 = 0.0f;
            }
        }
        if (Float.isNaN(f2) && !Float.isNaN(f8)) {
            f2 = 1.0f;
        }
        if (!Float.isNaN(f2) && Float.isNaN(f8)) {
            f8 = 1.0f;
        }
        if (widgetFrame5.visibility == 4) {
            f3 = f8;
            f4 = 0.0f;
        } else {
            f4 = f2;
            f3 = f8;
        }
        float f10 = widgetFrame6.visibility == 4 ? 0.0f : f3;
        if (widgetFrame4.widget == null || !transition.hasPositionKeyframes()) {
            i5 = i13;
            f5 = f;
        } else {
            Transition.KeyPosition findPreviousPosition = transition2.findPreviousPosition(widgetFrame4.widget.stringId, i12);
            i5 = i13;
            Transition.KeyPosition findNextPosition = transition2.findNextPosition(widgetFrame4.widget.stringId, i12);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i5 = (int) (findPreviousPosition.x * ((float) i));
                i7 = i2;
                i14 = (int) (findPreviousPosition.y * ((float) i7));
                i6 = findPreviousPosition.frame;
                i8 = i;
            } else {
                i8 = i;
                i7 = i2;
                i6 = 0;
            }
            if (findNextPosition != null) {
                i15 = (int) (findNextPosition.x * ((float) i8));
                i16 = (int) (findNextPosition.y * ((float) i7));
                i9 = findNextPosition.frame;
            } else {
                i9 = 100;
            }
            f5 = (f9 - ((float) i6)) / ((float) (i9 - i6));
        }
        int i21 = i5;
        widgetFrame4.widget = widgetFrame5.widget;
        int i22 = (int) (((float) i21) + (((float) (i15 - i21)) * f5));
        widgetFrame4.left = i22;
        int i23 = (int) (((float) i14) + (f5 * ((float) (i16 - i14))));
        widgetFrame4.top = i23;
        float f11 = f;
        float f12 = 1.0f - f11;
        widgetFrame4.right = i22 + ((int) ((((float) i4) * f12) + (((float) i17) * f11)));
        widgetFrame4.bottom = i23 + ((int) ((f12 * ((float) i3)) + (((float) i19) * f11)));
        widgetFrame4.pivotX = interpolate(widgetFrame5.pivotX, widgetFrame6.pivotX, 0.5f, f11);
        widgetFrame4.pivotY = interpolate(widgetFrame5.pivotY, widgetFrame6.pivotY, 0.5f, f11);
        widgetFrame4.rotationX = interpolate(widgetFrame5.rotationX, widgetFrame6.rotationX, 0.0f, f11);
        widgetFrame4.rotationY = interpolate(widgetFrame5.rotationY, widgetFrame6.rotationY, 0.0f, f11);
        widgetFrame4.rotationZ = interpolate(widgetFrame5.rotationZ, widgetFrame6.rotationZ, 0.0f, f11);
        widgetFrame4.scaleX = interpolate(widgetFrame5.scaleX, widgetFrame6.scaleX, 1.0f, f11);
        widgetFrame4.scaleY = interpolate(widgetFrame5.scaleY, widgetFrame6.scaleY, 1.0f, f11);
        widgetFrame4.translationX = interpolate(widgetFrame5.translationX, widgetFrame6.translationX, 0.0f, f11);
        widgetFrame4.translationY = interpolate(widgetFrame5.translationY, widgetFrame6.translationY, 0.0f, f11);
        widgetFrame4.translationZ = interpolate(widgetFrame5.translationZ, widgetFrame6.translationZ, 0.0f, f11);
        widgetFrame4.alpha = interpolate(f4, f10, 1.0f, f11);
        Set<String> keySet = widgetFrame6.mCustom.keySet();
        widgetFrame4.mCustom.clear();
        for (String next : keySet) {
            if (widgetFrame5.mCustom.containsKey(next)) {
                CustomVariable customVariable = widgetFrame5.mCustom.get(next);
                CustomVariable customVariable2 = widgetFrame6.mCustom.get(next);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame4.mCustom.put(next, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue((Object) Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f11)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i24 = 0; i24 < numberOfInterpolatedValues; i24++) {
                        fArr[i24] = interpolate(fArr[i24], fArr2[i24], 0.0f, f11);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private static float interpolate(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return f + (f4 * (f2 - f));
    }

    public float centerX() {
        int i = this.left;
        return ((float) i) + (((float) (this.right - i)) / 2.0f);
    }

    public float centerY() {
        int i = this.top;
        return ((float) i) + (((float) (this.bottom - i)) / 2.0f);
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, (int) TypedValues.Custom.TYPE_COLOR, i);
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, (int) TypedValues.Custom.TYPE_FLOAT, f);
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public void setCustomAttribute(String str, int i, float f) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomAttribute(String str, int i, int i2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, i2));
        }
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, z));
        }
    }

    public void setCustomAttribute(String str, int i, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, str2));
        }
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setValue(java.lang.String r4, androidx.constraintlayout.core.parser.CLElement r5) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1881940865: goto L_0x00d2;
                case -1383228885: goto L_0x00c7;
                case -1349088399: goto L_0x00bc;
                case -1249320806: goto L_0x00b1;
                case -1249320805: goto L_0x00a6;
                case -1249320804: goto L_0x009b;
                case -1225497657: goto L_0x0090;
                case -1225497656: goto L_0x0085;
                case -1225497655: goto L_0x007a;
                case -987906986: goto L_0x006f;
                case -987906985: goto L_0x0063;
                case -908189618: goto L_0x0056;
                case -908189617: goto L_0x0049;
                case 115029: goto L_0x003c;
                case 3317767: goto L_0x0030;
                case 92909918: goto L_0x0024;
                case 108511772: goto L_0x0017;
                case 642850769: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00de
        L_0x000b:
            java.lang.String r0 = "interpolatedPos"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 11
            goto L_0x00df
        L_0x0017:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 15
            goto L_0x00df
        L_0x0024:
            java.lang.String r0 = "alpha"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 10
            goto L_0x00df
        L_0x0030:
            java.lang.String r0 = "left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 14
            goto L_0x00df
        L_0x003c:
            java.lang.String r0 = "top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 13
            goto L_0x00df
        L_0x0049:
            java.lang.String r0 = "scaleY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 9
            goto L_0x00df
        L_0x0056:
            java.lang.String r0 = "scaleX"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 8
            goto L_0x00df
        L_0x0063:
            java.lang.String r0 = "pivotY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 1
            goto L_0x00df
        L_0x006f:
            java.lang.String r0 = "pivotX"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 0
            goto L_0x00df
        L_0x007a:
            java.lang.String r0 = "translationZ"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 7
            goto L_0x00df
        L_0x0085:
            java.lang.String r0 = "translationY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 6
            goto L_0x00df
        L_0x0090:
            java.lang.String r0 = "translationX"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 5
            goto L_0x00df
        L_0x009b:
            java.lang.String r0 = "rotationZ"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 4
            goto L_0x00df
        L_0x00a6:
            java.lang.String r0 = "rotationY"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 3
            goto L_0x00df
        L_0x00b1:
            java.lang.String r0 = "rotationX"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 2
            goto L_0x00df
        L_0x00bc:
            java.lang.String r0 = "custom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 17
            goto L_0x00df
        L_0x00c7:
            java.lang.String r0 = "bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 16
            goto L_0x00df
        L_0x00d2:
            java.lang.String r0 = "phone_orientation"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00de
            r4 = 12
            goto L_0x00df
        L_0x00de:
            r4 = -1
        L_0x00df:
            switch(r4) {
                case 0: goto L_0x015a;
                case 1: goto L_0x0153;
                case 2: goto L_0x014c;
                case 3: goto L_0x0145;
                case 4: goto L_0x013e;
                case 5: goto L_0x0137;
                case 6: goto L_0x0130;
                case 7: goto L_0x0129;
                case 8: goto L_0x0122;
                case 9: goto L_0x011b;
                case 10: goto L_0x0114;
                case 11: goto L_0x010d;
                case 12: goto L_0x0106;
                case 13: goto L_0x00ff;
                case 14: goto L_0x00f8;
                case 15: goto L_0x00f0;
                case 16: goto L_0x00e8;
                case 17: goto L_0x00e3;
                default: goto L_0x00e2;
            }
        L_0x00e2:
            return r2
        L_0x00e3:
            r3.parseCustom(r5)
            goto L_0x0160
        L_0x00e8:
            int r4 = r5.getInt()
            r3.bottom = r4
            goto L_0x0160
        L_0x00f0:
            int r4 = r5.getInt()
            r3.right = r4
            goto L_0x0160
        L_0x00f8:
            int r4 = r5.getInt()
            r3.left = r4
            goto L_0x0160
        L_0x00ff:
            int r4 = r5.getInt()
            r3.top = r4
            goto L_0x0160
        L_0x0106:
            float r4 = r5.getFloat()
            phone_orientation = r4
            goto L_0x0160
        L_0x010d:
            float r4 = r5.getFloat()
            r3.interpolatedPos = r4
            goto L_0x0160
        L_0x0114:
            float r4 = r5.getFloat()
            r3.alpha = r4
            goto L_0x0160
        L_0x011b:
            float r4 = r5.getFloat()
            r3.scaleY = r4
            goto L_0x0160
        L_0x0122:
            float r4 = r5.getFloat()
            r3.scaleX = r4
            goto L_0x0160
        L_0x0129:
            float r4 = r5.getFloat()
            r3.translationZ = r4
            goto L_0x0160
        L_0x0130:
            float r4 = r5.getFloat()
            r3.translationY = r4
            goto L_0x0160
        L_0x0137:
            float r4 = r5.getFloat()
            r3.translationX = r4
            goto L_0x0160
        L_0x013e:
            float r4 = r5.getFloat()
            r3.rotationZ = r4
            goto L_0x0160
        L_0x0145:
            float r4 = r5.getFloat()
            r3.rotationY = r4
            goto L_0x0160
        L_0x014c:
            float r4 = r5.getFloat()
            r3.rotationX = r4
            goto L_0x0160
        L_0x0153:
            float r4 = r5.getFloat()
            r3.pivotY = r4
            goto L_0x0160
        L_0x015a:
            float r4 = r5.getFloat()
            r3.pivotX = r4
        L_0x0160:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.WidgetFrame.setValue(java.lang.String, androidx.constraintlayout.core.parser.CLElement):boolean");
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) {
            return "unknown";
        }
        return constraintWidget.stringId;
    }

    /* access modifiers changed from: package-private */
    public void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i = 0; i < size; i++) {
            CLKey cLKey = (CLKey) cLObject.get(i);
            cLKey.content();
            CLElement value = cLKey.getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(cLKey.content(), (int) TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(cLKey.content(), (int) TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(cLKey.content(), (int) TypedValues.Custom.TYPE_STRING, content);
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type serializeAnchor : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, serializeAnchor);
            }
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String next : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(next);
                sb.append(next);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case TypedValues.Custom.TYPE_INT:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT:
                    case TypedValues.Custom.TYPE_DIMENSION:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor != null && anchor.mTarget != null) {
            sb.append("Anchor");
            sb.append(type.name());
            sb.append(": ['");
            String str = anchor.mTarget.getOwner().stringId;
            if (str == null) {
                str = "#PARENT";
            }
            sb.append(str);
            sb.append("', '");
            sb.append(anchor.mTarget.getType().name());
            sb.append("', '");
            sb.append(anchor.mMargin);
            sb.append("'],\n");
        }
    }

    private static void add(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    private static void add(StringBuilder sb, String str, float f) {
        if (!Float.isNaN(f)) {
            sb.append(str);
            sb.append(": ");
            sb.append(f);
            sb.append(",\n");
        }
    }

    /* access modifiers changed from: package-private */
    public void printCustomAttributes() {
        String str;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str = str2 + "/" + (this.widget.hashCode() % 1000) + " ";
        } else {
            str = str2 + "/NULL ";
        }
        HashMap<String, CustomVariable> hashMap = this.mCustom;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                System.out.println(str + this.mCustom.get(str3).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void logv(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str2 = str3 + "/" + (this.widget.hashCode() % 1000);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + " " + str);
    }
}
