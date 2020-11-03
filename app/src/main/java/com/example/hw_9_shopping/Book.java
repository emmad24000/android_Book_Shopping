package com.example.hw_9_shopping;


import java.util.ArrayList;

public class Book {
    public String title;
    public String author;
    public String src;
    public static ArrayList<Book> bookArrayList = new ArrayList<>();
    public static ArrayList<String> cart = new ArrayList<>();
    public static String date;
    public static String time;

    public Book(String titleIn, String authorIn, String srcIn){
        title = titleIn;
        author = authorIn;
        src = srcIn;

    }




}
