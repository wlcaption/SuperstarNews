package com.hola.superstarnews.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.hola.superstarnews.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/6.
 */

public class EmptyLayout extends FrameLayout {

    public static final int STATUS_HIDE = 1001;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NET = 2;
    public static final int STATUS_NO_DATA = 3;
    private Context mContext;
    private OnRetryListener mOnRetryListener;
    private int mEmptyStatus = STATUS_LOADING;
    private int mBgColor;

    @BindView(R.id.tv_net_error)
    TextView mTvEmptyMessage;
    @BindView(R.id.rl_empty_container)
    View mRlEmptyContainer;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.empty_loading)
    SpinKitView mEmptyLoading;



    public EmptyLayout(@NonNull Context context) {
        super(context,null);
    }

    public EmptyLayout(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        this.mContext = context;
        init(attributeSet);
    }

    /**
     * 初始化布局
     * @param attributeSet
     */
    private void init(AttributeSet attributeSet) {
        TypedArray a = mContext.obtainStyledAttributes(attributeSet,R.styleable.EmptyLayout);
        try {
            mBgColor = a.getColor(R.styleable.EmptyLayout_background_color, Color.WHITE);
        }finally {
            a.recycle();
        }
        View.inflate(mContext, R.layout.layout_empty_loading,this);
        ButterKnife.bind(this);
        mEmptyLayout.setBackgroundColor(mBgColor);
        _switchEmptyView();
    }

    /**
     * 隐藏视图
     */
    public void hide(){
        mEmptyStatus = STATUS_HIDE;
        _switchEmptyView();
    }

    /**
     * 设置状态
     * @param emptyStatus
     */
    public void setEmptyStatus(@EmptyStatus int emptyStatus){
        mEmptyStatus = emptyStatus;
        _switchEmptyView();
    }

    /**
     * 获取状态
     * @return 状态
     */
    public int getEmptyStatus(){
        return mEmptyStatus;
    }

    /**
     * 设置异常消息
     * @param msg
     */
    public void setEmptyMessage(String msg){
        mTvEmptyMessage.setText(msg);
    }

    public void hideErrorIcon(){
        mTvEmptyMessage.setCompoundDrawables(null,null,null,null);
    }

    private void _switchEmptyView() {
        switch (mEmptyStatus){
            case STATUS_LOADING:
                setVisibility(VISIBLE);
                mRlEmptyContainer.setVisibility(GONE);
                mEmptyLoading.setVisibility(VISIBLE);
                break;
            case STATUS_NO_DATA:
            case STATUS_NO_NET:
                setVisibility(VISIBLE);
                mEmptyLoading.setVisibility(VISIBLE);
                mRlEmptyContainer.setVisibility(VISIBLE);
                break;
            case STATUS_HIDE:
                setVisibility(GONE);
                break;
        }
    }

    public void setRetryListener(OnRetryListener retryListener){
        this.mOnRetryListener = retryListener;
    }

    @OnClick(R.id.tv_net_error)
    public void onClick(){
        if (mOnRetryListener != null) {
            mOnRetryListener.onRetry();
        }
    }

    /**
     * 点击重试监听器
     */
    public interface OnRetryListener{
        void onRetry();
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATUS_LOADING, STATUS_NO_NET,STATUS_NO_DATA})
    public @interface EmptyStatus{}
}
