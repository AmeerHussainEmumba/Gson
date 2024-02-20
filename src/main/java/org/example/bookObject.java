package org.example;

public class bookObject {
    String title;
    int price;
    String[] categories;
    int isbn;
    int pages;

    public bookObject(String title,int price, String[]categories, int isbn, int pages)
    {
        this.title=title;
        this.price=price;
        this.categories=categories;
        this.isbn=isbn;
        this.pages=pages;
    }

}
