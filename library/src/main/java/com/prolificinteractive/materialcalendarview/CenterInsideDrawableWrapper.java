package com.prolificinteractive.materialcalendarview;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

import androidx.annotation.Nullable;

public class CenterInsideDrawableWrapper extends InsetDrawable {
    private Rect tempRect = new Rect();

    public CenterInsideDrawableWrapper(@Nullable Drawable drawable) {
        super(drawable, 0);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        tempRect.set(bounds);

        final double offset = Math.abs(bounds.height() - bounds.width()) / 2.0;

        if(bounds.width() > bounds.height()) {
            tempRect.left += Math.floor(offset);
            tempRect.right -= Math.ceil(offset);
        }
        else {
            tempRect.top += Math.floor(offset);
            tempRect.bottom -= Math.ceil(offset);
        }

        // Apply inset bounds to the wrapped drawable.
        super.onBoundsChange(tempRect);
    }
}