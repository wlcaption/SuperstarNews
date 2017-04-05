package com.hola.superstarnews.module;

import com.hola.superstarnews.module.base.BaseActivity;
import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by Administrator on 2017/4/5.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public void showLoading() {

        //

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError() {

    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return null;
    }
}
