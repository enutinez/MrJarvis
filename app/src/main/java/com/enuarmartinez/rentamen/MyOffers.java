package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MyOffers extends AppCompatActivity {

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_offers);

    }

    public void MaProfile(View view){
        Intent in = new Intent(MyOffers.this,Profile.class);
        startActivity(in);
    }

    public void MaAddOffer(View view){
        Intent in = new Intent(MyOffers.this,AddOffer.class);
        startActivity(in);
    }

    public void MaHome(View view){
        Intent in = new Intent(MyOffers.this,Home.class);
        startActivity(in);
    }


}
