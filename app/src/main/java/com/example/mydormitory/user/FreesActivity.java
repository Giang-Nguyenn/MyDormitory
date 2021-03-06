package com.example.mydormitory.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
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
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class FreesActivity  extends AppCompatActivity {
    ListView listView;
    Adapter_Fees adapter_fees;
    ArrayList<User_lvFees> lvFeesList=new ArrayList<>();
    Hi hi=new Hi();

    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_frees);
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId = sharedPref.getString("UserId", "ko co name");
        String url=hi.getIp().toString()+"User/getlvfees.php";
        Anhxa();
        GetLvFees(url,UserId);
        adapter_fees=new Adapter_Fees(this,R.layout.user_free_custom_item,lvFeesList);
        listView.setAdapter(adapter_fees);

        Click_Button click_button =new Click_Button();
        click_button.Click(FreesActivity.this,UserId,btn_room,btn_mesenger,btn_notifycation,btn_fees);
    }

    private void GetLvFees(String url, final String UserId){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                lvFeesList.add(new User_lvFees(jsonArray.getJSONObject(i).getString("Describe"),
                                        jsonArray.getJSONObject(i).getString("Create"),
                                        jsonArray.getJSONObject(i).getString("Status")));
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
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param=new HashMap<>();
                param.put("Id",UserId);
                return param;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void Anhxa(){
        listView=findViewById(R.id.listview);
        btn_room=(Button) findViewById(R.id.btn_room);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);

    }
}
