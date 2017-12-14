package com.example.admin.bolojie.interfaces;

import com.example.admin.bolojie.bean.Data;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public interface IndexView{
    void showProgress();
    void hideProgress();
    void loadDataError(String tag,String error);
    void loadDataSuccess(String tag,List<?> list);
    void loadDataSuccess(String tag, Data data);
}
