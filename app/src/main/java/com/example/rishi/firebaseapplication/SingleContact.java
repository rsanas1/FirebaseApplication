package com.example.rishi.firebaseapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class SingleContact extends AppCompatActivity {

    private String task_key=null;
    private TextView mName,mNumber;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);
        mName=(TextView)findViewById(R.id.name);
        mNumber=(TextView)findViewById(R.id.number);
       task_key=getIntent().getExtras().getString("ContactId");
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Users");

        mDatabase.child(task_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ContactName=(String)dataSnapshot.child("Name").getValue();
                Long PhoneNumber=(Long)dataSnapshot.child("Phone").getValue();

                mNumber.setText(PhoneNumber.toString());
                mName.setText(ContactName);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
