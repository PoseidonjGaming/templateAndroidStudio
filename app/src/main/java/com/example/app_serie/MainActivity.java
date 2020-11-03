package com.example.app_serie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
    }

    public void BTNListeSerie_Click(View view) {
        startActivity(new Intent(MainActivity.this,listeSerie.class));
    }

    public void BTNAjouter_Click(View view) {
        startActivity(new Intent(MainActivity.this,AjoutSerie.class));
    }
}