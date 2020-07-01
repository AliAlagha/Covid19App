package com.example.covid19app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.covid19app.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/%D8%B7%D8%A8%D9%8A%D8%A8_%D8%A5%D9%8A%D8%B7%D8%A7%D9%84%D9%8A__%D9%81%D9%8A%D8%B1%D9%88%D8%B3_%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7_%D9%81%D9%82%D8%AF_%D8%A7%D9%84%D9%83%D8%AB%D9%8A%D8%B1_%D9%85%D9%86_%D8%AE%D8%B7%D9%88%D8%B1%D8%AA%D9%87%5B1%5D." +
                "mp4?alt=media&token=3d8dd00a-0753-4273-bf81-2ba18b6a7461");

        VideoView videoView1 = findViewById(R.id.videoView1);
        videoView1.setVideoURI(uri);
        MediaController mediaController1 = new MediaController(this);
        videoView1.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView1);

        Uri uri1 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/%D8%AA%D8%B9%D8%B1%D9%81_%D8%B9%D9%84%D9%89_%D8%B7%D8%B1%D9%82_%D8%A7%D9%84%D9%88%D9%82%D8%A7%D9%8A%D8%A9_%D9%85%D9%86_%D9%81%D9%8A%D8%B1%D9%88%D8%B3_%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7%5B1%5D" +
                ".mp4?alt=media&token=402fe203-e9be-4509-b592-83d0399cfc2c");

        VideoView videoView2 = findViewById(R.id.videoView2);
        videoView2.setVideoURI(uri1);
        MediaController mediaController2 = new MediaController(this);
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

        Uri uri2 = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/%D8%A8%D9%85%D8%B4%D8%A7%D8%B1%D9%83%D8%A9_30_%D8%AF%D9%88%D9%84%D8%A9.._%D9%85%D9%86%D8%B8%D9%85%D8%A9_%D8%A7%D9%84%D8%B5%D8%AD%D8%A9_%D8%AA%D8%AF%D8%B4%D9%86_%D8%AA%D8%AD%D8%A7%D9%84%D9%81%D8%A7_%D9%84%D9%84%D8%AA%D8%B4%D8%A7%D8%B1%D9%83_%D9%81%D9%8A_%D9%88%D8%B3%D8%A7%D8%A6%D9%84_%D8%B9%D9%84%D8%A7" +
                "%D8%AC_%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7%5B1%5D.mp4?alt=media&token=4e80cffc-6f34-4cf6-bb9f-1a4bccaa13f2");

        VideoView videoView3 = findViewById(R.id.videoView3);
        videoView3.setVideoURI(uri2);
        MediaController mediaController3 = new MediaController(this);
        videoView3.setMediaController(mediaController3);
        mediaController3.setAnchorView(videoView3);

    }
}
