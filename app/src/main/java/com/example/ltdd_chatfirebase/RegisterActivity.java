package com.example.ltdd_chatfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, password;
    Button btn_register,btn_cancel;
    FirebaseAuth auth;
    DatabaseReference mDatabase;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.txtUsername);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        btn_register = findViewById(R.id.btnConfirmReg);
        btn_cancel = findViewById(R.id.btnCancel);
        // Write a message to the database

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
                DatabaseReference dbRef = database.getReference();
                dbRef.setValue("Hello");
                Toast.makeText(RegisterActivity.this, "hhhhhhhhhh", Toast.LENGTH_SHORT).show();
            }
        });



        // Write a message to the database



        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegisterActivity.this, "All fileds are required", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length() < 6 ){
                    Toast.makeText(RegisterActivity.this, "password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(txt_email, txt_password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {

                                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công 1", Toast.LENGTH_SHORT).show();



//                                        FirebaseUser firebaseUser = auth.getCurrentUser();
//                                        assert firebaseUser != null;
//                                        String userid = firebaseUser.getUid();



//                                        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
//
//                                        HashMap<String, String> hashMap = new HashMap<>();
//                                        hashMap.put("id", userid);
//                                        hashMap.put("username", txt_username);
//                                        hashMap.put("imageURL", "default");
//                                        hashMap.put("status", "offline");
//                                        hashMap.put("search", txt_username.toLowerCase());
//
//                                        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//                                                if (task.isSuccessful()){
//                                                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công 2", Toast.LENGTH_SHORT).show();
//                                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                                    startActivity(intent);
//                                                    finish();
//                                                }
//                                            }
//                                        });


//                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                }
                            });
                }
            }
        });
    }



}
