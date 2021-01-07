package com.example.mydormitory.Admin;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.example.mydormitory.font.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

class Adapter_Admin_LvUser extends BaseAdapter {
    Hi hi=new Hi();
     private Context context;
     private Integer layout;
     private List<Admin_LvUser> admin_lvUsers;

    public Adapter_Admin_LvUser(Context context, Integer layout, List<Admin_LvUser> admin_lvUsers) {
        this.context = context;
        this.layout = layout;
        this.admin_lvUsers = admin_lvUsers;
    }

    @Override
    public int getCount() {
        return admin_lvUsers.size();
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
        ImageView image_view=(ImageView) convertView.findViewById(R.id.image_view);
        TextView txt_name=(TextView) convertView.findViewById(R.id.txt_name);
        TextView txt_address=(TextView) convertView.findViewById(R.id.txt_address);
        Admin_LvUser admin_lvUser=admin_lvUsers.get(position);
        Picasso.get().load(hi.getIp().toString()+admin_lvUser.getImage().substring(21)).transform(new CircleTransform()).into(image_view);
        txt_name.setText(admin_lvUser.getName());
        txt_address.setText(admin_lvUser.getAddress());
        return convertView;
    }
}
