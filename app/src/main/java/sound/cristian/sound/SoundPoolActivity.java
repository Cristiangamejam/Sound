package sound.cristian.sound;


import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundPoolActivity extends AppCompatActivity implements View.OnClickListener{
Button buttonPlay,buttonStop;
    SoundPool soundPool;
    boolean loader=false;
    private  int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        buttonPlay =(Button) findViewById(R.id.SoundPoolBotonPlay);
        buttonPlay.setOnClickListener(this);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                loader= true;
            }
        });
        soundID= soundPool.load(this,R.raw.beautiful,1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.SoundPoolBotonPlay:
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVol = (float )audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolumen =(float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVol/maxVolumen;

                soundPool.play(soundID,volume,volume,1,0,1f);

                break;
            case R.id.SoundPoolBotonStop:
                soundPool.stop(soundID);
                break;
        }
    }
}
