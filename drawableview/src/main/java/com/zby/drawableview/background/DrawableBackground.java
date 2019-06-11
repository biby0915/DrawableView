package com.zby.drawableview.background;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author ZhuBingYang
 */
public interface DrawableBackground {
    void generateBackground(View view, AttributeSet attrs);

    boolean onTouchEvent(MotionEvent event);

    void setBackgroundParams(String[] keys, Object[] values);

    void invalidate();
}
