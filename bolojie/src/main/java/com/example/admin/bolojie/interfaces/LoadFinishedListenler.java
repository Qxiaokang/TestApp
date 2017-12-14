package com.example.admin.bolojie.interfaces;

import com.example.admin.bolojie.bean.Data;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public interface LoadFinishedListenler{
    void onLoadError(String tag,String error);
    void onLoadSuccess(String tag,List<?> list);
    void onLoadSuccess(String tag, Data data);
}

