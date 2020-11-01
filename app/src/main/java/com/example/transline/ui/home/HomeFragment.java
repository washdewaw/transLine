package com.example.transline.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.transline.DepotActivity;
import com.example.transline.DriversActivity;
import com.example.transline.MapsActivity;
import com.example.transline.R;

public class HomeFragment extends Fragment {

    private Button Depot;
    private Button Drivers;
    private Button Container;
    private Button Maps;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home, parent, false);
        Depot = layout.findViewById(R.id.denDepotButton);
        Drivers = layout.findViewById(R.id.denDriversButton);
        Maps = layout.findViewById(R.id.denMapsButton);

        Depot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DepotActivity.class);
                startActivity(intent);
            }

        });

        Drivers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DriversActivity.class);
                startActivity(intent);
            }

        });

        Maps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }

        });


        return layout;
    }
}
