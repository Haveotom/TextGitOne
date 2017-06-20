package com.cnea.textgitone;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cnea.textgitone.databinding.AtyDataBinding;


/**
 * Created by Administrator on 2017/6/20.
 */

public class DataAty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_data);
        AtyDataBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.aty_data);
        User user = new User("牛儿", 18, "北京");
        dataBinding.setJing(user);

        dataBinding.dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DataAty", "好的");
            }
        });
    }
}
