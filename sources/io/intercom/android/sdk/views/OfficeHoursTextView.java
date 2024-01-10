package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;

public class OfficeHoursTextView extends AppCompatTextView {
    public OfficeHoursTextView(Context context) {
        super(context);
    }

    public OfficeHoursTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOfficeHoursDrawable(int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.intercom_snooze);
        drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.intercom_office_hours_drawable_padding));
    }
}
