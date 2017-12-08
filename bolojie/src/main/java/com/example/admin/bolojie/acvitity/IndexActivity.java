package com.example.admin.bolojie.acvitity;

import android.os.Bundle;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.dialog.AwardDialog;

public class IndexActivity extends BaseActivity{
    private AwardDialog awardDialog;
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
        awardDialog=new AwardDialog(IndexActivity.this);
        awardDialog.show();
    }
    @Override
    protected void onDestroy(){
        if(awardDialog!=null&&awardDialog.isShowing()){
            awardDialog.dismiss();
        }
        super.onDestroy();
    }
}
