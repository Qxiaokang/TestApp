package com.example.admin.bolojie.util;

import android.content.Context;
import android.content.res.AssetManager;

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
}
