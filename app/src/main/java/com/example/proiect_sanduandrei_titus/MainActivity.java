package com.example.proiect_sanduandrei_titus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private TextView mainInitial;
    private FloatingActionButton fabAttractions;
    private FloatingActionButton fabEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        fabAttractions = findViewById(R.id.fab_main_attractions);
        fabEvents = findViewById(R.id.fab_main_events);

        setFabAttractionsListener();
        setFabEventsListener();
    }

    private void setFabAttractionsListener() {
        fabAttractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AttractionsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setFabEventsListener() {
        fabEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_settings) {
            Intent feedbackIntent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(feedbackIntent);
        }
        if(item.getItemId()==R.id.menu_photo_gallery) {

        }
        if(item.getItemId()==R.id.menu_feedback) {
            Intent feedbackIntent = new Intent(getApplicationContext(), FeedbackActivity.class);
            startActivity(feedbackIntent);
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}