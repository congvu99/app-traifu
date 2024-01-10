package com.trainerfu.android;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.trainerfu.utils.DrillLocation;
import io.intercom.android.sdk.models.Part;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class DrillViewHelper {
    private static Drawable editDrawable;
    private static Drawable tipDrawable;
    private TextView exerciseTextView;
    /* access modifiers changed from: private */
    public Context fragContext;
    /* access modifiers changed from: private */
    public TextView groupDrillNoteView;
    private TextView groupDrillSetsView;
    private View leftBorderView;

    private static String getMeasureMetric(int i) {
        if (i == 2) {
            return "Rep";
        }
        if (i == 4) {
            return "Weight";
        }
        if (i == 8) {
            return "Sets";
        }
        if (i == 16) {
            return "Duration";
        }
        if (i != 32) {
            return null;
        }
        return "Distance";
    }

    static {
        Drawable drawable = MyApplication.getAppContext().getResources().getDrawable(R.drawable.ic_mode_edit_black_24dp);
        editDrawable = drawable;
        drawable.setColorFilter(MyApplication.getAppContext().getResources().getColor(R.color.grayColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable2 = MyApplication.getAppContext().getResources().getDrawable(R.drawable.tip);
        tipDrawable = drawable2;
        drawable2.setColorFilter(MyApplication.getAppContext().getResources().getColor(R.color.darkGreen), PorterDuff.Mode.SRC_IN);
    }

    public String getText(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("program_drill_type", 1);
            if (optInt == 1) {
                this.groupDrillSetsView.setVisibility(8);
                this.groupDrillNoteView.setVisibility(8);
                return jSONObject.getString("exercise_name");
            }
            String str2 = "";
            if (optInt != 2 && optInt != 4) {
                return str2;
            }
            if (optInt == 2) {
                str2 = "SUPERSET";
                str = "Sets: ";
            } else if (optInt == 4) {
                str2 = "CIRCUIT";
                str = "Rounds: ";
            } else {
                str = str2;
            }
            this.exerciseTextView.setTextColor(this.fragContext.getResources().getColor(R.color.black25PercentColor));
            String sets = getSets(jSONObject);
            final String string = jSONObject.getString(Part.NOTE_MESSAGE_STYLE);
            if (!jSONObject.isNull(Part.NOTE_MESSAGE_STYLE)) {
                if (!string.isEmpty()) {
                    this.groupDrillNoteView.setVisibility(0);
                    this.groupDrillNoteView.setText("Note: " + string);
                    if (this.groupDrillNoteView.length() > 140) {
                        final SpannableString spannableString = new SpannableString((this.groupDrillNoteView.getText().subSequence(0, 140) + "...") + " More");
                        spannableString.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                DrillViewHelper.this.groupDrillNoteView.setMaxLines(1000);
                                SpannableString spannableString = new SpannableString(string + " Less");
                                spannableString.setSpan(new ClickableSpan() {
                                    public void onClick(View view) {
                                        DrillViewHelper.this.groupDrillNoteView.setText(spannableString);
                                        DrillViewHelper.this.groupDrillNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                                    }
                                }, string.length() + 1, spannableString.length(), 33);
                                spannableString.setSpan(new ForegroundColorSpan(DrillViewHelper.this.fragContext.getResources().getColor(R.color.tintColor)), string.length() + 1, spannableString.length(), 33);
                                DrillViewHelper.this.groupDrillNoteView.setText(spannableString);
                                DrillViewHelper.this.groupDrillNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                            }
                        }, 144, 148, 33);
                        spannableString.setSpan(new ForegroundColorSpan(this.fragContext.getResources().getColor(R.color.tintColor)), 144, 148, 33);
                        this.groupDrillNoteView.setText(spannableString);
                        this.groupDrillNoteView.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
            }
            if (sets != null && !sets.isEmpty() && !sets.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.groupDrillSetsView.setVisibility(0);
                this.groupDrillSetsView.setText(str + sets);
            }
            return str2;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDetailText(JSONObject jSONObject, JSONObject jSONObject2, Context context) {
        return getDetailText(jSONObject, jSONObject2, context, true, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db A[Catch:{ JSONException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e2 A[Catch:{ JSONException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0148 A[Catch:{ JSONException -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDetailText(org.json.JSONObject r17, org.json.JSONObject r18, android.content.Context r19, boolean r20, boolean r21) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "no_note_instructions"
            java.lang.String r3 = "program_drill_type"
            r4 = 1
            int r3 = r0.optInt(r3, r4)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r5 = "Note: "
            java.lang.String r6 = "0"
            java.lang.String r7 = "measures"
            java.lang.String r8 = ""
            java.lang.String r9 = "note"
            if (r3 != r4) goto L_0x015c
            if (r1 != 0) goto L_0x0022
            java.lang.Object r3 = r0.get(r7)     // Catch:{ JSONException -> 0x01df }
        L_0x001f:
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x01df }
            goto L_0x0027
        L_0x0022:
            java.lang.Object r3 = r1.get(r7)     // Catch:{ JSONException -> 0x01df }
            goto L_0x001f
        L_0x0027:
            java.util.Iterator r4 = r3.keys()     // Catch:{ JSONException -> 0x01df }
            android.text.SpannableStringBuilder r7 = new android.text.SpannableStringBuilder     // Catch:{ JSONException -> 0x01df }
            r7.<init>()     // Catch:{ JSONException -> 0x01df }
            r11 = 0
        L_0x0031:
            boolean r12 = r4.hasNext()     // Catch:{ JSONException -> 0x01df }
            java.lang.String r13 = " • "
            if (r12 == 0) goto L_0x0097
            java.lang.Object r12 = r4.next()     // Catch:{ JSONException -> 0x01df }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x01df }
            java.lang.String r14 = r3.getString(r12)     // Catch:{ JSONException -> 0x01df }
            boolean r15 = r14.equals(r6)     // Catch:{ JSONException -> 0x01df }
            if (r15 != 0) goto L_0x0091
            java.lang.String r15 = "0.0"
            boolean r15 = r14.equals(r15)     // Catch:{ JSONException -> 0x01df }
            if (r15 != 0) goto L_0x0091
            if (r11 <= 0) goto L_0x0056
            r7.append(r13)     // Catch:{ JSONException -> 0x01df }
        L_0x0056:
            android.text.SpannableString r13 = new android.text.SpannableString     // Catch:{ JSONException -> 0x01df }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x01df }
            int r12 = r12.intValue()     // Catch:{ JSONException -> 0x01df }
            java.lang.String r12 = getMeasureMetric(r12)     // Catch:{ JSONException -> 0x01df }
            r13.<init>(r12)     // Catch:{ JSONException -> 0x01df }
            android.text.style.ForegroundColorSpan r12 = new android.text.style.ForegroundColorSpan     // Catch:{ JSONException -> 0x01df }
            android.content.res.Resources r15 = r19.getResources()     // Catch:{ JSONException -> 0x01df }
            r10 = 2131100514(0x7f060362, float:1.7813412E38)
            int r10 = r15.getColor(r10)     // Catch:{ JSONException -> 0x01df }
            r12.<init>(r10)     // Catch:{ JSONException -> 0x01df }
            int r10 = r13.length()     // Catch:{ JSONException -> 0x01df }
            r15 = 33
            r16 = r3
            r3 = 0
            r13.setSpan(r12, r3, r10, r15)     // Catch:{ JSONException -> 0x01df }
            r7.append(r13)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r10 = ": "
            r7.append(r10)     // Catch:{ JSONException -> 0x01df }
            r7.append(r14)     // Catch:{ JSONException -> 0x01df }
            int r11 = r11 + 1
            goto L_0x0094
        L_0x0091:
            r16 = r3
            r3 = 0
        L_0x0094:
            r3 = r16
            goto L_0x0031
        L_0x0097:
            java.lang.String r3 = "rest_time"
            if (r1 != 0) goto L_0x00a0
            java.lang.String r3 = r0.getString(r3)     // Catch:{ JSONException -> 0x01df }
            goto L_0x00a6
        L_0x00a0:
            java.lang.Object r3 = r1.get(r3)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x01df }
        L_0x00a6:
            boolean r4 = r3.equals(r6)     // Catch:{ JSONException -> 0x01df }
            if (r4 != 0) goto L_0x00bb
            if (r11 <= 0) goto L_0x00b1
            r7.append(r13)     // Catch:{ JSONException -> 0x01df }
        L_0x00b1:
            java.lang.String r4 = "Rest: "
            r7.append(r4)     // Catch:{ JSONException -> 0x01df }
            r7.append(r3)     // Catch:{ JSONException -> 0x01df }
            int r11 = r11 + 1
        L_0x00bb:
            r3 = 0
            if (r1 == 0) goto L_0x00cc
            boolean r4 = r1.has(r9)     // Catch:{ JSONException -> 0x00c9 }
            if (r4 == 0) goto L_0x00cc
            java.lang.String r4 = r1.getString(r9)     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r0 = move-exception
            goto L_0x0154
        L_0x00cc:
            r4 = r3
        L_0x00cd:
            if (r0 == 0) goto L_0x00d9
            boolean r6 = r0.has(r9)     // Catch:{ JSONException -> 0x00c9 }
            if (r6 == 0) goto L_0x00d9
            java.lang.String r3 = r0.getString(r9)     // Catch:{ JSONException -> 0x00c9 }
        L_0x00d9:
            if (r1 != 0) goto L_0x00dc
            r4 = r3
        L_0x00dc:
            boolean r1 = r0.has(r2)     // Catch:{ JSONException -> 0x00c9 }
            if (r1 == 0) goto L_0x00e7
            java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x00e8
        L_0x00e7:
            r0 = r8
        L_0x00e8:
            java.lang.String r1 = "null"
            if (r20 == 0) goto L_0x0112
            if (r4 == 0) goto L_0x0112
            boolean r2 = r4.equals(r1)     // Catch:{ JSONException -> 0x00c9 }
            if (r2 != 0) goto L_0x0112
            java.lang.String r2 = r4.trim()     // Catch:{ JSONException -> 0x00c9 }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x00c9 }
            if (r2 <= 0) goto L_0x0112
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c9 }
            r2.<init>()     // Catch:{ JSONException -> 0x00c9 }
            r2.append(r8)     // Catch:{ JSONException -> 0x00c9 }
            r2.append(r4)     // Catch:{ JSONException -> 0x00c9 }
            java.lang.String r3 = ". "
            r2.append(r3)     // Catch:{ JSONException -> 0x00c9 }
            java.lang.String r8 = r2.toString()     // Catch:{ JSONException -> 0x00c9 }
        L_0x0112:
            if (r21 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x0141
            boolean r1 = r0.equals(r1)     // Catch:{ JSONException -> 0x00c9 }
            if (r1 != 0) goto L_0x0141
            java.lang.String r1 = r0.trim()     // Catch:{ JSONException -> 0x00c9 }
            int r1 = r1.length()     // Catch:{ JSONException -> 0x00c9 }
            if (r1 <= 0) goto L_0x0141
            int r1 = r8.length()     // Catch:{ JSONException -> 0x00c9 }
            if (r1 <= 0) goto L_0x0142
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c9 }
            r1.<init>()     // Catch:{ JSONException -> 0x00c9 }
            r1.append(r8)     // Catch:{ JSONException -> 0x00c9 }
            java.lang.String r2 = "\n\n"
            r1.append(r2)     // Catch:{ JSONException -> 0x00c9 }
            r1.append(r0)     // Catch:{ JSONException -> 0x00c9 }
            java.lang.String r0 = r1.toString()     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x0142
        L_0x0141:
            r0 = r8
        L_0x0142:
            boolean r1 = r0.isEmpty()     // Catch:{ JSONException -> 0x00c9 }
            if (r1 != 0) goto L_0x0157
            if (r11 <= 0) goto L_0x014d
            r7.append(r13)     // Catch:{ JSONException -> 0x00c9 }
        L_0x014d:
            r7.append(r5)     // Catch:{ JSONException -> 0x00c9 }
            r7.append(r0)     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x0157
        L_0x0154:
            r0.printStackTrace()     // Catch:{ JSONException -> 0x01df }
        L_0x0157:
            java.lang.String r0 = r7.toString()     // Catch:{ JSONException -> 0x01df }
            return r0
        L_0x015c:
            java.lang.Object r1 = r0.get(r7)     // Catch:{ JSONException -> 0x01df }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x01df }
            java.lang.String r2 = "8"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r2 = r0.getString(r9)     // Catch:{ JSONException -> 0x01df }
            boolean r0 = r0.isNull(r9)     // Catch:{ JSONException -> 0x01df }
            if (r0 != 0) goto L_0x0178
            boolean r0 = r2.isEmpty()     // Catch:{ JSONException -> 0x01df }
            if (r0 == 0) goto L_0x0179
        L_0x0178:
            r2 = r8
        L_0x0179:
            boolean r0 = r1.equals(r6)     // Catch:{ JSONException -> 0x01df }
            if (r0 != 0) goto L_0x01c3
            r0 = 2
            if (r3 != r0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01df }
            r0.<init>()     // Catch:{ JSONException -> 0x01df }
            java.lang.String r3 = "Sets: "
            r0.append(r3)     // Catch:{ JSONException -> 0x01df }
            r0.append(r1)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x01df }
            goto L_0x01a8
        L_0x0194:
            r0 = 4
            if (r3 != r0) goto L_0x01a8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01df }
            r0.<init>()     // Catch:{ JSONException -> 0x01df }
            java.lang.String r3 = "Rounds: "
            r0.append(r3)     // Catch:{ JSONException -> 0x01df }
            r0.append(r1)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x01df }
        L_0x01a8:
            int r0 = r2.length()     // Catch:{ JSONException -> 0x01df }
            if (r0 <= 0) goto L_0x01d8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01df }
            r0.<init>()     // Catch:{ JSONException -> 0x01df }
            r0.append(r8)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r1 = "\nNote: "
            r0.append(r1)     // Catch:{ JSONException -> 0x01df }
            r0.append(r2)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x01df }
            goto L_0x01d8
        L_0x01c3:
            int r0 = r2.length()     // Catch:{ JSONException -> 0x01df }
            if (r0 <= 0) goto L_0x01d8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01df }
            r0.<init>()     // Catch:{ JSONException -> 0x01df }
            r0.append(r5)     // Catch:{ JSONException -> 0x01df }
            r0.append(r2)     // Catch:{ JSONException -> 0x01df }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x01df }
        L_0x01d8:
            int r0 = r8.length()     // Catch:{ JSONException -> 0x01df }
            if (r0 != 0) goto L_0x01de
        L_0x01de:
            return r8
        L_0x01df:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.DrillViewHelper.getDetailText(org.json.JSONObject, org.json.JSONObject, android.content.Context, boolean, boolean):java.lang.String");
    }

    public String getSets(JSONObject jSONObject) {
        String str;
        JSONException e;
        try {
            str = ((JSONObject) jSONObject.get("measures")).getString("8");
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        return str;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return null;
        } catch (JSONException e3) {
            e = e3;
            str = null;
            e.printStackTrace();
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(android.content.Context r19, com.trainerfu.android.PlanDrillViewType r20, org.json.JSONObject r21, org.json.JSONObject r22, com.trainerfu.utils.DrillLocation r23, boolean r24, boolean r25, com.trainerfu.android.DrillViewEventsListener r26, android.view.View r27, com.trainerfu.android.StartDragListener r28, androidx.recyclerview.widget.RecyclerView.ViewHolder r29) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            r8 = r21
            r9 = r23
            r10 = r26
            r11 = r27
            java.lang.String r12 = "youtube_url"
            java.lang.String r13 = "instructions"
            java.lang.String r2 = "layout_inflater"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.view.LayoutInflater r2 = (android.view.LayoutInflater) r2
            r2 = 2131362162(0x7f0a0172, float:1.8344097E38)
            android.view.View r2 = r11.findViewById(r2)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            r7.fragContext = r0
            r2 = 2131362384(0x7f0a0250, float:1.8344547E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.exerciseTextView = r2
            r2 = 2131362488(0x7f0a02b8, float:1.8344758E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.groupDrillSetsView = r2
            r2 = 2131362487(0x7f0a02b7, float:1.8344756E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.groupDrillNoteView = r2
            r2 = 2131362686(0x7f0a037e, float:1.834516E38)
            android.view.View r2 = r11.findViewById(r2)
            r7.leftBorderView = r2
            r2 = 2131362247(0x7f0a01c7, float:1.834427E38)
            android.view.View r2 = r11.findViewById(r2)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r2 = "program_drill_type"
            r6 = 1
            int r2 = r8.optInt(r2, r6)
            com.trainerfu.android.ProgramDrillType r5 = com.trainerfu.android.ProgramDrillType.get(r2)
            com.trainerfu.android.ProgramDrillType r2 = com.trainerfu.android.ProgramDrillType.EXERCISE
            r4 = 0
            if (r5 != r2) goto L_0x01df
            r2 = 2131363390(0x7f0a063e, float:1.8346587E38)
            android.view.View r2 = r11.findViewById(r2)
            r2.setVisibility(r4)
            r2 = 2131363315(0x7f0a05f3, float:1.8346435E38)
            android.view.View r2 = r11.findViewById(r2)
            r2.setVisibility(r4)
            com.trainerfu.android.PlanDrillViewType r2 = com.trainerfu.android.PlanDrillViewType.FOR_TRACKING
            r3 = 2131100514(0x7f060362, float:1.7813412E38)
            if (r1 != r2) goto L_0x00e5
            r1 = 2131362316(0x7f0a020c, float:1.834441E38)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            r1.setVisibility(r4)
            com.trainerfu.android.DrillViewHelper$2 r2 = new com.trainerfu.android.DrillViewHelper$2
            r2.<init>(r10, r8)
            r1.setOnCheckedChangeListener(r2)
            if (r24 == 0) goto L_0x00ae
            r1.setChecked(r6)
            android.content.res.Resources r2 = r19.getResources()
            int r2 = r2.getColor(r3)
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r1.setButtonTintList(r2)
            goto L_0x00b1
        L_0x00ae:
            r1.setChecked(r4)
        L_0x00b1:
            r1 = 2131363381(0x7f0a0635, float:1.834657E38)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r1.setVisibility(r4)
            android.graphics.drawable.Drawable r2 = editDrawable
            r1.setImageDrawable(r2)
            com.trainerfu.android.DrillViewHelper$3 r2 = new com.trainerfu.android.DrillViewHelper$3
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            if (r25 == 0) goto L_0x013a
            r1 = 2131363296(0x7f0a05e0, float:1.8346397E38)
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.graphics.drawable.Drawable r2 = tipDrawable
            r1.setImageDrawable(r2)
            r1 = 2131363297(0x7f0a05e1, float:1.8346399E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r4)
            goto L_0x013a
        L_0x00e5:
            com.trainerfu.android.PlanDrillViewType r2 = com.trainerfu.android.PlanDrillViewType.FOR_EDITING
            if (r1 != r2) goto L_0x00fe
            r1 = 2131362332(0x7f0a021c, float:1.8344442E38)
            android.view.View r1 = r11.findViewById(r1)
            com.joanzapata.iconify.widget.IconTextView r1 = (com.joanzapata.iconify.widget.IconTextView) r1
            r1.setVisibility(r4)
            com.trainerfu.android.DrillViewHelper$4 r2 = new com.trainerfu.android.DrillViewHelper$4
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            goto L_0x013a
        L_0x00fe:
            r1 = 2131362791(0x7f0a03e7, float:1.8345373E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r4)
            com.trainerfu.android.DrillViewHelper$5 r2 = new com.trainerfu.android.DrillViewHelper$5
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            r1 = 2131362790(0x7f0a03e6, float:1.834537E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r4)
            com.trainerfu.android.DrillViewHelper$6 r2 = new com.trainerfu.android.DrillViewHelper$6
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            r1 = 2131362232(0x7f0a01b8, float:1.8344239E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r4)
            com.trainerfu.android.DrillViewHelper$7 r2 = new com.trainerfu.android.DrillViewHelper$7
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            r1 = 2131362308(0x7f0a0204, float:1.8344393E38)
            r11.findViewById(r1)
        L_0x013a:
            android.widget.TextView r1 = r7.exerciseTextView
            java.lang.String r2 = r7.getText(r8)
            r1.setText(r2)
            r1 = r22
            java.lang.String r16 = getDetailText(r8, r1, r0)
            if (r16 == 0) goto L_0x01d6
            boolean r1 = r16.isEmpty()
            if (r1 != 0) goto L_0x01d6
            android.text.Spanned r1 = android.text.Html.fromHtml(r16)
            r15.setText(r1)
            r15.setVisibility(r4)
            r15.getLineCount()
            int r1 = r15.length()
            r2 = 140(0x8c, float:1.96E-43)
            if (r1 <= r2) goto L_0x01d6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.CharSequence r3 = r15.getText()
            java.lang.CharSequence r2 = r3.subSequence(r4, r2)
            r1.append(r2)
            java.lang.String r2 = "..."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " More"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r3.<init>(r1)
            com.trainerfu.android.DrillViewHelper$8 r2 = new com.trainerfu.android.DrillViewHelper$8
            r1 = r2
            r29 = r12
            r12 = r2
            r2 = r18
            r20 = r3
            r28 = r13
            r13 = 2131100514(0x7f060362, float:1.7813412E38)
            r3 = r15
            r4 = r16
            r17 = r5
            r5 = r20
            r6 = r19
            r1.<init>(r3, r4, r5, r6)
            r1 = 144(0x90, float:2.02E-43)
            r2 = 148(0x94, float:2.07E-43)
            r3 = 33
            r4 = r20
            r4.setSpan(r12, r1, r2, r3)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            android.content.res.Resources r6 = r19.getResources()
            int r6 = r6.getColor(r13)
            r5.<init>(r6)
            r4.setSpan(r5, r1, r2, r3)
            r15.setText(r4)
            android.text.method.MovementMethod r1 = android.text.method.LinkMovementMethod.getInstance()
            r15.setMovementMethod(r1)
            goto L_0x01dc
        L_0x01d6:
            r17 = r5
            r29 = r12
            r28 = r13
        L_0x01dc:
            r3 = r17
            goto L_0x01f0
        L_0x01df:
            r17 = r5
            r29 = r12
            r28 = r13
            com.trainerfu.android.ProgramDrillType r2 = com.trainerfu.android.ProgramDrillType.START_CIRCUIT
            r3 = r17
            if (r3 == r2) goto L_0x01f3
            com.trainerfu.android.ProgramDrillType r2 = com.trainerfu.android.ProgramDrillType.START_SUPERSET
            if (r3 != r2) goto L_0x01f0
            goto L_0x01f3
        L_0x01f0:
            r6 = 0
            goto L_0x027c
        L_0x01f3:
            com.trainerfu.android.PlanDrillViewType r2 = com.trainerfu.android.PlanDrillViewType.FOR_TRACKING
            r4 = 2131362489(0x7f0a02b9, float:1.834476E38)
            r5 = 2131362484(0x7f0a02b4, float:1.834475E38)
            if (r1 == r2) goto L_0x0264
            android.view.View r2 = r11.findViewById(r5)
            r6 = 0
            r2.setVisibility(r6)
            r2 = 2131362490(0x7f0a02ba, float:1.8344762E38)
            android.view.View r2 = r11.findViewById(r2)
            r2.setVisibility(r6)
            android.view.View r2 = r7.leftBorderView
            r2.setVisibility(r6)
            com.trainerfu.android.PlanDrillViewType r2 = com.trainerfu.android.PlanDrillViewType.FOR_EDITING
            if (r1 != r2) goto L_0x0251
            android.view.View r1 = r11.findViewById(r4)
            r1.setVisibility(r6)
            r1 = 2131362333(0x7f0a021d, float:1.8344444E38)
            android.view.View r1 = r11.findViewById(r1)
            com.joanzapata.iconify.widget.IconTextView r1 = (com.joanzapata.iconify.widget.IconTextView) r1
            com.trainerfu.android.ProgramDrillType r2 = com.trainerfu.android.ProgramDrillType.START_CIRCUIT
            if (r3 != r2) goto L_0x0236
            r2 = 2131952034(0x7f1301a2, float:1.95405E38)
            java.lang.String r2 = r0.getString(r2)
            r1.setText(r2)
        L_0x0236:
            com.trainerfu.android.DrillViewHelper$9 r2 = new com.trainerfu.android.DrillViewHelper$9
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            r1 = 2131361893(0x7f0a0065, float:1.8343551E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r6)
            com.trainerfu.android.DrillViewHelper$10 r2 = new com.trainerfu.android.DrillViewHelper$10
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            goto L_0x0273
        L_0x0251:
            r1 = 2131362234(0x7f0a01ba, float:1.8344243E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r6)
            com.trainerfu.android.DrillViewHelper$11 r2 = new com.trainerfu.android.DrillViewHelper$11
            r2.<init>(r10, r8)
            r1.setOnClickListener(r2)
            goto L_0x0273
        L_0x0264:
            r6 = 0
            android.view.View r1 = r11.findViewById(r5)
            r1.setVisibility(r6)
            android.view.View r1 = r11.findViewById(r4)
            r1.setVisibility(r6)
        L_0x0273:
            android.widget.TextView r1 = r7.exerciseTextView
            java.lang.String r2 = r7.getText(r8)
            r1.setText(r2)
        L_0x027c:
            r1 = 2131362297(0x7f0a01f9, float:1.834437E38)
            android.view.View r1 = r11.findViewById(r1)
            r2 = 2131362483(0x7f0a02b3, float:1.8344748E38)
            android.view.View r2 = r11.findViewById(r2)
            com.trainerfu.utils.DrillLocation r4 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_LAST
            if (r9 != r4) goto L_0x0298
            java.lang.String r4 = "#000000"
            int r4 = android.graphics.Color.parseColor(r4)
            r1.setBackgroundColor(r4)
            goto L_0x02ad
        L_0x0298:
            com.trainerfu.utils.DrillLocation r4 = com.trainerfu.utils.DrillLocation.START_MARKER
            if (r9 == r4) goto L_0x02a4
            com.trainerfu.utils.DrillLocation r4 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_FIRST
            if (r9 == r4) goto L_0x02a4
            com.trainerfu.utils.DrillLocation r4 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_NON_EDGE
            if (r9 != r4) goto L_0x02ad
        L_0x02a4:
            java.lang.String r4 = "#F5F5F5"
            int r4 = android.graphics.Color.parseColor(r4)
            r1.setBackgroundColor(r4)
        L_0x02ad:
            com.trainerfu.utils.DrillLocation r4 = com.trainerfu.utils.DrillLocation.END_MARKER
            r5 = 8
            if (r9 != r4) goto L_0x02cc
            android.widget.TextView r4 = r7.exerciseTextView
            r4.setVisibility(r5)
            r4 = 2131363455(0x7f0a067f, float:1.834672E38)
            android.view.View r4 = r11.findViewById(r4)
            int r0 = com.trainerfu.utils.Util.sizeInPx(r0, r6)
            r4.setPadding(r6, r0, r6, r6)
            r4.setVisibility(r5)
            r14.setVisibility(r5)
        L_0x02cc:
            com.trainerfu.utils.DrillLocation r0 = com.trainerfu.utils.DrillLocation.START_MARKER
            if (r9 == r0) goto L_0x02dc
            com.trainerfu.utils.DrillLocation r0 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_FIRST
            if (r9 == r0) goto L_0x02dc
            com.trainerfu.utils.DrillLocation r0 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_NON_EDGE
            if (r9 == r0) goto L_0x02dc
            com.trainerfu.utils.DrillLocation r0 = com.trainerfu.utils.DrillLocation.GROUP_EXERCISE_LAST
            if (r9 != r0) goto L_0x02e7
        L_0x02dc:
            android.view.View r0 = r7.leftBorderView
            r0.setVisibility(r6)
            r2.setVisibility(r6)
            r1.setVisibility(r5)
        L_0x02e7:
            com.trainerfu.android.ProgramDrillType r0 = com.trainerfu.android.ProgramDrillType.EXERCISE
            if (r3 == r0) goto L_0x02ec
            return r11
        L_0x02ec:
            r0 = r28
            r8.getString(r0)     // Catch:{ Exception -> 0x0375 }
            r1 = 2131363464(0x7f0a0688, float:1.8346738E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0375 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0375 }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0375 }
            r2 = 2131362948(0x7f0a0484, float:1.834569E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x0375 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0375 }
            r3 = r29
            java.lang.String r4 = r8.getString(r3)     // Catch:{ Exception -> 0x0375 }
            boolean r3 = r8.isNull(r3)     // Catch:{ Exception -> 0x0375 }
            r5 = 2131231489(0x7f080301, float:1.807906E38)
            if (r3 != 0) goto L_0x034e
            java.lang.String r3 = r4.trim()     // Catch:{ Exception -> 0x0375 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0375 }
            if (r3 <= 0) goto L_0x034e
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x0375 }
            r3 = 1
            r1.setClickable(r3)     // Catch:{ Exception -> 0x0375 }
            java.lang.String r0 = "http://img.youtube.com/vi/%s/2.jpg"
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0375 }
            r9[r6] = r4     // Catch:{ Exception -> 0x0375 }
            java.lang.String r0 = java.lang.String.format(r0, r9)     // Catch:{ Exception -> 0x0375 }
            com.squareup.picasso.Picasso r4 = com.squareup.picasso.Picasso.get()     // Catch:{ Exception -> 0x0375 }
            com.squareup.picasso.RequestCreator r0 = r4.load((java.lang.String) r0)     // Catch:{ Exception -> 0x0375 }
            com.squareup.picasso.RequestCreator r0 = r0.placeholder((int) r5)     // Catch:{ Exception -> 0x0375 }
            r0.into((android.widget.ImageView) r1)     // Catch:{ Exception -> 0x0375 }
            r2.setClickable(r3)     // Catch:{ Exception -> 0x0375 }
            com.trainerfu.android.DrillViewHelper$12 r0 = new com.trainerfu.android.DrillViewHelper$12     // Catch:{ Exception -> 0x0375 }
            r0.<init>(r10, r8)     // Catch:{ Exception -> 0x0375 }
            r2.setOnClickListener(r0)     // Catch:{ Exception -> 0x0375 }
            r1.setOnClickListener(r0)     // Catch:{ Exception -> 0x0375 }
            goto L_0x0366
        L_0x034e:
            r3 = 1
            r1.setImageResource(r5)     // Catch:{ Exception -> 0x0375 }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ Exception -> 0x0375 }
            r1.setScaleType(r4)     // Catch:{ Exception -> 0x0375 }
            boolean r0 = r8.isNull(r0)     // Catch:{ Exception -> 0x0375 }
            if (r0 != 0) goto L_0x0366
            r0 = 2131231103(0x7f08017f, float:1.8078278E38)
            r2.setImageResource(r0)     // Catch:{ Exception -> 0x0375 }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x0375 }
        L_0x0366:
            r2.setClickable(r3)     // Catch:{ Exception -> 0x0375 }
            com.trainerfu.android.DrillViewHelper$13 r0 = new com.trainerfu.android.DrillViewHelper$13     // Catch:{ Exception -> 0x0375 }
            r0.<init>(r8, r10)     // Catch:{ Exception -> 0x0375 }
            r2.setOnClickListener(r0)     // Catch:{ Exception -> 0x0375 }
            r1.setOnClickListener(r0)     // Catch:{ Exception -> 0x0375 }
            return r11
        L_0x0375:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.DrillViewHelper.getView(android.content.Context, com.trainerfu.android.PlanDrillViewType, org.json.JSONObject, org.json.JSONObject, com.trainerfu.utils.DrillLocation, boolean, boolean, com.trainerfu.android.DrillViewEventsListener, android.view.View, com.trainerfu.android.StartDragListener, androidx.recyclerview.widget.RecyclerView$ViewHolder):android.view.View");
    }

    public DrillLocation getDrillLocation(List<JSONObject> list, int i) {
        int size = list.size();
        int optInt = list.get(i).optInt("program_drill_type", 1);
        if (optInt == 2 || optInt == 4) {
            return DrillLocation.START_MARKER;
        }
        if (optInt == 3 || optInt == 5) {
            return DrillLocation.END_MARKER;
        }
        if (i == 0 || i == size - 1) {
            return DrillLocation.NON_GROUP_EXERCISE;
        }
        int i2 = i - 1;
        int i3 = i2;
        while (i3 >= 0) {
            int optInt2 = list.get(i3).optInt("program_drill_type", 1);
            if (optInt2 == 2 || optInt2 == 4) {
                JSONObject jSONObject = list.get(i2);
                int optInt3 = list.get(i + 1).optInt("program_drill_type", 1);
                if (optInt3 == 3 || optInt3 == 5) {
                    return DrillLocation.GROUP_EXERCISE_LAST;
                }
                int optInt4 = jSONObject.optInt("program_drill_type", 1);
                if (optInt4 == 2 || optInt4 == 4) {
                    return DrillLocation.GROUP_EXERCISE_FIRST;
                }
                return DrillLocation.GROUP_EXERCISE_NON_EDGE;
            } else if (optInt2 == 3 || optInt2 == 5) {
                return DrillLocation.NON_GROUP_EXERCISE;
            } else {
                i3--;
            }
        }
        return DrillLocation.NON_GROUP_EXERCISE;
    }
}
