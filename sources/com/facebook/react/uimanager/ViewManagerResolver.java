package com.facebook.react.uimanager;

import java.util.List;
import javax.annotation.Nullable;

public interface ViewManagerResolver {
    @Nullable
    ViewManager getViewManager(String str);

    List<String> getViewManagerNames();
}
