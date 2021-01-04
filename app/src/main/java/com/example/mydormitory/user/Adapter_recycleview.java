package com.example.mydormitory.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydormitory.Hi;
import com.example.mydormitory.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_recycleview extends RecyclerView.Adapter<Adapter_recycleview.ViewHoldel> {
    Hi hi=new Hi();
    ArrayList<User_LvRoom> adapter;
    Context context;


    @NonNull
    @Override
    public ViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemview=layoutInflater.inflate(R.layout.custom_view_user_room,parent,false);
        return new ViewHoldel(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldel holder, int position) {
        holder.txt_name.setText(adapter.get(position).getName());
        holder.txt_birthday.setText(adapter.get(position).getBirthDay());
        Picasso.get().load(hi.getIp().toString()+adapter.get(position).getImage().substring(21)).into(holder.image_view);

    }

    @Override
    public int getItemCount() {
        return adapter.size();
    }

    public class ViewHoldel extends RecyclerView.ViewHolder{
        ImageView image_view;
        TextView txt_name;
        TextView txt_birthday;

        public ViewHoldel(@NonNull View itemView) {
            super(itemView);
            txt_name=(TextView) itemView.findViewById(R.id.txt_name);
            txt_birthday=(TextView) itemView.findViewById(R.id.txt_birthday);
            image_view=(ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
