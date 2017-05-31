package com.bubble.customviewstudydemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @description
 * @date 17/5/26
 */

public class CustomBaseView extends View {
    public Context mContext;

    public TypedArray typedArray;

    public CustomBaseView(Context context) {
        super(context);
    }

    public CustomBaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
    }

    /**
     * 一些必要的初始化操作，需要子类复写。如初始化画笔等
     *
     * @param set
     * @param defStyleAttr
     * @param attrs
     */
    public void init(AttributeSet set, int defStyleAttr, int[] attrs) {
        getAttrs(set, defStyleAttr, attrs);
    }

    /**
     * 获得自定义的样式属性，需要子类复写
     *
     * @param set
     * @param defStyleAttr
     * @param attrs
     */
    public void getAttrs(AttributeSet set, int defStyleAttr, int[] attrs) {
        typedArray = mContext.getTheme().obtainStyledAttributes(set, attrs, defStyleAttr, 0);
    }
}