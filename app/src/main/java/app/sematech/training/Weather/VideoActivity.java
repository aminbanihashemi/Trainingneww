package app.sematech.training.Weather;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import app.sematech.training.R;

public class VideoActivity extends AppCompatActivity {
    VideoView showVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        bind();
        Intent intent = getIntent();
        String item_selected=getIntent().getStringExtra("a_Tag");
        showVideo.setVideoURI(Uri.parse(item_selected.toString()));
        showVideo.start();
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void bind() {
        showVideo = (VideoView) findViewById(R.id.showVideo);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
