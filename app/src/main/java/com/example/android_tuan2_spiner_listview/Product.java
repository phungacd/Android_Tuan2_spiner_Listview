package com.example.android_tuan2_spiner_listview;

public class Product extends Goods {
    private Catalog danhmuc;

    public Product(String id, String name, Catalog danhmuc) {
        super(id, name);
        this.danhmuc = danhmuc;
    }

    public Product(Catalog danhmuc) {
        this.danhmuc = danhmuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    public Product() {
    }

    public Catalog getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(Catalog danhmuc) {
        this.danhmuc = danhmuc;
    }
}
