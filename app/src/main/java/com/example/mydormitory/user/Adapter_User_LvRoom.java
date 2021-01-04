package com.example.mydormitory.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.example.mydormitory.user.User_LvRoom;
import com.squareup.picasso.Picasso;

import java.util.List;

class Adapter_User_LvRoom extends BaseAdapter {
    Hi hi=new Hi();
    private Context context;
    private int layout;
    private List<User_LvRoom> Lv_User_LvRoom;

    public Adapter_User_LvRoom(Context context, int layout, List<User_LvRoom> lv_User_LvRoom) {
        this.context = context;
        this.layout = layout;
        this.Lv_User_LvRoom = lv_User_LvRoom;
    }

    @Override
    public int getCount() {
        return Lv_User_LvRoom.size();
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
        ImageView imageView=(ImageView) convertView.findViewById(R.id.image_view);
        TextView txt_name=(TextView) convertView.findViewById(R.id.txt_name);
        TextView txt_birthday=(TextView) convertView.findViewById(R.id.txt_birthday);
        User_LvRoom user_lvRoom=Lv_User_LvRoom.get(position);
        Picasso.get().load(hi.getIp().toString()+user_lvRoom.getImage().substring(21)).into(imageView);
        txt_name.setText(user_lvRoom.getName());
        txt_birthday.setText(user_lvRoom.getBirthDay());
        return convertView;
    }
}
