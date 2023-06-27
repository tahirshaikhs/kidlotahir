package com.tahir.tahirkidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class pagetwo extends AppCompatActivity {
    TextView nameone,emailone,dobone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagetwo);
        nameone=findViewById(R.id.nameone);
        emailone=findViewById(R.id.emailone);
        dobone=findViewById(R.id.dobone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("namekey");
        nameone.setText(name);

        Intent intenttwo = getIntent();
        String email = intenttwo.getStringExtra("emailkey");
        emailone.setText(email);

        Intent intentthree = getIntent();
        String dob = intentthree.getStringExtra("dobkey");
        dobone.setText(dob);
    }
}