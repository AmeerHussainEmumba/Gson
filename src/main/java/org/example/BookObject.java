package org.example;
import java.math.BigInteger;



public class BookObject {
    String title;
    String Author;
    MetaData metadata;

    public BookObject(String title, String Author, MetaData metadata)
    {
        this.title=title;
        this.Author=Author;
        this.metadata=metadata;
    }

}
