package com.pjx.mvvmdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.widget.AdapterView;
import com.pjx.mvvmdemo.model.TextModel;
import com.pjx.mvvmdemo.mvvm.DaggerBaseComponent;
import com.pjx.mvvmdemo.mvvmapplication.R;
import com.pjx.mvvmdemo.mvvmapplication.databinding.ActivityTextBinding;
import com.pjx.mvvmdemo.mvvmapplication.databinding.ItemTextBinding;
import com.pjx.mvvmdemo.myjni.MyJni;
import com.xpj.mvvm.mvvmlib.base.BaseActvity;
import com.xpj.mvvm.mvvmlib.base.MvvmBaseAdapter;
import com.xpj.mvvm.mvvmlib.dragger.BaseModule;
public class TextActivity extends BaseActvity<ActivityTextBinding, TextModel> {
    VideoAdapter videoAdapter;
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void bindViewAndsetModel(final ActivityTextBinding viewDataBinding) {
        viewDataBinding.setViewmodel(getVModle());
        getVModle().title.set(MyJni.getString());
        viewDataBinding.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVModle().insertData();
                viewDataBinding.content.setText(getVModle().getContent());
                startActivity(new Intent(TextActivity.this, MainActivity.class));
            }
        });
        videoAdapter=new VideoAdapter(getVModle().strings, TextActivity.this);
        viewDataBinding.videolist.setAdapter(videoAdapter);
        viewDataBinding.videolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(TextActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text;
    }

    @Override
    protected void initDragger() {
        DaggerBaseComponent.builder().baseModule(new BaseModule(this)).build().inject(this);
    }

    private class VideoAdapter extends MvvmBaseAdapter<String,ItemTextBinding> {

        public VideoAdapter(ObservableArrayList<String> datas, Context context) {
            super(datas, context);
        }

        @Override
        public void bindView(final ItemTextBinding itemVideoBinding, int position) {
          itemVideoBinding.setViewmodel(getVModle());
          itemVideoBinding.setPosition(position);
        }

        @Override
        public int getItemLayoutId() {
            return R.layout.item_text;
        }
    }
}
