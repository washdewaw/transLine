package com.example.transline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DriversActivity extends AppCompatActivity implements AdapterDrivers.OnDriverClickListener{
    private RecyclerView RecyclerDriver;
    private AdapterDrivers adapterDrivers;
    private List<ContainerDrivers> list;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        RecyclerDriver= findViewById(R.id.DriversRecycler);
            list = new ArrayList<>();
            list.add(new ContainerDrivers("Mark Twain", "233445", "Newbie", "None.","ContLXLYG1"));
            list.add(new ContainerDrivers("Shake Spear", "655443", "Master", "Nairobi Depot.","ContLXLYG12"));
            list.add(new ContainerDrivers("Lennon John", "838485", "Legend", "Kitale.","ContLXLYG7"));
            list.add(new ContainerDrivers("Presley Elvis", "038495", "Ultimate", "Nakuru.","ContLXLYG21"));
            list.add(new ContainerDrivers("Mike Jack", "057495", "Begginer", "Naivasha Depot.",""));
            list.add(new ContainerDrivers("Braynt Kobe", "086480", "Professional", "Eldoret.",""));
            adapterDrivers =new AdapterDrivers(list,this,this);
            RecyclerDriver.setLayoutManager(new LinearLayoutManager(this));
            adapterDrivers.setHasStableIds(true);
            adapterDrivers.notifyDataSetChanged();
            RecyclerDriver.setAdapter(adapterDrivers);

    }

    @Override
    public void onDriverClick(int position) {
           ContainerDrivers containerDrivers = list.get(position);
        Intent intent= new Intent(DriversActivity.this, DriverProfile.class);
        intent.putExtra("driveName",containerDrivers.getName());
        intent.putExtra("driveDetails",containerDrivers.getDetails());
        intent.putExtra("driveTransit",containerDrivers.getTransit());
        intent.putExtra("containerName",containerDrivers.getContainer());
        startActivity(intent);

    }
}
