package com.example.admin.bolojie.acvitity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.bolojie.R;
import com.example.admin.bolojie.bean.UrlContent;
import com.example.admin.bolojie.util.LogUtils;

/**
 * 用户协议页面
 *
 * @author Admin
 */
public class ProtocolActivity extends BaseActivity implements View.OnClickListener{
    private ImageView ivBack;
    private TextView tvTitle;
    private WebView wbProtocol;
    private ProgressBar progressBar;
    private View vLine;
    private LinearLayout llTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    //初始化
    @Override
    void init(){
        ivBack = (ImageView) findViewById(R.id.iv_protocol_back);
        tvTitle = (TextView) findViewById(R.id.tv_protocol_title);
        progressBar = (ProgressBar) findViewById(R.id.pb_protocol);
        llTitle= (LinearLayout) findViewById(R.id.ll_title);
        vLine=findViewById(R.id.v_line);
        ivBack.setOnClickListener(this);
        initWebView();
    }
    //加载webview
    private void initWebView(){
        wbProtocol = (WebView) findViewById(R.id.wb_protocol);
        wbProtocol.getSettings().setJavaScriptEnabled(true);
        wbProtocol.requestFocus();
        wbProtocol.setWebViewClient(webViewClient);
        wbProtocol.setWebChromeClient(new MChromeClient());
        wbProtocol.loadUrl(UrlContent.protocol);
    }
    //更新进度
    class MChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress){
            super.onProgressChanged(view, newProgress);
            LogUtils.i("newProgress:"+newProgress);
            progressBar.setProgress(newProgress);
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case 0:
                    progressBar.setProgress(0);
                    break;
                default:
                    break;
            }
        }
    };
    WebViewClient webViewClient = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
            LogUtils.d("shouldOverrideUrlLoading---");
            //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
            //return super.shouldOverrideUrlLoading(view, request);
            wbProtocol.loadUrl(UrlContent.protocol);
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);
            progressBar.setProgress(0);
        }

        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
            LogUtils.d("web  title:"+view.getTitle());
            tvTitle.setText(view.getTitle());
            progressBar.setVisibility(View.GONE);
            llTitle.setBackgroundColor(Color.GRAY);
            vLine.setVisibility(View.VISIBLE);
        }
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error){
            super.onReceivedError(view, request, error);
            LogUtils.e("webView  loadError");
            progressBar.setVisibility(View.GONE);
            llTitle.setBackgroundColor(Color.GRAY);
            tvTitle.setText("加载失败");
        }
    };
    DownloadListener downloadListener = new DownloadListener(){
        @Override
        public void onDownloadStart(String s, String s1, String s2, String s3, long l){
            LogUtils.d("web  downLoadStart");
        }
    };
    @Override
    int getContentViewId(){
        return R.layout.activity_protocol;
    }

    @Override
    public void onClick(View view){
        ProtocolActivity.this.finish();
    }
}
