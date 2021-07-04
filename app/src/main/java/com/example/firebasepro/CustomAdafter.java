package com.example.firebasepro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdafter extends ArrayAdapter<DataBase> {
    private Activity contex;
    private List<DataBase> dataBaseList;

    public CustomAdafter(Activity contex, List<DataBase> dataBaseList) {
        super(contex,R.layout.sample_layout,dataBaseList);
        this.contex = contex;
        this.dataBaseList = dataBaseList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=contex.getLayoutInflater();
       View view= layoutInflater.inflate(R.layout.sample_layout,null,true);
       DataBase dataBase=dataBaseList.get(position);
        TextView t1=view.findViewById(R.id.nameid);
        TextView t2=view.findViewById(R.id.priceid);

        t1.setText(dataBase.getName());
        t2.setText(dataBase.getPrice());


        return view;
    }
}
