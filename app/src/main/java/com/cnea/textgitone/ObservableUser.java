package com.cnea.textgitone;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Administrator on 2017/6/20.
 */

public class ObservableUser extends BaseObservable {
    private String name;
    private String alias;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAlias() {
        return alias;
    }

    public void setName(String name) {
        this.name = name;
//        notifyPropertyChanged(BR.name);
    }


    public void setAlias(String alias) {
        this.alias = alias;
//        notifyPropertyChanged(BR.alias);
    }
}
