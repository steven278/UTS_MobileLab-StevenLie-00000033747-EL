package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.File;
import java.net.URI;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class SfxDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_TTITLE ="title";
    public static final String EXTRA_GENRE = "genre";
    public static final String EXTRA_URI = "uri";
    TextView tv_title, tv_genre;
    Button btn_play, btn_stop;
    MediaPlayer mediaPlayer;
    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfx_details);
        tv_title = findViewById(R.id.soundDetailTitle);
        tv_genre = findViewById(R.id.soundDetailGenre);
        btn_play = findViewById(R.id.playSFX);
        btn_stop = findViewById(R.id.pauseFX);
        String title = getIntent().getStringExtra(EXTRA_TTITLE);
        String genre = getIntent().getStringExtra(EXTRA_GENRE);
        String uri = getIntent().getStringExtra(EXTRA_URI);
        tv_title.setText(title);
        tv_genre.setText(genre);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(uri));
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPlaying){
                    mediaPlayer.start();
                    isPlaying = true;
                    findViewById(R.id.SoundDetailPhoto).startAnimation(rotateAnimation);
                }
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    mediaPlayer.pause();
                    isPlaying = false;
                    findViewById(R.id.SoundDetailPhoto).clearAnimation();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}