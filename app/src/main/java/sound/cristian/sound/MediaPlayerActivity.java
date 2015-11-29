package sound.cristian.sound;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {
Button buttonPlay,buttonStop;
    boolean play=true;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        buttonPlay = (Button)findViewById(R.id.MediaPlayerBotonPlay);
        buttonPlay.setOnClickListener(this);
        buttonStop=(Button) findViewById(R.id.MediaPlayerBotonStop);
        buttonStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.MediaPlayerBotonPlay:

                play();
                break;
            case R.id.MediaPlayerBotonStop:
                stop();
                break;
        }
    }
    private void play(){

        if (play){
            play=false;
            mp = MediaPlayer.create(this,R.raw.beautiful);
            mp.start();
        }

    }
    private  void  stop(){
        if (!play){
            mp.stop();
            play=true;
        }
    }
}
