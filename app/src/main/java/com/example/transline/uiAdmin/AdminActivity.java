package com.example.transline.uiAdmin;

import android.content.Intent;
import android.os.Bundle;

import com.example.transline.LoginActivity;
import com.example.transline.NavActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.transline.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.transline.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseUser mUser;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        checkLogIn();
        Toolbar toolbar = findViewById(R.id.toolbarAdmin);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fabAdmin);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    DrawerLayout drawer = findViewById(R.id.drawer_layout_admin);
    NavigationView navigationView = findViewById(R.id.nav_view_admin);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    mAppBarConfiguration = new AppBarConfiguration.Builder(
    R.id.nav_home_admin, R.id.nav_manage_drivers, R.id.nav_manage_shipments)
            .setDrawerLayout(drawer)
                .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_admin);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btn_log_out:
                if (mUser!=null){
                    signOut();
                }
                else {
                    Intent intent= new Intent(AdminActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent= new Intent(AdminActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
    }
    private void checkLogIn() {
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser != null) {

        } else {
            Intent intentLogin= new Intent(AdminActivity.this,LoginActivity.class);
            startActivity(intentLogin);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_admin);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

