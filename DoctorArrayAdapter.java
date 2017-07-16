package com.example.android.slidingtabsbasic;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHUPENDRA JAIN on 15-04-2016.
 */
public class DoctorArrayAdapter extends ArrayAdapter<Doctor> {

    LayoutInflater inflater;

    public DoctorArrayAdapter(Context context,LayoutInflater inflater , ArrayList<Doctor> objects) {
        super(context, 0, objects);
        this.inflater=inflater;
    }

    public static class BatchViewHolder{
        TextView batchNameTV;
        TextView courseNameTV;
        TextView seatsTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Doctor d= getItem(position);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.doctor_list_item_view,null);
            BatchViewHolder holder=new BatchViewHolder();
            holder.batchNameTV= (TextView) convertView.findViewById(R.id.batchNameTextView);
            holder.courseNameTV=(TextView) convertView.findViewById(R.id.courseNameTextView);
            holder.seatsTV=(TextView) convertView.findViewById(R.id.seatsTextView);
            convertView.setTag(holder);

        }
        BatchViewHolder holder=(BatchViewHolder) convertView.getTag();
        holder.batchNameTV.setText(d.docName);

        return convertView;
    }
}
