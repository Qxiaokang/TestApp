package com.example.admin.bolojie.util;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.bolojie.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Admin on 2017/12/12.
 */
public class ComUtil{
    public static Context getContext(){
        return MobileApplication.context;
    }
    public static String downLoadAssets(String name){
        StringBuilder stringBuilder=new StringBuilder();
        try{
            AssetManager assets = getContext().getResources().getAssets();
            InputStream open = assets.open(name);
            InputStreamReader inputStreamReader=new InputStreamReader(open,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
        }catch(Exception e){
            return "error";
        }
        return stringBuilder.toString();
    }
    public static Dialog createLoadingDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_progress, null);// 得到加载view

        Dialog loadingDialog = new Dialog(context);// 创建自定义样式dialog
        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
        loadingDialog.setContentView(view);// 设置布局
        return loadingDialog;
    }
}
