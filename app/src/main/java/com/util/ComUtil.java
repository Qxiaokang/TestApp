package com.util;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.fingerprint.FingerprintManager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.activity.R;

import java.util.UUID;

/**
 * Created by Admin on 2017/11/13.
 */
public class ComUtil{
    public String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    /**获取FingerprintManager服务对象
     * @param context
     * */
    public static FingerprintManager getFinger(Context context){
        FingerprintManager fingerprintManager=null;
        try{
            fingerprintManager= (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
        }catch(Exception e){
            LogUtils.e("get  fingerprintManager faild");
        }
        return fingerprintManager;
    }
    public static void showToast(Context context,String content){
        View view=View.inflate(context, R.layout.toast_layout,null);
        Toast toast=new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,20);
        TextView textView= (TextView) view.findViewById(R.id.tv_toast_content);
        textView.setText(content);
        toast.setView(view);
        toast.show();
    }
    public static void startAnim(ImageView imageView){
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.start();
    }
    public static void stopAnim(ImageView imageView){
        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.stop();
    }
}
