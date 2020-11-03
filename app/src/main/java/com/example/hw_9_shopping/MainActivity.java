package com.example.hw_9_shopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookAdapter bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mainRV);
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
        createBookList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Intent intent = new Intent(getApplicationContext(),Cart_Activity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }


    void createBookList(){
        Book book1 = new Book("The Hobbit","J.R. Tolkien","book1.jpeg");
        Book.bookArrayList.add(book1);

        Book book2 = new Book("Educated","Tara Westover","book2.jpeg");
        Book.bookArrayList.add(book2);



        Book book4 = new Book("Looking For Alaska","John Green","book4.jpeg");
        Book.bookArrayList.add(book4);

        Book book3 = new Book("1984","Orwell","book3.jpeg");
        Book.bookArrayList.add(book3);
    }


    class BookAdapter extends RecyclerView.Adapter{
        private final View.OnClickListener bookOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rvPosition = recyclerView.getChildLayoutPosition(view);
                Book temp = Book.bookArrayList.get(rvPosition);

                Intent intent = new Intent(getApplicationContext(),DetailedBookActivity.class);
                intent.putExtra("INDEX",rvPosition);
                intent.putExtra("TITLE",temp.title);
                intent.putExtra("AUTHOR",temp.author);
                intent.putExtra("SRC",temp.src);
                startActivity(intent);



            }
        };

        class BookViewHolder extends RecyclerView.ViewHolder{
            public TextView rvTitleTV;
            public TextView rvAuthorTV;
            public ImageView rvBookIV;

            public BookViewHolder(@NonNull View view){
                super(view);
                this.rvTitleTV = view.findViewById(R.id.rvTitleTV);
                this.rvAuthorTV = view.findViewById(R.id.rvAuthorTV);
                this.rvBookIV = view.findViewById(R.id.rvBookIV);

            }

        };


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_template,parent,false);
            view.setOnClickListener(bookOnClickListener);
            return new BookViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Book arr = Book.bookArrayList.get(position);
            String src = arr.src;
            BookViewHolder bookViewHolder = (BookViewHolder) holder;
            bookViewHolder.rvTitleTV.setText(arr.title);
            bookViewHolder.rvAuthorTV.setText(arr.author);
            if(src.equals("book1.jpeg")){
                bookViewHolder.rvBookIV.setImageResource(R.drawable.book1);
            }else if(src.equals("book2.jpeg")){
                bookViewHolder.rvBookIV.setImageResource(R.drawable.book2);
            }else if(src.equals("book3.jpeg")){
                bookViewHolder.rvBookIV.setImageResource(R.drawable.book3);
            }else if(src.equals("book4.jpeg")){
                bookViewHolder.rvBookIV.setImageResource(R.drawable.book42);
            }


        }

        @Override
        public int getItemCount() {
            return Book.bookArrayList.size();
        }
    }


}