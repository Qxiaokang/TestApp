package com.example.admin.bolojie.interfaces;

/**
 * Created by Admin on 2017/12/22.
 */
public interface MultiItemTypeSupport<T>{
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
