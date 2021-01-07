package com.example.mydormitory.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mydormitory.font.CircleTransform;
import com.example.mydormitory.user.User_Messenger;
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class User_Messenger_Adapter extends BaseAdapter {
    Hi hi=new Hi();
    private Context context;
    private int layout;
    private String Image;
    private List<User_Messenger> messengerList;

    public User_Messenger_Adapter(Context context, int layout, String image, List<User_Messenger> messengerList) {
        this.context = context;
        this.layout = layout;
        Image = image;
        this.messengerList = messengerList;
    }

    @Override
    public int getCount() {
        return messengerList.size() ;
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

        ConstraintLayout left_ct=(ConstraintLayout) convertView.findViewById(R.id.left_ct);
        ImageView left_image_view=(ImageView) convertView.findViewById(R.id.left_image_view);
        TextView left_txt_messenger=(TextView) convertView.findViewById(R.id.left_txt_messenger);
        TextView left_txt_time=(TextView) convertView.findViewById(R.id.left_txt_time);

        ConstraintLayout right_ct=(ConstraintLayout) convertView.findViewById(R.id.right_ct);
        ImageView right_image_view=(ImageView) convertView.findViewById(R.id.right_image_view);
        TextView right_txt_messenger=(TextView) convertView.findViewById(R.id.right_txt_messenger);
        TextView right_txt_time=(TextView) convertView.findViewById(R.id.right_txt_time);

        User_Messenger messenger=messengerList.get(position);
        if(messenger.getId_send().equals("Admin")){
            right_ct.setVisibility(View.GONE);
            Picasso.get().load(hi.getIp().toString()+Image).transform(new CircleTransform()).into(left_image_view);
            left_txt_messenger.setText(messenger.getMessenger());
            left_txt_time.setText(messenger.getTime());

        }
        else {
            left_ct.setVisibility(View.GONE);
            Picasso.get().load(hi.getIp().toString()+"Images/Admin.PNG").transform(new CircleTransform()).into(right_image_view);
            right_txt_messenger.setText(messenger.getMessenger());
            right_txt_time.setText(messenger.getTime());

        }

        return convertView;
    }
}
