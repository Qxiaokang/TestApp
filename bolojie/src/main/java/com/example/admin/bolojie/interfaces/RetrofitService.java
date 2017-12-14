package com.example.admin.bolojie.interfaces;

import com.example.admin.bolojie.bean.NewMessage;
import com.example.admin.bolojie.bean.TagMessage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 2017/12/12.
 */
public interface RetrofitService{
    @GET("home/get_tag")
    Call<TagMessage> getTags(
        @Query("nonce") String nonce,
        @Query("publickey") String publickey,
        @Query("sys_ver") String sys_ver,
        @Query("timestamp") String timestamp,
        @Query("token") String token,
        @Query("ver") String ver,
        @Query("signature") String signature
    );
    @GET("home/get_single")
    Call<NewMessage> getNewMsg(
        @Query("nonce") String nonce,
        @Query("pageindex") int pageindex,
        @Query("publickey") float publickey,
        @Query("sys_ver") String sys_ver,
        @Query("tag_id") int tag_id,
        @Query("timestamp") String timestamp,
        @Query("token") String token,
        @Query("ver") String ver,
        @Query("signature") String signature
    );
}
