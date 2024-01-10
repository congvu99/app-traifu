package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface MenuProvider {

    /* renamed from: androidx.core.view.MenuProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onMenuClosed(MenuProvider menuProvider, Menu menu) {
        }

        public static void $default$onPrepareMenu(MenuProvider menuProvider, Menu menu) {
        }
    }

    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    void onMenuClosed(Menu menu);

    boolean onMenuItemSelected(MenuItem menuItem);

    void onPrepareMenu(Menu menu);
}
