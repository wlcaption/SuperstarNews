package com.hola.superstarnews;

import android.app.Application;
import android.content.Intent;

import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * Created by Administrator on 2017/4/5.
 */

public class MyApplication extends DefaultApplicationLike {

    public MyApplication(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }
}
