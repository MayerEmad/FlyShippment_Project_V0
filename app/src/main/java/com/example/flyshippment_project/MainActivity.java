package com.example.flyshippment_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements SearchNavFragment.OnSearchButtonClickListenerInterface
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

    @Override
    public void onFiltering(/* GET filtering items*/)
    {
        Shipment_Shower_Freg SSF=new Shipment_Shower_Freg();
            //TODO filter for Shipments
            ArrayList<ShipmentItem> ShipmentList = new ArrayList<ShipmentItem>();
            ShipmentList.add(new ShipmentItem("Shipment 5", R.drawable.ic_launcher_foreground));
            ShipmentList.add(new ShipmentItem("Shipment 6", R.drawable.ic_launcher_foreground));
           //TODO save in bundle and
            Bundle SSF_bundle=new Bundle();
            SSF_bundle.putSerializable("SSF_Array",(Serializable)ShipmentList);
            //TODO send
            SSF.setArguments(SSF_bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.search_page_viewer,SSF).commit();
          //  Toast.makeText(this, "From SearchNav ----------> To MainActivity", Toast.LENGTH_SHORT).show();
    }
}
