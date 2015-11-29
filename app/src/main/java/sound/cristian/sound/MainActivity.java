package sound.cristian.sound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button buttonEjemplo1,buttonEjemplo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonEjemplo1 = (Button) findViewById(R.id.ButtonEjemplo1);
        buttonEjemplo1.setOnClickListener(this);

        buttonEjemplo2 = (Button) findViewById(R.id.ButtonEjemplo2);
        buttonEjemplo2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ButtonEjemplo1:
                Intent intentSoundPool = new Intent(MainActivity.this,SoundPoolActivity.class);
                startActivity(intentSoundPool);
                break;
            case R.id.ButtonEjemplo2:
                Intent intentMediaPlayer = new Intent(MainActivity.this,MediaPlayerActivity.class);
                startActivity(intentMediaPlayer);
                break;
        }
    }
}
