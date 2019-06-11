package com.zby.drawableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.zby.drawableview.background.AnimatorSupport;
import com.zby.drawableview.background.AnimatorSupportImpl;
import com.zby.drawableview.background.DefaultDrawableBackground;


/**
 * @author ZhuBingYang
 */
public class DrawableLinearLayout extends LinearLayout implements AnimatorSupport {

    private DefaultDrawableBackground mDrawableBackground;
    private AnimatorSupport mAnimatorSupport;

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

        mAnimatorSupport = new AnimatorSupportImpl(mDrawableBackground);
    }

    public DefaultDrawableBackground getDrawableBackground() {
        return mDrawableBackground;
    }

    @Override
    public void setCornerRadius(int radius) {
        mAnimatorSupport.setCornerRadius(radius);
    }

    @Override
    public void setSolidColor(int color) {
        mAnimatorSupport.setSolidColor(color);
    }
}
