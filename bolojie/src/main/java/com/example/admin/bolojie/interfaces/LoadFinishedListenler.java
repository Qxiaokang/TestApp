package com.example.admin.bolojie.interfaces;

import com.example.admin.bolojie.bean.Data;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public interface LoadFinishedListenler{
    void onLoadError(int tag,String error);
    void onLoadSuccess(int tag,List<?> list);
    void onLoadSuccess(int tag, Data data);
}

