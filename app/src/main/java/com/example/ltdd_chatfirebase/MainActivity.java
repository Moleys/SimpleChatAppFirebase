package com.example.ltdd_chatfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ltdd_chatfirebase.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_here;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_here = findViewById(R.id.button);
        btn_here.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    int upperbound = 100;
                    Random rand = new Random();
                    int int_random = rand.nextInt(upperbound);

                    DatabaseReference myRef = database.getReference("message");

                    myRef.setValue("Hello, World!"+upperbound);
                    DatabaseReference dbRef = database.getReference();
                    dbRef.setValue("Hello");
                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                }
                catch (Throwable e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}