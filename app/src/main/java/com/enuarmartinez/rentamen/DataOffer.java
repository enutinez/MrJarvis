package com.enuarmartinez.rentamen;

import java.util.ArrayList;

public class DataOffer {
    private static ArrayList<Offer> Offers = new ArrayList<>();
    public static void Save (Offer c){ Offers.add(c);}
    public static ArrayList<Offer> Get(){return Offers;}
}
