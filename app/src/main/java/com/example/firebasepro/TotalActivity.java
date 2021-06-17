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

public class TotalActivity extends AppCompatActivity {
   private ListView listView;
    DatabaseReference databaseReference;
    private List<DataBase> dataBaseList;
    private Customadafter customadafter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        databaseReference= FirebaseDatabase.getInstance().getReference("market");
        dataBaseList=new ArrayList<>();
        customadafter=new Customadafter(TotalActivity.this,dataBaseList);
        listView=findViewById(R.id.listviewid);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataBaseList.clear();
                for (DataSnapshot dataSnapshot1:snapshot.getChildren())
                {
                    DataBase dataBase=dataSnapshot1.getValue(DataBase.class);
                    dataBaseList.add(dataBase);

                }
                listView.setAdapter(customadafter);
               }




            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}