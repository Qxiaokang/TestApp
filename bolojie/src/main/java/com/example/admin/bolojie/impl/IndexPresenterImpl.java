package com.example.admin.bolojie.impl;

import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.interfaces.IndexPresenter;
import com.example.admin.bolojie.interfaces.IndexView;
import com.example.admin.bolojie.interfaces.LoadFinishedListenler;

import java.util.List;

/**
 * Created by Admin on 2017/12/12.
 */
public class IndexPresenterImpl implements IndexPresenter,LoadFinishedListenler{
    private  IndexView indexView;
    private IndexModelImpl indexModel;
    public IndexPresenterImpl(IndexView indexView){
        this.indexView=indexView;
        indexModel=new IndexModelImpl();
    }
    @Override
    public void validateCredentials(String tag){
        if(indexView!=null){
            indexView.showProgress();
        }
        indexModel.startLoad(tag,this);
    }

    @Override
    public void onDestroy(){
        indexView=null;
    }
    @Override
    public void onLoadError(String tag,String error){
        if(indexView!=null){
            indexView.hideProgress();
            indexView.loadDataError(tag,error);
        }
    }

    @Override
    public void onLoadSuccess(String tag,List<?> list){
        if(indexView!=null){
            indexView.hideProgress();
            indexView.loadDataSuccess(tag,list);
        }
    }

    @Override
    public void onLoadSuccess(String tag, Data data){
        if(indexView!=null){
            indexView.hideProgress();
            indexView.loadDataSuccess(tag,data);
        }
    }
}
