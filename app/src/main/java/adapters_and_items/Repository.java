package adapters_and_items;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.flyshippment_project.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Repository
{
    static String url_str="a";
   /* private static final List<ShipmentItem> ShipmentList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem(url_str,8.40,5,"mobile","NewYork","Cairo","10/4/2020",
                            16.50,url_str,"Mayer Emad",3.5));
        add(new ShipmentItem(url_str,20.5,1,"bag","London","Alexandria","1/4/2020",
                            200.99,url_str,"Mero Gamed",2.5));
        add(new ShipmentItem(url_str,3.00,2,"Computer","Assuit","Tokyo","29/3/2020",
                             5.20,url_str,"7mada Mshakel",3.5));
    }};*/
    private static final String SHIPMENT_ITEMS_REQUEST_URL="http://www.originaliereny.com/shipping/public/api/shipInfo";

    private static final ArrayList<ShipmentItem> ShipmentList=new ArrayList<ShipmentItem>();
    public static ArrayList<ShipmentItem> getShipmentsFromApi()
    {
        ShipmentApiAsyncTask task = new ShipmentApiAsyncTask();
        task.execute();
        return ShipmentList;
    }


    private static final List<ShipmentItem> TripList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem(url_str,8.40,5,"Trip1","Cairo","NewYork","10/4/2020",
                16.50,url_str,"Mayer Emad",3.5));
        add(new ShipmentItem(url_str,20.5,1,"Trip2","London","Alexandria","1/4/2020",
                200.99,url_str,"Mero Gamed",2.5));
        add(new ShipmentItem(url_str,3.00,2,"Trip3","Assuit","Tokyo","29/3/2020",
                5.20,url_str,"7mada Mshakel",3.5));
    }};

    public static List<ShipmentItem> getTrips() {
        return TripList;
    }

    // TODO --------------- Networking in BackGround---------------
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
            ShipmentList.clear();
            ShipmentList.addAll(data);
        }
    }

}


