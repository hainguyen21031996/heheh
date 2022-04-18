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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {
    ArrayList<FeartureHelperClass> featurelocation;

    public FeaturedAdapter(ArrayList<FeartureHelperClass> featurelocation) {
        this.featurelocation = featurelocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv1_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeartureHelperClass feartureHelperClass = featurelocation.get(position);
        holder.img.setImageResource(feartureHelperClass.getImg());
        holder.title.setText(feartureHelperClass.getTitle());
        holder.desc.setText(feartureHelperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return featurelocation.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.rcv1_img);
            title = itemView.findViewById(R.id.txt_img);
            desc = itemView.findViewById(R.id.txt_img_desc);
        }
    }
}
