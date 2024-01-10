package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;

public class TastyToast {
    public static final int CONFUSING = 6;
    public static final int DEFAULT = 5;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    static ConfusingToastView confusingToastView;
    static DefaultToastView defaultToastView;
    static ErrorToastView errorToastView;
    static InfoToastView infoToastView;
    static SuccessToastView successToastView;
    static WarningToastView warningToastView;

    public static Toast makeText(Context context, String str, int i, int i2) {
        Toast toast = new Toast(context);
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(context).inflate(R.layout.success_toast_layout, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(R.id.toastMessage);
                textView.setText(str);
                SuccessToastView successToastView2 = (SuccessToastView) inflate.findViewById(R.id.successView);
                successToastView = successToastView2;
                successToastView2.startAnim();
                textView.setBackgroundResource(R.drawable.success_toast);
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate);
                break;
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.warning_toast_layout, (ViewGroup) null, false);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.toastMessage);
                textView2.setText(str);
                warningToastView = (WarningToastView) inflate2.findViewById(R.id.warningView);
                final Spring createSpring = SpringSystem.create().createSpring();
                createSpring.setCurrentValue(1.8d);
                createSpring.setSpringConfig(new SpringConfig(40.0d, 5.0d));
                createSpring.addListener(new SimpleSpringListener() {
                    public void onSpringUpdate(Spring spring) {
                        float currentValue = 0.9f - (((float) spring.getCurrentValue()) * 0.5f);
                        TastyToast.warningToastView.setScaleX(currentValue);
                        TastyToast.warningToastView.setScaleY(currentValue);
                    }
                });
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException unused) {
                        }
                        createSpring.setEndValue(0.4000000059604645d);
                    }
                }).start();
                textView2.setBackgroundResource(R.drawable.warning_toast);
                textView2.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate2);
                break;
            case 3:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, (ViewGroup) null, false);
                TextView textView3 = (TextView) inflate3.findViewById(R.id.toastMessage);
                textView3.setText(str);
                ErrorToastView errorToastView2 = (ErrorToastView) inflate3.findViewById(R.id.errorView);
                errorToastView = errorToastView2;
                errorToastView2.startAnim();
                textView3.setBackgroundResource(R.drawable.error_toast);
                textView3.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate3);
                break;
            case 4:
                View inflate4 = LayoutInflater.from(context).inflate(R.layout.info_toast_layout, (ViewGroup) null, false);
                TextView textView4 = (TextView) inflate4.findViewById(R.id.toastMessage);
                textView4.setText(str);
                InfoToastView infoToastView2 = (InfoToastView) inflate4.findViewById(R.id.infoView);
                infoToastView = infoToastView2;
                infoToastView2.startAnim();
                textView4.setBackgroundResource(R.drawable.info_toast);
                textView4.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate4);
                break;
            case 5:
                View inflate5 = LayoutInflater.from(context).inflate(R.layout.default_toast_layout, (ViewGroup) null, false);
                TextView textView5 = (TextView) inflate5.findViewById(R.id.toastMessage);
                textView5.setText(str);
                DefaultToastView defaultToastView2 = (DefaultToastView) inflate5.findViewById(R.id.defaultView);
                defaultToastView = defaultToastView2;
                defaultToastView2.startAnim();
                textView5.setBackgroundResource(R.drawable.default_toast);
                textView5.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate5);
                break;
            case 6:
                View inflate6 = LayoutInflater.from(context).inflate(R.layout.confusing_toast_layout, (ViewGroup) null, false);
                TextView textView6 = (TextView) inflate6.findViewById(R.id.toastMessage);
                textView6.setText(str);
                ConfusingToastView confusingToastView2 = (ConfusingToastView) inflate6.findViewById(R.id.confusingView);
                confusingToastView = confusingToastView2;
                confusingToastView2.startAnim();
                textView6.setBackgroundResource(R.drawable.confusing_toast);
                textView6.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(inflate6);
                break;
        }
        toast.setDuration(i);
        toast.show();
        return toast;
    }
}
