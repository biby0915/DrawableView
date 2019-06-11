package com.zby.drawableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zby.drawableview.background.AnimatorSupport;
import com.zby.drawableview.background.AnimatorSupportImpl;
import com.zby.drawableview.background.DefaultDrawableBackground;

/**
 * @author ZhuBingYang
 */
public class DrawableView extends View implements AnimatorSupport {

    private DefaultDrawableBackground mDrawableBackground;
    private AnimatorSupport mAnimatorSupport;

    public DrawableView(Context context) {
        this(context, null);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
