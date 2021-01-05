package com.example.mydormitory.Admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;

import static androidx.core.content.ContextCompat.startActivity;

class Click_Button {
    private Button btn_home;
    private Button btn_fees;
    private Button btn_notification;
    private Button btn_messenger;

    public void Click(final Context context, Button btn_home, Button btn_fees, Button btn_notification, Button btn_messenger){
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Admin_mainActivity.class);
                startActivity(context,intent,null);
            }
        });

        btn_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Admin_Fees_Activity.class);
                startActivity(context,intent,null);
            }
        });

        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Admin_mainActivity.class);
                startActivity(context,intent,null);
            }
        });

        btn_messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Admin_mainActivity.class);
                startActivity(context,intent,null);
            }
        });
    }


}
