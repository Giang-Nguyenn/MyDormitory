package com.example.mydormitory.Admin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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

import java.util.HashMap;
import java.util.Map;

public  class Admin_Fees_Add_Activity extends AppCompatActivity {
    String option;
     EditText edt_namefees;
     EditText edt_addinfor;
     EditText edt_id;
     TextView txt_id;
     RadioGroup radioGroup;
     Button btn_done;

     Button btn_home;
     Button btn_mesenger;
     Button btn_fees;
     Button btn_notifycation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_fees_add);
        Anhxa();
        Hi hi=new Hi();
        final String url=hi.getIp().toString().trim()+"Admin/add_fees.php";
        SharedPreferences sharedPref=getSharedPreferences("Admin",Context.MODE_PRIVATE);
        final String Status = sharedPref.getString("Status", "1");
        Toast.makeText(Admin_Fees_Add_Activity.this,Status,Toast.LENGTH_SHORT).show();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radio_user:
                        option="1";
                        txt_id.setVisibility(View.VISIBLE);
                        edt_id.setVisibility(View.VISIBLE);

                        break;
                    case R.id.radio_room:
                        option="2";
                        txt_id.setVisibility(View.VISIBLE);
                        edt_id.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radio_all:
                        option="3";
                        txt_id.setVisibility(View.GONE);
                        edt_id.setVisibility(View.GONE);
                        break;
                }
            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fees_Add(url,Status,option,edt_namefees.getText().toString(),edt_addinfor.getText().toString(),edt_id.getText().toString().trim());
            }
        });

        Click_Button click_button=new Click_Button();
        click_button.Click(Admin_Fees_Add_Activity.this,btn_home,btn_fees,btn_notifycation,btn_mesenger);

    }
    private void Case(RadioGroup radioGroup, final String url, final String Status){

    }
    private void Fees_Add(String url, final String Status, final String check, final String Describe, final String Add_Infor, final String ListId){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("Success")){
                            dialog(response.toString().trim());
                        }
                        else {
                            dialog("Lỗi");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog("lỗi");

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<>();
                param.put("Status",Status);
                param.put("Option",check);
                param.put("Describe",Describe);
                param.put("Add_Infor",Add_Infor);
                param.put("ListId",ListId);
                return param;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void dialog(String s){
        AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle(s);
        dialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent=new Intent(Admin_Fees_Add_Activity.this,Admin_Fees_Add_Activity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
    private void Anhxa(){
        edt_namefees=(EditText) findViewById(R.id.edt_namefees);
        edt_addinfor=(EditText) findViewById(R.id.edt_addinfor);
        edt_id=(EditText) findViewById(R.id.edt_id);
        txt_id=(TextView) findViewById(R.id.txt_id);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        btn_done=(Button) findViewById(R.id.btn_done);

        btn_home=(Button) findViewById(R.id.btn_home);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);
    }
}
