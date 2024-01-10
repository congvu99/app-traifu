package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricComponents;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class IntBufferBatchMountItem implements MountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = IntBufferBatchMountItem.class.getSimpleName();
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    public IntBufferBatchMountItem(int i, int[] iArr, Object[] objArr, int i2) {
        this.mSurfaceId = i;
        this.mCommitNumber = i2;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        int i3 = 0;
        this.mIntBufferLen = iArr != null ? iArr.length : 0;
        Object[] objArr2 = this.mObjBuffer;
        this.mObjBufferLen = objArr2 != null ? objArr2.length : i3;
    }

    private void beginMarkers(String str) {
        Systrace.beginSection(0, "FabricUIManager::" + str + " - " + this.mIntBufferLen + " intBufSize  - " + this.mObjBufferLen + " objBufSize");
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, (String) null, this.mCommitNumber);
        }
    }

    private void endMarkers() {
        if (this.mCommitNumber > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, (String) null, this.mCommitNumber);
        }
        Systrace.endSection(0);
    }

    private static StateWrapper castToState(Object obj) {
        if (obj != null) {
            return (StateWrapper) obj;
        }
        return null;
    }

    private static ReadableMap castToProps(Object obj) {
        if (obj != null) {
            return (ReadableMap) obj;
        }
        return null;
    }

    private static EventEmitterWrapper castToEventEmitter(Object obj) {
        if (obj != null) {
            return (EventEmitterWrapper) obj;
        }
        return null;
    }

    public void execute(MountingManager mountingManager) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.e(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
        } else if (surfaceManager.isStopped()) {
            FLog.e(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
        } else {
            if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                FLog.d(TAG, "Executing IntBufferBatchMountItem on surface [%d]", (Object) Integer.valueOf(this.mSurfaceId));
            }
            beginMarkers("mountViews");
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i8 = i6 + 1;
                int i9 = iArr[i6];
                int i10 = i9 & -2;
                if ((i9 & 1) != 0) {
                    int i11 = iArr[i8];
                    i8++;
                    i = i11;
                } else {
                    i = 1;
                }
                int i12 = i7;
                i6 = i8;
                for (int i13 = 0; i13 < i; i13++) {
                    if (i10 == 2) {
                        int i14 = i12 + 1;
                        String fabricComponentName = FabricComponents.getFabricComponentName((String) this.mObjBuffer[i12]);
                        int i15 = i6 + 1;
                        int i16 = this.mIntBuffer[i6];
                        int i17 = i14 + 1;
                        ReadableMap castToProps = castToProps(this.mObjBuffer[i14]);
                        int i18 = i17 + 1;
                        i12 = i18 + 1;
                        i4 = i15 + 1;
                        surfaceManager.createView(fabricComponentName, i16, castToProps, castToState(this.mObjBuffer[i17]), castToEventEmitter(this.mObjBuffer[i18]), this.mIntBuffer[i15] == 1);
                    } else {
                        if (i10 == 4) {
                            surfaceManager.deleteView(this.mIntBuffer[i6]);
                            i6++;
                        } else {
                            if (i10 == 8) {
                                int[] iArr2 = this.mIntBuffer;
                                int i19 = i6 + 1;
                                int i20 = i19 + 1;
                                i5 = i20 + 1;
                                surfaceManager.addViewAt(iArr2[i19], iArr2[i6], iArr2[i20]);
                            } else if (i10 == 16) {
                                int[] iArr3 = this.mIntBuffer;
                                int i21 = i6 + 1;
                                int i22 = i21 + 1;
                                i5 = i22 + 1;
                                surfaceManager.removeViewAt(iArr3[i6], iArr3[i21], iArr3[i22]);
                            } else {
                                if (i10 == 32) {
                                    i2 = i6 + 1;
                                    i3 = i12 + 1;
                                    surfaceManager.updateProps(this.mIntBuffer[i6], castToProps(this.mObjBuffer[i12]));
                                } else if (i10 == 64) {
                                    i2 = i6 + 1;
                                    i3 = i12 + 1;
                                    surfaceManager.updateState(this.mIntBuffer[i6], castToState(this.mObjBuffer[i12]));
                                } else if (i10 == 128) {
                                    int[] iArr4 = this.mIntBuffer;
                                    int i23 = i6 + 1;
                                    int i24 = iArr4[i6];
                                    int i25 = i23 + 1;
                                    int i26 = iArr4[i23];
                                    int i27 = i25 + 1;
                                    int i28 = iArr4[i25];
                                    int i29 = i27 + 1;
                                    int i30 = i29 + 1;
                                    i4 = i30 + 1;
                                    surfaceManager.updateLayout(i24, i26, i28, iArr4[i27], iArr4[i29], iArr4[i30]);
                                } else if (i10 == 512) {
                                    int[] iArr5 = this.mIntBuffer;
                                    int i31 = i6 + 1;
                                    int i32 = iArr5[i6];
                                    int i33 = i31 + 1;
                                    int i34 = iArr5[i31];
                                    int i35 = i33 + 1;
                                    int i36 = iArr5[i33];
                                    int i37 = i35 + 1;
                                    surfaceManager.updatePadding(i32, i34, i36, iArr5[i35], iArr5[i37]);
                                    i6 = i37 + 1;
                                } else if (i10 == 256) {
                                    i2 = i6 + 1;
                                    i3 = i12 + 1;
                                    surfaceManager.updateEventEmitter(this.mIntBuffer[i6], castToEventEmitter(this.mObjBuffer[i12]));
                                } else {
                                    throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i10 + " at index: " + i6);
                                }
                                i6 = i2;
                                i12 = i3;
                            }
                            i6 = i5;
                        }
                    }
                    i6 = i4;
                }
                i7 = i12;
            }
            endMarkers();
        }
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean shouldSchedule() {
        return this.mIntBufferLen != 0;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", new Object[]{Integer.valueOf(this.mSurfaceId)}));
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.mIntBufferLen) {
                int i7 = i5 + 1;
                int i8 = this.mIntBuffer[i5];
                int i9 = i8 & -2;
                if ((i8 & 1) != 0) {
                    i2 = this.mIntBuffer[i7];
                    i7++;
                } else {
                    i2 = 1;
                }
                for (int i10 = 0; i10 < i2; i10++) {
                    if (i9 == 2) {
                        int i11 = i + 1;
                        i3 = i11 + 1;
                        sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), Integer.valueOf(this.mIntBuffer[i11]), FabricComponents.getFabricComponentName((String) this.mObjBuffer[i6])}));
                        i6 = i6 + 1 + 3;
                    } else {
                        if (i9 == 4) {
                            i4 = i + 1;
                            sb.append(String.format("DELETE [%d]\n", new Object[]{Integer.valueOf(this.mIntBuffer[i])}));
                        } else if (i9 == 8) {
                            int i12 = i + 1;
                            int i13 = i12 + 1;
                            i3 = i13 + 1;
                            sb.append(String.format("INSERT [%d]->[%d] @%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), Integer.valueOf(this.mIntBuffer[i12]), Integer.valueOf(this.mIntBuffer[i13])}));
                        } else if (i9 == 16) {
                            int i14 = i + 1;
                            int i15 = i14 + 1;
                            i3 = i15 + 1;
                            sb.append(String.format("REMOVE [%d]->[%d] @%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), Integer.valueOf(this.mIntBuffer[i14]), Integer.valueOf(this.mIntBuffer[i15])}));
                        } else if (i9 == 32) {
                            castToProps(this.mObjBuffer[i6]);
                            i3 = i + 1;
                            sb.append(String.format("UPDATE PROPS [%d]: %s\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), "<hidden>"}));
                            i6++;
                        } else if (i9 == 64) {
                            i6++;
                            i4 = i + 1;
                            sb.append(String.format("UPDATE STATE [%d]\n", new Object[]{Integer.valueOf(this.mIntBuffer[i])}));
                        } else {
                            if (i9 == 128) {
                                int i16 = i + 1;
                                int i17 = i16 + 1;
                                int i18 = i17 + 1;
                                int i19 = i18 + 1;
                                int i20 = i19 + 1;
                                sb.append(String.format("UPDATE LAYOUT [%d]: x:%d y:%d w:%d h:%d displayType:%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), Integer.valueOf(this.mIntBuffer[i16]), Integer.valueOf(this.mIntBuffer[i17]), Integer.valueOf(this.mIntBuffer[i18]), Integer.valueOf(this.mIntBuffer[i19]), Integer.valueOf(this.mIntBuffer[i20])}));
                                i = i20 + 1;
                            } else if (i9 == 512) {
                                int i21 = i + 1;
                                int i22 = i21 + 1;
                                int i23 = i22 + 1;
                                int i24 = i23 + 1;
                                sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", new Object[]{Integer.valueOf(this.mIntBuffer[i]), Integer.valueOf(this.mIntBuffer[i21]), Integer.valueOf(this.mIntBuffer[i22]), Integer.valueOf(this.mIntBuffer[i23]), Integer.valueOf(this.mIntBuffer[i24])}));
                                i = i24 + 1;
                            } else if (i9 == 256) {
                                i6++;
                                i4 = i + 1;
                                sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", new Object[]{Integer.valueOf(this.mIntBuffer[i])}));
                            } else {
                                String str = TAG;
                                FLog.e(str, "String so far: " + sb.toString());
                                throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i9 + " at index: " + i);
                            }
                        }
                        i = i4;
                    }
                    i = i3;
                }
                i5 = i;
            }
            return sb.toString();
        } catch (Exception e) {
            FLog.e(TAG, "Caught exception trying to print", (Throwable) e);
            StringBuilder sb2 = new StringBuilder();
            for (int i25 = 0; i25 < this.mIntBufferLen; i25++) {
                sb2.append(this.mIntBuffer[i25]);
                sb2.append(", ");
            }
            FLog.e(TAG, sb2.toString());
            for (int i26 = 0; i26 < this.mObjBufferLen; i26++) {
                String str2 = TAG;
                Object[] objArr = this.mObjBuffer;
                FLog.e(str2, objArr[i26] != null ? objArr[i26].toString() : JsonLexerKt.NULL);
            }
            return "";
        }
    }
}
