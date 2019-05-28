package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {



    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);






    }

    public void PaMyOffers(View view){
        Intent in = new Intent(Profile.this,MyOffers.class);
        startActivity(in);
    }

    public void PaAddOffer(View view){
        Intent in = new Intent(Profile.this,AddOffer.class);
        startActivity(in);
    }

    public void PaHome(View view){
        Intent in = new Intent(Profile.this,Home.class);
        startActivity(in);
    }


}
