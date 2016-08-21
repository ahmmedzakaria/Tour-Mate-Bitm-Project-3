package com.example.ahmme.tourmate.TravelLogManagement;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ahmme.tourmate.R;
import com.example.ahmme.tourmate.TourMate.MainFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelLogFragment extends Fragment implements View.OnClickListener{

    ImageView addTravelLogIV;
    ListView travelLogListView;


    Fragment currentFragment;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_travel_log, container, false);
        addTravelLogIV=(ImageView)view.findViewById(R.id.add_travel_log);
        travelLogListView=(ListView)view.findViewById(R.id.travle_log_list_view);


        currentFragment = new TravelLogFragment();
        manager = getFragmentManager();
        /*transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, currentFragment);
        transaction.commit();*/

        addTravelLogIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentFragment=new AddTravelLogFragment();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container, currentFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                /*Intent intent=new Intent(getActivity(),AddTravelLogFragment.class);
                Toast.makeText(getActivity(), "Add Travel Log", Toast.LENGTH_SHORT).show();
                getActivity().startActivity(intent);*/
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
       /* int id=view.getId();
        switch (id){
            case R.id.add_travel_log:
                Intent intent=new Intent(getActivity(),AddTravelLogFragment.class);
                Toast.makeText(getActivity(), "Add Travel Log", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.travle_log_list_view:
                travelLogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
                break;
        }*/
    }
}
