package com.zby.drawableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.zby.drawableview.background.AnimatorSupport;
import com.zby.drawableview.background.AnimatorSupportImpl;
import com.zby.drawableview.background.TextDrawableBackgroundImpl;

/**
 * @author ZhuBingYang
 */
public class DrawableTextView extends TextView implements AnimatorSupport {
    private TextDrawableBackgroundImpl mDrawableBackground;
    private AnimatorSupport mAnimatorSupport;

    public DrawableTextView(Context context) {
        this(context, null);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mDrawableBackground = new TextDrawableBackgroundImpl();
        mDrawableBackground.generateBackground(this, attrs);

        mAnimatorSupport = new AnimatorSupportImpl(mDrawableBackground);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDrawableBackground.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public TextDrawableBackgroundImpl getDrawableBackground() {
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

    public void setOnDrawableClickListener(TextDrawableBackgroundImpl.OnDrawableClickListener listener) {
        mDrawableBackground.setOnDrawableClickListener(listener);
    }
}
