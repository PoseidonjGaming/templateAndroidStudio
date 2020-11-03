package com.example.app_serie;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class JSONHelper {

    private ArrayList<Serie> lesSerie=new ArrayList<Serie>();

    public ArrayList<Serie> getLesSerie(){
        return lesSerie;
    }

    public JSONHelper(Context context){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context));
            JSONArray userArray = obj.getJSONArray("data");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject serieDetail = userArray.getJSONObject(i);
                Serie a = new Serie(serieDetail.getString("titre"),serieDetail.getString("resume"),serieDetail.getString("duree"),serieDetail.getString("premiereDiffusion"), serieDetail.getString("image"), serieDetail.getLong("id"));
                SerieSqlHelper dbHelper=new SerieSqlHelper(context);
                dbHelper.addSerie(a);
                lesSerie.add(a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            context.getAssets();
            InputStream is = context.getAssets().open("serie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public Serie getSerie(int id){
       return lesSerie.get(id);
        /*for (Serie serie : lesSerie) {
            if (serie.getId() == id) {
                return serie;
            }
        }
        throw new NoSuchElementException();*/



    }
}
