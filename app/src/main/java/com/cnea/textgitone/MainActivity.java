package com.cnea.textgitone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * b2来喽
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,DataAty.class));
        /**
         * 这里就是我在jing_b1时候的改变
         */
        /**
         * 再改变一次
         */
        init();
        initA();

    }

    private void initA() {
        
    }

    private void init() {
        /**
         * 这可就是一个比较大的改动啊
         */
    }


}
