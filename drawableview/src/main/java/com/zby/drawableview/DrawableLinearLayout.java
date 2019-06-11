package com.zby.drawableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.zby.drawableview.background.DefaultDrawableBackground;


/**
 * Created by ZhuBingYang on 2019/1/29.
 */
public class DrawableLinearLayout extends LinearLayout {

    private DefaultDrawableBackground mDrawableBackground;

    public DrawableLinearLayout(Context context) {
        this(context, null);
    }

    public DrawableLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mDrawableBackground = new DefaultDrawableBackground();
        mDrawableBackground.generateBackground(this, attrs);
    }

    public DefaultDrawableBackground getDrawableBackground() {
        return mDrawableBackground;
    }
}
