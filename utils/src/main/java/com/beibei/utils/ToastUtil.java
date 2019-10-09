package com.beibei.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    public static void showToast(Context context, int strID) {
        showToast(context, context.getString(strID));
    }

    /**
     * 自定义中部toast
     *
     * @param context
     */
    public static void setDefineToast(Context context, int padding) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            ViewGroup toastView = (ViewGroup) toast.getView();
            TextView child = new TextView(context.getApplicationContext());
            child.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dip2px(context.getApplicationContext(), padding)));
            toastView.addView(child, 0);
            TextView child1 = new TextView(context.getApplicationContext());
            child1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dip2px(context.getApplicationContext(), padding)));
            toastView.addView(child1, 2);
            toast.setGravity(Gravity.CENTER, 0, 0);
        }
    }

    /**
     * 自定义中部toast(默认10dp上下内间距)
     *
     * @param context
     */
    public static void setDefineToast(Context context) {
        setDefineToast(context, 10);
    }

    /**
     * 根据手机的分辨率将dp的单位转成px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
