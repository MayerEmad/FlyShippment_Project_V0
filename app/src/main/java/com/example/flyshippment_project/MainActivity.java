package com.example.flyshippment_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import adapters_and_items.ShipmentItem;
import login_rejester_splash.SplashScreen;
import search_classes.SearchNavFragment;
import search_classes.Shipment_Shower_Freg;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private static boolean goToSplash=true;


    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment SelectedFragment=null;

                    switch (menuItem.getItemId()) {
                        case R.id.search_bottom_nav:
                            SelectedFragment=new SearchNavFragment();
                            break;
                        case R.id.shipment_bottom_nav:
                            SelectedFragment=new ShipmentNavFragment();
                            break;
                        case R.id.trib_bottom_nav:
                            SelectedFragment=new TripNavFragment();
                            break;
                        case R.id.inbox_bottom_nav:
                            SelectedFragment=new InboxNavFragment();
                            break;
                        case R.id.profile_bottom_nav:
                            SelectedFragment=new ProfileNavFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_frame,SelectedFragment).commit();
                    return true;
                }
            };

    // We can move to SearchNavFragment , ShipmentNavFragment , TripNavFragment , InboxNavFragment ,ProfileNavFragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Bottom Navigation Bar Listener
        BottomNavigationView bottomNav=findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_frame,new SearchNavFragment()).commit(); //Default
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

}
