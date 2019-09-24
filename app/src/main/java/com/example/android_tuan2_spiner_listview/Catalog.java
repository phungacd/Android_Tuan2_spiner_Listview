package com.example.android_tuan2_spiner_listview;

import java.util.ArrayList;

public class Catalog extends Goods {

    private ArrayList<Product> listsp = null;

    public Catalog(String id, String name ) {
        super(id, name);
        this.listsp = new ArrayList<Product>();
    }

    public Catalog( ) {
        this.listsp = new ArrayList<Product>();
    }


    public boolean isDulicate(Product product) {
        for (Product p1 : listsp) {
            if (p1.getId().trim().equalsIgnoreCase(product.getId().trim()))
                return true;
        }
        return false;
    }

    public boolean addProduct (Product product){
        boolean isDup = isDulicate(product);
        if (!isDup){
            product.setDanhmuc(this);
            return listsp.add(product);
        }
        return  !isDup;
    }

    public  ArrayList<Product> getListProduct(){
        return this.listsp;
    }
    public int size(){
        return listsp.size();
    }
    public Product get (int i){
        return listsp.get(i);
    }
}
