package com.example.app_serie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public class SerieCustomAdapter extends ArrayAdapter<Serie>{
    private Context mContext;
    private List<Serie> serieList;

    public SerieCustomAdapter (Context context, ArrayList<Serie> list){
        super(context,0,list);
        mContext = context;
        serieList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItem = convertView;
        if(listItem==null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_serie,parent,false);
        Serie currentSerie = serieList.get(position);
        TextView nom = (TextView) listItem.findViewById(R.id.titre);
        TextView premDiff = (TextView) listItem.findViewById(R.id.premDiff);
        ImageView image = (ImageView) listItem.findViewById(R.id.imageView_poster);
        Picasso.get().load(currentSerie.getImage()).into(image);
        nom.setText(currentSerie.getTitre());
        premDiff.setText(currentSerie.getPremiereDiffusion());

        return listItem;
    }

}
