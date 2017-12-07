package com.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by Admin on 2017/11/14.
 */
public class InitContent{
    private String photoPath= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"images";
    private static  InitContent initContent;

    public String getPhotoPath(){
        return photoPath;
    }

    public void setPhotoPath(String photoPath){
        this.photoPath = photoPath;
    }

    private InitContent(){

    }
    public synchronized static InitContent getinStance(){
        if(initContent==null){
            initContent=new InitContent();
        }
        return initContent;
    }
}
