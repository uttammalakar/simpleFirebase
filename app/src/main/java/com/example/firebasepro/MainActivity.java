package com.example.firebasepro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private Button savebutton;
private EditText product,amount;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference=FirebaseDatabase.getInstance().getReference("market");
        savebutton=findViewById(R.id.save);
        product=findViewById(R.id.product);
        amount=findViewById(R.id.amount);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
public void saveData(){
      String name=product.getText().toString().trim();
      String price=amount.getText().toString().trim();
      String key=databaseReference.push().getKey();
      DataBase dataBase=new DataBase(name,price);
      databaseReference.child(key).setValue(dataBase);
     Toast.makeText(getApplicationContext(),"data store",Toast.LENGTH_SHORT).show();


}
}