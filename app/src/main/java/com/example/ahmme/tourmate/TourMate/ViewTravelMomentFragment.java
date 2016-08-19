package com.example.ahmme.tourmate.TourMate;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ahmme.tourmate.R;
import com.example.ahmme.tourmate.TravelLogManagement.TravelLogFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewTravelMomentFragment extends Fragment {
    ListView listViewLv;
    ImageView addEventIV;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_travel_moment, container, false);
        listViewLv = (ListView) view.findViewById(R.id.listView);
        addEventIV = (ImageView) view.findViewById(R.id.add_event);

        addEventIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddEventFragment.class);
                startActivity(intent);
            }
        });

        arrayList = new ArrayList<>();
        arrayList.add("Zakarai");
        arrayList.add("Emon");
        arrayList.add("Arif");
        arrayList.add("Masud");
        arrayList.add("Imam");
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, arrayList);
        listViewLv.setAdapter(adapter);
        listViewLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), TravelLogFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
