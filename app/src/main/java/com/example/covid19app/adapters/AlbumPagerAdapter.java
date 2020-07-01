package com.example.covid19app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.covid19app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumPagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> slides;

    public AlbumPagerAdapter(Context context, List<String> slides) {
        this.context = context;
        this.slides = slides;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.album_pager_item, null);

        ImageView albumImageView = view.findViewById(R.id.albumImageView);
        Picasso.get().load(slides.get(position)).into(albumImageView);

        container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return slides.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
