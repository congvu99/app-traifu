package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import com.trainerfu.story.ShowAchievementDetailsBinder;
import com.trainerfu.story.ShowWorkoutDetailsBinder;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutStoryViewModel extends StoryBaseViewModel {
    private ShowAchievementDetailsBinder.EventHandler showAchievementDetailsEventHandler;
    private boolean showWorkout = false;
    private ShowWorkoutDetailsBinder.EventHandler showWorkoutDetailsEventHandler;

    public static abstract class HView {
    }

    public WorkoutStoryViewModel(Context context, JSONObject jSONObject, Bundle bundle) {
        super(context, jSONObject, bundle);
    }

    public void setShowWorkoutDetailsEventHandler(ShowWorkoutDetailsBinder.EventHandler eventHandler) {
        this.showWorkoutDetailsEventHandler = eventHandler;
    }

    public void setShowAchievementDetailsEventHandler(ShowAchievementDetailsBinder.EventHandler eventHandler) {
        this.showAchievementDetailsEventHandler = eventHandler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0359 A[Catch:{ JSONException -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x035c A[Catch:{ JSONException -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0385 A[Catch:{ JSONException -> 0x03dc }, LOOP:2: B:110:0x037f->B:112:0x0385, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0395 A[Catch:{ JSONException -> 0x03dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x033a A[Catch:{ JSONException -> 0x03dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.trainerfu.story.SectionPartDefinition> getParts() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "no"
            java.lang.String r2 = "photo"
            java.lang.String r3 = "0"
            java.lang.String r4 = "note"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x03dc }
            r5.<init>()     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r6 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.StoryTitleView> r7 = com.trainerfu.story.StoryTitleView.class
            com.trainerfu.story.StoryTitleViewBinder r8 = new com.trainerfu.story.StoryTitleViewBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r9 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            boolean r10 = r22.isNewsModerated()     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.StoryTitleView$EventListener r11 = r22.getStoryTitleViewEventListener()     // Catch:{ JSONException -> 0x03dc }
            r8.<init>(r9, r1, r10, r11)     // Catch:{ JSONException -> 0x03dc }
            r6.<init>(r7, r8)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r6)     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r6 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            boolean r6 = r6.has(r4)     // Catch:{ JSONException -> 0x03dc }
            r7 = 25
            if (r6 == 0) goto L_0x005e
            org.json.JSONObject r6 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            boolean r6 = r6.isNull(r4)     // Catch:{ JSONException -> 0x03dc }
            if (r6 != 0) goto L_0x005e
            r1.addWhiteSpace(r5, r7)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r6 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.SectionTextView> r8 = com.trainerfu.story.SectionTextView.class
            com.trainerfu.story.SectionTextBinder r9 = new com.trainerfu.story.SectionTextBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r10 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r11 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r11 = r11.getString(r4)     // Catch:{ JSONException -> 0x03dc }
            r9.<init>(r10, r11)     // Catch:{ JSONException -> 0x03dc }
            r6.<init>(r8, r9)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r6)     // Catch:{ JSONException -> 0x03dc }
        L_0x005e:
            org.json.JSONObject r6 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            boolean r6 = r6.isNull(r2)     // Catch:{ JSONException -> 0x03dc }
            if (r6 != 0) goto L_0x0083
            com.trainerfu.story.SectionPartDefinition r6 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.PhotoView> r8 = com.trainerfu.story.PhotoView.class
            com.trainerfu.story.PhotoViewBinder r9 = new com.trainerfu.story.PhotoViewBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r10 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r11 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r2 = r11.getJSONObject(r2)     // Catch:{ JSONException -> 0x03dc }
            r9.<init>(r10, r2)     // Catch:{ JSONException -> 0x03dc }
            r6.<init>(r8, r9)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r6)     // Catch:{ JSONException -> 0x03dc }
        L_0x0083:
            org.json.JSONObject r2 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r6 = "workout"
            org.json.JSONArray r2 = r2.getJSONArray(r6)     // Catch:{ JSONException -> 0x03dc }
            int r6 = r2.length()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r8 = "is_pr_vol"
            java.lang.String r9 = "is_pr_rm"
            r10 = 0
            if (r6 <= 0) goto L_0x0331
            r11 = 5
            r1.addWhiteSpace(r5, r11)     // Catch:{ JSONException -> 0x03dc }
            boolean r11 = r1.showWorkout     // Catch:{ JSONException -> 0x03dc }
            if (r11 == 0) goto L_0x0331
            org.json.JSONObject r11 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = "whd"
            boolean r11 = r11.getBoolean(r12)     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r12 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            boolean r12 = r12.has(r4)     // Catch:{ JSONException -> 0x03dc }
            if (r12 == 0) goto L_0x00d4
            org.json.JSONObject r12 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            boolean r4 = r12.isNull(r4)     // Catch:{ JSONException -> 0x03dc }
            if (r4 != 0) goto L_0x00d4
            r1.addWhiteSpace(r5, r7)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r4 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.DividerView> r12 = com.trainerfu.story.DividerView.class
            com.trainerfu.story.SectionPartBinder r13 = new com.trainerfu.story.SectionPartBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r14 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            r13.<init>(r14)     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r12, r13)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r4)     // Catch:{ JSONException -> 0x03dc }
        L_0x00d4:
            boolean r4 = r22.showWorkoutDetails()     // Catch:{ JSONException -> 0x03dc }
            if (r4 == 0) goto L_0x02ea
            r1.addWhiteSpace(r5, r7)     // Catch:{ JSONException -> 0x03dc }
            r4 = 0
        L_0x00de:
            int r11 = r2.length()     // Catch:{ JSONException -> 0x03dc }
            if (r4 >= r11) goto L_0x02c6
            org.json.JSONObject r11 = r2.getJSONObject(r4)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r12 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.H3View> r13 = com.trainerfu.story.H3View.class
            com.trainerfu.story.HBinder r14 = new com.trainerfu.story.HBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r15 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r7 = "en"
            java.lang.String r7 = r11.getString(r7)     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r7 = r7.toUpperCase()     // Catch:{ JSONException -> 0x03dc }
            r14.<init>(r15, r7)     // Catch:{ JSONException -> 0x03dc }
            r12.<init>(r13, r14)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r12)     // Catch:{ JSONException -> 0x03dc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = ""
            r7.<init>(r12)     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = "s"
            java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x03dc }
            boolean r13 = r12.equals(r3)     // Catch:{ JSONException -> 0x03dc }
            r14 = 1
            if (r13 != 0) goto L_0x0129
            java.lang.String r13 = "Sets : %s"
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x03dc }
            r15[r10] = r12     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = java.lang.String.format(r13, r15)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r12)     // Catch:{ JSONException -> 0x03dc }
            r12 = 1
            r13 = 1
            goto L_0x012b
        L_0x0129:
            r12 = 0
            r13 = 0
        L_0x012b:
            java.lang.String r15 = "r"
            java.lang.String r15 = r11.getString(r15)     // Catch:{ JSONException -> 0x03dc }
            boolean r16 = r15.equals(r3)     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r10 = " • "
            if (r16 != 0) goto L_0x0154
            if (r12 <= 0) goto L_0x013e
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x013e:
            int r12 = r12 + 1
            java.lang.String r13 = "Reps : %s"
            r16 = r12
            java.lang.Object[] r12 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x03dc }
            r17 = 0
            r12[r17] = r15     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = java.lang.String.format(r13, r12)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r12)     // Catch:{ JSONException -> 0x03dc }
            r12 = r16
            r13 = 1
        L_0x0154:
            java.lang.String r15 = "w"
            java.lang.String r15 = r11.getString(r15)     // Catch:{ JSONException -> 0x03dc }
            boolean r16 = r15.equals(r3)     // Catch:{ JSONException -> 0x03dc }
            if (r16 != 0) goto L_0x017b
            if (r12 <= 0) goto L_0x0165
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x0165:
            int r12 = r12 + 1
            java.lang.String r13 = "Weight : %s"
            r16 = r12
            java.lang.Object[] r12 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x03dc }
            r17 = 0
            r12[r17] = r15     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = java.lang.String.format(r13, r12)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r12)     // Catch:{ JSONException -> 0x03dc }
            r12 = r16
            r13 = 1
        L_0x017b:
            java.lang.String r15 = "di"
            java.lang.String r15 = r11.getString(r15)     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r14 = "0.0"
            boolean r14 = r15.equals(r14)     // Catch:{ JSONException -> 0x03dc }
            if (r14 != 0) goto L_0x01a4
            if (r12 <= 0) goto L_0x018e
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x018e:
            int r12 = r12 + 1
            java.lang.String r13 = "Distance : %s"
            r18 = r12
            r14 = 1
            java.lang.Object[] r12 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x03dc }
            r14 = 0
            r12[r14] = r15     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r12 = java.lang.String.format(r13, r12)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r12)     // Catch:{ JSONException -> 0x03dc }
            r12 = r18
            r13 = 1
        L_0x01a4:
            java.lang.String r14 = "du"
            java.lang.String r14 = r11.getString(r14)     // Catch:{ JSONException -> 0x03dc }
            boolean r15 = r14.equals(r3)     // Catch:{ JSONException -> 0x03dc }
            if (r15 != 0) goto L_0x01ca
            if (r12 <= 0) goto L_0x01b5
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x01b5:
            int r12 = r12 + 1
            java.lang.String r13 = "Duration : %s"
            r18 = r3
            r15 = 1
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ JSONException -> 0x03dc }
            r15 = 0
            r3[r15] = r14     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r3 = java.lang.String.format(r13, r3)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r3)     // Catch:{ JSONException -> 0x03dc }
            r13 = 1
            goto L_0x01cc
        L_0x01ca:
            r18 = r3
        L_0x01cc:
            boolean r3 = r11.has(r0)     // Catch:{ JSONException -> 0x03dc }
            if (r3 == 0) goto L_0x01d7
            java.lang.String r3 = r11.getString(r0)     // Catch:{ JSONException -> 0x03dc }
            goto L_0x01d8
        L_0x01d7:
            r3 = 0
        L_0x01d8:
            if (r3 == 0) goto L_0x0204
            java.lang.String r14 = "null"
            boolean r14 = r3.equals(r14)     // Catch:{ JSONException -> 0x03dc }
            if (r14 != 0) goto L_0x0204
            java.lang.String r14 = r3.trim()     // Catch:{ JSONException -> 0x03dc }
            int r14 = r14.length()     // Catch:{ JSONException -> 0x03dc }
            if (r14 <= 0) goto L_0x0204
            if (r12 <= 0) goto L_0x01f1
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x01f1:
            int r12 = r12 + 1
            java.lang.String r13 = "Note : %s"
            r14 = 1
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ JSONException -> 0x03dc }
            r14 = 0
            r15[r14] = r3     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r3 = java.lang.String.format(r13, r15)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r3)     // Catch:{ JSONException -> 0x03dc }
            r14 = 1
            goto L_0x0205
        L_0x0204:
            r14 = r13
        L_0x0205:
            java.lang.String r3 = "rm"
            r15 = r14
            double r13 = r11.getDouble(r3)     // Catch:{ JSONException -> 0x03dc }
            r19 = 0
            int r3 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x0231
            if (r12 <= 0) goto L_0x0217
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x0217:
            int r12 = r12 + 1
            java.lang.String r3 = "1RM : %d"
            r21 = r0
            r15 = 1
            java.lang.Object[] r0 = new java.lang.Object[r15]     // Catch:{ JSONException -> 0x03dc }
            int r13 = (int) r13     // Catch:{ JSONException -> 0x03dc }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x03dc }
            r14 = 0
            r0[r14] = r13     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r0)     // Catch:{ JSONException -> 0x03dc }
            r14 = 1
            goto L_0x0234
        L_0x0231:
            r21 = r0
            r14 = r15
        L_0x0234:
            java.lang.String r0 = "vol"
            r3 = r14
            double r13 = r11.getDouble(r0)     // Catch:{ JSONException -> 0x03dc }
            int r0 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x025b
            if (r12 <= 0) goto L_0x0244
            r7.append(r10)     // Catch:{ JSONException -> 0x03dc }
        L_0x0244:
            java.lang.String r0 = "Volume : %d"
            r3 = 1
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ JSONException -> 0x03dc }
            int r12 = (int) r13     // Catch:{ JSONException -> 0x03dc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ JSONException -> 0x03dc }
            r17 = 0
            r10[r17] = r12     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r0 = java.lang.String.format(r0, r10)     // Catch:{ JSONException -> 0x03dc }
            r7.append(r0)     // Catch:{ JSONException -> 0x03dc }
            r14 = 1
            goto L_0x025e
        L_0x025b:
            r17 = 0
            r14 = r3
        L_0x025e:
            if (r14 == 0) goto L_0x0277
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.RecordView> r3 = com.trainerfu.story.RecordView.class
            com.trainerfu.story.RecordBinder r10 = new com.trainerfu.story.RecordBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r12 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x03dc }
            r10.<init>(r12, r7)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r10)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
        L_0x0277:
            boolean r0 = r11.getBoolean(r9)     // Catch:{ JSONException -> 0x03dc }
            if (r0 != 0) goto L_0x0283
            boolean r0 = r11.getBoolean(r8)     // Catch:{ JSONException -> 0x03dc }
            if (r0 == 0) goto L_0x0296
        L_0x0283:
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.PRView> r3 = com.trainerfu.story.PRView.class
            com.trainerfu.story.PRViewBinder r7 = new com.trainerfu.story.PRViewBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r10 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            r7.<init>(r10, r11)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r7)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
        L_0x0296:
            if (r14 != 0) goto L_0x02b6
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.RecordView> r3 = com.trainerfu.story.RecordView.class
            com.trainerfu.story.RecordBinder r7 = new com.trainerfu.story.RecordBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r10 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r11 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            r12 = 2131952006(0x7f130186, float:1.9540443E38)
            java.lang.String r11 = r11.getString(r12)     // Catch:{ JSONException -> 0x03dc }
            r7.<init>(r10, r11)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r7)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
        L_0x02b6:
            r0 = 20
            r1.addWhiteSpace(r5, r0)     // Catch:{ JSONException -> 0x03dc }
            int r4 = r4 + 1
            r3 = r18
            r0 = r21
            r7 = 25
            r10 = 0
            goto L_0x00de
        L_0x02c6:
            r17 = 0
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.ClickableLabel> r3 = com.trainerfu.story.ClickableLabel.class
            com.trainerfu.story.ShowWorkoutDetailsBinder r4 = new com.trainerfu.story.ShowWorkoutDetailsBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r7 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r10 = r22.getState()     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.ShowWorkoutDetailsBinder$EventHandler r11 = r1.showWorkoutDetailsEventHandler     // Catch:{ JSONException -> 0x03dc }
            boolean r12 = r22.showWorkoutDetails()     // Catch:{ JSONException -> 0x03dc }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r7, r10, r11, r12)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
            goto L_0x0333
        L_0x02ea:
            r0 = 25
            r17 = 0
            r1.addWhiteSpace(r5, r0)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.SectionTextView> r3 = com.trainerfu.story.SectionTextView.class
            com.trainerfu.story.WorkoutSummaryBinder r4 = new com.trainerfu.story.WorkoutSummaryBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r7 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r10 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r7, r10)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
            if (r11 == 0) goto L_0x0333
            r0 = 10
            r1.addWhiteSpace(r5, r0)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r0 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.ClickableLabel> r3 = com.trainerfu.story.ClickableLabel.class
            com.trainerfu.story.ShowWorkoutDetailsBinder r4 = new com.trainerfu.story.ShowWorkoutDetailsBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r7 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r10 = r22.getState()     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.ShowWorkoutDetailsBinder$EventHandler r11 = r1.showWorkoutDetailsEventHandler     // Catch:{ JSONException -> 0x03dc }
            boolean r12 = r22.showWorkoutDetails()     // Catch:{ JSONException -> 0x03dc }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r7, r10, r11, r12)     // Catch:{ JSONException -> 0x03dc }
            r0.<init>(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r0)     // Catch:{ JSONException -> 0x03dc }
            goto L_0x0333
        L_0x0331:
            r17 = 0
        L_0x0333:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x03dc }
            r0.<init>()     // Catch:{ JSONException -> 0x03dc }
            if (r6 <= 0) goto L_0x0359
            r3 = 0
            r4 = 0
        L_0x033c:
            int r6 = r2.length()     // Catch:{ JSONException -> 0x03dc }
            if (r3 >= r6) goto L_0x035a
            org.json.JSONObject r6 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x03dc }
            boolean r7 = r6.getBoolean(r9)     // Catch:{ JSONException -> 0x03dc }
            if (r7 == 0) goto L_0x034e
            int r4 = r4 + 1
        L_0x034e:
            boolean r6 = r6.getBoolean(r8)     // Catch:{ JSONException -> 0x03dc }
            if (r6 == 0) goto L_0x0356
            int r4 = r4 + 1
        L_0x0356:
            int r3 = r3 + 1
            goto L_0x033c
        L_0x0359:
            r4 = 0
        L_0x035a:
            if (r4 <= 0) goto L_0x0374
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x03dc }
            r2.<init>()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r3 = "type"
            com.trainerfu.story.AchievementType r6 = com.trainerfu.story.AchievementType.PR     // Catch:{ JSONException -> 0x03dc }
            int r6 = r6.getMask()     // Catch:{ JSONException -> 0x03dc }
            r2.put(r3, r6)     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r3 = "count"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r0.add(r2)     // Catch:{ JSONException -> 0x03dc }
        L_0x0374:
            org.json.JSONObject r2 = r22.getMeta()     // Catch:{ JSONException -> 0x03dc }
            java.lang.String r3 = "achievements"
            org.json.JSONArray r2 = r2.getJSONArray(r3)     // Catch:{ JSONException -> 0x03dc }
            r3 = 0
        L_0x037f:
            int r4 = r2.length()     // Catch:{ JSONException -> 0x03dc }
            if (r3 >= r4) goto L_0x038f
            org.json.JSONObject r4 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x03dc }
            r0.add(r4)     // Catch:{ JSONException -> 0x03dc }
            int r3 = r3 + 1
            goto L_0x037f
        L_0x038f:
            int r2 = r0.size()     // Catch:{ JSONException -> 0x03dc }
            if (r2 <= 0) goto L_0x03d5
            r2 = 25
            r1.addWhiteSpace(r5, r2)     // Catch:{ JSONException -> 0x03dc }
            com.trainerfu.story.SectionPartDefinition r2 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.DividerView> r3 = com.trainerfu.story.DividerView.class
            com.trainerfu.story.SectionPartBinder r4 = new com.trainerfu.story.SectionPartBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r6 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r6)     // Catch:{ JSONException -> 0x03dc }
            r2.<init>(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r2)     // Catch:{ JSONException -> 0x03dc }
            r2 = 25
            r1.addWhiteSpace(r5, r2)     // Catch:{ JSONException -> 0x03dc }
            r10 = 0
        L_0x03b3:
            int r2 = r0.size()     // Catch:{ JSONException -> 0x03dc }
            if (r10 >= r2) goto L_0x03d5
            com.trainerfu.story.SectionPartDefinition r2 = new com.trainerfu.story.SectionPartDefinition     // Catch:{ JSONException -> 0x03dc }
            java.lang.Class<com.trainerfu.story.AchievementView> r3 = com.trainerfu.story.AchievementView.class
            com.trainerfu.story.AchievementBinder r4 = new com.trainerfu.story.AchievementBinder     // Catch:{ JSONException -> 0x03dc }
            android.content.Context r6 = r22.getContext()     // Catch:{ JSONException -> 0x03dc }
            java.lang.Object r7 = r0.get(r10)     // Catch:{ JSONException -> 0x03dc }
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x03dc }
            r4.<init>(r6, r7)     // Catch:{ JSONException -> 0x03dc }
            r2.<init>(r3, r4)     // Catch:{ JSONException -> 0x03dc }
            r5.add(r2)     // Catch:{ JSONException -> 0x03dc }
            int r10 = r10 + 1
            goto L_0x03b3
        L_0x03d5:
            r1.addFooter(r5)     // Catch:{ JSONException -> 0x03dc }
            r1.addSectionSeparator(r5)     // Catch:{ JSONException -> 0x03dc }
            return r5
        L_0x03dc:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.story.WorkoutStoryViewModel.getParts():java.util.List");
    }

    public void setShowWorkout(boolean z) {
        this.showWorkout = z;
    }

    public void setShowWorkoutDetails(boolean z) {
        try {
            getState().put("show_workout_details", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setShowAchievementDetails(boolean z) {
        try {
            getState().put("show_achievement_details", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showAchievementDetails() {
        try {
            if (getState().has("show_achievement_details")) {
                return getState().getBoolean("show_achievement_details");
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showWorkout() {
        return this.showWorkout;
    }

    public boolean showWorkoutDetails() {
        try {
            if (getState().has("show_workout_details")) {
                return getState().getBoolean("show_workout_details");
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
