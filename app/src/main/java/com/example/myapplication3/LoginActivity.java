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

public class LoginActivity extends AppCompatActivity {

    EditText emailId;
    EditText pass;

    Button loginButton;
    Button signUpButton;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Button button = (Button) findViewById(R.id.login_btn);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
//                startActivity(intent);
//            }
//        });

        emailId = findViewById(R.id.emailID);
        pass = findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_btn);
        signUpButton = (Button) findViewById(R.id.signUpBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = emailId.getText().toString();
                String Pass = pass.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if (Email.isEmpty()) {
                    emailId.setError("Please enter your Email-ID");
                    emailId.requestFocus();
                }
                else if (Pass.isEmpty()) {
                    pass.setError("Please enter your Password");
                    pass.requestFocus();
                }
                else if (!Email.isEmpty() && !Pass.isEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, GamePage.class));
                            }else {
                                Toast.makeText(LoginActivity.this,"Login Failed! - Your entered the wrong Details.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }

}
