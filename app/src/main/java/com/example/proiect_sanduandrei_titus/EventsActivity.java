package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private Button btnBack;
    private RecyclerView rvEvents;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initComponents();
    }
    //to add datepicker for viewing events in a specific time period for next phase
    private void initComponents() {
        btnBack = findViewById(R.id.btn_events_back);
        rvEvents = findViewById(R.id.rv_events);

        String[] locations = getResources().getStringArray(R.array.event_locations);
        String[] names = getResources().getStringArray(R.array.event_names);
        String[] dates = getResources().getStringArray(R.array.event_dates);
        events=new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            Event event = new Event(locations[i], names[i], dates[i]);
            events.add(event);
        }

        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        rvEvents.setAdapter(new EventAdapter(getApplicationContext(), events));
        setListener();
    }

    private void setListener() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}