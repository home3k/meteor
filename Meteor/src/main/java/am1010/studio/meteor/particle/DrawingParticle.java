package am1010.studio.meteor.particle;

import am1010.studio.meteor.view.Drawing;
import android.graphics.Canvas;

/**
 * @author home3k (home3k@gmail.com)
 * @version 1.0
 * @desc TODO
 * @date 14-8-25
 */
public class DrawingParticle extends Particle{
    private Drawing drawing;
    public DrawingParticle(Drawing drawing) {
        super();
        this.drawing = drawing;
    }

    @Override
    public void draw(Canvas c) {
        super.draw(c);
    }

    @Override
    public void configure(long timeToLive, float emiterX, float emiterY) {
    }
}
