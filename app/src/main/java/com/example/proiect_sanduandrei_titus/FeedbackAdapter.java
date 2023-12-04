package com.example.proiect_sanduandrei_titus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedbackAdapter extends ArrayAdapter<Feedback> {
    Context context;
    List<Feedback> feedbackList;
    private int resource;
    private LayoutInflater inflater;

    public FeedbackAdapter(@NonNull Context context, int resource, @NonNull List<Feedback> objects,
                           LayoutInflater inflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.feedbackList=objects;
        this.inflater=inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(resource,parent,false);
        Feedback feedback=feedbackList.get(position);
        addFeedbackName(view,feedback.getName());
        addFeedbackEmail(view,feedback.getEmail());
        addFeedbackAttraction(view,feedback.getAttraction());
        addFeedbackRating(view,feedback.getRating());
        return view;
    }

    private void addFeedbackRating(View view, float rating) {
        TextView textView=view.findViewById(R.id.cell_lv_rating);
        textView.setText(String.valueOf(rating));
    }

    private void addFeedbackAttraction(View view, String attraction) {
        TextView textView=view.findViewById(R.id.cell_lv_hotel_ratings);
        textView.setText(attraction);
    }

    private void addFeedbackEmail(View view, String email) {
        TextView textView=view.findViewById(R.id.cell_lv_hotel_location);
        textView.setText(email);
    }

    private void addFeedbackName(View view, String name) {
        TextView textView=view.findViewById(R.id.cell_lv_name);
        textView.setText(name);
    }

}
