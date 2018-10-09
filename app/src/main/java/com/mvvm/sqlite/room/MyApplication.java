package com.mvvm.sqlite.room;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.mvvm.sqlite.room.databinding.AppDataBindingComponent;

public class MyApplication extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
