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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydormitory.user.User_Messenger_Content_Activity;
import com.example.mydormitory.user.User_Messenger_Header;
import com.example.mydormitory.user.User_Messenger_Header_Adapter;
import com.example.mydormitory.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class User_Messenger_Activity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    TextView textView;
    TextView textView1;
    ListView listview;
    Button btn_seach;
    ArrayList<User_Messenger_Header> messenger_headerArrayList=new ArrayList<>();
    User_Messenger_Header_Adapter adapter_messenger_header;

    User_Messenger_Header messenger_header;
    String Id="{Admin}";
    Intent intent=getIntent();

    Button btn_room;
    Button btn_mesenger;
    Button btn_fees;
    Button btn_notifycation;




//    FirebaseDatabase
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_list);
        Anhxa();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId =sharedPref.getString("UserId", "ko co name");
        Toast.makeText(User_Messenger_Activity.this,UserId,Toast.LENGTH_SHORT).show();

        adapter_messenger_header=new User_Messenger_Header_Adapter(this,R.layout.custom_mess_list,messenger_headerArrayList);
        listview.setAdapter(adapter_messenger_header);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Messenger_Activity.this,"1111",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(User_Messenger_Activity.this, User_Messenger_Content_Activity.class);
                intent.putExtra("MessengerId",messenger_headerArrayList.get(position).getId_mess().toString());
                intent.putExtra("Image",messenger_headerArrayList.get(position).getImage());
                intent.putExtra("Name",messenger_headerArrayList.get(position).getName());
                startActivity(intent);
            }
        });
        mDatabase.child("Messenger").child("messenger").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.getKey().contains("{"+UserId+"}")){
                    User_Messenger_Header messenger_header=snapshot.child("messenger_header").getValue(User_Messenger_Header.class);
                   messenger_headerArrayList.add(messenger_header);
                   adapter_messenger_header.notifyDataSetChanged();
                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.getKey().contains("{"+UserId+"}")){
                    User_Messenger_Header messenger_header=snapshot.child("messenger_header").getValue(User_Messenger_Header.class);
                    for(int i=0;i<messenger_headerArrayList.size();i++){
                        if(messenger_header.getId_mess().equals(messenger_headerArrayList.get(i).getId_mess())){
                            messenger_headerArrayList.remove(i);
                            messenger_headerArrayList.add(0,messenger_header);
                            break;
                        }
                    }
                    adapter_messenger_header.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        Click_Button click_button=new Click_Button();
//        click_button.Click(User_Messenger_Activity.this,UserId,btn_room,btn_mesenger,btn_notifycation,btn_fees);

    }
    private void Anhxa(){
        textView=(TextView) findViewById(R.id.txt);
        textView1=(TextView) findViewById(R.id.txt1);
        listview=(ListView) findViewById(R.id.listview);
        btn_seach=(Button) findViewById(R.id.btn_seach);


        btn_room=(Button) findViewById(R.id.btn_room);
        btn_mesenger=(Button) findViewById(R.id.btn_messenger);
        btn_fees=(Button) findViewById(R.id.btn_fees);
        btn_notifycation=(Button) findViewById(R.id.btn_notification);
    }
}
