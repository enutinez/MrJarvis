package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class OfferDetail extends AppCompatActivity {

    private TextView Tittle, Price, Contact, Des;
    private Resources Res;
    private Intent In;
    private ArrayList<Offer> Offers;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer_detail);

        In = getIntent();
        Offers = DataOffer.Get();

        int Position = In.getIntExtra("position",0);

        Tittle = (TextView)findViewById(R.id.txtTittleD);
        Price = (TextView)findViewById(R.id.txtPriceD);
        Contact = (TextView)findViewById(R.id.txtCellD);
        Des = (TextView)findViewById(R.id.txtDesD);

        LoadData(Offers.get(Position));
    }

    private void LoadData(Offer offer) {

        Tittle.setText(offer.getTitulo());
        Price.setText(""+offer.getPrecio());
        Contact.setText(offer.getCelular());
        Des.setText(offer.getDescripcion());

    }
}
