package com.thread;

import com.bean.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/11/13.
 */
public class ImageThread extends Thread{
    private String path;
    List<Image> images=new ArrayList<>();
    public ImageThread(){

    }
    public ImageThread(String path){
        this.path=path;
    }
    @Override
    public void run(){
        super.run();

    }
}
