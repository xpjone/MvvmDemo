package com.pjx.mvvmdemo.view;

import android.annotation.SuppressLint;

import com.pjx.mvvmdemo.R;
import com.pjx.mvvmdemo.model.MainViewModel;
import com.xpj.mvvm.mvvmlib.base.BaseDialogFragment;
import com.pjx.mvvmdemo.databinding.DialogMainBinding;
/**
 * @author by xie on 2018/3/2.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */

@SuppressLint("ValidFragment")
public class MainDialog extends BaseDialogFragment<DialogMainBinding, MainViewModel> {

    public MainDialog(MainViewModel mainViewModel) {
        super(mainViewModel);
    }

    @Override
    public void bindView(DialogMainBinding vd) {
        vd.setMainviewmodel(getVModle());
        setSize(100, 100);
    }

    @Override
    public int getFragmentId() {
        return R.layout.dialog_main;
    }
}
