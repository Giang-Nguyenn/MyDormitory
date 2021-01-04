package com.example.mydormitory.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mydormitory.Admin.Adapter_Admin_LvRoom;
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Admin_mainActivity extends AppCompatActivity{
    GridView gridView;
    EditText edt_seach;
    ArrayList<Admin_LvRoom> admin_lvRooms=new ArrayList<>();
    ArrayList<Admin_LvRoom> admin_lvRooms1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main);
        Hi hi=new Hi();
        String url=hi.getIp().toString()+"Admin/getlistroom.php";
        Intent intent=getIntent();
        gridView=(GridView) findViewById(R.id.grid_view);
        edt_seach=(EditText) findViewById(R.id.edt_seach);
        GetListRoom(url);
        final Adapter_Admin_LvRoom adapter_admin_lvRoom=new Adapter_Admin_LvRoom(this,R.layout.custom_admin_list_room,admin_lvRooms);
        gridView.setAdapter(adapter_admin_lvRoom);
        Log.d("Hi",Integer.toString(Size(admin_lvRooms)));
        edt_seach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                admin_lvRooms.clear();
                Log.d("At",Integer.toString(admin_lvRooms.size()));
                for(int i=0;i<admin_lvRooms1.size();i++){
                    admin_lvRooms.add(admin_lvRooms1.get(i));
                }
                Log.d("As",Integer.toString(admin_lvRooms.size()));
                Log.d("A1",Integer.toString(admin_lvRooms1.size()));
                for(int i=0;i<admin_lvRooms.size();i++){
                    if(admin_lvRooms.get(i).getName().toString().trim().startsWith(s.toString())!=true){
                        admin_lvRooms.remove(i);
                        i--;
                    }
                }
                adapter_admin_lvRoom.notifyDataSetChanged();


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(Admin_mainActivity.this, Admin_LvUserActivity.class);
                intent1.putExtra("RoomId",admin_lvRooms.get(position).getName().toString().trim());
                startActivity(intent1);
            }
        });

    }
    private  Integer Size(ArrayList a){
        return a.size();
    }
    private void GetListRoom(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(Admin_mainActivity.this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(Admin_mainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                admin_lvRooms.add(new Admin_LvRoom(jsonArray.getJSONObject(i).getString("RoomId").toString(),
                                        jsonArray.getJSONObject(i).getString("Countt"),
                                        "1"));
                                admin_lvRooms1.add(new Admin_LvRoom(jsonArray.getJSONObject(i).getString("RoomId").toString(),
                                        jsonArray.getJSONObject(i).getString("Countt"),
                                        "1"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }
}
