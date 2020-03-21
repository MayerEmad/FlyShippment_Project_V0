package adapters_and_items;

import android.util.Log;

import com.example.flyshippment_project.R;

import java.util.ArrayList;
import java.util.List;

public class DataProvider
{

    private static final List<ShipmentItem> ShipmentList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem("Shipment 1", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Shipment 2", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Shipment 3", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Shipment 4", R.drawable.ic_launcher_foreground));
    }};

    public static List<ShipmentItem> getShipments() {
       // Log.i("DataProvider", "----------------------ShipmentList Size="+ShipmentList.size());
        return ShipmentList;
    }

    private static final List<ShipmentItem> TripList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem("Trip 1", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Trip 2", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Trip 3", R.drawable.ic_launcher_foreground));
        add(new ShipmentItem("Trip 4", R.drawable.ic_launcher_foreground));
    }};

    public static List<ShipmentItem> getTrips() {
        // Log.i("DataProvider", "----------------------ShipmentList Size="+ShipmentList.size());
        return TripList;
    }
}

