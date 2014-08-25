package am1010.studio.meteor.view;

import android.graphics.*;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class PolygonDrawing implements Drawing {

    @Override
    public Bitmap draw(Canvas canvas, Paint paint, Point point, float... lenParams) {
        Path path = new Path();
        float r = lenParams[0];
        Bitmap bitmap = Bitmap.createBitmap((int) r * 2, (int) r * 2, Bitmap.Config.ARGB_8888);
        Canvas bitmapCanvas = new Canvas(bitmap);
        path.moveTo(point.x - r, point.y - r);
        path.lineTo(point.x + r, point.y - r);
        path.lineTo(point.x + 2 * r, point.y);
        path.lineTo(point.x + r, point.y + r);
        path.lineTo(point.x - r, point.y + r);
        path.lineTo(point.x - 2 * r, point.y);
        path.close();
        canvas.drawPath(path, paint);
        bitmapCanvas.drawPath(path, paint);
        return bitmap;
    }

    }
