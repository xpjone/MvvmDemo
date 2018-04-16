package com.pjx.mvvmdemo.mvvm;

import android.content.Context;


import com.xpj.mvvm.mvvmlib.model.localdata.Dao;

import javax.inject.Inject;
import javax.inject.Singleton;

import greendao.DaoMaster;
import greendao.DaoSession;

/**
 * @author by xie on 2018/2/24.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */
@Singleton
public class MyDao extends Dao<DaoSession> {
    @Inject
    public MyDao(Context context) {
        super(context);
    }

    @Override
    public DaoSession setupDatabase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, getDBName(), null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        return daoMaster.newSession();
    }
    @Override
    public String getDBName() {
        return "greendao.db";
    }


}
