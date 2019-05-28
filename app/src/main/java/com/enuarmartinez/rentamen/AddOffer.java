package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddOffer extends AppCompatActivity {

    private EditText Tittle, Price, Des, Cel;
    private Resources Res;
    private FirebaseDatabase database;
    private DatabaseReference MyRef;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_offer);

        Tittle = (EditText)findViewById(R.id.TxtTittle);
        Price = (EditText)findViewById(R.id.TxtPrice);
        Des = (EditText)findViewById(R.id.TxtDes);
        Res = this.getResources();
        Cel = (EditText)findViewById(R.id.TxtCelular);
        database = FirebaseDatabase.getInstance();
        MyRef = database.getReference();

    }


    public void CreateOffer (View view){
        String tittle, des, cel;
        Float price;

        tittle = Tittle.getText().toString().trim();
        des = Des.getText().toString().trim();
        price = Float.parseFloat(Price.getText().toString().trim());
        cel = Cel.getText().toString().trim();

        if (tittle.isEmpty() || des.isEmpty() || price == 0 || price == null || cel.isEmpty()){
            validar(tittle,des,price, cel);
        } else {

            Offer o = new Offer(tittle, des, price, cel);
            o.SaveOffer();
            MyRef.child("Offer").push().setValue(o);
            Toast.makeText(this,Res.getString(R.string.success), Toast.LENGTH_SHORT).show();
            Intent in = new Intent(AddOffer.this, Home.class);
            startActivity(in);

        }

    }

    private void validar(String tittle, String des, Float price, String cel) {

        if (tittle.isEmpty()){ Tittle.setError("*"); }
        if (des.isEmpty()){ Price.setError("*"); }
        if (price == 0 || price == null) { Price.setError("*"); }
        if (cel.isEmpty()){ Cel.setError("*"); }

    }

    public void AaProfile(View view){
        Intent in = new Intent(AddOffer.this,Profile.class);
        startActivity(in);
    }

    public void AaMyOffers(View view){
        Intent in = new Intent(AddOffer.this,MyOffers.class);
        startActivity(in);
    }

    public void AaHome(View view){
        Intent in = new Intent(AddOffer.this,Home.class);
        startActivity(in);
    }


}
