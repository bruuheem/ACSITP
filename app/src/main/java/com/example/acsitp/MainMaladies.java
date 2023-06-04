package com.example.acsitp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMaladies extends AppCompatActivity {
    private static final String  TAG="mainMaladies";
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<Maladie> maladieList;
    private MaladieDAO maladietDAO;
    private Maladie_creation maladie_creation;
    private  MaladieAdapter maladieAdapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maladies);


        listView = findViewById(R.id.listView);

        maladieList = new ArrayList<>();
        maladietDAO = new MaladieDAO(this);
        Maladie_creation creation = new Maladie_creation(this.maladietDAO);
        /////////////////////

        creation.create("Sinusite ","Symptômes : douleur faciale ou pression dans les sinus, congestion nasale, maux de tête, écoulement nasal épais, fièvre légère.");
        creation.create("Sinusite ","Symptômes : douleur faciale ou pression dans les sinus, congestion nasale, maux de tête, écoulement nasal épais, fièvre légère.");






        maladieList = maladietDAO.getAllmaladies();


        final List<String> maladienamesList = new ArrayList<>();
        for (int i = 0; i < maladieList.size(); i++) {
            maladienamesList.add(maladieList.get(i).getName());
        }

        // Create an ArrayAdapter to mdisplay the announcement titles in the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,maladienamesList);
        listView.setAdapter(adapter);

        ///////////////////
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Maladie selectedItem = (Maladie) maladieList.get(position);
                Intent intent = new Intent(getApplicationContext(), MaladieDetailled.class);
                intent.putExtra("itemName", selectedItem.getName());
                intent.putExtra("itemDes", selectedItem.getDescription());
                //intent.putExtra("itemSyps",selectedItem.getSyps());
                startActivity(intent);
            }
        });
        ImageButton goBackButton = findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

    }
}
