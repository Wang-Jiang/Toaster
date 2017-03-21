package space.wangjiang.toastersimple;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import space.wangjiang.toaster.Toaster;

public class MainActivity extends Activity implements View.OnClickListener {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        findViewById(R.id.system_default_toast).setOnClickListener(this);
        findViewById(R.id.success_toaster).setOnClickListener(this);
        findViewById(R.id.warning_toaster).setOnClickListener(this);
        findViewById(R.id.error_toaster).setOnClickListener(this);
        findViewById(R.id.normal_toaster).setOnClickListener(this);
        findViewById(R.id.info_toaster).setOnClickListener(this);
        findViewById(R.id.primary_toaster).setOnClickListener(this);
        findViewById(R.id.custom_toaster).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.system_default_toast:
                Toast.makeText(context, "This is a system default toast.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.success_toaster:
                Toaster.success(context, "Yep,it's pretty useful!", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.warning_toaster:
                Toaster.warning(context, "Maybe you should notice this.", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.error_toaster:
                Toaster.error(context, "Opps!System make a mistake!", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.normal_toaster:
                Toaster.normal(context, "It's raining now.", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.info_toaster:
                Toaster.info(context, "I'll show you something.", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.primary_toaster:
                Toaster.primary(context, "What is 'primary'?I don't konw.", Toaster.LENGTH_SHORT).show();
                break;
            case R.id.custom_toaster:
                Toaster.custom(context,
                        getContextDrawable(R.drawable.ic_coffee_cup) ,
                        "It's delicious!",
                        getContextColor(R.color.colorCoffee),
                        getContextColor(R.color.toasterTextColor),
                        Toaster.LENGTH_SHORT
                ).show();
                break;
            default:
                break;
        }
    }

    public Drawable getContextDrawable(@DrawableRes int drawableId) {
        return ContextCompat.getDrawable(this, drawableId);
    }

    public  @ColorInt int getContextColor(@ColorRes int colorId) {
        return ContextCompat.getColor(this, colorId);
    }
}
