package search_classes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapters_and_items.AdapterRecyclerShipment;
import com.example.flyshippment_project.R;

import adapters_and_items.Repository;
import adapters_and_items.ShipmentItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trip_Shower_Freg extends Fragment
{

    public Trip_Shower_Freg() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.recycler_viewer_search, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        recyclerView = (RecyclerView) view.findViewById(R.id.rc1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        // For the first time before applying any Filtering
        ArrayList<ShipmentItem> FromAPI=(ArrayList<ShipmentItem>) Repository.getTrips();
        recyclerView.setAdapter(new AdapterRecyclerShipment(FromAPI));

        //TODO  (Edit)ShipmentItem -> TripItem
        //When the Data from the API Changes due to Filtering it will be updated here
        final SearchViewModel viewModel = ViewModelProviders.of(getActivity()).get(SearchViewModel.class);
        viewModel.getTripLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<ShipmentItem>>() {
            @Override
            public void onChanged(ArrayList<ShipmentItem> tripItems) {
                recyclerView.setAdapter(new AdapterRecyclerShipment( tripItems));
            }
        });
    }
}
