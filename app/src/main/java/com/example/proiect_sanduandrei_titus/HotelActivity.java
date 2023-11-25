package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    private List<Hotel> hotelList=new ArrayList<>();
    private ListView lvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        initComponents();
        lvHotel=findViewById(R.id.lv_hotel);
        lvAdapter();
    }
    private void initComponents(){
        String[] hotelNames = getResources().getStringArray(R.array.hotel_names);
        String[] towns = getResources().getStringArray(R.array.hotel_towns);
        String[] addresses = getResources().getStringArray(R.array.hotel_addresses);
        hotelList=new ArrayList<>();

        for (int i = 0; i < hotelNames.length; i++) {
            Hotel hotel = new Hotel(hotelNames[i], towns[i], addresses[i]);
            hotelList.add(hotel);
        }
    }

    private void lvAdapter() {
        HotelsAdapter adapter=new HotelsAdapter(getApplicationContext(),R.layout.lv_cell_hotels_view,
                hotelList,getLayoutInflater());
        lvHotel.setAdapter(adapter);
    }
}