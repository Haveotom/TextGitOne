package com.cnea.textgitone;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * author: Jing
 * date: 2017/6/23.
 */

public class WebViewAty extends AppCompatActivity {

    private WebView mWebView;
    private WebSettings mWebSettings;
    private String mString;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_webview);
        mWebView = (WebView) findViewById(R.id._webview);
        mWebSettings = mWebView.getSettings();
        //设置与JS交互的权限
        mWebSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("file:///android_asset/wst.html");
        //要对webview绑定javascriptInterface，js脚本通过这个接口来调用java代码。
        mWebView.addJavascriptInterface(this, "wst");
//        showWebView();
        mWebView.evaluateJavascript("javascript:javacalljs()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                Log.d("WebViewAty", s);
                mString = s;
            }
        });

    }

    private void showWebView() {
        //允许js弹窗
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        /**
         * 方法一:
         */
        /**
         * 注意:必须另开线程进行JS方法的调用
         */
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//                mWebView.post(new Runnable() {
//                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//                    @Override
//                    public void run() {
//                        /**
//                         * 注意方法名要对应
//                         * 调用js中的方法
//                         */
//
//                        int VERSION = Build.VERSION.SDK_INT;
//                        if (VERSION < 18) {
//                            mWebView.loadUrl("javascript:callJS()");
//
//                        } else {
//                            mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
//                                @Override
//                                public void onReceiveValue(String s) {
//                                    Log.d("WebViewAty", "return s===" + s);
//                                }
//                            });
//                        }
//
//
//                    }
//                });
//
//            }
//        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.d("WebViewAty", "message===" + message);
                Log.d("WebViewAty", "url===" + url);
                Log.d("WebViewAty", "result:" + result);
                return true;

            }
        });


    }

    public void startFunction() {

        Toast.makeText(this, "这是点击了吧", Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("WebViewAty","我来了吗==="+ mString);
            }
        });
    }
}
