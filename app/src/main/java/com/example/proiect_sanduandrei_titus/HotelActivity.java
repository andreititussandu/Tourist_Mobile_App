package com.example.proiect_sanduandrei_titus;

import com.example.proiect_sanduandrei_titus.network.HttpManager;
import com.example.proiect_sanduandrei_titus.parser.DataJsonParser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    private static final String HOTELS_URL="https://www.jsonkeeper.com/b/ZY6D";
    private List<Hotel> hotelList=new ArrayList<>();
    private ListView lvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        //initComponents();
        lvHotel=findViewById(R.id.lv_hotel);
        lvAdapter();
        loadDataFromUrl();
    }

    private void loadDataFromUrl() {
        Thread thread=new Thread(){
            @Override
            public void run() {
                HttpManager manager=new HttpManager(HOTELS_URL);
                String result=manager.process();
                new Handler(getMainLooper()).post(() -> mainThreadGetDataFromHttpCallback(result));
            }
        };
        thread.start();
    }


    private void mainThreadGetDataFromHttpCallback(String result){
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        hotelList.addAll(DataJsonParser.fromJson(result));
        notifyAdapter();
    }

    private void lvAdapter() {
        HotelsAdapter adapter=new HotelsAdapter(getApplicationContext(),R.layout.lv_cell_hotels_view,
                hotelList,getLayoutInflater());
        lvHotel.setAdapter(adapter);
    }

    private void notifyAdapter() {
        HotelsAdapter adapter = (HotelsAdapter) lvHotel.getAdapter();
        adapter.notifyDataSetChanged();
    }
}