package com.pjx.mvvmdemo.mvvm;


import com.pjx.mvvmdemo.entiry.Teacher;
import com.xpj.mvvm.mvvmlib.model.DataMananger;
import com.xpj.mvvm.mvvmlib.retrofit.HttpRetrofitUtil;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author by xie on 2018/2/24.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */
@Singleton
public class MyDataMananger extends DataMananger<HttpRetrofitUtil, MyDao> {
    @Inject
    public MyDataMananger() {
    }

    public void insertTeacher(){
       getDao().insertOrReplace(new Teacher(1,"张三","25"));
    }
    public String getTextActivityContent() {
        List<Teacher> teachers =  getDao().queryClass(Teacher.class);
        return teachers.get(0).getName();
    }
}
