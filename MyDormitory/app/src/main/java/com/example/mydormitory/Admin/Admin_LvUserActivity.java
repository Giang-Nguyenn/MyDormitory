package com.example.mydormitory.Admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin_LvUserActivity extends AppCompatActivity {
    TextView txt_roomname;
    ListView listView;
    Button button_add;
    ArrayList<Admin_LvUser> admin_lvUsers=new ArrayList<>();

    Button btn_home;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_room);
        Anhxa();
        Hi hi=new Hi();
        String url=hi.getIp().toString()+"Admin/getdatalvroom.php";

        final SharedPreferences sharedPref =getSharedPreferences("Admin", Context.MODE_PRIVATE);
        final String Status = sharedPref.getString("Status", "1");
        Toast.makeText(this,Status.toString().trim().substring(4),Toast.LENGTH_SHORT).show();
        txt_roomname.setText("Phòng "+Status.toString().trim().substring(4));
        GetDatalvRoom(url,Status.toString().trim().substring(4));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Adapter_Admin_LvUser adapter_admin_lvUser=new Adapter_Admin_LvUser(this,R.layout.custom_admin_view_user_room,admin_lvUsers);
        listView.setAdapter(adapter_admin_lvUser);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putString("Status","User"+admin_lvUsers.get(position).getUserId().toString().trim());
                editor.commit();
                Intent intent1=new Intent(Admin_LvUserActivity.this,Admin_viewUser_Activity.class);
                intent1.putExtra("ID",admin_lvUsers.get(position).getUserId().toString().trim());
                startActivity(intent1);
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(admin_lvUsers.size()<8){
                    Intent intent1=new Intent(Admin_LvUserActivity.this,Admin_AddUserActivity.class);
                    intent1.putExtra("RoomId",Status.toString().trim().substring(4));
                    intent1.putExtra("Number",Integer.toString(admin_lvUsers.size()+1));
                    startActivity(intent1);
                }
                else
                {
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Admin_LvUserActivity.this);
                    alertDialog.setMessage("Đã đủ số lượng");
                    alertDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();

                }
            }
        });

        Click_Button click_button=new Click_Button();
        click_button.Click(Admin_LvUserActivity.this,btn_home,btn_fees,btn_notifycation,btn_mesenger);
    }
    private void GetDatalvRoom(String url, final String RoomId) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(Admin_LvUserActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray j=new JSONArray(response);
                            for(int i=0;i<j.length();i++){
                                JSONObject user=j.getJSONObject(i);
                                admin_lvUsers.add(new Admin_LvUser(user.getString("Name").toString(),
                                        user.getString("Image").toString(),
                                        user.getString("Address").toString(),
                                        user.getString("UserId").toString()));
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
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("RoomId", RoomId);
                return param;
            }

            ;
        };
        requestQueue.add(stringRequest);
    }

    private void Anhxa(){
        txt_roomname=(TextView) findViewById(R.id.txt_roomname);
        listView=(ListView) findViewById(R.id.listview);
        button_add=(Button) findViewById(R.id.btn_add);

        btn_home=(Button) findViewById(R.id.btn_home);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);

    }
}
