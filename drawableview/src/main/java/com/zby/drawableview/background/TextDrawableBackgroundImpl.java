package com.zby.drawableview.background;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zby.drawableview.R;
import com.zby.drawableview.Util;

/**
 * @author ZhuBingYang
 */
public class TextDrawableBackgroundImpl extends DefaultDrawableBackground implements TextDrawableBackground {

    public int textColor;
    public int touchTextColor;

    public int drawableWidth;
    public int drawableHeight;

    public int drawableRightWidth;
    public int drawableRightHeight;

    public int drawableTopWidth;
    public int drawableTopHeight;

    public int drawableBottomWidth;
    public int drawableBottomHeight;

    @Override
    public void generateBackground(View view, AttributeSet attrs) {
        mView = view;

        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.DrawableTextView);
        solidColor = a.getColor(R.styleable.DrawableTextView_solidColor, Color.TRANSPARENT);
        strokeColor = a.getColor(R.styleable.DrawableTextView_strokeColor, Color.TRANSPARENT);
        gradientStartColor = a.getColor(R.styleable.DrawableTextView_gradientStartColor, Color.TRANSPARENT);
        gradientEndColor = a.getColor(R.styleable.DrawableTextView_gradientEndColor, Color.TRANSPARENT);
        gradientCenterColor = a.getColor(R.styleable.DrawableTextView_gradientCenterColor, Color.TRANSPARENT);
        touchColor = a.getColor(R.styleable.DrawableTextView_touchSolidColor, Color.TRANSPARENT);
        touchTextColor = a.getColor(R.styleable.DrawableTextView_touchTextColor, Color.TRANSPARENT);
        cornerRadius = (int) a.getDimension(R.styleable.DrawableTextView_cornerRadius, 0);
        topLeftRadius = (int) a.getDimension(R.styleable.DrawableTextView_topLeftRadius, 0);
        topRightRadius = (int) a.getDimension(R.styleable.DrawableTextView_topRightRadius, 0);
        bottomLeftRadius = (int) a.getDimension(R.styleable.DrawableTextView_bottomLeftRadius, 0);
        bottomRightRadius = (int) a.getDimension(R.styleable.DrawableTextView_bottomRightRadius, 0);
        strokeWidth = (int) a.getDimension(R.styleable.DrawableTextView_strokeWidth, 0);
        strokeDashWidth = (int) a.getDimension(R.styleable.DrawableTextView_strokeDashWidth, 0);
        strokeDashGap = (int) a.getDimension(R.styleable.DrawableTextView_strokeDashGap, 0);
        gradientAngle = a.getInt(R.styleable.DrawableTextView_gradientAngle, 0);
        gradientRadius = (int) a.getDimension(R.styleable.DrawableTextView_gradientRadius, 0);
        gradientUseLevel = a.getBoolean(R.styleable.DrawableTextView_gradientUseLevel, false);
        gradientType = a.getInt(R.styleable.DrawableTextView_gradientType, -1);
        gradientOrientation = a.getInt(R.styleable.DrawableTextView_gradientOrientation, -1);
        shapeType = a.getInt(R.styleable.DrawableTextView_shapeType, -1);
        gradientLeft = a.getDimensionPixelOffset(R.styleable.DrawableTextView_gradientLeft, 0);
        gradientTop = a.getDimensionPixelOffset(R.styleable.DrawableTextView_gradientTop, 0);
        gradientRight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_gradientRight, 0);
        gradientBottom = a.getDimensionPixelOffset(R.styleable.DrawableTextView_gradientBottom, 0);

        drawableWidth = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableWidth, Util.dip2px(25));
        drawableHeight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableHeight, Util.dip2px(25));

        drawableRightWidth = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableRightWidth, Util.dip2px(25));
        drawableRightHeight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableRightHeight, Util.dip2px(25));

        drawableTopWidth = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableTopWidth, Util.dip2px(25));
        drawableTopHeight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableTopHeight, Util.dip2px(25));

        drawableBottomWidth = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableBottomWidth, 0);
        drawableBottomHeight = a.getDimensionPixelOffset(R.styleable.DrawableTextView_drawableBottomHeight, 0);

        if (a.hasValue(R.styleable.DrawableTextView_shadowColor)) {
            isShadowDefined = true;
            shadowLeft = a.getDimensionPixelSize(R.styleable.DrawableTextView_shadowLeft, 0);
            shadowTop = a.getDimensionPixelSize(R.styleable.DrawableTextView_shadowTop, 0);
            shadowRight = a.getDimensionPixelSize(R.styleable.DrawableTextView_shadowRight, 0);
            shadowBottom = a.getDimensionPixelSize(R.styleable.DrawableTextView_shadowBottom, 0);
            shadowColor = a.getColor(R.styleable.DrawableTextView_shadowColor, Color.TRANSPARENT);
            shadowRadius = (int) a.getDimension(R.styleable.DrawableTextView_shadowRadius, 0);
            shadowOrientation = a.getInt(R.styleable.DrawableTextView_shadowOrientation, -1);
            shadowStartColor = a.getColor(R.styleable.DrawableTextView_shadowStartColor, Color.TRANSPARENT);
            shadowCenterColor = a.getColor(R.styleable.DrawableTextView_shadowCenterColor, Color.TRANSPARENT);
            shadowEndColor = a.getColor(R.styleable.DrawableTextView_shadowEndColor, Color.TRANSPARENT);
        }

        a.recycle();


        updateBackground();
        resizeDrawables();

//        if ((touchColor != Color.TRANSPARENT || touchTextColor != Color.TRANSPARENT) && !(mView instanceof EditText)) {
//            mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        }
    }

    private void resizeDrawables() {
        Drawable[] drawables = ((TextView) mView).getCompoundDrawables();

        Drawable textDrawable;

        //设置宽高
        textDrawable = drawables[0];
        if (textDrawable != null && drawableWidth != -1 && drawableHeight != -1) {
            textDrawable.setBounds(0, 0, drawableWidth, drawableHeight);
        }

        textDrawable = drawables[1];
        if (textDrawable != null && drawableTopWidth != -1 && drawableTopHeight != -1) {
            textDrawable.setBounds(0, 0, drawableTopWidth, drawableTopHeight);
        }

        textDrawable = drawables[2];
        if (textDrawable != null && drawableRightWidth != -1 && drawableRightHeight != -1) {
            textDrawable.setBounds(0, 0, drawableRightWidth, drawableRightHeight);
        }

        textDrawable = drawables[3];
        if (textDrawable != null && drawableBottomWidth != -1 && drawableBottomHeight != -1) {
            textDrawable.setBounds(0, 0, drawableBottomWidth, drawableBottomHeight);
        }

        //update
        ((TextView) mView).setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!(mView instanceof EditText))
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            if (onDrawableClickListener != null) {
//
//                Drawable drawable = getCompoundDrawables()[2];
//                if (drawable != null && event.getX() >= (getWidth() - drawable.getBounds().width())) {
//                    onDrawableClickListener.onClick(this);
//                    return true;
//                }
//
//            } else if (onLeftDrawableClickListener != null) {
//                Drawable drawable = getCompoundDrawables()[0];
//                if (drawable != null && event.getX() <= drawable.getBounds().width()) {
//
//                    onLeftDrawableClickListener.onClick(this);
//                    return true;
//                }
//            }


                if (mView.hasOnClickListeners()) {
                    if (touchColor != Color.TRANSPARENT) {
                        gradientDrawable.setColor(touchColor);
                        mView.postInvalidate();
                    }
                    if (touchTextColor != Color.TRANSPARENT) {
                        if (textColor == Color.TRANSPARENT) {
                            textColor = ((TextView) mView).getCurrentTextColor();
                        }
                        ((TextView) mView).setTextColor(touchTextColor);
                    }
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                if (touchColor != Color.TRANSPARENT) {
                    gradientDrawable.setColor(solidColor);
                    updateBackground();
                }
                if (touchTextColor != Color.TRANSPARENT) {
                    ((TextView) mView).setTextColor(textColor);
                }
            }

        return false;
    }

    @Override
    public void setDrawable(Drawable drawable, Position position, boolean adjustAspectRatio) {
        Drawable[] drawables = ((TextView) mView).getCompoundDrawables();

        int width = 0, height = 0;
        int index = 0;
        switch (position) {
            case LEFT:
                width = drawableWidth;
                height = drawableHeight;
                break;
            case TOP:
                width = drawableTopWidth;
                height = drawableTopHeight;
                index = 1;
                break;
            case RIGHT:
                width = drawableRightWidth;
                height = drawableRightHeight;
                index = 2;
                break;
            case BOTTOM:
                width = drawableBottomWidth;
                height = drawableBottomHeight;
                index = 3;
                break;
        }


        if (drawable != null) {
            if (adjustAspectRatio) {
                height = width * drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth();
            }
            drawable.setBounds(0, 0, width, height);
        }

        drawables[index] = drawable;

        ((TextView) mView).setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
    }
}
