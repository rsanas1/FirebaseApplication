package com.example.rishi.firebaseapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by rishi on 6/17/2017.
 */

public class ContactAdapter  {

    Map<String,Long> mContacts;
    List<String> mNames;


/*    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv; LinearLayout linear;
        View mView;
        public ContactViewHolder(View view){
                super(view);
            mView=view;

        }

        public void setName(String name,int position){
            linear=(LinearLayout)mView.findViewById(R.id.linear);
            nameTv=(TextView)mView.findViewById(R.id.nameView);
            nameTv.setText(name);
            nameTv.setTextColor(Color.parseColor("#FFFFFF"));
            if(position%2==0)
            {
                linear.setBackgroundResource(R.drawable.item_background);
            }
            else{
                linear.setBackgroundResource(R.drawable.item_background1);
            }
    }


    }

    public ContactAdapter(Map<String,Long> contacts,List<String> names){
        mContacts=contacts;
        mNames=names;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
        holder.setName(mNames.get(position),position);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),mContacts.get(mNames.get(position)).toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }*/

}
