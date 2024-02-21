package org.example;
import java.math.BigInteger;



public class bookObject {
    String title;
    String Author;
    metaData metaData;
    public bookObject(String title, String Author, int price, String[]categories, BigInteger isbn, int pages)
    {
        this.title=title;
        this.Author=Author;
        this.metaData=new metaData (price,categories,isbn,pages);
    }

}
