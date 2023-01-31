package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private final static String PHOTO_URL = "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Droopy_dog.png/150px-Droopy_dog.png";
    private final List<dog> mdog;
    private Context mContext;

    DogsAdapter(List<dog> dog) {

        this.mdog = dog;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        dog dog = mdog.get(position);
        holder.nameTextView.setText(dog.getName());

        Picasso.with(mContext)
                .load(PHOTO_URL + dog.getPhoto())
                .resize(200, 150)
                .into(holder.  dogsImageView );

    }

    @Override
    public int getItemCount() {
        if (mdog == null) {
            return 0;
        }
        return mdog.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView   dogsImageView ;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            dogsImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
        }
    }
}