package com.example.transline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class DepotActivity extends AppCompatActivity implements AdapterContainerDepot.OnContainerDepotClickListener{

    private Button Containertwo;
    private RecyclerView RecyclerDepot;
    private ContainerDepot containerDepot;
    private AdapterContainerDepot adapterContainerDepot;
    ArrayList<ContainerDepot> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depot);
        list = new ArrayList<>();
        list.add(new ContainerDepot("ContLXLYG1", "Mombasa Depot", "Not Cleared", "Not Ready for Transit","Mark Twain"));
        list.add(new ContainerDepot("ContLXLYG12", "From Mombasa Depot to Kitale", "Cleared", "Ready for Transit","Shake Spear"));
        list.add(new ContainerDepot("ContLXLYG7", "From Mombasa to Nairobi", "Cleared", "In Transit","Lennon John"));
        list.add(new ContainerDepot("ContLXLYG21", "NOT ARRIVED", "Cleared", "Not Ready for Transit","Presley Elvis"));

        adapterContainerDepot =new AdapterContainerDepot(list,this,this);
        RecyclerDepot = findViewById(R.id.DepotRecycler);
        RecyclerDepot.setLayoutManager(new LinearLayoutManager(this));
        adapterContainerDepot.setHasStableIds(true);
        adapterContainerDepot.notifyDataSetChanged();
       RecyclerDepot.setAdapter(adapterContainerDepot);


    }

    @Override
    public void onContainerDepot(int position) {
        containerDepot = list.get(position);
        Intent intentDriver= new Intent(DepotActivity.this, DriverProfile.class);
        intentDriver.putExtra("driveName",containerDepot.getDriver());
        intentDriver.putExtra("driveDetails",containerDepot.getDetails());
        intentDriver.putExtra("driveTransit",containerDepot.getTransit());
        intentDriver.putExtra("containerName",containerDepot.getName());
        startActivity(intentDriver);
    }
}
