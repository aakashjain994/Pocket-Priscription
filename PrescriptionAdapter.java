package com.example.android.slidingtabsbasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BHUPENDRA JAIN on 15-04-2016.
 */
public class PrescriptionAdapter extends ArrayAdapter<String> {
    LayoutInflater inflater;
    public PrescriptionAdapter(Context context, LayoutInflater inflater,ArrayList<String> objects) {
        super(context, 0,objects);
        this.inflater=inflater;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position);
        View v = inflater.inflate(R.layout.item_list_of_prescription, null);
        TextView tv = (TextView) v.findViewById(R.id.presNo);
        tv.setText(name);

        return v;
    }
}
