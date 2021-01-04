package com.example.mydormitory.user;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.core.content.ContextCompat.startForegroundService;


public class Click_Button {
    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;

    public void Click(final Context context, final String UserId, Button btn_room, Button btn_mesenger, Button btn_notifycation, Button btn_fees) {
        btn_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_viewroom = new Intent(context, UserViewRoomActivity.class);
                intent_viewroom.putExtra("Id", UserId);
                startActivity(context,intent_viewroom,null);
            }
        });

        btn_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_viewroom = new Intent(context, FreesActivity.class);
                intent_viewroom.putExtra("Id", UserId);
                startActivity(context,intent_viewroom,null);
            }
        });

        btn_notifycation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_viewroom = new Intent(context,Activity_User_Notification.class);
                intent_viewroom.putExtra("Id", UserId);
                startActivity(context,intent_viewroom,null);
            }
        });

        btn_mesenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_viewroom = new Intent(context, UserViewRoomActivity.class);
                intent_viewroom.putExtra("Id", UserId);
                startActivity(context,intent_viewroom,null);
            }
        });
    }
}

