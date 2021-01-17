package com.example.mydormitory.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydormitory.R;
import com.example.mydormitory.Admin.Admin_Messenger;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Calendar;

public class Admin_Messenger_Content_Activity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    ArrayList<Admin_Messenger> messengerArrayList=new ArrayList<>();
    Admin_Messenger_Adapter adapter_messenger;
    ListView listview1;
    Button btn_send;
    EditText edt_input;
    TextView txt_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_dialog_custom);
        listview1=(ListView) findViewById(R.id.listview1);
        btn_send=(Button) findViewById(R.id.btn_send);
        edt_input=(EditText) findViewById(R.id.edt_input);
        txt_name=(TextView) findViewById(R.id.txt_name);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Intent intent=getIntent();
        final String MessengerId=intent.getStringExtra("MessengerId");
        final String Image=intent.getStringExtra("Image");
        final String Name=intent.getStringExtra("Name");
        Toast.makeText(Admin_Messenger_Content_Activity.this,MessengerId.toString()+"-"+Image.toString()+"-"+Name.toString(),Toast.LENGTH_SHORT).show();

        txt_name.setText(Name);
        adapter_messenger=new Admin_Messenger_Adapter(this,R.layout.messenger_content_custom,Image,messengerArrayList);
        listview1.setAdapter(adapter_messenger);
        mDatabase.child("Messenger").child("messenger").child(MessengerId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(!snapshot.getKey().toString().equals("messenger_header")){
                    Admin_Messenger messenger=snapshot.getValue(Admin_Messenger.class);
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
                Admin_Messenger messenger=new Admin_Messenger("Admin",edt_input.getText().toString(),"0", Calendar.getInstance().getTime().toString().substring(0,19));
                mDatabase.child("Messenger").child("messenger").child(MessengerId).push().setValue(messenger);
                Admin_Messenger_Header messenger_header=new Admin_Messenger_Header(MessengerId,"Admin",edt_input.getText().toString(),"0",
                        Calendar.getInstance().getTime().toString().substring(0,19),Image,Name,"0");
                mDatabase.child("Messenger").child("messenger").child(MessengerId).child("messenger_header").setValue(messenger_header);
            }
        });
    }
}
