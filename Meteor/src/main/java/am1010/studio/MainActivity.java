package am1010.studio;

import am1010.studio.meteor.Meteor;
import am1010.studio.meteor.particle.ParticleSystem;
import am1010.studio.meteor.view.ShapeFactory;
import am1010.studio.meteor.view.ShapeType;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meteor meteor = new Meteor(MainActivity.this, Color.BLUE,100,100,100f,1000);
                meteor.configureMeteorBody(ShapeType.polygon,10).configureMeteorTail(ShapeType.circle,10,3).startMeteor();
//                ParticleSystem particleSystem = new ParticleSystem(MainActivity.this, 10, 10000, ShapeFactory.getDrawing(ShapeType.circle), Color.CYAN, 5);
//                //ParticleSystem particleSystem = new ParticleSystem(MainActivity.this, 10, R.drawable.ic_launcher,10000);
//                particleSystem.setScaleRange(1.0f, 1.1f);
//                particleSystem.setSpeedModuleAndAngleRange(0.1f, 0.2f, 10, 20);
//                particleSystem.setRotationSpeedRange(90, 180);
//                //particleSystem.setAcceleration(0.0004f, 90);
//                particleSystem.setFadeOut(1, new AccelerateInterpolator());
//                particleSystem.oneShot(view,200);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
