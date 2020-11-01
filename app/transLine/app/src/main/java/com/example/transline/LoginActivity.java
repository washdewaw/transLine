package com.example.transline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.transline.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Create_Account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        Name = findViewById(R.id.denUsername);
        Create_Account = findViewById(R.id.denButtonCreateAcc);
        Create_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
        Password = findViewById(R.id.denPassword);
        Login = findViewById(R.id.denLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        FirebaseUser currentuser = mAuth.getCurrentUser();
        updateUI(currentuser);
    }


    private void validate (){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(LoginActivity.this, HomeFragment.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            signIn();
        }    }

    private void updateUI(FirebaseUser currentuser) {
    }
    private void createAccount(){
        mAuth.createUserWithEmailAndPassword(Name.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(LoginActivity.this, "Account created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(LoginActivity.this, HomeFragment.class);
                            startActivity(intent);
                        } else {
                            // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    private void signIn(){
        mAuth.signInWithEmailAndPassword(Name.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(LoginActivity.this, "Signed in successfully.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(LoginActivity.this, HomeFragment.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}