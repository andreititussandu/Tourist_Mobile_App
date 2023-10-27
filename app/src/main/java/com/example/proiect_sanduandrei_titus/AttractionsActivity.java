package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AttractionsActivity extends AppCompatActivity {
    private Button btnBack;
    private ListView lvAttractionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        btnBack=findViewById(R.id.btn_attractions_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        lvAttractionsList=findViewById(R.id.lv_attractions_list);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),
               R.array.attractions_list, android.R.layout.simple_list_item_1);
        lvAttractionsList.setAdapter(adapter);
    }
}