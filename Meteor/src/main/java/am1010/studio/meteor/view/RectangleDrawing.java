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
public class RectangleDrawing implements Drawing {
    @Override
    public Bitmap draw(Canvas canvas, Paint paint, Point point, float... lenParams) {
        Bitmap bitmap = Bitmap.createBitmap((int) lenParams[0], (int)lenParams[1], Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bitmap);
        canvas.drawRect(point.x, point.y, lenParams[0], lenParams[1], paint);
        bitmapCanvas.drawRect(point.x, point.y, lenParams[0], lenParams[1], paint);
        return bitmap;
    }
}
