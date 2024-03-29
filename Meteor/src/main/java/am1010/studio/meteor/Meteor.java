/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor;

import am1010.studio.meteor.particle.ParticleSystem;
import am1010.studio.meteor.view.ShapeFactory;
import am1010.studio.meteor.view.ShapeType;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class Meteor {

    private int color;
    private int startX, startY;
    private float radius;
    private int circleDuration;
    private Activity activity;
    private View bodyView;

    private ViewGroup mParentView;

    private ParticleSystem particleSystem;

    private int particleNumbers;

    public Meteor(Activity activity, int color, int startX, int startY, float radius, int circleDuration) {
        mParentView = (ViewGroup) activity.findViewById(android.R.id.content);
        this.activity = activity;
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.radius = radius;
        this.circleDuration = circleDuration;
    }

    public Meteor configureMeteorBody(ShapeType shapeType, float... shapeLenParams) {
        bodyView = ShapeFactory.getShape(activity, shapeType, this.color, new Point(startX, startY), shapeLenParams);
        mParentView.addView(bodyView);
        return this;
    }

    public Meteor configureMeteorTail(ShapeType shapeType, int numbers, float... shapeLenParams) {
        this.particleNumbers = numbers;
        //Bitmap bitmap = ShapeFactory.getShape(activity, shapeType, color, shapeLenParams);
        particleSystem = new ParticleSystem(activity, numbers, 10000, ShapeFactory.getDrawing(shapeType), this.color, shapeLenParams);
        particleSystem.setScaleRange(1.0f, 1.1f);
        particleSystem.setSpeedModuleAndAngleRange(0.1f, 0.2f, 10, 20);
        particleSystem.setRotationSpeedRange(90, 180);
        //particleSystem.setAcceleration(0.0004f, 90);
        particleSystem.setFadeOut(1, new AccelerateInterpolator());
        particleSystem.oneShot(this.bodyView, 200);
        return this;
    }

    public void startMeteor() {
        particleSystem.emit(bodyView, particleNumbers, 2000);
        startBodyRotation();
    }

    public void stopMeteor() {
        particleSystem.cancel();
    }

    private void startBodyRotation() {

        final RotateAnimation rotateAnimation = new
                RotateAnimation(0f, 360f, Animation.RELATIVE_TO_PARENT, 0.1f, Animation.RELATIVE_TO_PARENT, 0.1f);
        rotateAnimation.setDuration(1000);
        this.bodyView.startAnimation(rotateAnimation);

    }

    private void stopBodyRotation() {
        this.bodyView.clearAnimation();

    }
}
