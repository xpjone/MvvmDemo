package com.pjx.mvvmdemo.mvvm;

import com.pjx.mvvmdemo.activity.MainActivity;
import com.pjx.mvvmdemo.activity.TextActivity;
import com.xpj.mvvm.mvvmlib.dragger.ActivityScope;
import com.xpj.mvvm.mvvmlib.dragger.BaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建者 by xie on 2017/8/22.
 * 更新者：
 * 更新时间：
 * 功能描述：
 */
@ActivityScope
@Singleton
@Component(modules = BaseModule.class)
public interface BaseComponent {
    void inject(MainActivity mainActivity);
    void inject(TextActivity textActivity);
}
