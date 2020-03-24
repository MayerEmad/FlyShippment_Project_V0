package adapters_and_items;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flyshippment_project.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterShipment extends RecyclerView.Adapter<AdapterShipment.MyViewHolder>
{
    private ArrayList<ShipmentItem> ShipmentsList;
    private Context mcontext;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterShipment(ArrayList<ShipmentItem> DataList,Context con)
    {
        ShipmentsList = DataList;
        mcontext=con;
    }

    //ok
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ImageView imageView;

        public MyViewHolder(View listItemView)
        {
            super(listItemView);
            textView=(TextView)listItemView.findViewById(R.id.xxx);
            imageView=(ImageView)listItemView.findViewById(R.id.image);
        }

    }

    // ok Create new views (invoked by the layout manager)
    @Override
    public AdapterShipment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View listItemView = LayoutInflater.from(mcontext).inflate(R.layout.shipment_item, parent, false);
        MyViewHolder vh = new MyViewHolder(listItemView);
        Log.i("-------------------->", "onCreate ");
        return vh;
    }

    // ok Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(ShipmentsList.get(position).getstr());
        holder.imageView.setImageResource(ShipmentsList.get(position).getImageId());
        Log.i("AdapterShipment--------", "onBind "+ShipmentsList.get(position).getstr());
    }

    // ok Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ShipmentsList.size();
    }

    public void updateData(ArrayList<ShipmentItem> filteredItems) {
        Log.i("Adapter Shipment","-------------Update is called");
        ShipmentsList.clear();
        ShipmentsList.addAll(filteredItems);
        this.notifyDataSetChanged();
    }
    public void clear() {
        int size = ShipmentsList.size();
        ShipmentsList.clear();
        notifyItemRangeRemoved(0, size);
    }



}

