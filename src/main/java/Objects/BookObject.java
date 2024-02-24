package Objects;

import java.math.BigInteger;

public class BookObject {
    public String title;
    public String Author;
    public MetaData metadata;

    public BookObject(String title, String Author, MetaData metadata)
    {
        this.title=title;
        this.Author=Author;
        this.metadata=metadata;
    }


    public void displayBookData()
    {
            System.out.println("Title: " + title);
            System.out.println("Author: " + Author);
            System.out.println("Price: " + metadata.price);
            System.out.println("Categories: ");
            for (String category : metadata.categories) {
                System.out.println("  - " + category);
            }
            System.out.println("ISBN: " + metadata.isbn);
            System.out.println("Pages: " +metadata.pages);
            System.out.println();
    }

    public String titleName ()
    {
        return title;
    }
    public String authorName ()
    {
        return Author;
    }
    public int price()
    {
        return metadata.price;
    }
    public String[] categories ()
    {
        return metadata.categories;
    }
    public BigInteger isbn ()
    {
        return metadata.isbn;
    }
    public int pagesCount ()
    {
        return metadata.pages;
    }

}

