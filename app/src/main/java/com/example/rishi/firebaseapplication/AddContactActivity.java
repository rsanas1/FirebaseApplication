package com.example.rishi.firebaseapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContactActivity extends AppCompatActivity {

    DatabaseReference database;
    EditText mName;
    EditText mPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


    }

    public void addButton(View view)
    {
        database= FirebaseDatabase.getInstance().getInstance().getReference().child("Users");
        mName=(EditText)findViewById(R.id.nameEt);
        mPhone=(EditText)findViewById(R.id.phoneEt);

        String name=mName.getText().toString();
        Long phone;
        try
        {
            phone=Long.parseLong(mPhone.getText().toString());
            DatabaseReference newContact=database.push();
            newContact.child("Name").setValue(name);
            newContact.child("Phone").setValue(phone);
            onBackPressed();
        }catch(NumberFormatException e){
            mPhone.setText("");
            Toast.makeText(this,"Enter Numbers",Toast.LENGTH_LONG).show();
        }


    }

}
