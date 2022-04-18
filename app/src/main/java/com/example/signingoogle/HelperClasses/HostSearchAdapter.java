package com.example.signingoogle.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signingoogle.R;

import java.util.ArrayList;

public class HostSearchAdapter extends RecyclerView.Adapter<HostSearchAdapter.AdapterAllHostsearchViewHolder> {

    ArrayList<HostsearchHelperClass> hostsearchlocation;

    public HostSearchAdapter(ArrayList<HostsearchHelperClass> mostViewedLocations) {
        this.hostsearchlocation = mostViewedLocations;
    }

    @NonNull
    @Override
    public AdapterAllHostsearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostsearch_card_design, parent, false);
        AdapterAllHostsearchViewHolder lvh = new AdapterAllHostsearchViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllHostsearchViewHolder holder, int position) {

        HostsearchHelperClass helperClass = hostsearchlocation.get(position);
        holder.title.setText(helperClass.getTitle());
        holder.desc.setText(helperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return hostsearchlocation.size();
    }

    public static class AdapterAllHostsearchViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc;

        public AdapterAllHostsearchViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_hs);
            desc = itemView.findViewById(R.id.desc_hs);
        }
    }
}
