package com.enuarmartinez.rentamen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ListView LV;
    private FirebaseDatabase database;
    private DatabaseReference MyRef;
    private ArrayList<Offer>Off;
    private TextView NoResult;
    private ArrayList<String> Ofertas;
    private Intent in;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        LV = (ListView)findViewById(R.id.LVOffer);
        database = FirebaseDatabase.getInstance();
        MyRef = database.getReference("Offer");
        Ofertas = new ArrayList<String>();
        NoResult = (TextView)findViewById(R.id.TxtHome);

       /*MyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String tittle = ds.child("titulo").getValue().toString().trim();
                    String des = ds.child("descripcion").getValue().toString();
                    Float price = Float.parseFloat(ds.child("precio").getValue().toString());
                    String cel = ds.child("celular").getValue().toString().trim();

                    Offer o = new Offer(tittle,des,price,cel);
                    o.SaveOffer();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });*/

        Off = DataOffer.Get();
        if (Off.size() > 0){
            NoResult.setVisibility(View.INVISIBLE);
            LV.setVisibility(View.VISIBLE);

           for (int i = 0; i < Off.size(); i++){
               Ofertas.add(Off.get(i).getTitulo() + "    " + Off.get(i).getPrecio()) ;            }



        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Ofertas);
        LV.setAdapter(ad);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
             in = new Intent(Home.this, OfferDetail.class);
             in.putExtra("position", position);
             startActivity(in);
            }
        });


    }

    public void Profile(View view){
        Intent in = new Intent(this,Profile.class);
        startActivity(in);
    }

    public void MyOffers(View view){
        Intent in = new Intent(this,MyOffers.class);
        startActivity(in);
    }

    public void AddOffer(View view){
        Intent in = new Intent(this,AddOffer.class);
        startActivity(in);
    }

    public void Home(View view){
        Intent in = new Intent(this,Home.class);
        startActivity(in);
    }


}
