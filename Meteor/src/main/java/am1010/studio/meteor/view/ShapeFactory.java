/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class ShapeFactory {

    private static Map<String, Bitmap> bitmapCache = new ConcurrentHashMap<String, Bitmap>();
    private static Point middlePoint;

    /**
     *
     * @param shapeType
     * @return
     */
    public static Drawing getDrawing(ShapeType shapeType) {
        Drawing drawing;
        switch (shapeType) {
            case circle:
                drawing = new CircleDrawing();
            case rectangle:
                drawing = new RectangleDrawing();
            case polygon:
                drawing = new PolygonDrawing();
            default:
                drawing = new CircleDrawing();
        }
        return drawing;
    }

    public static Bitmap getShape(Context context, ShapeType shapeType, int color, float... lengthParams) {
        String cacheKey = getCacheKey(shapeType, color, lengthParams);
        if (bitmapCache.containsKey(cacheKey)) {
            return bitmapCache.get(cacheKey);
        }

        Paint p = new Paint();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);

        Bitmap bitmap = getDrawing(shapeType).draw(new Canvas(), p, getMiddlePoint(context), lengthParams);
        //getShape(context, shapeType, color, getMiddlePoint(context), lengthParams).getBitmap();
        bitmapCache.put(cacheKey, bitmap);
        return bitmap;
    }

    private static Point getMiddlePoint(Context context) {
        if (middlePoint != null)
            return middlePoint;
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        middlePoint = new Point(dm.widthPixels / 2, dm.heightPixels / 2);
        return middlePoint;
    }

    public static DrawingView getShape(Context context, ShapeType shapeType, int color, Point point, float... lengthParams) {

        DrawingView view = new DrawingView(context, getDrawing(shapeType), color, point, lengthParams);

        return view;
    }

    /**
     * @param shapeType
     * @param color
     * @param lengthParams
     * @return
     */
    private static String getCacheKey(ShapeType shapeType, int color, float... lengthParams) {
        StringBuilder stringBuilder = new StringBuilder(shapeType.name());
        stringBuilder.append(color);
        for (float lenParam : lengthParams) {
            stringBuilder.append(lenParam);
        }
        return stringBuilder.toString();
    }

    private static Bitmap getViewBitmap(View v) {
        v.clearFocus();
        v.setPressed(false);

        boolean willNotCache = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);

        // Reset the drawing cache background color to fully transparent
        // for the duration of this operation
        int color = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);

        if (color != 0) {
            v.destroyDrawingCache();
        }

        v.setDrawingCacheEnabled(true);

        Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;

/*
        // this is the important code :)
        // Without it the view will have a dimension of 0,0 and the bitmap will be null
        v.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

        v.buildDrawingCache(true);
        Bitmap cacheBitmap = v.getDrawingCache();
        if (cacheBitmap == null) {
            return null;
        }

        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

        // Restore the view
        v.destroyDrawingCache();
        v.setWillNotCacheDrawing(willNotCache);
        v.setDrawingCacheBackgroundColor(color);

        return bitmap;
        */
    }
}
