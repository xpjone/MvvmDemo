package com.pjx.mvvmdemo.activity;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.View;
import com.pjx.mvvmdemo.entiry.Student;
import com.pjx.mvvmdemo.model.MainViewModel;
import com.pjx.mvvmdemo.mvvm.DaggerBaseComponent;
import com.pjx.mvvmdemo.mvvmapplication.R;
import com.pjx.mvvmdemo.mvvmapplication.databinding.ActivityMainBinding;
import com.pjx.mvvmdemo.mvvmapplication.databinding.ItemListBinding;
import com.pjx.mvvmdemo.view.MainDialog;
import com.xpj.mvvm.mvvmlib.base.BaseActvity;
import com.xpj.mvvm.mvvmlib.base.MvvmBaseAdapter;
import com.xpj.mvvm.mvvmlib.dragger.BaseModule;

public class MainActivity extends BaseActvity<ActivityMainBinding, MainViewModel> {
    MainAdapter mainAdapter;

    @Override
    protected void bindViewAndsetModel(ActivityMainBinding activityMainBinding) {

        activityMainBinding.setMainviewmodel(getVModle());
        activityMainBinding.btRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVModle().onRetryClick();
                MainDialog mainDialog = new MainDialog(getVModle());
                mainDialog.show(getFragmentManager(), MainActivity.class.getSimpleName());
            }
        });
        mainAdapter = new MainAdapter(getVModle().getStudents(), this);
        activityMainBinding.list.setAdapter(mainAdapter);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDragger() {
        DaggerBaseComponent.builder().baseModule(new BaseModule(this)).build().inject(this);
    }

    public class MainAdapter extends MvvmBaseAdapter<Student, ItemListBinding> {

        public MainAdapter(ObservableArrayList<Student> datas, Context context) {
            super(datas, context);
        }

        @Override
        public void bindView(ItemListBinding itemListBinding, int position) {
            itemListBinding.setMainviewmodel(getVModle());
            itemListBinding.setPosition(position);
        }

        @Override
        public int getItemLayoutId() {
            return R.layout.item_list;
        }
    }
}
