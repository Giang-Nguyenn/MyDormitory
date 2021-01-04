package com.example.mydormitory.user;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.mydormitory.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class Adapter_Fees extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User_lvFees> user_lvFees;

    public Adapter_Fees(Context context, int layout, List<User_lvFees> user_lvFees) {
        this.context = context;
        this.layout = layout;
        this.user_lvFees = user_lvFees;
    }

    @Override
    public int getCount() {
        return user_lvFees.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);
        TextView txt_describe=(TextView) convertView.findViewById(R.id.txt_describe);
        TextView txt_create=(TextView) convertView.findViewById(R.id.txt_create);
        TextView txt_status=(TextView) convertView.findViewById(R.id.txt_status);
        User_lvFees object= user_lvFees.get(position);
        txt_describe.setText(object.getDescribe());
        txt_create.setText(object.getCreate());
        if(object.getStatus().toString().equals("0")){
            txt_status.setText("X");
            txt_status.setBackgroundColor(Color.RED);
        }
        else {
            txt_status.setText("V");
            txt_status.setBackgroundColor(Color.GREEN);
        }
        return convertView;
    }
}
