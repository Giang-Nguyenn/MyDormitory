package com.example.mydormitory.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mydormitory.R;

import java.util.List;

class Adapter_Admin_LvRoom extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Admin_LvRoom> admin_lvRooms;

    public Adapter_Admin_LvRoom(Context context, int layout, List<Admin_LvRoom> admin_lvRooms) {
        this.context = context;
        this.layout = layout;
        this.admin_lvRooms = admin_lvRooms;
    }

    @Override
    public int getCount() {
        return admin_lvRooms.size();
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
        TextView txt_room=(TextView) convertView.findViewById(R.id.txt_room);
        TextView txt_count=(TextView) convertView.findViewById(R.id.txt_count);
        TextView txt_color=(TextView) convertView.findViewById(R.id.txt_color);
        Admin_LvRoom admin_lvRoom=admin_lvRooms.get(position);
        if(admin_lvRoom.getCount().toString().equals("null")){
            admin_lvRoom.setCount("0");
        }
        txt_room.setText(admin_lvRoom.getName().toString());
        txt_count.setText("Số lượng : "+admin_lvRoom.getCount().toString());
        txt_color.setText(admin_lvRoom.getColor().toString());
        return convertView;
    }
}
