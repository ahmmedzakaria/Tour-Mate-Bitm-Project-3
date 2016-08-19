package com.example.ahmme.tourmate.Tracker;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmme.tourmate.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationTrackerFragment extends Fragment implements View.OnClickListener {
    TextView locationText;
    ListView listViewLV;
    ImageView showMapIV;
    LocationTracker tracker;
    LocationManager manager;
    MyReceiver myReceiver;
    private String datapassed;
    Switch mySwitch = null;
    LocationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_tracker, container, false);

        locationText = (TextView) view.findViewById(R.id.loation);
        listViewLV = (ListView) view.findViewById(R.id.listView);
        showMapIV = (ImageView) view.findViewById(R.id.show_map);
        showMapIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });


        mySwitch = (Switch) view.findViewById(R.id.mySwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mySwitch.isChecked()) {
                    mySwitch.setText("Tracking ON");
                    Intent intent = new Intent(getActivity(), TrackingService.class);
                    getActivity().startService(intent);

                } else if (!mySwitch.isChecked()) {
                    mySwitch.setText("Tracking OFF");
                    getActivity().stopService(new Intent(getActivity(), TrackingService.class));
                }
            }
        });

        tracker = new LocationTracker();
        manager = new LocationManager(getActivity());

        return view;
    }

    @Override
    public void onStart() {
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TrackingService.MY_ACTION);
        getActivity().registerReceiver(myReceiver, intentFilter);

        super.onStart();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        getActivity().unregisterReceiver(myReceiver);
        super.onStop();
    }

    @Override
    public void onClick(View view) {


    }

    private class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub

            datapassed = arg1.getStringExtra("Location");
            locationText.setText(datapassed);
            try {
                LocationTracker lastLoation = manager.getLastLocatin();
                if (datapassed == null) {
                    locationText.setText(lastLoation.getAddress());
                } else {
                    locationText.setText(datapassed);

                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Collecting Location...", Toast.LENGTH_SHORT).show();
            }
            showListView();

        }


    }


  /*  public void showMap(View view) {

    }*/

    private void showListView() {
        ArrayList<LocationTracker> allLocation = manager.getAllTimeAndAddress();
        if (allLocation.size() > 0) {
            adapter = new LocationAdapter(getActivity(), allLocation);
            listViewLV.setAdapter(adapter);
        }


    }

}
