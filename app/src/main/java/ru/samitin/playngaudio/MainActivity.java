package ru.samitin.playngaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isPlay=false;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.stuff);


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