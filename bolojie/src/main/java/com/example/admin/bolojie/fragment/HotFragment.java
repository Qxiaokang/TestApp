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
import com.example.admin.bolojie.adapter.HotLivingAdapter;
import com.example.admin.bolojie.adapter.ImagePageAdapter;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.bean.Hot;
import com.example.admin.bolojie.bean.Living;
import com.example.admin.bolojie.interfaces.MultiItemTypeSupport;
import com.example.admin.bolojie.util.LogUtils;
import com.example.admin.bolojie.view.PageIndexView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**

 */
public class HotFragment extends Fragment implements ViewPager.OnPageChangeListener{
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
    private Data data;
    private int tag;
    private int livePosition;
    public static  final int TYPE_TOP=1,TYPE_BOT=2;
    public HotFragment(){
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.layout_hot, container, false);
        topPage= (ViewPager) view.findViewById(R.id.top_page);
        pageIndexView= (PageIndexView) view.findViewById(R.id.page_index);
        recyclerView= (RecyclerView) view.findViewById(R.id.hot_recycle);
        LogUtils.w("---HotFragment---onCreateView---");
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        LogUtils.w("---HotFragment---onStart---");
    }

    @Override
    public void onResume(){
        super.onResume();
        LogUtils.w("---HotFragment---onResume---");
    }

    @Override
    public void onPause(){
        super.onPause();
        LogUtils.w("---HotFragment---onPause---");
    }

    @Override
    public void onStop(){
        super.onStop();
        LogUtils.w("---HotFragment---onStop---");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

    }
    @Override
    public void onPageSelected(int position){
        if(listUrl.size()>0){
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
    }

    @Override
    public void onPageScrollStateChanged(int state){

    }
    public void updateFragment(List<String> list, int tag, Data data){
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
        updateMore(getContext(),tag,data);
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
        LogUtils.w("---HotFragment---onDestroy---");
    }
    private void updateMore(Context context,int tag,Data data){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
        gridLayoutManager.setAutoMeasureEnabled(true);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position){
                int type=recyclerView.getAdapter().getItemViewType(position);
                return type==TYPE_TOP?2:1;
            }
        });
        List<Living> livings=new ArrayList<Living>();
        Hot hot= (Hot) data;
        List<Hot.ListBean> list = hot.getList();
        for(int i = 0; i < list.size(); i++){
            if(i==0){
                livings=list.get(i).getLivelist();
                livePosition=livings.size()-1;
                LogUtils.d("livePosition:"+livePosition);
            }
            if(i!=0){
                livings.addAll(list.get(i).getLivelist());
            }
        }
        HotLivingAdapter hotLivingAdapter=new HotLivingAdapter(context, livePosition, livings, new MultiItemTypeSupport(){
            @Override
            public int getLayoutId(int itemType){
                if(itemType==TYPE_BOT){
                    return R.layout.att_item;
                }
                return R.layout.hot_item;
            }
            @Override
            public int getItemViewType(int position, Object o){
                if(position>=livePosition){
                   return TYPE_BOT;
                }
                return TYPE_TOP;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(hotLivingAdapter);
    }
}
