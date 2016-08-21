package com.example.ahmme.tourmate.TourMate;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmme.tourmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEventFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        getActivity().setTitle("Add Event");

        return view;
    }

}
