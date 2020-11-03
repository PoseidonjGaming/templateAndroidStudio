package com.example.app_serie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listeSerie extends AppCompatActivity {
    ListView listView;
    ArrayList<Serie> lesSerie=new ArrayList<Serie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONHelper listeSerieJSON=new JSONHelper(listeSerie.this);
        listView=findViewById(R.id.lstView);

        //lesSerie=listeSerieJSON.getLesSerie();

        SerieSqlHelper listSeriesql=new SerieSqlHelper(listeSerie.this);
        lesSerie=listSeriesql.getLesSeries();

        SerieCustomAdapter mAdapter = new SerieCustomAdapter(listeSerie.this, lesSerie);
        listView.setAdapter(mAdapter);

        /*istView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this, detailSerie.class);
                intent.putExtra("titre",lesSerie.get(i).getNom());
                intent.putExtra("desc",lesSerie.get(i).getDesc());
                intent.putExtra("premDiff",lesSerie.get(i).getPremDiff());
                intent.putExtra("img",lesSerie.get(i).getImg());
                intent.putExtra("duree", lesSerie.get(i).getDesc());
                startActivity(intent);
            }
        });*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object listItem = listView.getItemAtPosition(position);
                Serie serie=(Serie) listItem;
                Intent detailSerieActivity = new Intent(getApplicationContext(), DetailSerie.class);
                detailSerieActivity.putExtra("id",serie.getId());
                startActivity(detailSerieActivity);

            }
        });
    }
}
