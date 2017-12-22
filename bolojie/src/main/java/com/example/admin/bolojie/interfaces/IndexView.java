package com.example.admin.bolojie.interfaces;

import com.example.admin.bolojie.bean.Data;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public interface IndexView{
    void showProgress();
    void hideProgress();
    void loadDataError(int tag,String error);
    void loadDataSuccess(int tag,List<?> list);
    void loadDataSuccess(int tag, Data data);
}
