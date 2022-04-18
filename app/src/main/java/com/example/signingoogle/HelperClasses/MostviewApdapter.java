package com.example.signingoogle.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signingoogle.R;

import java.util.ArrayList;

public class MostviewApdapter extends RecyclerView.Adapter<MostviewApdapter.MostViewedViewHolder> {

    ArrayList<MostviewHelperClass> mostViewedLocations;
    public MostviewApdapter(ArrayList<MostviewHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mostview_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostviewHelperClass helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitlemv());
        holder.des.setText(helperClass.getDescmv());
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, des;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_mv);
            textView = itemView.findViewById(R.id.title_mv);
            des = itemView.findViewById(R.id.desc_mv);
        }
    }
}
