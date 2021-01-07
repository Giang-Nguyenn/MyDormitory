package com.example.mydormitory.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydormitory.user.User_Messenger;
import com.example.mydormitory.user.User_Messenger_Adapter;
import com.example.mydormitory.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class User_Messenger_Content_Activity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    ArrayList<User_Messenger> messengerArrayList=new ArrayList<>();
    User_Messenger_Adapter adapter_messenger;
    ListView listview1;
    Button btn_send;
    EditText edt_input;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_dialog_custom);
        listview1=(ListView) findViewById(R.id.listview1);
        btn_send=(Button) findViewById(R.id.btn_send);
        edt_input=(EditText) findViewById(R.id.edt_input);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        SharedPreferences sharedPref =getSharedPreferences("User", Context.MODE_PRIVATE);
        final String UserId = sharedPref.getString("UserId", "ko co name");
        Intent intent=getIntent();
        final String MessengerId=intent.getStringExtra("MessengerId");
        final String Image=intent.getStringExtra("Image");
        final String Name=intent.getStringExtra("Name");
        Toast.makeText(User_Messenger_Content_Activity.this,UserId,Toast.LENGTH_SHORT).show();


        adapter_messenger=new User_Messenger_Adapter(this,R.layout.messenger_content_custom,Image,messengerArrayList);
        listview1.setAdapter(adapter_messenger);
        mDatabase.child("Messenger").child("messenger").child(MessengerId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(!snapshot.getKey().toString().equals("messenger_header")){
                    User_Messenger messenger=snapshot.getValue(User_Messenger.class);
                    messengerArrayList.add(messenger);
                    adapter_messenger.notifyDataSetChanged();
                    Log.e("A123",snapshot.getKey().toString());
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_Messenger messenger=new User_Messenger(UserId,edt_input.getText().toString(),"0", Calendar.getInstance().getTime().toString().substring(0,19));
                mDatabase.child("Messenger").child("messenger").child(MessengerId).push().setValue(messenger);
                User_Messenger_Header user_messenger_header=new User_Messenger_Header(MessengerId,UserId,edt_input.getText().toString(),"0",
                        Calendar.getInstance().getTime().toString().substring(0,19),Image,Name,"0");
                mDatabase.child("Messenger").child("messenger").child(MessengerId).child("messenger_header").setValue(user_messenger_header);


            }
        });
    }
}
