package search_classes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import adapters_and_items.AdapterShipment;
import com.example.flyshippment_project.R;

import adapters_and_items.DataProvider;
import adapters_and_items.ShipmentItem;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trip_Shower_Freg extends Fragment
{

    public Trip_Shower_Freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.recycler_viewer_search, container, false);

        final ArrayList<ShipmentItem>  ShipmentsList = (ArrayList<ShipmentItem>) DataProvider.getShipments();

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rc1);

        // use a linear layout manager                                    ***********
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter mAdapter = new AdapterShipment(ShipmentsList);
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
