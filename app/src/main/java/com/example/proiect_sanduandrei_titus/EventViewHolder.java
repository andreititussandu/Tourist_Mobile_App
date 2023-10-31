package com.example.proiect_sanduandrei_titus;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {
    TextView locationView, nameView, dateView;
    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        locationView=itemView.findViewById(R.id.tv_events_location);
        nameView=itemView.findViewById(R.id.tv_events_name);
        dateView=itemView.findViewById(R.id.tv_events_date);
    }
}
