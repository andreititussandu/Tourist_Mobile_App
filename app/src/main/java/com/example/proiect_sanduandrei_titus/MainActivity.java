package com.example.proiect_sanduandrei_titus;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mainInitial;
    private FloatingActionButton fabAttractions;
    private FloatingActionButton fabEvents;
    private List<Feedback> feedbackList=new ArrayList<>();
    private ListView lvFeedback;
    private ActivityResultLauncher<Intent> feedbackLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        feedbackLauncher=registerFeedbackLauncher();
    }

    private void initComponents() {
        fabAttractions = findViewById(R.id.fab_main_attractions);
        fabEvents = findViewById(R.id.fab_main_events);

        setFabAttractionsListener();
        setFabEventsListener();

        lvFeedback=findViewById(R.id.lv_main_feedback);
        lvAdapter();
    }

    private void lvAdapter() {
        ArrayAdapter<Feedback> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
                feedbackList);
        lvFeedback.setAdapter(adapter);
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

    private ActivityResultLauncher<Intent> registerFeedbackLauncher() {
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK && result.getData()!= null) {
                Feedback feedback = (Feedback) result.getData()
                        .getSerializableExtra(FeedbackActivity.FEEDBACK_KEY);
                if (feedback != null) {
                    feedbackList.add(feedback);
                    ArrayAdapter adapter = (ArrayAdapter) lvFeedback.getAdapter();
                    adapter.notifyDataSetChanged();
                }
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
            Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingsIntent);
        }
        if(item.getItemId()==R.id.menu_photo_gallery) {
            Intent galleryIntent = new Intent(getApplicationContext(), GalleryActivity.class);
            startActivity(galleryIntent);
        }
        if(item.getItemId()==R.id.menu_feedback) {
            Intent feedbackIntent = new Intent(getApplicationContext(), FeedbackActivity.class);
            feedbackLauncher.launch(feedbackIntent);
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