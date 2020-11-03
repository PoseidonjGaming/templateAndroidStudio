package com.example.app_serie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AjoutSerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_serie);

        EditText titre=findViewById(R.id.EditTXTTitre);
        EditText duree=findViewById(R.id.EditTXTDuree);
        EditText premDiff=findViewById(R.id.EditTXTPremDiff);
        EditText resume=findViewById(R.id.EditTXTResume);
        EditText img=findViewById(R.id.EditTXTImage);

        SerieSqlHelper listSeriesql=new SerieSqlHelper(AjoutSerie.this);

        Serie uneSerie=new Serie(titre.getText().toString(), resume.getText().toString() , duree.getText().toString(), premDiff.getText().toString(), img.getText().toString(), 0);
        listSeriesql.addSerie(uneSerie);
    }
}