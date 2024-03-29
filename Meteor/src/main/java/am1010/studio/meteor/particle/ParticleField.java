/*
 * 1010.am Studio.
 * Copyright (c) 2000-2014 All Rights Reserved.
 */

package am1010.studio.meteor.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class ParticleField extends View {

    private ArrayList<Particle> mParticles;

    public ParticleField(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ParticleField(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParticleField(Context context) {
        super(context);
    }

    public void setParticles(ArrayList<Particle> particles) {
        mParticles = particles;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw all the particles
        for (int i=0; i<mParticles.size(); i++) {
            mParticles.get(i).draw(canvas);
        }
    }
}

