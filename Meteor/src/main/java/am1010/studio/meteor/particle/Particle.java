/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.particle;

import am1010.studio.meteor.particle.modifiers.ParticleModifier;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.List;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class Particle {

    protected Bitmap mImage;

    public float mCurrentX;
    public float mCurrentY;

    public float mScale = 1f;
    public int mAlpha = 255;

    public float mInitialRotation = 0f;

    public float mRotationSpeed = 0f;

    public float mSpeedX = 0f;
    public float mSpeedY = 0f;

    public float mAccelerationX;
    public float mAccelerationY;

    private Matrix mMatrix;
    private Paint mPaint;

    protected float mInitialX;
    protected float mInitialY;

    protected float mRotation;

    protected long mTimeToLive;

    protected long mStartingMilisecond;

    protected int mBitmapHalfWidth;
    protected int mBitmapHalfHeight;

    protected List<ParticleModifier> mModifiers;


    protected Particle() {
        mMatrix = new Matrix();
        mPaint = new Paint();
    }

    public Particle (Bitmap bitmap) {
        this();
        mImage = bitmap;
    }

    public void configure(long timeToLive, float emiterX, float emiterY) {
        mBitmapHalfWidth = mImage.getWidth()/2;
        mBitmapHalfHeight = mImage.getHeight()/2;

        mInitialX = emiterX - mBitmapHalfWidth;
        mInitialY = emiterY - mBitmapHalfHeight;
        mCurrentX = mInitialX;
        mCurrentY = mInitialY;

        mTimeToLive = timeToLive;
        mScale = 1;
        mAlpha = 255;
    }

    public boolean update (long miliseconds) {
        long realMiliseconds = miliseconds - mStartingMilisecond;
        if (realMiliseconds > mTimeToLive) {
            return false;
        }
        mCurrentX = mInitialX+mSpeedX*realMiliseconds+mAccelerationX*realMiliseconds*realMiliseconds;
        mCurrentY = mInitialY+mSpeedY*realMiliseconds+mAccelerationY*realMiliseconds*realMiliseconds;
        mRotation = mInitialRotation + mRotationSpeed*realMiliseconds/1000;
        for (int i=0; i<mModifiers.size(); i++) {
            mModifiers.get(i).apply(this, realMiliseconds);
        }
        return true;
    }

    public void draw (Canvas c) {
        mMatrix.reset();
        mMatrix.postRotate(mRotation, mBitmapHalfWidth, mBitmapHalfHeight);
        mMatrix.postScale(mScale, mScale, mBitmapHalfWidth, mBitmapHalfHeight);
        mMatrix.postTranslate(mCurrentX, mCurrentY);
        mPaint.setAlpha(mAlpha);
        c.drawBitmap(mImage, mMatrix, mPaint);
    }

    public Particle activate(long startingMilisecond, List<ParticleModifier> modifiers) {
        mStartingMilisecond = startingMilisecond;
        // We do store a reference to the list, there is no need to copy, since the modifiers do not carte about states
        mModifiers = modifiers;
        return this;
    }

}
