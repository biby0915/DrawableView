package com.zby.drawableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zby.drawableview.background.DefaultDrawableBackground;

/**
 * @author ZhuBingYang
 */
public class DrawableView extends View {

    private DefaultDrawableBackground mDrawableBackground;

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
    }

    public DefaultDrawableBackground getDrawableBackground() {
        return mDrawableBackground;
    }
}
