package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import io.intercom.android.sdk.metrics.MetricTracker;
import kotlinx.serialization.json.internal.JsonLexerKt;

class MultiplicationAnimatedNode extends ValueAnimatedNode {
    private final int[] mInputNodes;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public MultiplicationAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
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
        this.mValue = 1.0d;
        int i = 0;
        while (true) {
            int[] iArr = this.mInputNodes;
            if (i < iArr.length) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(iArr[i]);
                if (nodeById != null && (nodeById instanceof ValueAnimatedNode)) {
                    this.mValue *= ((ValueAnimatedNode) nodeById).getValue();
                    i++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.multiply node");
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiplicationAnimatedNode[");
        sb.append(this.mTag);
        sb.append("]: input nodes: ");
        int[] iArr = this.mInputNodes;
        sb.append(iArr != null ? iArr.toString() : JsonLexerKt.NULL);
        sb.append(" - super: ");
        sb.append(super.prettyPrint());
        return sb.toString();
    }
}
