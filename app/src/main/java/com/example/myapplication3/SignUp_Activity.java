package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Activity extends AppCompatActivity {

    EditText name;
    EditText emailID;
    EditText phone;
    EditText password;
    //EditText confirmPass;
    Button signUpBtn;
    Button askLoginBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.fullName);
        emailID = findViewById(R.id.userEmailId);
        phone = findViewById(R.id.mobileNumber);
        password = findViewById(R.id.password);
        //confirmPass = findViewById(R.id.confirmPassword);
        signUpBtn = findViewById(R.id.signUpBtn);
        askLoginBtn = findViewById(R.id.already_user);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = name.getText().toString();
                String email = emailID.getText().toString();
                String phn = phone.getText().toString();
                String pass = password.getText().toString();
                //String cnfpass = confirmPass.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if (nm.isEmpty()){
                    name.setError("Please Enter your name.");
                    name.requestFocus();
                }
                else if (email.isEmpty()) {
                    emailID.setError("Please enter your Email ID.");
                    emailID.requestFocus();
                }
                else if (phn.isEmpty()) {
                    phone.setError("Please Enter your phone number.");
                    phone.requestFocus();
                }
                else if (pass.isEmpty()) {
                    password.setError("Please Enter your password number.");
                    password.requestFocus();
                }
                else if (!email.isEmpty() && !pass.isEmpty()) {
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isComplete()){
                                Toast.makeText(SignUp_Activity.this,"SignUp Failed",Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUp_Activity.this, LoginActivity.class));
                            }
                        }
                    });
                }
            }
        });
    }
}