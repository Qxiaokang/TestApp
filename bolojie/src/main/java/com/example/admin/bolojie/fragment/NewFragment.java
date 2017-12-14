package com.example.admin.bolojie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.adapter.ImagePageAdapter;
import com.example.admin.bolojie.adapter.RecycleAdapter;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.view.PageIndexView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class NewFragment extends Fragment implements ViewPager.OnPageChangeListener{
    private ViewPager topPage;
    private PageIndexView pageIndexView;
    private List<String> listUrl=new ArrayList<String>();
    private boolean  isDownload=false;
    private ImagePageAdapter imagePageAdapter;
    private RecyclerView recyclerView;
    private int currentPosition;
    private static final int First_Page=1;
    private Timer timer;
    private TimerTask timerTask;
    public NewFragment(){
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new, container, false);
        topPage= (ViewPager) view.findViewById(R.id.top_page);
        pageIndexView= (PageIndexView) view.findViewById(R.id.page_index);
        recyclerView= (RecyclerView) view.findViewById(R.id.new_recycle);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

    }
    @Override
    public void onPageSelected(int position){
        if(position==listUrl.size()-1){
            currentPosition=First_Page;
        }else if(position==0){
            currentPosition= listUrl.size()-2;
        }else {
            currentPosition=position;
        }
        if(isDownload){
            pageIndexView.setCurrIndex(currentPosition-1);
        }
        if(currentPosition!=position){
            topPage.setCurrentItem(currentPosition);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state){

    }
    public void updateFragment(List<String> list, String tag, Data data){
        if(list!=null){
            this.listUrl=list;
        }
        if(list!=null&&list.size()>2){
            pageIndexView.setCount(listUrl.size()-2);
        }
        imagePageAdapter=new ImagePageAdapter(getContext(),listUrl);
        topPage.setAdapter(imagePageAdapter);
        topPage.addOnPageChangeListener(this);
        topPage.setCurrentItem(First_Page);
        startTimer();
        isDownload=true;
        initRecycle(getContext(),tag,data);
    }
    private void initRecycle(Context context,String tag,Data data){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        gridLayoutManager.setAutoMeasureEnabled(true);
        RecycleAdapter recycleAdapter=new RecycleAdapter(context,data,tag);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleAdapter);
    }
    private void startTimer(){
        timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                handler.sendEmptyMessage(0);
            }
        },0, 2000);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case 0:
                    topPage.setCurrentItem(currentPosition+1);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    public void onDestroy(){
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
        super.onDestroy();
    }
}
