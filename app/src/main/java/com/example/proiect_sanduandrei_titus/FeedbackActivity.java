package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FeedbackActivity extends AppCompatActivity {
    private Spinner spnChooseAttraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        spnChooseAttraction=findViewById(R.id.spn_feedback_choose_attraction);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.attractions_list, android.R.layout.simple_spinner_dropdown_item);
        spnChooseAttraction.setAdapter(adapter);
    }
}