/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class DrawingView extends View {

    private int shapeColor = Color.BLUE;

    private float[] lenParams;

    private Drawing drawing;

    private Point point;

    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, Drawing drawing, int shapeColor, Point point, float... lenParams) {
        this(context);
        this.drawing = drawing;
        this.point = point;
        this.shapeColor = shapeColor;
        this.lenParams = lenParams;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(shapeColor);
        p.setStyle(Paint.Style.FILL);

        this.bitmap = this.drawing.draw(canvas,p,point,lenParams);

    }
}
