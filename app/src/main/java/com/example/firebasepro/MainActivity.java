package com.example.firebasepro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private Button savebutton,showbutton;
private EditText productE,priceE;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference=FirebaseDatabase.getInstance().getReference("market");
        savebutton=findViewById(R.id.save);
        showbutton=findViewById(R.id.show);
        productE=findViewById(R.id.productEditText);
        priceE=findViewById(R.id.priceEditText);
        //***********************************
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });


        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
public void saveData(){
      String name=productE.getText().toString().trim();
      String price=priceE.getText().toString().trim();
      String key=databaseReference.push().getKey();
      DataBase dataBase=new DataBase(name,price);
      databaseReference.child(key).setValue(dataBase);
      Toast.makeText(getApplicationContext(),"data store",Toast.LENGTH_SHORT).show();
      productE.setText("");
      priceE.setText("");


}
}