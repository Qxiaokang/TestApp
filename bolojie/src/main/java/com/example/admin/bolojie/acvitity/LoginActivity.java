package com.example.admin.bolojie.acvitity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.util.LogUtils;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**登录页
 * @author Admin
 * */
public class LoginActivity extends BaseActivity implements SurfaceHolder.Callback{
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mp;
    private static final String APP_ID="1106166887";
    private static final String SCOPE ="all";
    private Tencent mTencent;
    private ImageView ivQQ,ivWechat,ivWeiBo,ivPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
        LogUtils.d("屏幕分辨率："+screenH+"*"+screenW+"  密度："+density+"  DPI:"+dpi);
    }

    private void init(){
        surfaceView= (SurfaceView) findViewById(R.id.login_sfv);
        ivWechat= (ImageView) findViewById(R.id.iv_wechat);
        ivWeiBo= (ImageView) findViewById(R.id.iv_weibo);
        ivQQ= (ImageView) findViewById(R.id.iv_qq);
        ivPhone= (ImageView) findViewById(R.id.iv_phone);
        mp=MediaPlayer.create(this,R.raw.login);
        surfaceHolder=surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        ivWechat.setOnClickListener(onClickListener);
        ivWeiBo.setOnClickListener(onClickListener);
        ivQQ.setOnClickListener(onClickListener);
        ivPhone.setOnClickListener(onClickListener);
    }

    @Override
    int getContentViewId(){
        return R.layout.activity_login;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){
        if(mp!=null){
            mp.setDisplay(surfaceHolder);
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setLooping(true);//循环
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mediaPlayer){
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }
            });
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2){
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
    }

    @Override
    protected void onDestroy(){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp=null;
        }
        super.onDestroy();
    }
    private void loginByQQ(){
        mTencent=Tencent.createInstance(APP_ID,LoginActivity.this.getApplicationContext());
        if(!mTencent.isSessionValid()){
            mTencent.login(this,SCOPE,iUiListener);
        }
    }
    IUiListener iUiListener=new IUiListener(){
        @Override
        public void onComplete(Object o){
            LogUtils.d("object:"+o.toString());
            initOpenIdAndToken((JSONObject)o);
        }

        @Override
        public void onError(UiError uiError){
            LogUtils.e("授权出错："+uiError.toString());
        }

        @Override
        public void onCancel(){
        }
    };
    View.OnClickListener onClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.iv_wechat:
                    break;
                case R.id.iv_weibo:
                    break;
                case R.id.iv_qq:
                    LogUtils.d("login by qq");
                    loginByQQ();
                    break;
                case R.id.iv_phone:
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Tencent.onActivityResultData(requestCode,resultCode,data,iUiListener);
    }
    private void initOpenIdAndToken(JSONObject jsonObject){
        try{
            String openId=jsonObject.getString("openid");
            String access_token = jsonObject.getString("access_token");
            String expires_in = jsonObject.getString("expires_in");
            mTencent.setOpenId(openId);
            mTencent.setAccessToken(access_token,expires_in);
            getUserInfo();
        }catch(JSONException e){
            LogUtils.e("getOpenIdAndToken   faild");
            //e.printStackTrace();
        }
    }
    //获取用户信息
    private void getUserInfo(){
        UserInfo userInfo=new UserInfo(this,mTencent.getQQToken());
        userInfo.getUserInfo(new IUiListener(){
            @Override
            public void onComplete(Object o){
                LogUtils.d("get UserInfo ="+o.toString());
            }

            @Override
            public void onError(UiError uiError){
                LogUtils.e("get userInfo faild:"+uiError.toString());
            }

            @Override
            public void onCancel(){
            }
        });
    }
}
