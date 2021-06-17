package com.example.firebasepro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Customadafter extends ArrayAdapter<DataBase> {

    private Activity contex;
    private List<DataBase> dataBaseList;

    public Customadafter(Activity context,List<DataBase> dataBaseList) {
        super(context, R.layout.sample, dataBaseList);
        this.contex = contex;
        this.dataBaseList = dataBaseList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater layoutInflater=contex.getLayoutInflater();

        View view=layoutInflater.inflate(R.layout.sample,null,true);
        DataBase dataBase=dataBaseList.get(position);
        TextView t1=view.findViewById(R.id.nameid);
        TextView t2=view.findViewById(R.id.priceid);
        t1.setText("Product"+dataBase.getName());
        t2.setText("Price"+dataBase.getPrice());

        return view;
    }
}
