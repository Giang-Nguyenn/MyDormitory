package com.example.mydormitory.Admin;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mydormitory.R;

import java.util.List;

class Admin_Fees_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Admin_Frees> adminFreesList;

    public Admin_Fees_Adapter(Context context, int layout, List<Admin_Frees> adminFreesList) {
        this.context = context;
        this.layout = layout;
        this.adminFreesList = adminFreesList;
    }

    @Override
    public int getCount() {
        return adminFreesList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);

         TextView txt_describe=(TextView) convertView.findViewById(R.id.txt_describe);
         TextView txt_create=(TextView) convertView.findViewById(R.id.txt_create);
         TextView txt_status=(TextView) convertView.findViewById(R.id.txt_status);

         Admin_Frees admin_frees=adminFreesList.get(position);
         txt_describe.setText(admin_frees.getDescribe());
         txt_create.setText(admin_frees.getCreate());
         if(admin_frees.getStatus().toString().trim().equals("1")){
             txt_status.setText("V");
             txt_status.setBackgroundColor(Color.GREEN);
         }
         else {
             txt_status.setText("X");
             txt_status.setBackgroundColor(Color.RED);
         }

        return convertView;
    }
}
