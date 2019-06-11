package com.zby.drawableview.background;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zby.drawableview.R;

/**
 * @author ZhuBingYang
 */
public class DefaultDrawableBackground implements DrawableBackground {
    public int solidColor;
    public int strokeColor;
    public int gradientStartColor, gradientEndColor, gradientCenterColor;
    public int touchColor;
    public int topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius;
    public int gradientLeft, gradientTop, gradientRight, gradientBottom;
    public int cornerRadius;
    public int strokeWidth;
    public int strokeDashWidth;
    public int gradientRadius;
    public int strokeDashGap;
    public int gradientAngle;
    public boolean gradientUseLevel;
    public int gradientType;
    public int gradientOrientation;
    public int shapeType;

    public int shadowColor;
    public int shadowRadius;
    public int shadowLeft;
    public int shadowTop;
    public int shadowRight;
    public int shadowBottom;
    public int shadowOrientation;
    public int shadowStartColor;
    public int shadowCenterColor;
    public int shadowEndColor;

    public boolean isShadowDefined = false;
    public LayerDrawable layerDrawable;
    public GradientDrawable gradientDrawable;

    protected View mView;

    @Override
    public void generateBackground(View view, AttributeSet attrs) {
        mView = view;

        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.DrawableBackground);
        solidColor = a.getColor(R.styleable.DrawableBackground_solidColor, Color.TRANSPARENT);
        strokeColor = a.getColor(R.styleable.DrawableBackground_strokeColor, Color.TRANSPARENT);
        gradientStartColor = a.getColor(R.styleable.DrawableBackground_gradientStartColor, Color.TRANSPARENT);
        gradientEndColor = a.getColor(R.styleable.DrawableBackground_gradientEndColor, Color.TRANSPARENT);
        gradientCenterColor = a.getColor(R.styleable.DrawableBackground_gradientCenterColor, Color.TRANSPARENT);
        touchColor = a.getColor(R.styleable.DrawableBackground_touchSolidColor, Color.TRANSPARENT);
        cornerRadius = (int) a.getDimension(R.styleable.DrawableBackground_cornerRadius, 0);
        topLeftRadius = (int) a.getDimension(R.styleable.DrawableBackground_topLeftRadius, 0);
        topRightRadius = (int) a.getDimension(R.styleable.DrawableBackground_topRightRadius, 0);
        bottomLeftRadius = (int) a.getDimension(R.styleable.DrawableBackground_bottomLeftRadius, 0);
        bottomRightRadius = (int) a.getDimension(R.styleable.DrawableBackground_bottomRightRadius, 0);
        strokeWidth = (int) a.getDimension(R.styleable.DrawableBackground_strokeWidth, 0);
        strokeDashWidth = (int) a.getDimension(R.styleable.DrawableBackground_strokeDashWidth, 0);
        strokeDashGap = (int) a.getDimension(R.styleable.DrawableBackground_strokeDashGap, 0);
        gradientAngle = a.getInt(R.styleable.DrawableBackground_gradientAngle, 0);
        gradientRadius = (int) a.getDimension(R.styleable.DrawableBackground_gradientRadius, 0);
        gradientUseLevel = a.getBoolean(R.styleable.DrawableBackground_gradientUseLevel, false);
        gradientType = a.getInt(R.styleable.DrawableBackground_gradientType, -1);
        gradientOrientation = a.getInt(R.styleable.DrawableBackground_gradientOrientation, -1);
        shapeType = a.getInt(R.styleable.DrawableBackground_shapeType, -1);
        gradientLeft = a.getDimensionPixelOffset(R.styleable.DrawableBackground_gradientLeft, 0);
        gradientTop = a.getDimensionPixelOffset(R.styleable.DrawableBackground_gradientTop, 0);
        gradientRight = a.getDimensionPixelOffset(R.styleable.DrawableBackground_gradientRight, 0);
        gradientBottom = a.getDimensionPixelOffset(R.styleable.DrawableBackground_gradientBottom, 0);


        if (a.hasValue(R.styleable.DrawableBackground_shadowColor)) {
            isShadowDefined = true;
            shadowLeft = a.getDimensionPixelSize(R.styleable.DrawableBackground_shadowLeft, 0);
            shadowTop = a.getDimensionPixelSize(R.styleable.DrawableBackground_shadowTop, 0);
            shadowRight = a.getDimensionPixelSize(R.styleable.DrawableBackground_shadowRight, 0);
            shadowBottom = a.getDimensionPixelSize(R.styleable.DrawableBackground_shadowBottom, 0);
            shadowColor = a.getColor(R.styleable.DrawableBackground_shadowColor, Color.TRANSPARENT);
            shadowRadius = (int) a.getDimension(R.styleable.DrawableBackground_shadowRadius, 0);
            shadowOrientation = a.getInt(R.styleable.DrawableBackground_shadowOrientation, -1);
            shadowStartColor = a.getColor(R.styleable.DrawableBackground_shadowStartColor, Color.TRANSPARENT);
            shadowCenterColor = a.getColor(R.styleable.DrawableBackground_shadowCenterColor, Color.TRANSPARENT);
            shadowEndColor = a.getColor(R.styleable.DrawableTextView_shadowEndColor, Color.TRANSPARENT);
        }

        a.recycle();

        updateBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (touchColor != Color.TRANSPARENT) {
                gradientDrawable.setColor(touchColor);
                mView.postInvalidate();
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP
                || event.getAction() == MotionEvent.ACTION_CANCEL) {
            if (touchColor != Color.TRANSPARENT) {
                gradientDrawable.setColor(solidColor);
                mView.postInvalidate();
            }
        }

        return false;
    }

    @Override
    public void setBackgroundParams(String[] keys, Object[] values) {
        if (keys.length != values.length)
            throw new IllegalArgumentException("The number of keys must be the same as the number of values.");
        for (int i = 0; i < keys.length; i++) {
            switch (keys[i]) {
                case "solidColor":
                    solidColor = (int) values[i];
                    break;
                case "cornerRadius":
                    cornerRadius = (int) values[i];
                    break;
                case "strokeColor":
                    strokeColor = (int) values[i];
                    break;
                case "strokeWidth":
                    strokeWidth = (int) values[i];
                    break;
                case "touchColor":
                    touchColor = (int) values[i];
                    break;
                case "topLeftRadius":
                    cornerRadius = (int) values[i];
                    break;
                case "topRightRadius":
                    topRightRadius = (int) values[i];
                    break;
                case "bottomLeftRadius":
                    bottomLeftRadius = (int) values[i];
                    break;
                case "bottomRightRadius":
                    bottomRightRadius = (int) values[i];
                    break;
                default:
                    throw new IllegalArgumentException("[" + keys[i] + "] this parameter is not supported");
            }
        }

        invalidate();
    }

    @Override
    public void invalidate() {
        updateBackground();
    }

    void updateBackground() {
        createGradientDrawable();
        if (isShadowDefined) {
            createLayerDrawable();
            setBackground(layerDrawable);
        } else {
            setBackground(gradientDrawable);
        }
    }

    private void setBackground(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mView.setBackground(drawable);
        } else {
            mView.setBackgroundDrawable(drawable);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createLayerDrawable() {
        Drawable[] drawable = new Drawable[2];

        GradientDrawable shadowDrawable = new GradientDrawable();

        if (shadowRadius == 0) {
            shadowRadius = cornerRadius;
        }
        shadowDrawable.setCornerRadius(shadowRadius);
        shadowDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);

        if (shadowOrientation != -1) {
            shadowDrawable.setOrientation(getOrientation(gradientOrientation));
            shadowDrawable.setColors(new int[]{shadowStartColor, shadowCenterColor, shadowEndColor});
        } else {
            shadowDrawable.setColor(shadowColor);
        }


        drawable[0] = shadowDrawable;
        drawable[1] = gradientDrawable;
        layerDrawable = new LayerDrawable(drawable);

        layerDrawable.setLayerInset(0, shadowLeft, shadowTop, shadowRight, shadowBottom);
        layerDrawable.setLayerInset(1, gradientLeft, gradientTop, gradientRight, gradientBottom);
    }

    private void createGradientDrawable() {
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
        if (gradientOrientation != -1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                gradientDrawable.setOrientation(getOrientation(gradientOrientation));
                gradientDrawable.setColors(new int[]{gradientStartColor, gradientCenterColor, gradientEndColor});
            }
        } else {
            gradientDrawable.setColor(solidColor);
        }

        if (shapeType == 0) {
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        } else if (shapeType == 1) {
            gradientDrawable.setShape(GradientDrawable.OVAL);
        } else if (shapeType == 2) {
            gradientDrawable.setShape(GradientDrawable.LINE);
        } else if (shapeType == 3) {
            gradientDrawable.setShape(GradientDrawable.RING);
        }

        if (shapeType != GradientDrawable.OVAL) {
            if (cornerRadius != 0) {
                gradientDrawable.setCornerRadius(cornerRadius);
            } else {
                gradientDrawable.setCornerRadii(new float[]{topLeftRadius,
                        topLeftRadius, topRightRadius, topRightRadius,
                        bottomRightRadius, bottomRightRadius, bottomLeftRadius,
                        bottomLeftRadius});
            }
        }

        if (gradientUseLevel) {
            gradientDrawable.setUseLevel(true);
        }

        if (gradientType == 0) {
            gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        } else if (gradientType == 1) {
            gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        } else if (gradientType == 2) {
            gradientDrawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
        }
        gradientDrawable.setGradientRadius(gradientRadius);
    }

    private GradientDrawable.Orientation getOrientation(int gradientOrientation) {
        GradientDrawable.Orientation orientation = null;
        switch (gradientOrientation) {
            case 0:
                orientation = GradientDrawable.Orientation.BL_TR;
                break;
            case 1:
                orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                break;
            case 2:
                orientation = GradientDrawable.Orientation.BR_TL;
                break;
            case 3:
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                break;
            case 4:
                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                break;
            case 5:
                orientation = GradientDrawable.Orientation.TL_BR;
                break;
            case 6:
                orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                break;
            case 7:
                orientation = GradientDrawable.Orientation.TR_BL;
                break;
        }
        return orientation;
    }
}
