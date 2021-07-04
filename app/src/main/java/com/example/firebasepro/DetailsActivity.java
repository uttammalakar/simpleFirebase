package com.example.firebasepro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    private List<DataBase> dataBaseList;
    private CustomAdafter customAdafter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        listView=findViewById(R.id.listviewid);
        databaseReference= FirebaseDatabase.getInstance().getReference("market");
        dataBaseList=new ArrayList<>();
        customAdafter=new CustomAdafter(DetailsActivity.this,dataBaseList);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    DataBase dataBase=dataSnapshot.getValue(DataBase.class);
                    dataBaseList.add(dataBase);

                }
                listView.setAdapter(customAdafter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}