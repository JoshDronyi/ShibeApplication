package com.example.shibeapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shibeapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {
    private Context context;
    private List<String> shibeURLs;

    public ShibeAdapter(List<String> urls) {
        shibeURLs = urls;
    }

    @NonNull
    @Override
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View theView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shibe_item, parent, false);
        return new ShibeViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
        //TOdo bind the image views to the data received from the list.

        String imageString = shibeURLs.get(position);

        Picasso.get()
                .load(imageString)
                .fit()
                .into(holder.shibeImage);


    }

    @Override
    public int getItemCount() {
        return shibeURLs.size();
    }

    public class ShibeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView shibeImage;

        public ShibeViewHolder(@NonNull View itemView) {
            super(itemView);
            shibeImage = itemView.findViewById(R.id.rv_shibeImage);
            shibeImage.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            //TODO This is where you should make the position of the image show up
        }
    }
}
