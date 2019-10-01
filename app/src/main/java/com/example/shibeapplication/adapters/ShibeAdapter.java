package com.example.shibeapplication.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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
        String imagePosition = String.valueOf(position);
        holder.shibeImage.setTag("Image position in array was :" + imagePosition);

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
            Toast.makeText(context, view.getTag().toString(), Toast.LENGTH_SHORT).show();
            Log.e("POSITION OF IMAGE", view.getTag().toString());
        }
    }
}
