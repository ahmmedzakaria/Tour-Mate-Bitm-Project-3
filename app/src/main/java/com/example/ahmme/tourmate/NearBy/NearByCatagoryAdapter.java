package com.example.ahmme.tourmate.NearBy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ahmme.tourmate.R;

import java.util.ArrayList;

/**
 * Created by Laptop Dream on 07-Jul-16.
 */
public class NearByCatagoryAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<String> catagoryList;
    ViewHolder viewHolder;
    public NearByCatagoryAdapter(Context context, ArrayList<String> catagoryList) {
        super(context, R.layout.near_by_catagory_row_layout, catagoryList);
        this.context=context;
        this.catagoryList = catagoryList;
    }
    public class ViewHolder{
        private TextView sirialNoTV;
        private TextView catagoryTV;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.near_by_catagory_row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.sirialNoTV = (TextView) convertView.findViewById(R.id.sirial_no);
            viewHolder.catagoryTV = (TextView) convertView.findViewById(R.id.catagory_name);
            convertView.setTag(viewHolder);
        }
        else {
            convertView.getTag();
        }

        viewHolder.sirialNoTV.setText(String.valueOf(position+1));
        viewHolder.catagoryTV.setText(catagoryList.get(position));
        return convertView;
    }
}
