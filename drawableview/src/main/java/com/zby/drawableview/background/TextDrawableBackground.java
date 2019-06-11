package com.zby.drawableview.background;

import android.graphics.drawable.Drawable;

/**
 * @author ZhuBingYang
 */
public interface TextDrawableBackground extends DrawableBackground {
    /**
     * @param drawable          图像对象
     * @param position          更新图片对应的位置
     * @param adjustAspectRatio 是否自动调整图片比例，防止图片变形
     */
    void setDrawable(Drawable drawable, Position position, boolean adjustAspectRatio);

    enum Position {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }
}
