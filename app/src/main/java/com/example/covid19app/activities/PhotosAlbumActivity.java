package com.example.covid19app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.covid19app.R;
import com.example.covid19app.adapters.AlbumListAdapter;
import com.example.covid19app.adapters.AlbumPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PhotosAlbumActivity extends AppCompatActivity {

    private ViewPager sliderPager;
    private RecyclerView recyclerView;
    private List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos_album);

        sliderPager = findViewById(R.id.viewPager);
        recyclerView = findViewById(R.id.recyclerView);

        viewPagerSetup();

        recyclerViewSetup();

        getData();

    }

    private void recyclerViewSetup() {

        List<String> data = getData();

        AlbumListAdapter albumListAdapter = new AlbumListAdapter(getApplicationContext(), data
                , new AlbumListAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {

                sliderPager.setCurrentItem(position);

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL
                ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(albumListAdapter);

    }

    private void viewPagerSetup() {

        List<String> data = getData();

        AlbumPagerAdapter albumPagerAdapter = new AlbumPagerAdapter(getApplicationContext(),data);

        sliderPager.setAdapter(albumPagerAdapter);

    }

    private List<String> getData() {

        images = new ArrayList<>();

        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com" +
                "/o/1-1318109.jpg?alt=media&token=ec991292-5542-4030-9588-a273239b6c0b");
        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com" +
                "/o/unnamed.png?alt=media&token=85987020-9546-4253-9fb7-6271d6ffec38");
        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/32020261489462" +
                ".jpg?alt=media&token=0c5c705f-1b0d-4d8c-816a-f1b8f385200f");
        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/" +
                "_110902442_coronavirus_symptoms_short_640-nc.png?alt=media&token=cad3cb8a-6506-4d43-b783-2613750ee697");
        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793.appspot.com/o/%D9%83%D9%88%D8%B1%D9%88%D9%86%D8%A7-" +
                "3.png?alt=media&token=274c7641-e713-49cd-85cb-64f623a006f6");
        images.add("https://firebasestorage.googleapis.com/v0/b/covid19app-8d793" +
                ".appspot.com/o/776.jpg?alt=media&token=c771c9d6-19a1-4ce2-a1cd-93b981e8ad9f");

        return images;

    }

}
