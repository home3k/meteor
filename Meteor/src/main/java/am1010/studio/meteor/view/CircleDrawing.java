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
public class CircleDrawing implements Drawing {
    @Override
    public Bitmap draw(Canvas canvas, Paint paint, Point point, float... lenParams) {
        Bitmap bitmap = Bitmap.createBitmap((int) lenParams[0] * 2, (int) lenParams[0] * 2, Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bitmap);
        _draw(canvas,paint,point,lenParams);
        _draw(bitmapCanvas,paint,point,lenParams);
        return bitmap;
    }

    private void _draw(Canvas canvas, Paint paint, Point point, float... lenParams) {
        canvas.drawCircle(point.x, point.y, lenParams[0], paint);
        paint.setAntiAlias(true);
    }
}
