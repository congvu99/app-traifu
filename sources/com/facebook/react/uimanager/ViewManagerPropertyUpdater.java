package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.ViewManagersPropertyCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ViewManagerPropertyUpdater {
    private static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new HashMap();
    private static final String TAG = "ViewManagerPropertyUpdater";
    private static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

    public interface Settable {
        void getProperties(Map<String, String> map);
    }

    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void setProperty(T t, String str, Object obj);
    }

    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void setProperty(T t, V v, String str, Object obj);
    }

    public static void clear() {
        ViewManagersPropertyCache.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    public static <T extends ViewManagerDelegate<V>, V extends View> void updateProps(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            t.setProperty(v, (String) next.getKey(), next.getValue());
        }
    }

    public static <T extends ViewManager, V extends View> void updateProps(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerSetter<?, V> findManagerSetter = findManagerSetter(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            findManagerSetter.setProperty(t, v, (String) next.getKey(), next.getValue());
        }
    }

    public static <T extends ReactShadowNode> void updateProps(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ShadowNodeSetter<?> findNodeSetter = findNodeSetter(t.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.mBackingMap.getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            findNodeSetter.setProperty(t, (String) next.getKey(), next.getValue());
        }
    }

    public static Map<String, String> getNativeProps(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        HashMap hashMap = new HashMap();
        findManagerSetter(cls).getProperties(hashMap);
        findNodeSetter(cls2).getProperties(hashMap);
        return hashMap;
    }

    private static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> findManagerSetter(Class<? extends ViewManager> cls) {
        ViewManagerSetter<T, V> viewManagerSetter = VIEW_MANAGER_SETTER_MAP.get(cls);
        if (viewManagerSetter == null) {
            viewManagerSetter = (ViewManagerSetter) findGeneratedSetter(cls);
            if (viewManagerSetter == null) {
                viewManagerSetter = new FallbackViewManagerSetter<>(cls);
            }
            VIEW_MANAGER_SETTER_MAP.put(cls, viewManagerSetter);
        }
        return viewManagerSetter;
    }

    private static <T extends ReactShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ReactShadowNode> cls) {
        ShadowNodeSetter<T> shadowNodeSetter = SHADOW_NODE_SETTER_MAP.get(cls);
        if (shadowNodeSetter == null) {
            shadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (shadowNodeSetter == null) {
                shadowNodeSetter = new FallbackShadowNodeSetter<>(cls);
            }
            SHADOW_NODE_SETTER_MAP.put(cls, shadowNodeSetter);
        }
        return shadowNodeSetter;
    }

    private static <T> T findGeneratedSetter(Class<?> cls) {
        String name = cls.getName();
        try {
            return Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.w(TAG, "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        }
    }

    private static class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {
        private final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

        private FallbackViewManagerSetter(Class<? extends ViewManager> cls) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(cls);
        }

        public void setProperty(T t, V v, String str, Object obj) {
            ViewManagersPropertyCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateViewProp(t, v, obj);
            }
        }

        public void getProperties(Map<String, String> map) {
            for (ViewManagersPropertyCache.PropSetter next : this.mPropSetters.values()) {
                map.put(next.getPropName(), next.getPropType());
            }
        }
    }

    private static class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {
        private final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

        private FallbackShadowNodeSetter(Class<? extends ReactShadowNode> cls) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(cls);
        }

        public void setProperty(ReactShadowNode reactShadowNode, String str, Object obj) {
            ViewManagersPropertyCache.PropSetter propSetter = this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateShadowNodeProp(reactShadowNode, obj);
            }
        }

        public void getProperties(Map<String, String> map) {
            for (ViewManagersPropertyCache.PropSetter next : this.mPropSetters.values()) {
                map.put(next.getPropName(), next.getPropType());
            }
        }
    }
}
