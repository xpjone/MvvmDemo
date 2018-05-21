package com.pjx.mvvmdemo.entiry;


import android.databinding.ObservableField;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author by xie on 2017/12/28.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */

public class Student {
    public Student( int icon, ObservableField<String> name, String age, String grade) {
        this.icon = icon;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int icon;
    public ObservableField<String> name;
    public String age;
    public String grade;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}
