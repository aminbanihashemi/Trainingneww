package app.sematech.training.VideoBroadcast;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import app.sematech.training.R;

public class VideoBroadcastActivity extends AppCompatActivity {
    VideoView video;
    BroadcastReceiver callReceiver;
    String url = "https://hw18.cdn.asset.aparat.com/aparat-video/2655c25689d0faa997af1124a128886411285735-144p__70597.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_broadcast);
        video = (VideoView) findViewById(R.id.video);


        video.setMediaController(new MediaController(this));
        video.setVideoURI(Uri.parse(url));
        video.start();

        callReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (video.isPlaying())
                    video.pause();
            }
        };
        IntentFilter callFilter= new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(callReceiver,callFilter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1500);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(callReceiver);
    }
}