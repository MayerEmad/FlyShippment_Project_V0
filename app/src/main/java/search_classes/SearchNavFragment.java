package search_classes;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import adapters_and_items.AdapterTaps;
import adapters_and_items.ShipmentItem;

import com.example.flyshippment_project.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class SearchNavFragment extends Fragment
{

    public SearchNavFragment() {
        // Required empty public constructor
    }

    // OnSearchButtonClickListenerInterface interface, calls a method in the host activity named onFiltering
    public interface OnSearchButtonClickListenerInterface {
        void onFiltering();
    }
    // Define a new interface OnSearchButtonClickListenerInterface that triggers a callback in the host activity
    OnSearchButtonClickListenerInterface mCallback;

    // Override onAttach to make sure that the container activity has implemented the callback
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            mCallback = (OnSearchButtonClickListenerInterface) context;
        } catch (ClassCastException e)
        {
         //   throw new ClassCastException(context.toString() + " must implement OnSearchButtonClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView= inflater.inflate(R.layout.fragment_search_nav, container, false);

        // Create an adapter that knows which fragment should be shown on each page
        AdapterTaps adapter = new AdapterTaps(getChildFragmentManager(),1);

        // Viewer page hosts the Shipment_Shower_Freg & Trip_Shower_Freg
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.search_page_viewer);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.search_page_upper_tab);
        tabLayout.setupWithViewPager(viewPager);

       //TODO  ------------------Filtering---------------------

        Button searchButton = (Button)rootView.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               mCallback.onFiltering();
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        Log.i("SearchNavFragment", " ------------------The Big Search Fregment is Dead now. ");
        super.onDestroy();
    }



}
