package com.example.rishi.firebaseapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.rishi.firebaseapplication.R.id.recyclerView;


public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView mRecyclerView;
    ContactAdapter contactAdapter;
    Map<String,Long> map;
    List<String> names;
    TextView nameTv,phoneTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mRecyclerView=(RecyclerView)findViewById(recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);


        reference=FirebaseDatabase.getInstance().getReference().child("Users");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if (id==R.id.action_addContact){
            Intent i=new Intent(MainActivity.this,AddContactActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }



    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public ContactViewHolder(View view){
            super(view);
            mView=view;

        }

        public void setNameView(String name,int position){
            LinearLayout linear=(LinearLayout)mView.findViewById(R.id.linear);
            TextView nameTv=(TextView)mView.findViewById(R.id.nameView);
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
        public void setNumber(Long num){
            TextView  phoneTv=(TextView)mView.findViewById(R.id.phoneView);

            try {
                phoneTv.setText(String.valueOf(num));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Contact,ContactViewHolder> FBRA= new FirebaseRecyclerAdapter<Contact, ContactViewHolder>(
                Contact.class,
                R.layout.list_item,
                ContactViewHolder.class,
                reference
        ) {




            @Override
            protected void populateViewHolder(ContactViewHolder viewHolder, Contact model, int position) {
                final String task_key=getRef(position).getKey().toString();
                Log.e("RISHI","model.toString() "+model.toString());
                Log.e("RISHI","model.getName() "+model.getName());
                viewHolder.setNameView(model.getName(),position);
                viewHolder.setNumber(model.getPhone());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent single_contact =new Intent(MainActivity.this,SingleContact.class);
                        single_contact.putExtra("ContactId",task_key);
                        startActivity(single_contact);
                    }
                });
            }
        };
        mRecyclerView.setAdapter(FBRA);
    }


}
