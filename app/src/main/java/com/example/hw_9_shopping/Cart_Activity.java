package com.example.hw_9_shopping;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Cart_Activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    ListView cart;
    String time;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_display);
        cart = findViewById(R.id.cartListView);
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, Book.cart);

        cart.setAdapter(adapter);

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.cart_menu,menu);
            return true;

        }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item){
            AlertDialog.Builder builder  = new AlertDialog.Builder(Cart_Activity.this);
            builder.setTitle("Are you sure you would like to clear the cart?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Book.cart.clear();
                    adapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();

            return super.onOptionsItemSelected(item);
        }





    public void setDateClick(View view) {
        DatePickerFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(),null);

    }

    public void setTimeClick(View view) {
        TimePickerFragment timePickerFragment = new TimePickerFragment(this);
        timePickerFragment.show(getSupportFragmentManager(),null);
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
         time = String.format("%02d:%02d",hour,minute);

    }

    public void submitClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Cart_Activity.this);
        builder.setTitle("Delivery set for "+ Book.date +" at " +  time);
        builder.setMessage("Continue?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(),DeliveryActivity.class);
                intent.putExtra("TIME",time);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();


    }

}
