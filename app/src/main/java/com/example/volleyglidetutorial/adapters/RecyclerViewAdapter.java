package com.example.volleyglidetutorial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volleyglidetutorial.R;
import com.example.volleyglidetutorial.activities.AnimeActivity;
import com.example.volleyglidetutorial.model.Anime;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;
    private RequestOptions options;


    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_items, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, AnimeActivity.class);

                intent.putExtra("anime_name", mData.get(myViewHolder.getAdapterPosition()).getName());
                intent.putExtra("anime_description", mData.get(myViewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("anime_studio", mData.get(myViewHolder.getAdapterPosition()).getStudio());
                intent.putExtra("anime_category", mData.get(myViewHolder.getAdapterPosition()).getCategory());
                intent.putExtra("anime_rating", mData.get(myViewHolder.getAdapterPosition()).getRating());
                intent.putExtra("anime_image", mData.get(myViewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(intent);


            }
        });

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_name.setText(mData.get(position).getName());
        myViewHolder.tv_rating.setText(mData.get(position).getRating());
        myViewHolder.tv_studio.setText(mData.get(position).getStudio());
        myViewHolder.tv_category.setText(mData.get(position).getCategory());


        // for image we are using glide library
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(myViewHolder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            tv_category = itemView.findViewById(R.id.category);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}
