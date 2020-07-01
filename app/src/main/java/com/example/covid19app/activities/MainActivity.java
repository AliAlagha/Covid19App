package com.example.covid19app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.covid19app.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView questionsCardView = findViewById(R.id.questionsCardView);
        questionsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(intent);
            }
        });

        CardView chatCardView = findViewById(R.id.chatCardView);
        chatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UsersListActivity.class);
                startActivity(intent);
            }
        });

        CardView statisticsCardView = findViewById(R.id.statisticsCardView);
        statisticsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VirusStatisticsActivity.class);
                startActivity(intent);
            }
        });

        CardView photosAlbumCardView = findViewById(R.id.photosAlbumCardView);
        photosAlbumCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhotosAlbumActivity.class);
                startActivity(intent);
            }
        });

        CardView videosCardView = findViewById(R.id.videosCardView);
        videosCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });

        Button logoutBtn = findViewById(R.id.exitBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}
