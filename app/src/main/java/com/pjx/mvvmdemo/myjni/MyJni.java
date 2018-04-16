package com.pjx.mvvmdemo.myjni;

/**
 * @author by xie on 2018/3/27.
 *         更新者：
 *         更新时间：
 *         功能描述：
 */

public class MyJni {
    static {
        System.loadLibrary("MyJni");
    }
    public native static String getString();
}
