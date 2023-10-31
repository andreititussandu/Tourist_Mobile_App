package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EventsActivity extends AppCompatActivity {
    private Button btnBack;
    private ListView lvEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        initComponents();
    }
    //to add datepicker for viewing events in a specific time period for next phase
    private void initComponents() {
        btnBack = findViewById(R.id.btn_events_back);
        lvEvents = findViewById(R.id.lv_events);

        setListener();
        setupListView();
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

    private void setupListView() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.events_list, android.R.layout.simple_list_item_1);
        lvEvents.setAdapter(adapter);
    }
}