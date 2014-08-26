/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.particle;

import am1010.studio.meteor.view.Drawing;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class DrawingParticle extends Particle{

    private Drawing drawing;

    private static Point middlePoint;

    public DrawingParticle(Context context, Drawing drawing, int shapeColor, float... lenParams) {
        super();
        this.drawing = drawing;
        Paint p = new Paint();
        p.setColor(shapeColor);
        p.setStyle(Paint.Style.FILL);

        mImage = drawing.draw(new Canvas(),p,getMiddlePoint(context), lenParams);
    }

    private Point getMiddlePoint(Context context) {
        if (middlePoint != null)
            return middlePoint;
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
        middlePoint = new Point(dm.widthPixels / 2, dm.heightPixels / 2);
        return middlePoint;
    }


}
