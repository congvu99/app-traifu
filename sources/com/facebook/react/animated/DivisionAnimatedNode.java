package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.github.mikephil.charting.utils.Utils;
import io.intercom.android.sdk.metrics.MetricTracker;
import kotlinx.serialization.json.internal.JsonLexerKt;

class DivisionAnimatedNode extends ValueAnimatedNode {
    private final int[] mInputNodes;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public DivisionAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableArray array = readableMap.getArray(MetricTracker.Object.INPUT);
        this.mInputNodes = new int[array.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.mInputNodes;
            if (i < iArr.length) {
                iArr[i] = array.getInt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public void update() {
        int i = 0;
        while (true) {
            int[] iArr = this.mInputNodes;
            if (i < iArr.length) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(iArr[i]);
                if (nodeById == null || !(nodeById instanceof ValueAnimatedNode)) {
                } else {
                    double value = ((ValueAnimatedNode) nodeById).getValue();
                    if (i == 0) {
                        this.mValue = value;
                    } else if (value != Utils.DOUBLE_EPSILON) {
                        this.mValue /= value;
                    } else {
                        throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node with Animated ID " + this.mTag);
                    }
                    i++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node with Animated ID " + this.mTag);
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("DivisionAnimatedNode[");
        sb.append(this.mTag);
        sb.append("]: input nodes: ");
        int[] iArr = this.mInputNodes;
        sb.append(iArr != null ? iArr.toString() : JsonLexerKt.NULL);
        sb.append(" - super: ");
        sb.append(super.prettyPrint());
        return sb.toString();
    }
}
