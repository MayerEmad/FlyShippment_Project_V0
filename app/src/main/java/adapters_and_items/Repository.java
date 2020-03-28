package adapters_and_items;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.flyshippment_project.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import search_classes.SearchViewModel;

public class Repository
{
    private static final String SHIPMENT_ITEMS_REQUEST_URL="http://www.originaliereny.com/shipping/public/api/shipInfo";

    // for RecyclerShipment we use LiveData
    // Data is stored in  SearchViewModel.getShipmentLiveData().getValue();
    public static ArrayList<ShipmentItem> getShipmentsFromApi()
    {
        ShipmentApiAsyncTask task = new ShipmentApiAsyncTask();
        task.execute();
        return SearchViewModel.getShipmentLiveData().getValue();
    }

    private static final ArrayList<TripItem> TripList = new ArrayList<TripItem>() {{
        add(new TripItem("NewYork","Cairo","10/4/2020",5.5,3.5 ,null,"Mayer Emad",3.5));
        add(new TripItem("London","Assuit","1/4/2020",33,4 ,null,"Mayer Emad",3.5));
        add(new TripItem("China","Alex","9/3/2020",13,9.4 ,null,"Mayer Emad",3.5));
    }};
    public static ArrayList<TripItem>  getTrips() {
        return TripList;
    }

    // TODO --------------- Networking in BackGround Shipments---------------
    private static class ShipmentApiAsyncTask extends AsyncTask<Void, Void, ArrayList<ShipmentItem>>
    {
        @Override
        protected ArrayList<ShipmentItem> doInBackground(Void... voids)
        {
            ArrayList<ShipmentItem> result = QueryUtils.getApiShipmentItemsData(SHIPMENT_ITEMS_REQUEST_URL);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<ShipmentItem> data) {
            SearchViewModel.setShipmentLiveData(data);   //Update Recycler View Adapters
        }
    }

    // TODO --------------- Networking in BackGround Trips---------------
    // String imgURL = places.getImage();
    //Picasso.with(context).load(imgURL).into(holder.imageView);
}

