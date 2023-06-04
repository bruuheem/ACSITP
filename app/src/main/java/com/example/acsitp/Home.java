package com.example.acsitp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_home);


        TextView sante = findViewById(R.id.sec1);
        sante.setOnTouchListener( new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {

                    // Do what you want
                    Intent intent = new Intent(getApplicationContext(), MainMaladies.class);
                    startActivity(intent);

                }

                return true;}}

        );

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {

                    Toast.makeText(getApplicationContext(), "functionalite under dev", Toast.LENGTH_SHORT).show();


                }

                return true;}



        };
        TextView sec2 = findViewById(R.id.sec2);
        sec2.setOnTouchListener(touchListener);
        TextView sec3 = findViewById(R.id.sec3);
        sec3.setOnTouchListener(touchListener);
        TextView sec4 = findViewById(R.id.sec4);
        sec4.setOnTouchListener(touchListener);
        TextView sec5 = findViewById(R.id.sec5);
        sec5.setOnTouchListener(touchListener);
        TextView sec6 = findViewById(R.id.sec6);
        sec6.setOnTouchListener(touchListener);
        Button deconnexion = findViewById(R.id.deconnexion);

deconnexion.setOnClickListener(
        new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Login.class);
                startActivity(intent);
            }
        }
);


    }}
