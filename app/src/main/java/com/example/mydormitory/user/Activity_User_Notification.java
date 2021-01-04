package com.example.mydormitory.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Activity_User_Notification extends AppCompatActivity {
    Hi hi=new Hi();
    ArrayList<NotificationLv> notificationLvList=new ArrayList<>();
    Notification_AdapterLv notification_adapterLv;
    ListView listView;

    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_notification);
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId = sharedPref.getString("UserId", "ko co name");
        String url=hi.getIp().toString()+"User/getlvnotification.php";
        Anhxa();
        GetDataLvNotification(url,UserId);
        notification_adapterLv=new Notification_AdapterLv(this,R.layout.user_notification_custom_item,notificationLvList);
        listView.setAdapter(notification_adapterLv);

        Click_Button click_button=new Click_Button();
        click_button.Click(Activity_User_Notification.this,UserId,btn_room,btn_mesenger,btn_notifycation,btn_fees);
    }
    private void GetDataLvNotification(String url, final String UserId){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++){
                                notificationLvList.add(new NotificationLv(jsonArray.getJSONObject(i).getString("Id").toString(),
                                        jsonArray.getJSONObject(i).getString("Describe").toString(),
                                        jsonArray.getJSONObject(i).getString("Content").toString(),
                                        jsonArray.getJSONObject(i).getString("Create").toString(),
                                        jsonArray.getJSONObject(i).getString("Add_Infor").toString()));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(Activity_User_Notification.this,e.getMessage().toString(), Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity_User_Notification.this,"lỗi", Toast.LENGTH_LONG).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<>();
                param.put("Id",UserId);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void Anhxa(){
        listView=(ListView) findViewById(R.id.listview);
        btn_room=(Button) findViewById(R.id.btn_room);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);
    }
}
