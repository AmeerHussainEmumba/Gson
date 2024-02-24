package Objects;

import java.math.BigInteger;

public class MetaData {

    public int price;
    public String[] categories;
    public BigInteger isbn;
    public int pages;

    public MetaData(int price, String[] categories, BigInteger isbn, int pages) {
        this.price = price;
        this.categories = categories;
        this.isbn = isbn;
        this.pages = pages;
    }


}

