package com.enuarmartinez.rentamen;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Singin extends AppCompatActivity {

    private EditText Name, Lastname ,Age, Cellphone;
    private Spinner Gender;
    private String OpG[];
    private Resources Res;
    private FirebaseDatabase myDb;
    private DatabaseReference myRef;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in);



        Name = (EditText)findViewById(R.id.TxtName);
        Lastname = (EditText)findViewById(R.id.TxtLn);
        Age = (EditText)findViewById(R.id.TxtAge);
        Cellphone = (EditText)findViewById(R.id.TxtCellphone);

        Gender = (Spinner)findViewById(R.id.Gender);
        Res = this.getResources();
        OpG = Res.getStringArray(R.array.gender);


        myDb = FirebaseDatabase.getInstance();
        myRef = myDb.getReference();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,OpG);
        Gender.setAdapter(ad);



    }

    public void SingIn (View view){
        String name, ln, age, cellphone, gender;

        name = Name.getText().toString().trim();
        ln = Lastname.getText().toString().trim();
        age = Age.getText().toString().trim();
        cellphone = Cellphone.getText().toString().trim();
        gender = Gender.getSelectedItem().toString().trim();

            
        if (name.isEmpty() || ln.isEmpty() || age.isEmpty()
                || cellphone.isEmpty()){
            validar(name, ln, age, cellphone);
            Toast.makeText(this, Res.getString(R.string.wrlogin), Toast.LENGTH_LONG).show();
        }else {
                User u = new User(name,ln,age,gender,cellphone);
                myRef.child("User").push().setValue(u);
            Toast.makeText(this,Res.getString(R.string.success), Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Singin.this, MainActivity.class);
            startActivity(in);
            }

        }



        public void validar(String name, String lastname, String age, String cellphone) {

            if (name.isEmpty()){Name.setError("*");}
            if (lastname.isEmpty()){Lastname.setError("*");}
            if (age.isEmpty()){ Age.setError("*");}
            if(cellphone.isEmpty()){Cellphone.setError("*");}


    }



}
