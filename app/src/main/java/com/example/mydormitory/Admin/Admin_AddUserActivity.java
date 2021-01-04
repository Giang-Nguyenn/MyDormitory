package com.example.mydormitory.Admin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Admin_AddUserActivity extends AppCompatActivity {
    Hi hi=new Hi();
    String url=hi.getIp().toString()+"Admin/adduser.php";
    private int Request_Code_Image=123;
    ImageView imageView;
    Button btn_gui;
    Bitmap img;
    EditText edt_name;
    EditText edt_sex;
    EditText edt_phone;
    EditText edt_birthday;
    EditText edt_address;
    EditText edt_password;
    EditText edt_gmail;
    EditText edt_exp;
    EditText edt_addinfor;


     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_adduser);
        Anhxa();
        final Intent intent=getIntent();
        Toast.makeText(Admin_AddUserActivity.this,intent.getStringExtra("Number").toString(),Toast.LENGTH_SHORT).show();
        Log.d("a",intent.getStringExtra("RoomId").toString());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,Request_Code_Image);
            }
        });
        btn_gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue=Volley.newRequestQueue(Admin_AddUserActivity.this);
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("aaaa",response.toString());
                                Toast.makeText(Admin_AddUserActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        String s=convert(img);
                        Map<String, String> param=new HashMap<>();
                        param.put("Img",s);
                        param.put("RoomId",intent.getStringExtra("RoomId").toString().trim());
                        param.put("Name",edt_name.getText().toString());
                        param.put("Sex",edt_sex.getText().toString());
                        param.put("Phone",edt_phone.getText().toString());
                        param.put("BirthDay",edt_birthday.getText().toString());
                        param.put("Address",edt_address.getText().toString());
                        param.put("Password",edt_password.getText().toString());
                        param.put("Gmail",edt_gmail.getText().toString());
                        param.put("Exp",edt_exp.getText().toString());
                        param.put("AddInfor",edt_addinfor.getText().toString());
                        param.put("Number",intent.getStringExtra("Number").toString());
                        return param;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         if(requestCode==Request_Code_Image && resultCode==RESULT_OK && data!=null){
             Uri uri=data.getData();
             InputStream inputStream= null;
             try {
                 inputStream = getContentResolver().openInputStream(uri);
                 img= BitmapFactory.decodeStream(inputStream);
                 imageView.setImageBitmap(img);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }

         }
         super.onActivityResult(requestCode, resultCode, data);
     }
    public static String convert(Bitmap bitmap)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }
    private void Anhxa(){
        imageView=(ImageView) findViewById(R.id.img_image);
        btn_gui=(Button) findViewById(R.id.btn_ok);
        edt_name=(EditText) findViewById(R.id.edt_name);
        edt_sex=(EditText) findViewById(R.id.edt_sex);
        edt_phone=(EditText) findViewById(R.id.edt_phone);
        edt_birthday=(EditText) findViewById(R.id.edt_birthday);
        edt_address=(EditText) findViewById(R.id.edt_address);
        edt_password=(EditText) findViewById(R.id.edt_password);
        edt_gmail=(EditText) findViewById(R.id.edt_gmail);
        edt_exp=(EditText) findViewById(R.id.edt_exp);
        edt_addinfor=(EditText) findViewById(R.id.edt_addinfor);

    }
}
