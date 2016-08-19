package com.example.ahmme.tourmate.TravelLogManagement;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ahmme.tourmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelLogFragment extends Fragment implements View.OnClickListener{

    ImageView addTravelLogIV;
    ListView travelLogListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_travel_log, container, false);
        addTravelLogIV=(ImageView)view.findViewById(R.id.add_travel_log);
        travelLogListView=(ListView)view.findViewById(R.id.travle_log_list_view);

        return view;
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.add_travel_log:
                Intent intent=new Intent(getActivity(),AddTravelLogFragment.class);
                startActivity(intent);
                break;
            case R.id.travle_log_list_view:
                travelLogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
                break;
        }
    }
}
