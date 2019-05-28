package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingIn1 extends AppCompatActivity {

    private EditText Email, Password;
    private FirebaseAuth mAuth;
    private Resources Res;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in1);

        Email = (EditText)findViewById(R.id.TxtEm);
        Password = (EditText)findViewById(R.id.TxtPss);
        mAuth = FirebaseAuth.getInstance();
        Res = this.getResources();

    }

    public void CreateUser (View view){
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Email.setError("*");
            Password.setError("*");
        }else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(SingIn1.this, Res.getString(R.string.auth_success), Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(SingIn1.this, Singin.class);
                                startActivity(in);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SingIn1.this, Res.getString(R.string.error_auth), Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }
    }
}
