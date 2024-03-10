package Objects;
import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
public class MetaData {
    private int price;
    private String[] categories;
    private BigInteger isbn;
    private int pages;

    public MetaData(int price, String[] categories, BigInteger isbn, int pages) {
        this.price = price;
        this.categories = categories;
        this.isbn = isbn;
        this.pages = pages;
    }
}

