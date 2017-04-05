package com.hola.superstarnews.module.base;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2017/4/5.
 */

public abstract class BaseActivity <T extends IBasePresenter> extends RxAppCompatActivity implements IBaseView {

}
