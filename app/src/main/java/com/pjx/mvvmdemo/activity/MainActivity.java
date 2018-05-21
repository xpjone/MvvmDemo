package com.pjx.mvvmdemo.activity;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.net.Uri;
import android.view.View;
import android.widget.MediaController;

import com.pjx.mvvmdemo.R;
import com.pjx.mvvmdemo.databinding.ActivityMainBinding;
import com.pjx.mvvmdemo.databinding.ItemListBinding;
import com.pjx.mvvmdemo.entiry.Student;
import com.pjx.mvvmdemo.model.MainViewModel;
import com.pjx.mvvmdemo.mvvm.DaggerBaseComponent;
import com.pjx.mvvmdemo.view.MainDialog;
import com.xpj.mvvm.mvvmlib.base.BaseActvity;
import com.xpj.mvvm.mvvmlib.base.MvvmBaseAdapter;
import com.xpj.mvvm.mvvmlib.dragger.BaseModule;

import cn.jzvd.JZVideoPlayer;

public class MainActivity extends BaseActvity<ActivityMainBinding, MainViewModel>{
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
        activityMainBinding.videoplayer.setUp("http://10.1.186.48:1804/v1/file/stream?url=/upload/%E6%89%A7%E6%B3%95%E5%AF%B9%E8%B1%A1%E4%BA%B2%E5%8F%8B%E9%98%BB%E7%A2%8D%E6%89%A7%E6%B3%95_1526029759783.mp4",true,"测试");
        /**
         * 将控制器和播放器进行互相关联
         */
        MediaController controller = new MediaController(this);//实例化控制器
        activityMainBinding.myvideoplayer.setVideoURI(Uri.parse("http://10.1.186.12:8090/police/video/%E5%AF%B9%E8%BE%B1%E9%AA%82%EF%BC%8C%E6%9A%B4%E5%8A%9B%E9%98%BB%E7%A2%8D%E6%89%A7%E6%B3%95%E7%9A%84%E5%A4%84%E7%BD%AE.mp4"));
        controller.setMediaPlayer(  activityMainBinding.myvideoplayer);
        activityMainBinding.myvideoplayer.setMediaController(controller);
        activityMainBinding.myvideoplayer.start();
        //activityMainBinding.jzvideoplayer
        activityMainBinding.jzplayer.setUp("http://10.1.186.12:8090/police/video/%E5%AF%B9%E8%BE%B1%E9%AA%82%EF%BC%8C%E6%9A%B4%E5%8A%9B%E9%98%BB%E7%A2%8D%E6%89%A7%E6%B3%95%E7%9A%84%E5%A4%84%E7%BD%AE.mp4", JZVideoPlayer.SCREEN_WINDOW_LIST, "");
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
