package com.example.proiect_sanduandrei_titus;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAttractions;
    private FloatingActionButton fabEvents;
    private FloatingActionButton fabHotels;
    private List<Feedback> feedbackList=new ArrayList<>();
    private ListView lvFeedback;
    private ActivityResultLauncher<Intent> feedbackLauncher;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        feedbackLauncher=registerFeedbackLauncher();
        setupToggle();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id==R.id.menu_settings) {
                    Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(settingsIntent);
                }
                if(id==R.id.menu_photo_gallery) {
                    Intent galleryIntent = new Intent(getApplicationContext(), GalleryActivity.class);
                    startActivity(galleryIntent);
                }
                if(id==R.id.menu_feedback) {
                    Intent feedbackIntent = new Intent(getApplicationContext(), FeedbackActivity.class);
                    feedbackLauncher.launch(feedbackIntent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


    private void initComponents() {
        fabAttractions = findViewById(R.id.fab_main_attractions);
        fabEvents = findViewById(R.id.fab_main_events);
        fabHotels=findViewById(R.id.fab_main_hotels);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar_id);

        setFabAttractionsListener();
        setFabEventsListener();
        setFabHotelsListener();

        lvFeedback=findViewById(R.id.lv_main_feedback);
        lvAdapter();
    }

    private void setupToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
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

    private void setFabHotelsListener() {
        fabHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HotelActivity.class);
                startActivity(intent);
            }
        });
    }

    private void lvAdapter() {
//        ArrayAdapter<Feedback> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,
//                feedbackList);
        FeedbackAdapter adapter=new FeedbackAdapter(getApplicationContext(),R.layout.lv_cell_feedback_view,
                feedbackList,getLayoutInflater());
        lvFeedback.setAdapter(adapter);
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