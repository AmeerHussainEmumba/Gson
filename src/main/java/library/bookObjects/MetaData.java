package library.bookObjects;

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
}
