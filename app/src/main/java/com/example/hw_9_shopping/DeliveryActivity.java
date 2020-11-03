package com.example.hw_9_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_screen);
        Intent intent = getIntent();
        String time =  intent.getStringExtra("TIME");
        String date = Book.date;
        TextView delivery = findViewById(R.id.deliveryTV);
        delivery.setText("Delivery set for " + date + " at "+time);
        ListView cart = findViewById(R.id.cartListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,Book.cart);

        cart.setAdapter(adapter);



    }



}
