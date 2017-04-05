package com.hola.superstarnews.module.base;

import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by Administrator on 2017/4/5.
 */

public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示网络错误
     */
    void showNetError();

    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
    <T>LifecycleTransformer<T> bindToLife();

    /**
     * 完成刷新，新增控制刷新
     */
    void finishRefresh();
}
