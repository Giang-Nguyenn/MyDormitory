package com.example.mydormitory.Admin;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.example.mydormitory.font.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

class Admin_Messenger_Header_Adapter extends BaseAdapter {
    Hi hi=new Hi();
    private Context context;
    private int layout;
    private List<Admin_Messenger_Header> messenger_headerList;

    public Admin_Messenger_Header_Adapter(Context context, int layout, List<Admin_Messenger_Header> messenger_headerList) {
        this.context = context;
        this.layout = layout;
        this.messenger_headerList = messenger_headerList;
    }

    @Override
    public int getCount() {
        return messenger_headerList.size();
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
        ConstraintLayout constraintLayout=(ConstraintLayout) convertView.findViewById(R.id.ct);
        TextView txt_name=(TextView) convertView.findViewById(R.id.txt_name);
        ImageView image_view=(ImageView) convertView.findViewById(R.id.image_view);
        TextView txt_mess=(TextView) convertView.findViewById(R.id.txt_mess);
        TextView txt_time=(TextView) convertView.findViewById(R.id.txt_time);

        Admin_Messenger_Header messenger_header=messenger_headerList.get(position);
        if(messenger_header.getStatus().equals("0")){
            txt_mess.setTextColor(Color.GREEN);
        }
        txt_name.setText(messenger_header.getName());
        if(messenger_header.getId_send().equals("Admin")){
            txt_mess.setText("Bạn :"+messenger_header.getMessenger());
        }
        else {
            txt_mess.setText("User"+messenger_header.getMessenger());
        }
        txt_time.setText(messenger_header.getTime().substring(11,16));
        Picasso.get().load(hi.getIp().toString()+messenger_header.getImage().toString()).transform(new CircleTransform()).into(image_view);


        return convertView;
    }
}
