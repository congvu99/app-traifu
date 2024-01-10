package com.facebook.appevents.ml;

import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class Model {
    private static final int SEQ_LEN = 128;
    private MTensor convs_0_bias;
    private MTensor convs_0_weight;
    private MTensor convs_1_bias;
    private MTensor convs_1_weight;
    private MTensor convs_2_bias;
    private MTensor convs_2_weight;
    private MTensor embedding;
    private MTensor fc1_bias;
    private MTensor fc1_weight;
    private MTensor fc2_bias;
    private MTensor fc2_weight;
    private final Map<String, MTensor> final_weights = new HashMap();

    private Model(Map<String, MTensor> map) {
        this.embedding = map.get("embed.weight");
        this.convs_0_weight = Operator.transpose3D(map.get("convs.0.weight"));
        this.convs_1_weight = Operator.transpose3D(map.get("convs.1.weight"));
        this.convs_2_weight = Operator.transpose3D(map.get("convs.2.weight"));
        this.convs_0_bias = map.get("convs.0.bias");
        this.convs_1_bias = map.get("convs.1.bias");
        this.convs_2_bias = map.get("convs.2.bias");
        this.fc1_weight = Operator.transpose2D(map.get("fc1.weight"));
        this.fc2_weight = Operator.transpose2D(map.get("fc2.weight"));
        this.fc1_bias = map.get("fc1.bias");
        this.fc2_bias = map.get("fc2.bias");
        for (String str : new HashSet<String>() {
            {
                add(ModelManager.Task.MTML_INTEGRITY_DETECT.toKey());
                add(ModelManager.Task.MTML_APP_EVENT_PREDICTION.toKey());
            }
        }) {
            String str2 = str + ".weight";
            String str3 = str + ".bias";
            MTensor mTensor = map.get(str2);
            MTensor mTensor2 = map.get(str3);
            if (mTensor != null) {
                this.final_weights.put(str2, Operator.transpose2D(mTensor));
            }
            if (mTensor2 != null) {
                this.final_weights.put(str3, mTensor2);
            }
        }
    }

    public MTensor predictOnMTML(MTensor mTensor, String[] strArr, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            MTensor conv1D = Operator.conv1D(Operator.embedding(strArr, 128, this.embedding), this.convs_0_weight);
            Operator.addmv(conv1D, this.convs_0_bias);
            Operator.relu(conv1D);
            MTensor conv1D2 = Operator.conv1D(conv1D, this.convs_1_weight);
            Operator.addmv(conv1D2, this.convs_1_bias);
            Operator.relu(conv1D2);
            MTensor maxPool1D = Operator.maxPool1D(conv1D2, 2);
            MTensor conv1D3 = Operator.conv1D(maxPool1D, this.convs_2_weight);
            Operator.addmv(conv1D3, this.convs_2_bias);
            Operator.relu(conv1D3);
            MTensor maxPool1D2 = Operator.maxPool1D(conv1D, conv1D.getShape(1));
            MTensor maxPool1D3 = Operator.maxPool1D(maxPool1D, maxPool1D.getShape(1));
            MTensor maxPool1D4 = Operator.maxPool1D(conv1D3, conv1D3.getShape(1));
            Operator.flatten(maxPool1D2, 1);
            Operator.flatten(maxPool1D3, 1);
            Operator.flatten(maxPool1D4, 1);
            MTensor dense = Operator.dense(Operator.concatenate(new MTensor[]{maxPool1D2, maxPool1D3, maxPool1D4, mTensor}), this.fc1_weight, this.fc1_bias);
            Operator.relu(dense);
            MTensor dense2 = Operator.dense(dense, this.fc2_weight, this.fc2_bias);
            Operator.relu(dense2);
            Map<String, MTensor> map = this.final_weights;
            MTensor mTensor2 = map.get(str + ".weight");
            Map<String, MTensor> map2 = this.final_weights;
            MTensor mTensor3 = map2.get(str + ".bias");
            if (mTensor2 != null) {
                if (mTensor3 != null) {
                    MTensor dense3 = Operator.dense(dense2, mTensor2, mTensor3);
                    Operator.softmax(dense3);
                    return dense3;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static Model build(File file) {
        Class<Model> cls = Model.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            try {
                return new Model(parse(file));
            } catch (Exception unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c3, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:3:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, com.facebook.appevents.ml.MTensor> parse(java.io.File r18) {
        /*
            java.lang.Class<com.facebook.appevents.ml.Model> r1 = com.facebook.appevents.ml.Model.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            r2 = 0
            if (r0 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r3 = r18
            r0.<init>(r3)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r3 = r0.available()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            byte[] r0 = new byte[r3]     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r4.readFully(r0)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r4.close()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r4 = 4
            if (r3 >= r4) goto L_0x0026
            return r2
        L_0x0026:
            r5 = 0
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r0, r5, r4)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            java.nio.ByteOrder r7 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r6.order(r7)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r6 = r6.getInt()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r7 = r6 + 4
            if (r3 >= r7) goto L_0x0039
            return r2
        L_0x0039:
            java.lang.String r8 = new java.lang.String     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r8.<init>(r0, r4, r6)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            org.json.JSONArray r6 = r4.names()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r8 = r6.length()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r10 = 0
        L_0x004e:
            if (r10 >= r8) goto L_0x0059
            java.lang.String r11 = r6.getString(r10)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r9[r10] = r11     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r10 = r10 + 1
            goto L_0x004e
        L_0x0059:
            java.util.Arrays.sort(r9)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r6.<init>()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            java.util.Map r10 = getMapping()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r11 = 0
        L_0x0066:
            if (r11 >= r8) goto L_0x00c1
            r12 = r9[r11]     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            org.json.JSONArray r13 = r4.getJSONArray(r12)     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int r14 = r13.length()     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            int[] r15 = new int[r14]     // Catch:{ Exception -> 0x00c8, all -> 0x00c2 }
            r16 = 1
            r2 = 0
            r5 = 1
        L_0x0078:
            if (r2 >= r14) goto L_0x0089
            int r17 = r13.getInt(r2)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r15[r2] = r17     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r17 = r15[r2]     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            int r5 = r5 * r17
            int r2 = r2 + 1
            goto L_0x0078
        L_0x0087:
            r1 = 0
            goto L_0x00c9
        L_0x0089:
            int r2 = r5 * 4
            int r13 = r7 + r2
            if (r13 <= r3) goto L_0x0091
            r14 = 0
            return r14
        L_0x0091:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r0, r7, r2)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            java.nio.ByteOrder r7 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r2.order(r7)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            com.facebook.appevents.ml.MTensor r7 = new com.facebook.appevents.ml.MTensor     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r7.<init>(r15)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            java.nio.FloatBuffer r2 = r2.asFloatBuffer()     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            float[] r14 = r7.getData()     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r15 = 0
            r2.get(r14, r15, r5)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            boolean r2 = r10.containsKey(r12)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            if (r2 == 0) goto L_0x00b8
            java.lang.Object r2 = r10.get(r12)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
        L_0x00b8:
            r6.put(r12, r7)     // Catch:{ Exception -> 0x0087, all -> 0x00c2 }
            int r11 = r11 + 1
            r7 = r13
            r2 = 0
            r5 = 0
            goto L_0x0066
        L_0x00c1:
            return r6
        L_0x00c2:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1)
            r1 = 0
            return r1
        L_0x00c8:
            r1 = r2
        L_0x00c9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.Model.parse(java.io.File):java.util.Map");
    }

    private static Map<String, String> getMapping() {
        Class<Model> cls = Model.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return new HashMap<String, String>() {
                {
                    put("embedding.weight", "embed.weight");
                    put("dense1.weight", "fc1.weight");
                    put("dense2.weight", "fc2.weight");
                    put("dense3.weight", "fc3.weight");
                    put("dense1.bias", "fc1.bias");
                    put("dense2.bias", "fc2.bias");
                    put("dense3.bias", "fc3.bias");
                }
            };
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
