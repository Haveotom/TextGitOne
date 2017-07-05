package com.cnea.textgitone;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * author: Jing
 * date: 2017/6/23.
 */

public class JavaScriptObject {
    Context mContext;

    public JavaScriptObject(Context context) {
        this.mContext = context;
    }

    public void fun1FromAndroid(String name) {
        Log.d("JavaScriptObject", name);
    }

    public void fun2(String name2) {
        Log.d("JavaScriptObject", "调用fun2:::" + name2);
    }

    @JavascriptInterface
    public String toString() {
        return "myObj";
    }
}
