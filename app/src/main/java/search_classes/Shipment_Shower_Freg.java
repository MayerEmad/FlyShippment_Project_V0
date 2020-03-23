package search_classes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import adapters_and_items.AdapterShipment;
import com.example.flyshippment_project.R;

import adapters_and_items.DataProvider;
import adapters_and_items.ShipmentItem;
import java.util.ArrayList;
import java.util.Date;

public class Shipment_Shower_Freg extends Fragment
{
    public Shipment_Shower_Freg()
    {

        //FragmentManager fragmentManager=getChildFragmentManager().beginTransaction().replace(R.id.container_frame,new SearchNavFragment()).commit();
    }
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Its Layout is the Recycler View as Trip_Shower_Freg
        View rootView= inflater.inflate(R.layout.recycler_viewer_search, container, false);

        //TODO get from Bundle
         Bundle fromMain= getArguments();

            recyclerView = (RecyclerView) rootView.findViewById(R.id.rc1);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

             ArrayList<ShipmentItem> FromAPI=(ArrayList<ShipmentItem>) DataProvider.getShipments();
             ArrayList<ShipmentItem> ShipmentsList=new ArrayList<ShipmentItem>();
             ShipmentsList.addAll(FromAPI);


            if(fromMain!=null)
            {
                ArrayList<ShipmentItem> FilteredShipmentsList=(ArrayList<ShipmentItem>) fromMain.getSerializable("SSF_Array");
                mAdapter = new AdapterShipment(FilteredShipmentsList,getContext());
                Toast.makeText(getContext(), "After Search"+mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
            }
            else mAdapter = new AdapterShipment(ShipmentsList,getContext());

            recyclerView.setAdapter(mAdapter);
            return rootView;
    }

    @Override
    public void onDestroyView() {
        //Log.i("Shipment_Shower_Freg", "----------------------The Son Fregment is dead now");
        Toast.makeText(getContext(), "Shipment_Shower_Fregment is dead now ", Toast.LENGTH_SHORT).show();

        super.onDestroyView();
    }

}
