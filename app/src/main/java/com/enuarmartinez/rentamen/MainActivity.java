    package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

    public class MainActivity extends AppCompatActivity {
    private EditText Email, Password;
    private ListView LV;
    private FirebaseAuth mAuth;
    private String Opc[];
    private Intent In;
    private Resources Resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.TxtEmailL);
        Password = (EditText)findViewById(R.id.TxtPw);
        LV = (ListView)findViewById(R.id.LVLogin);
        Resources = this.getResources();
        mAuth = FirebaseAuth.getInstance();
        Opc = Resources.getStringArray(R.array.loginlist);
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Opc);
        LV.setAdapter(a);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        In = new Intent(MainActivity.this, Remenber.class);
                        startActivity(In);
                        break;

                    case 1:
                        In = new Intent(MainActivity.this, SingIn1.class);
                        startActivity(In);
                        break;
                }
            }
        });



    }


    public void Login(View view){
        String email, password;

        email = Email.getText().toString();
        password = Password.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, Resources.getString(R.string.wellcome), Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(MainActivity.this,Home.class);
                            startActivity(in);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, Resources.getString(R.string.error_login), Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
    });

    }
}
