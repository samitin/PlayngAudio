package ru.samitin.playngaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private boolean isPlay=false;
    MediaPlayer mediaPlayer;
    SeekBar volumeSeekBar;
    AudioManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.stuff);
        volumeSeekBar=findViewById(R.id.volumeSeekBar);
        manager=(AudioManager)getSystemService(AUDIO_SERVICE);

        int maxVolume=manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maxVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                manager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Button buttonPlayPause=findViewById(R.id.buttonPlayPause);
        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    buttonPlayPause.setText(getText(R.string.play));
                }else {
                    mediaPlayer.start();
                    buttonPlayPause.setText(getText(R.string.pause));
                }
            }
        });
    }
}