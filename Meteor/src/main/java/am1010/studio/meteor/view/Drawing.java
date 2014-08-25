/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public interface Drawing {
    /**
     * Using Paint drawing canvas;
     * @param canvas
     * @param paint
     * @param lenParams
     */
    Bitmap draw(Canvas canvas, Paint paint, Point point, float... lenParams);

}
