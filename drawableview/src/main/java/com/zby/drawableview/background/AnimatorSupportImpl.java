package com.zby.drawableview.background;

/**
 * @author ZhuBingYang
 */
public class AnimatorSupportImpl implements AnimatorSupport {
    private DefaultDrawableBackground mBackground;

    public AnimatorSupportImpl(DefaultDrawableBackground background) {
        this.mBackground = background;
    }

    @Override
    public void setCornerRadius(int radius) {
        mBackground.cornerRadius = radius;
        mBackground.invalidate();
    }

    @Override
    public void setSolidColor(int color) {
        mBackground.solidColor = color;
        mBackground.invalidate();
    }
}
