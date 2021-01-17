package com.example.mydormitory.user;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydormitory.R;

import java.util.List;

class Notification_AdapterLv extends BaseAdapter {
    private Context context;
    private Integer layout;
    private List<NotificationLv> notificationLvList;

    public Notification_AdapterLv(Context context, Integer layout, List<NotificationLv> notificationLvList) {
        this.context = context;
        this.layout = layout;
        this.notificationLvList = notificationLvList;
    }

    @Override
    public int getCount() {
        return notificationLvList.size();
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
        NotificationLv notificationLv=notificationLvList.get(position);
        txt_describe.setText(notificationLv.getDescribe());
        txt_create.setText(notificationLv.getCreate());
        return convertView;
    }
}
