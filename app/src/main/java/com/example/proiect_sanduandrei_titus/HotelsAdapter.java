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

public class HotelsAdapter extends ArrayAdapter<Hotel> {
    Context context;
    List<Hotel> hotelList;
    private int resource;
    private LayoutInflater inflater;

    public HotelsAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects,
                           LayoutInflater inflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.hotelList=objects;
        this.inflater=inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(resource,parent,false);
        Hotel hotel=hotelList.get(position);
        addHotelName(view,hotel.getHotelName());
        addHotelTown(view,hotel.getTown());
        addHotelAddress(view, hotel.getAddress());
        return view;
    }

    private void addHotelAddress(View view, String hotelAddress) {
        TextView textView=view.findViewById(R.id.cell_lv_hotel_address);
        textView.setText(hotelAddress);
    }

    private void addHotelTown(View view, String hotelTown) {
        TextView textView=view.findViewById(R.id.cell_lv_hotel_town);
        textView.setText(hotelTown);
    }

    private void addHotelName(View view, String hotelName) {
        TextView textView=view.findViewById(R.id.cell_lv_hotel_name);
        textView.setText(hotelName);
    }

}
