package space.wangjiang.toaster;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by WangJiang on 2017/3/19.
 *  参考了https://github.com/GrenderG/Toasty
 */

public class Toaster {

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;

    private Toaster() {
    }

    public static Toast success(Context context, CharSequence message, int duration) {
        return success(context, getDrawable(context, R.drawable.ic_toaster_success), message, duration);
    }

    public static Toast success(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorSuccess), getColor(context, R.color.toasterTextColor), duration);
    }

    public static Toast error(Context context, CharSequence message, int duration) {
        return error(context, getDrawable(context, R.drawable.ic_toaster_error), message, duration);
    }

    public static Toast error(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorError), getColor(context, R.color.toasterTextColor), duration);
    }

    public static Toast warning(Context context, CharSequence message, int duration) {
        return warning(context, getDrawable(context, R.drawable.ic_toaster_warning), message, duration);
    }

    public static Toast warning(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorWarning), getColor(context, R.color.toasterTextColor), duration);
    }

    public static Toast info(Context context, CharSequence message, int duration) {
        return info(context, getDrawable(context, R.drawable.ic_toaster_info), message, duration);
    }

    public static Toast info(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorInfo), getColor(context, R.color.toasterTextColor), duration);
    }

    public static Toast normal(Context context, CharSequence message, int duration) {
        return normal(context, getDrawable(context, R.drawable.ic_toaster_info), message, duration);
    }

    public static Toast normal(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorNormal), getColor(context, R.color.toasterTextColor), duration);
    }

    public static Toast primary(Context context, CharSequence message, int duration) {
        return primary(context, getDrawable(context, R.drawable.ic_toaster_info), message, duration);
    }

    public static Toast primary(Context context, Drawable icon, CharSequence message,  int duration) {
        return custom(context, icon, message, getColor(context, R.color.toasterColorPrimary), getColor(context, R.color.toasterTextColor), duration);
    }

    /**
     *
     * @param context 上下文
     * @param icon 显示的图标
     * @param message 提示内容
     * @param toasterColor  整体的颜色
     * @param textColor   文字的颜色
     * @param duration  显示时间
     * @return
     */
    public static Toast custom(Context context, Drawable icon, CharSequence message, @ColorInt int toasterColor, @ColorInt int textColor, int duration) {
        Toast toaster = new Toast(context);
        View toasterView = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
        //设置背景
        //改变drawable颜色
        NinePatchDrawable toasterDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toaster_background);
        toasterDrawable.setColorFilter(new PorterDuffColorFilter(toasterColor, PorterDuff.Mode.SRC_IN));
        ViewCompat.setBackground(toasterView, toasterDrawable);

        ImageView toasterIcon = (ImageView) toasterView.findViewById(R.id.toast_icon);
        toasterIcon.setImageDrawable(icon);
        TextView toasterTextView = (TextView) toasterView.findViewById(R.id.toast_text);
        toasterTextView.setText(message);
        toasterTextView.setTextColor(textColor);

        toaster.setView(toasterView);
        toaster.setDuration(duration);
        return toaster;
    }

    /**
     * 兼容处理
     * Use Support V4 Library
     */
    private static Drawable getDrawable(Context context, @DrawableRes int drawableId) {
        return ContextCompat.getDrawable(context, drawableId);
    }

    /**
     * 使用兼容包
     * Use Support V4 Library
     */
    private static @ColorInt int getColor(Context context, @ColorRes int colorId) {
        return ContextCompat.getColor(context, colorId);
    }

}
