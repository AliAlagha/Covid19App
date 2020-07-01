package com.example.covid19app.adapters;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.AlbumViewHolder> {

    private Context context;
    private List<String> images;
    private OnClickListener onClickListener;

    public AlbumListAdapter(Context context, List<String> images, OnClickListener onClickListener) {
        this.context = context;
        this.images = images;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_list_item, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AlbumViewHolder holder, int position) {

        Picasso.get().load(images.get(position)).into(holder.albumImageView);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        ImageView albumImageView;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            albumImageView = itemView.findViewById(R.id.albumImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onClickListener.onClick(getAdapterPosition());

                }
            });

        }

    }

    public interface OnClickListener {

        void onClick(int position);

    }

}
