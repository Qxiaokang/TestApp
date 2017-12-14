package com.example.admin.bolojie.acvitity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.adapter.MPagerAdapter;
import com.example.admin.bolojie.bean.Data;
import com.example.admin.bolojie.bean.NewMessage;
import com.example.admin.bolojie.bean.TagMessage;
import com.example.admin.bolojie.dialog.AwardDialog;
import com.example.admin.bolojie.dialog.PublishWindow;
import com.example.admin.bolojie.fragment.AttentionFragment;
import com.example.admin.bolojie.fragment.NewFragment;
import com.example.admin.bolojie.impl.IndexPresenterImpl;
import com.example.admin.bolojie.interfaces.IndexView;
import com.example.admin.bolojie.util.LogUtils;

import java.util.ArrayList;
import java.util.List;


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
    }
    private void initTab(){
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        fragmentList=new ArrayList<Fragment>();
        for(int i = 0; i < tabs.size(); i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabs.get(i)));
            if(i==0){
                fragmentList.add(new NewFragment());
            }else {
                fragmentList.add(new AttentionFragment());
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
        indexPresenter.validateCredentials("tab");
    }

    @Override
    protected void onDestroy(){
        if(awardDialog!=null&&awardDialog.isShowing()){
            awardDialog.dismiss();
        }
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

    }

    @Override
    public void hideProgress(){

    }
    @Override
    public void loadDataError(String tag,String error){
        LogUtils.e("loadDataError---"+tag);
    }
    @Override
    public void loadDataSuccess(String tag,List<?> list){
        LogUtils.d("loadDataSuccess:"+tag);
        if(tag!=null&&"tab".equals(tag)&&!download){
            List<TagMessage.ListBean> tablist = (List<TagMessage.ListBean>) list;
            tabs.clear();
            for(int i = 0; i <tablist.size(); i++){
                tabs.add(tablist.get(i).getName());
            }
            initTab();
            indexPresenter.validateCredentials("new");
        }
    }
    @Override
    public void loadDataSuccess(String tag, Data data){
        LogUtils.d("loadDataSuccess:"+tag);
        if("new".equals(tag)){
            updateNew(tag,data);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab){
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab){

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab){

    }
    //更新tab1
    private void updateNew(String tag,Data data){
        NewMessage newMessage= (NewMessage) data;
        List<NewMessage.BarBean> bar = newMessage.getBar();
        ArrayList<String> list=new ArrayList<String>();
        for(int i = 0; i < bar.size(); i++){
            if(i==0){
                list.add(bar.get(bar.size()-1).getImage());
            }
            list.add(bar.get(i).getImage());
            if(i==bar.size()-1){
                list.add(bar.get(0).getImage());
            }
        }
        download=true;
        ((NewFragment)fragmentList.get(0)).updateFragment(list,tag,data);
    }
}
