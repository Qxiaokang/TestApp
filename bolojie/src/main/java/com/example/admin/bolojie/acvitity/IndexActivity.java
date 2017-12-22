package com.example.admin.bolojie.acvitity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.example.admin.bolojie.R;
import com.example.admin.bolojie.adapter.MPagerAdapter;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.bean.Hot;
import com.example.admin.bolojie.bean.NewMessage;
import com.example.admin.bolojie.bean.Recommend;
import com.example.admin.bolojie.bean.TagMessage;
import com.example.admin.bolojie.dialog.AwardDialog;
import com.example.admin.bolojie.dialog.PublishWindow;
import com.example.admin.bolojie.fragment.AttentionFragment;
import com.example.admin.bolojie.fragment.HotFragment;
import com.example.admin.bolojie.fragment.NewFragment;
import com.example.admin.bolojie.fragment.RecommendFragment;
import com.example.admin.bolojie.impl.IndexPresenterImpl;
import com.example.admin.bolojie.interfaces.IndexView;
import com.example.admin.bolojie.util.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexActivity extends BaseActivity implements IndexView,ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, TabLayout.OnTabSelectedListener{
    private AwardDialog awardDialog;
    private List<String> tabs=new ArrayList<String>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MPagerAdapter mPagerAdapter;
    private List<Fragment> fragmentList;
    private RadioGroup  radioGroup;
    private ImageView iv_publish;
    private PublishWindow publishWindow;
    private IndexPresenterImpl indexPresenter;
    private boolean download=false;
    private Map<String,Boolean> map=new HashMap<String,Boolean>();
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    int getContentViewId(){
        return R.layout.activity_index;
    }
    @Override
    void init(){
        viewPager= (ViewPager) findViewById(R.id.in_page);
        radioGroup= (RadioGroup) findViewById(R.id.rg_in);
        tabLayout= (TabLayout) findViewById(R.id.in_tab);
        radioGroup.setOnCheckedChangeListener(this);
        iv_publish= (ImageView) findViewById(R.id.iv_publish);
        iv_publish.setOnClickListener(this);
        awardDialog=new AwardDialog(IndexActivity.this,R.style.MDialog,screenW,screenH);
        awardDialog.show();
        progress=new ProgressDialog(IndexActivity.this,R.style.new_circle_progress);
    }
    private void initTab(){
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        fragmentList=new ArrayList<Fragment>();
        for(int i = 0; i < tabs.size(); i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
            if(i==0){
                fragmentList.add(new NewFragment());
            }else if(i==1){
                fragmentList.add(new AttentionFragment());
            }else if(i==2){
                fragmentList.add(new RecommendFragment());
            }else if(i==3){
                fragmentList.add(new HotFragment());
            }else {
                fragmentList.add(new NewFragment());
            }
        }
        mPagerAdapter=new MPagerAdapter(getSupportFragmentManager(),fragmentList,tabs);
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        indexPresenter=new IndexPresenterImpl(this);
        indexPresenter.validateCredentials(0,"");
    }

    @Override
    protected void onDestroy(){
        if(awardDialog!=null&&awardDialog.isShowing()){
            awardDialog.dismiss();
        }
        // 必须在UI线程中调用
        Glide.get(this).clearMemory();//清除内存缓存
        new ClearCacheThread(getApplicationContext()).start();
        super.onDestroy();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

    }

    @Override
    public void onPageSelected(int position){

    }

    @Override
    public void onPageScrollStateChanged(int state){

    }
    //radioGroup  checkedChanged
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i){
        switch(radioGroup.getCheckedRadioButtonId()){
            case R.id.rb_index:
                break;
            case R.id.rb_user:
                break;
            case R.id.rb_message:
                break;
            case R.id.rb_mine:
                break;
        }
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.iv_living:

                break;
            case R.id.iv_publish:
                publishWindow=new PublishWindow(this,this);
                publishWindow.showPublishWindow(findViewById(R.id.rl_index));
                break;
            case R.id.iv_publish_cancle:
                if(publishWindow!=null&&publishWindow.isShowing()){
                    publishWindow.dismiss();
                }
                break;
            case R.id.iv_video:

                break;
            case R.id.iv_rank:
                break;
            case R.id.iv_search:
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress(){
        if(awardDialog!=null&&!awardDialog.isShowing()&&progress!=null){
            progress.show();
        }
    }

    @Override
    public void hideProgress(){
        if(progress!=null&&progress.isShowing()){
            progress.cancel();
        }
    }
    @Override
    public void loadDataError(int tag,String error){
        LogUtils.e("loadDataError---"+tag);
    }
    @Override
    public void loadDataSuccess(int tag,List<?> list){
        LogUtils.d("loadDataSuccess:"+tag);
        if(tag==0&&!download){
            List<TagMessage.ListBean> tablist = (List<TagMessage.ListBean>) list;
            tabs.clear();
            for(int i = 0; i <tablist.size(); i++){
                tabs.add(tablist.get(i).getName());
                map.put(tablist.get(i).getName(),false);
            }
            initTab();
            indexPresenter.validateCredentials(1,"");
        }
    }
    @Override
    public void loadDataSuccess(int tag, Data data){
        LogUtils.d("loadDataSuccess:"+tag);
        updatePage(tag,data);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab){
        int position=tab.getPosition();
        if(!map.get(tabs.get(position))){
            indexPresenter.validateCredentials(position+1,"");
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab){

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab){

    }
    //更新
    private void updatePage(int tag,Data data){
        if(tag==0){
            return;
        }
        ArrayList<String> list=new ArrayList<String>();
        //最新
        if(tag==1){
            NewMessage newMessage= (NewMessage) data;
            List<NewMessage.BarBean> bar = newMessage.getBar();
            for(int i = 0; i < bar.size(); i++){
                if(i==0){
                    list.add(bar.get(bar.size()-1).getImage());
                }
                list.add(bar.get(i).getImage());
                if(i==bar.size()-1){
                    list.add(bar.get(0).getImage());
                }
            }
            ((NewFragment)fragmentList.get(tag-1)).updateFragment(list,tag,data);
            download=true;
        }
        //关注
        if(tag==2){
            ((AttentionFragment)fragmentList.get(tag-1)).updateFragment(tag,data);
        }
        //推荐
        if(tag==3){
            Recommend recommend= (Recommend) data;
            List<Recommend.BarBean> bar = recommend.getBar();
            for(int i = 0; i < bar.size(); i++){
                if(i==0){
                    list.add(bar.get(bar.size()-1).getImage());
                }
                list.add(bar.get(i).getImage());
                if(i==bar.size()-1){
                    list.add(bar.get(0).getImage());
                }
            }
            ((RecommendFragment)fragmentList.get(tag-1)).updateFragment(list,tag,data);
        }
        //热门
        if(tag==4){
            Hot hot= (Hot) data;
            List<Hot.BarBean> bar = hot.getBar();
            for(int i = 0; i < bar.size(); i++){
                if(i==0){
                    list.add(bar.get(bar.size()-1).getImage());
                }
                list.add(bar.get(i).getImage());
                if(i==bar.size()-1){
                    list.add(bar.get(0).getImage());
                }
            }
            ((HotFragment)fragmentList.get(tag-1)).updateFragment(list,tag,data);
        }
        map.put(tabs.get(tag-1),true);
    }
    public static class ClearCacheThread extends Thread{
        private Context context;
        public ClearCacheThread(Context context){
            this.context=context;
        }
        @Override
        public void run(){
            super.run();
            Glide.get(context).clearDiskCache();//清理磁盘缓存需要在子线程中执行
        }
    }
}
