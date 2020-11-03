package com.example.hw_9_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedBookActivity extends AppCompatActivity {
    String title;
    String author;
    String src;
    TextView titleTV;
    TextView authorTV;
    ImageView bookIV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_book_view);
        Intent intent;
        intent = getIntent();
        title = intent.getStringExtra("TITLE");
        author = intent.getStringExtra("AUTHOR");
        src = intent.getStringExtra("SRC");
        titleTV = findViewById(R.id.titleTV);
        authorTV = findViewById(R.id.authorTV);
        bookIV = findViewById(R.id.bookImageIV);

        titleTV.setText(title);
        authorTV.setText(author);
        switch (src) {
            case "book1.jpeg":
                bookIV.setImageResource(R.drawable.book1);
                break;
            case "book2.jpeg":
                bookIV.setImageResource(R.drawable.book2);
                break;
            case "book3.jpeg":
                bookIV.setImageResource(R.drawable.book3);
                break;
            case "book4.jpeg":
                bookIV.setImageResource(R.drawable.book42);
                break;
        }



    }

    public void addToCartClick(View view){
        Book.cart.add(title);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }


}
