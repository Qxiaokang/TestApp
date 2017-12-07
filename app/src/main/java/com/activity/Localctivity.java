package com.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.util.ComUtil;
import com.util.LogUtils;
import com.util.MainApplication;

import java.util.Arrays;

public class Localctivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    private Button button = null;
    private EditText et = null;
    private ImageView iv = null;
    String str = "测试（）**123民789///&^$@#!456";
    private Bitmap bitmap = null;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LogUtils.i("local---onCreate");
        initViews();
    }

    private void initViews(){
        et = (EditText) findViewById(R.id.et_text);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        iv = (ImageView) findViewById(R.id.iv_product);
        button = (Button) findViewById(R.id.to_tab);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        navigationView= (NavigationView) findViewById(R.id.nv_list);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        iv= (ImageView) headerView.findViewById(R.id.iv_admin);
        iv.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Localctivity.this, MainActivity.class);
                startActivity(intent);
                ComUtil.showToast(getApplicationContext(),"SDK_INT："+Build.VERSION.SDK_INT);
            }
        });
    }

    @Override
    protected void onDestroy(){
        if(bitmap != null){
            bitmap.recycle();
            bitmap = null;
        }
        super.onDestroy();
        LogUtils.e("local---onDestroy");
    }

    @Override
    protected int getLayoutId(){
        return R.layout.activity_localctivity;
    }

    @Override
    protected void onResume(){
        super.onResume();
        LogUtils.w("Activities:" + Arrays.toString(MainApplication.getInstance().getActivityList().toArray()));
    }

    private boolean checkIsDetected(){
        boolean b = false;
        FingerprintManager finger = ComUtil.getFinger(getApplicationContext());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED){
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                b = finger.isHardwareDetected();
            }
        }
        return b;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        LogUtils.i("itemselected:"+item.getItemId());
        Intent intent=null;
        item.setCheckable(true);
        item.setChecked(true);
        switch(item.getItemId()){
            case R.id.menu1:
                intent=new Intent(Localctivity.this,MainActivity.class);
                break;
            case R.id.menu2:

                break;
            case R.id.menu3:
                intent=new Intent(Localctivity.this,CameraActivity.class);
                break;
            case R.id.menu4:

                break;
            case R.id.menu5:
                intent=new Intent(Localctivity.this,LiveActivity.class);
                break;
        }
        drawerLayout.closeDrawers();
        if(intent!=null){
            Localctivity.this.startActivity(intent);
        }
        return true;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.iv_admin:
                ComUtil.showToast(getApplicationContext(),"用户未登录");
                drawerLayout.closeDrawers();
                break;
            default:
                break;
        }
    }
}
