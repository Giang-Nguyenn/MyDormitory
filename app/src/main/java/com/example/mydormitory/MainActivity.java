package com.example.mydormitory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mydormitory.Admin.Admin_mainActivity;
import com.example.mydormitory.user.User_mainActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edt_user;
    EditText edt_password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hi hi=new Hi();

        SharedPreferences sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name", "Nameeeeee");
        editor.commit();

        edt_user=(EditText) findViewById(R.id.edt_user);
        edt_password=(EditText) findViewById(R.id.edt_Password);
        btn=(Button) findViewById(R.id.button);
        final String url=hi.getIp().toString()+"Login.php";
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post(url);
            }
        });
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                edt_user.setText("admin");
                edt_password.setText("admin");
                return true;
            }
        });
    }
    private void Post(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.toString().trim().startsWith("Ok")){
                            SharedPreferences sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("UserId", response.toString().trim().substring(2));
                            editor.commit();
                            Intent intent=new Intent(MainActivity.this, User_mainActivity.class);
                            intent.putExtra("Id",response.toString().trim().substring(2));
                            startActivity(intent);
                        }
                        else if(response.toString().trim().startsWith("Admin")){
                            String s=response.toString().trim().substring(5);
                            //Toast.makeText(MainActivity.this,s.toString(),Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this, Admin_mainActivity.class);
                            intent.putExtra("ID",s.toString().trim());
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(MainActivity.this,"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                        };
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this,"lỗi",Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param=new HashMap<>();
                param.put("user",edt_user.getText().toString());
                    param.put("password",edt_password.getText().toString());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
}