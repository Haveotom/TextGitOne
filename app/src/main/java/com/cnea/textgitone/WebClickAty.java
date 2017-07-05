package com.cnea.textgitone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * author: Jing
 * date: 2017/6/23.
 */

public class WebClickAty extends AppCompatActivity {

    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_webclick);
        mWebView = (WebView) findViewById(R.id.webclick_wv);

//        mWebSettings = mWebView.getSettings();
        //设置编码
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        //设置本地调用对象及其接口
        mWebView.addJavascriptInterface(new JavaScriptObject(this), "myObj");
        //载入JS
        mWebView.loadUrl("file:///android_asset/js_click.html");
        //点击调用js中的方法
        findViewById(R.id.webclick_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView.loadUrl("javascript:funFromJs()");
                Toast.makeText(WebClickAty.this, "调用javascript:funFromJs()", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
