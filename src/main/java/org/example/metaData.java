package org.example;
import java.math.BigInteger;

public class metaData {

    int price;
    String[] categories;
    BigInteger isbn;
    int pages;

    public metaData(int price, String[]categories, BigInteger isbn, int pages)
    {
        this.price=price;
        this.categories=categories;
        this.isbn=isbn;
        this.pages=pages;
    }
}
