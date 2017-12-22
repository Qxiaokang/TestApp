package com.example.admin.bolojie.impl;

import android.os.SystemClock;

import com.example.admin.bolojie.bean.Attention;
import com.example.admin.bolojie.bean.Hot;
import com.example.admin.bolojie.bean.NewMessage;
import com.example.admin.bolojie.bean.Recommend;
import com.example.admin.bolojie.bean.TagMessage;
import com.example.admin.bolojie.bean.UrlContent;
import com.example.admin.bolojie.interfaces.IndexModel;
import com.example.admin.bolojie.interfaces.LoadFinishedListenler;
import com.example.admin.bolojie.interfaces.RetrofitService;
import com.example.admin.bolojie.util.ComUtil;
import com.example.admin.bolojie.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 2017/12/12.
 */
public class IndexModelImpl implements IndexModel{
    private Retrofit retrofit;

    public IndexModelImpl(){
        retrofit = new Retrofit.Builder().baseUrl(UrlContent.BASE_URL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
    }

    //downLoad data
    @Override
    public void startLoad(int tag, LoadFinishedListenler loadFinishedListenler,String url){
        switch(tag){
            case 0:
                donwLoadTags(tag, loadFinishedListenler,url);
                break;
            case 1:
                downLoadNew(tag,loadFinishedListenler,url);
                break;
            case 2:
                downLoadAtt(tag,loadFinishedListenler,url);
                break;
            case 3:
                downLoadRec(tag,loadFinishedListenler,url);
                break;
            case 4:
                downLoadHot(tag,loadFinishedListenler,url);
                break;
            default:
                break;
        }
    }

    //download tags
    private void donwLoadTags(final int tag, final LoadFinishedListenler loadFinishedListenler,String url){
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<TagMessage> call = retrofitService.getTags("6qlype3r51", "3.9", "4.4.4", "1513044998", "59a04ad05e39d1d7f06e7b9be8489ade", "201711151000", "b115d504e0b64f8bdab5ab6ee619adff");
        call.enqueue(new Callback<TagMessage>(){
            @Override
            public void onResponse(Call<TagMessage> call, Response<TagMessage> response){
                LogUtils.d("get Tags success" + response.body().toString());
                TagMessage tagMessage = response.body();
                List<TagMessage.ListBean> list = tagMessage.getList();
                LogUtils.d("tag list size:" + list.size());
                loadFinishedListenler.onLoadSuccess(tag, list);
            }

            @Override
            public void onFailure(Call<TagMessage> call, Throwable t){
                LogUtils.e("get Tags  faild" + t.toString());
                loadFinishedListenler.onLoadError(tag, "Tags下载失败");
            }
        });
    }

    private void downLoadNewPersonMsg(final int tag, final LoadFinishedListenler loadFinishedListenler,String url){
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<NewMessage> call = retrofitService.getNewMsg("ez1gicsyk6", 1, 3.9f, "4.4.4", 9, "1513042749", "59a04ad05e39d1d7f06e7b9be8489ade", "201711151000", "5cff28a44864cf57c84507a5fc5d3699");
        call.enqueue(new Callback<NewMessage>(){
            @Override
            public void onResponse(Call<NewMessage> call, Response<NewMessage> response){
                LogUtils.d("get newMessage success" + response.body().toString());
                NewMessage newMessage = response.body();
                List<NewMessage> list = new ArrayList<NewMessage>();
                list.add(newMessage);
                loadFinishedListenler.onLoadSuccess(tag, list);
            }
            @Override
            public void onFailure(Call<NewMessage> call, Throwable t){
                LogUtils.e("get Tags  faild" + t.toString());
                loadFinishedListenler.onLoadError(tag, "Tags下载失败");
            }
        });
    }
    private void downLoadNew(int tag,LoadFinishedListenler loadFinishedListenler,String url){
        LogUtils.i("load :"+tag);
        SystemClock.sleep(1000);
        String message = ComUtil.downLoadAssets("new_message.json");
        LogUtils.d("get message :"+message);
        Gson gson=new Gson();
        NewMessage newMessage = gson.fromJson(message, NewMessage.class);
        loadFinishedListenler.onLoadSuccess(tag,newMessage);
    }
    private void downLoadAtt(int tag,LoadFinishedListenler loadFinishedListenler,String url){
        LogUtils.i("load :"+tag);
        SystemClock.sleep(1000);
        String message = ComUtil.downLoadAssets("attention.json");
        LogUtils.d("get message:"+message);
        Gson gson=new Gson();
        Attention attention = gson.fromJson(message, Attention.class);
        loadFinishedListenler.onLoadSuccess(tag,attention);
    }
    private void downLoadRec(int tag,LoadFinishedListenler loadFinishedListenler,String url){
        LogUtils.i("load :"+tag);
        SystemClock.sleep(1000);
        String message = ComUtil.downLoadAssets("recommend.json");
        LogUtils.d("get message:"+message);
        Gson gson=new Gson();
        Recommend newMessage = gson.fromJson(message, Recommend.class);
        loadFinishedListenler.onLoadSuccess(tag,newMessage);
    }
    private void downLoadHot(int tag,LoadFinishedListenler loadFinishedListenler,String url){
        LogUtils.i("load :"+tag);
        SystemClock.sleep(1000);
        String message = ComUtil.downLoadAssets("hot.json");
        LogUtils.d("get message:"+message);
        Gson gson=new Gson();
        Hot hot = gson.fromJson(message, Hot.class);
        loadFinishedListenler.onLoadSuccess(tag,hot);
    }
}
