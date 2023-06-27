package com.tahir.tahirkidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name,email;
    EditText birthid;

    Button submit;

    FirebaseDatabase rootNode2;
    DatabaseReference reference2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        birthid=findViewById(R.id.birthid);
        submit=findViewById(R.id.submit);

        birthid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear+1)
                                + "/" + String.valueOf(year);
                        birthid.setText("          "+date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() ){
                    Toast.makeText(MainActivity.this, "Enter your name or Blank field cannot be process", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your email or Blank field cannot be process", Toast.LENGTH_SHORT).show();
                }
                else if (birthid.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter your DOB or Blank field cannot be process", Toast.LENGTH_SHORT).show();
                }
                else {
                    rootNode2 = FirebaseDatabase.getInstance();
                    reference2 = rootNode2.getReference("tahirkidlo");
                    String namestr = name.getText().toString();
                    String emailstr = email.getText().toString();
                    String dobstr = birthid.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), pagetwo.class);
                    tahirmodel data = new tahirmodel( namestr,emailstr,dobstr);
                    reference2.child(namestr).setValue(data);

                    intent.putExtra("namekey",namestr);
                    intent.putExtra("emailkey",emailstr);
                    intent.putExtra("dobkey",dobstr);

                    startActivity(intent);
                }
            }
        });
    }
}