package com.pjx.mvvmdemo.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import com.pjx.mvvmdemo.mvvm.MyDataMananger;
import com.xpj.mvvm.mvvmlib.base.IViewModel;

import javax.inject.Inject;

/**
 * @author by xie on 2018/2/24.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */

public class TextModel extends IViewModel<MyDataMananger> {
    public ObservableField<String> title=new ObservableField<>("开始");
    public ObservableArrayList<String> strings=new ObservableArrayList<>();
    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableArrayList<String> getStrings() {
        return strings;
    }

    @Inject
    public TextModel() {
        for (int i = 0; i < 10; i++) {
            strings.add("haha"+i);
        }

    }

    public void insertData() {
        getDataMananger().insertTeacher();
    }

    public String getContent() {
        return getDataMananger().getTextActivityContent();
    }

}
