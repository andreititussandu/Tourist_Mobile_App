package com.example.proiect_sanduandrei_titus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    Context context;
    List<Event> events;

    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_cell_events_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.locationView.setText(events.get(position).getLocation());
        holder.nameView.setText(events.get(position).getName());
        holder.dateView.setText(events.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
