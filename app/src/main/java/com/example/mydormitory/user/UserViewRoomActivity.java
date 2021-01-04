package com.example.mydormitory.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mydormitory.user.Adapter_User_LvRoom;
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserViewRoomActivity extends AppCompatActivity {
    ListView listView;
    TextView txt_roomname;
    ArrayList<User_LvRoom> arrayList=new ArrayList<>();
    Adapter_User_LvRoom adapter_user_lvRoom;

    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_room);
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId = sharedPref.getString("UserId", "ko co name");
        Hi hi=new Hi();
        String url=hi.getIp().toString()+"User/getdataroom.php";
        Anhxa();
        listView=(ListView) findViewById(R.id.listview);
        GetDataRoom(url,UserId);
        adapter_user_lvRoom=new Adapter_User_LvRoom(this,R.layout.custom_view_user_room,arrayList);
        listView.setAdapter(adapter_user_lvRoom);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(UserViewRoomActivity.this, User_mainActivity.class);
                intent1.putExtra("Id",arrayList.get(position).getUserId().toString().trim());
                startActivity(intent1);
            }
        });
        Click_Button click_button=new Click_Button();
        click_button.Click(UserViewRoomActivity.this,UserId,btn_room,btn_mesenger,btn_notifycation,btn_fees);
    }
    private void GetDataRoom( String url, final String Id){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UserViewRoomActivity.this,Integer.toString(response.length()).toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(UserViewRoomActivity.this,response.toString(), Toast.LENGTH_LONG).show();
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<response.length();i++){
                                arrayList.add(new User_LvRoom(jsonArray.getJSONObject(i).getString("Name").toString(),
                                        jsonArray.getJSONObject(i).getString("Image").toString(),
                                        jsonArray.getJSONObject(i).getString("Birthday").toString(),
                                        jsonArray.getJSONObject(i).getString("UserId").toString()));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(UserViewRoomActivity.this,e.getMessage().toString()+"111111", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserViewRoomActivity.this,"lỗi 2", Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param=new HashMap<>();
                param.put("Id",Id);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void Anhxa(){
        btn_room=(Button) findViewById(R.id.btn_room);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);
    }
}
