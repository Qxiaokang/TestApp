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
import com.example.admin.bolojie.dialog.AwardDialog;
import com.example.admin.bolojie.dialog.PublishWindow;
import com.example.admin.bolojie.fragment.AttentionFragment;
import com.example.admin.bolojie.fragment.NewFragment;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener{
    private AwardDialog awardDialog;
    private String [] tabs=new String[]{"最新","关注","推荐","热门","附近","小视频","家族"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MPagerAdapter mPagerAdapter;
    private List<Fragment> fragmentList;
    private RadioGroup  radioGroup;
    private ImageView iv_publish;
    private PublishWindow publishWindow;
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
        radioGroup.setOnCheckedChangeListener(this);
        iv_publish= (ImageView) findViewById(R.id.iv_publish);
        iv_publish.setOnClickListener(this);
        initTab();
        awardDialog=new AwardDialog(IndexActivity.this,R.style.MDialog,screenW,screenH);
        awardDialog.show();
    }

    private void initTab(){
        tabLayout= (TabLayout) findViewById(R.id.in_tab);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        fragmentList=new ArrayList<Fragment>();
        for(int i = 0; i < tabs.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
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
            default:
                break;
        }
    }
}
