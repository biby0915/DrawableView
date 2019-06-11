package com.zby.drawableview;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author ZhuBingYang
 */

public class Util {

    public static int dip2px(float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
}
