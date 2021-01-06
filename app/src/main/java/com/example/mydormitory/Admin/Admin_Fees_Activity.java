package com.example.mydormitory.Admin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin_Fees_Activity extends AppCompatActivity {
    Hi hi=new Hi();
    TextView txt_name;
    Button btn_add;
    ListView listView;
    ArrayList<Admin_Frees> admin_freesArrayList=new ArrayList<>();
    Admin_Fees_Adapter admin_fees_adapter;

    Button btn_home;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_fees);
        Anhxa();
        final SharedPreferences sharedPref =getSharedPreferences("Admin", Context.MODE_PRIVATE);
        final String Status = sharedPref.getString("Status", "1");
        txt_name.setText(Status);
        final String url=hi.getIp().toString()+"Admin/getdatafees.php";
        final String url1=hi.getIp().toString()+"Admin/fees_done.php";

        GetDataFees(url,Status);
        admin_fees_adapter=new Admin_Fees_Adapter(this,R.layout.admin_free_custom_item,admin_freesArrayList);
        listView.setAdapter(admin_fees_adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Fees_Done(position,url1,Status);
                return false;
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin_Fees_Activity.this,Admin_Fees_Add_Activity.class);
                startActivity(intent);
            }
        });



        Click_Button click_button=new Click_Button();
        click_button.Click(Admin_Fees_Activity.this,btn_home,btn_fees,btn_notifycation,btn_mesenger);
    }

    private void GetDataFees(String url, final String Status){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Admin_Fees_Activity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                admin_freesArrayList.add(new Admin_Frees(jsonArray.getJSONObject(i).getString("Id"),
                                        jsonArray.getJSONObject(i).getString("Describe"),
                                        jsonArray.getJSONObject(i).getString("Create"),
                                        jsonArray.getJSONObject(i).getString("Status"),
                                        jsonArray.getJSONObject(i).getString("Add_Infor")));
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
                Map<String,String> param=new HashMap<>();
                param.put("Status",Status);
                return param;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void Fees_Done(final int position, final String url, final String Status){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        TextView txt_name=dialog.findViewById(R.id.txt_name);
        Button btn_yes=dialog.findViewById(R.id.btn_yes);
        Button btn_no=dialog.findViewById(R.id.btn_no);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue= Volley.newRequestQueue(Admin_Fees_Activity.this);
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Admin_Fees_Activity.this,"Thành công",Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();
                        param.put("Status",Status);
                        param.put("Id",admin_freesArrayList.get(position).getId().toString().trim());
                        return param;
                    }
                };
                requestQueue.add(stringRequest);
                dialog.dismiss();
                Intent intent=new Intent(Admin_Fees_Activity.this,Admin_Fees_Activity.class);
                startActivity(intent);
            }


        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void dialog(String s){
        android.app.AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle(s);
        dialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent=new Intent(Admin_Fees_Activity.this,Admin_Fees_Activity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    private void Anhxa(){
        txt_name=(TextView) findViewById(R.id.txt_name);
        listView=(ListView) findViewById(R.id.listview);
        btn_add=(Button) findViewById(R.id.btn_add);

        btn_home=(Button) findViewById(R.id.btn_home);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);

    }
}
