package search_classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import adapters_and_items.ShipmentItem;

public class SearchViewModel extends ViewModel
{
    private MutableLiveData<ArrayList<ShipmentItem>> ShipmentListLiveData = new MutableLiveData<ArrayList<ShipmentItem>>();

    public LiveData<ArrayList<ShipmentItem>> getShipmentLiveData() {
        return ShipmentListLiveData;
    }

    public void setShipmentLiveData(ArrayList<ShipmentItem> data) { ShipmentListLiveData.setValue(data); }


    //Todo (Edit) ShipmentItem->TripItem
    private MutableLiveData<ArrayList<ShipmentItem>> TripListLiveData = new MutableLiveData<ArrayList<ShipmentItem>>();
    //Todo (Edit)ShipmentItem->TripItem
    public LiveData<ArrayList<ShipmentItem>> getTripLiveData() {
        return TripListLiveData;
    }
    //Todo (Edit) ShipmentItem->TripItem
    public void setTripLiveData(ArrayList<ShipmentItem> data) {
        TripListLiveData.setValue(data);
    }

}

