package com.example.ahmme.tourmate.NearBy;


import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ahmme.tourmate.R;
import com.example.ahmme.tourmate.Tracker.MapsActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearByFragment extends Fragment {
    ArrayList<String> nearByItemListView;
    NearByCatagoryAdapter adapter;
    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_near_by, container, false);
        nearByItemListView=new ArrayList<>();
        listView=(ListView)view.findViewById(R.id.near_by_list_view);
        nearByItemListView.add("Hospital");
        nearByItemListView.add("Atm Booth");
        nearByItemListView.add("Resturant");
        nearByItemListView.add("Caffay");
        nearByItemListView.add("CNG Station");
        adapter=new NearByCatagoryAdapter(getActivity(), nearByItemListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });



        return view;
    }

}
