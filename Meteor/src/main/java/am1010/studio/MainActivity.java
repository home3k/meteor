package am1010.studio;

import am1010.studio.meteor.Meteor;
import am1010.studio.meteor.view.ShapeType;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Meteor meteor = new Meteor(MainActivity.this, Color.BLUE,100,30,100f,1000);
                meteor.configureMeteorBody(ShapeType.circle,20).configureMeteorTail(ShapeType.circle,10,5).startMeteor();
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
