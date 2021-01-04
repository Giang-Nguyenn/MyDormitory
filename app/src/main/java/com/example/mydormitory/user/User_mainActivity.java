package com.example.mydormitory.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class User_mainActivity extends AppCompatActivity {
    TextView txt_name;
    ImageView image_View;
    TextView txt_birthday;
    TextView txt_gt;
    TextView txt_class;
    TextView txt_room;
    TextView txt_religion;
    TextView txt_address;
    TextView txt_phone;
    TextView txt_begin;
    TextView txt_addinfor;
    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;
    Hi hi=new Hi();
    String[] a=null;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        Anhxa();
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId = sharedPref.getString("UserId", "ko co name");
        Intent intent=getIntent();
        String Id=intent.getStringExtra("Id");
        String url=hi.getIp().toString()+"User/getdata.php";
        GetDataUser(url,Id);
        Click_Button click_button=new Click_Button();
        click_button.Click(User_mainActivity.this,UserId,btn_room,btn_mesenger,btn_notifycation,btn_fees);

    }
    private void GetDataUser(String url, final String Id){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        Toast.makeText(User_mainActivity.this,a.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray data=new JSONArray(response);
                            JSONObject user=data.getJSONObject(0);
                            txt_name.setText(user.getString("Name"));
                            Picasso.get().load(hi.getIp().toString()+user.getString("Image").substring(21)).into(image_View);
                            txt_birthday.setText("Ngày sinh : "+user.getString("Birthday"));
                            txt_gt.setText("Giới tinh : "+user.getString("Sex"));
                            txt_class.setText("Lớp : ");
                            txt_room.setText("Phòng : "+user.getString("Room"));
                            txt_religion.setText("Dân tộc : "+"Kinh");
                            txt_address.setText("Quê Quán : "+user.getString("Address"));
                            txt_phone.setText("Số điện thoại : "+user.getString("Phone"));
                            txt_begin.setText("Ngày vào : "+user.getString("CreateTime"));
                            txt_addinfor.setText("Thông tin thêm : "+user.getString("AddInfor"));

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
                param.put("Id",Id);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    public void Anhxa(){
        txt_name=(TextView) findViewById(R.id.txt_name);
        image_View=(ImageView) findViewById(R.id.img_image);
        txt_birthday=(TextView) findViewById(R.id.txt_birthday);
        txt_gt=(TextView) findViewById(R.id.txt_gt);
        txt_class=(TextView) findViewById(R.id.txt_class);
        txt_room=(TextView) findViewById(R.id.txt_room);
        txt_religion=(TextView) findViewById(R.id.txt_religion);
        txt_address=(TextView) findViewById(R.id.txt_address);
        txt_phone=(TextView) findViewById(R.id.txt_phone);
        txt_begin=(TextView) findViewById(R.id.txt_begin);
        txt_addinfor=(TextView) findViewById(R.id.txt_addinfor);
        btn_room=(Button) findViewById(R.id.btn_room);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);

    }
}
