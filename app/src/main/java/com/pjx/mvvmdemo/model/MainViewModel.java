package com.pjx.mvvmdemo.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.pjx.mvvmdemo.R;
import com.pjx.mvvmdemo.entiry.Student;
import com.xpj.mvvm.mvvmlib.Main.DefaultDataMananger;
import com.xpj.mvvm.mvvmlib.base.IViewModel;

import javax.inject.Inject;

/**
 * @author by xie on 2017/12/28.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */
public class MainViewModel extends IViewModel<DefaultDataMananger> {
    ObservableArrayList<Student> students = new ObservableArrayList<>();
    @Inject
    public MainViewModel() {

        initArrayList("李四", "1", "高一");
    }



    public ObservableArrayList<Student> getStudents() {
        return students;
    }

    public void initArrayList(String name, String age, String grade) {
        students.removeAll(students);
        for (int i = 0; i < 5; i++) {
            students.add(new Student(R.mipmap.ic_launcher,new ObservableField<String>("王五") , "33", "大一"));
        }
    }


    public void onRetryClick() {
      getStudents().get(0).getName().set("呼呼");
    }
}
