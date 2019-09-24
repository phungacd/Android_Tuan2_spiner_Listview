package com.example.android_tuan2_spiner_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerdm;
    EditText ma,ten;
    Button nhap;
    ListView listViewsp;

    ArrayList<Catalog> arrayspiner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterspiner = null;

    ArrayList<Product> arrayListView = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListview = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    public void getWidgetControl(){
        spinnerdm = findViewById(R.id.spinnersp);
        ten = findViewById(R.id.txtmasp);
        ma = findViewById(R.id.txttensp);
        nhap = findViewById(R.id.btnnhap);
        listViewsp = findViewById(R.id.listsp);


        adapterspiner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_item,arrayspiner);

        adapterspiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerdm.setAdapter(adapterspiner);

        adapterListview = new ArrayAdapter<Product>(this,android.R.layout.simple_list_item_1,arrayListView);
        listViewsp.setAdapter(adapterListview);

    }

    private void fakeDataCatalog(){
        Catalog catalog1 = new Catalog ("1","Sam Sung");
        Catalog catalog2 = new Catalog ("2","Iphone");
        Catalog catalog3 = new Catalog ("3","LG");

        arrayspiner.add(catalog1);
        arrayspiner.add(catalog2);
        arrayspiner.add(catalog3);
        adapterspiner.notifyDataSetChanged();

    }

    private void addEventsForFormWidgets(){

        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addProductForCatalog();
            }
        });
        spinnerdm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loadListProductByCatalog(arrayspiner.get(i));
            }




        });
    }

    private void addProductForCatalog(){
        Product product = new Product();
        product.setId(ma.getText()+"");
        product.setName(ten.getText()+"");

        Catalog catalog = (Catalog) spinnerdm.getSelectedItem();
        catalog.addProduct(product);
        loadListProductByCatalog(catalog);

    }
    private void  loadListProductByCatalog(Catalog catalog){
        arrayListView.clear();
        arrayListView.addAll(catalog.getListProduct());
        adapterListview.notifyDataSetChanged();
    }
}
