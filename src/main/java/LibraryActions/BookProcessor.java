package LibraryActions;
import LibraryActions.Library;

import java.util.Arrays;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookProcessor {


    public void displayBookInfo(Library.BookObject[] books) {
        for (Library.BookObject book : books)
        {
            log.info("Title: " + book.getTitle());
            log.info("Author: " + book.getAuthor());
            log.info("Price: " + book.getMetadata().getPrice());
            log.info("Categories: ");
            for (String category : book.getMetadata().getCategories())
                log.info("  - " + category);
            log.info("ISBN: " + book.getMetadata().getIsbn());
            log.info("Pages: " +book.getMetadata().getPages());
        }
    }

    public void allBooksOfAnAuthor (Library.BookObject[] books, String author)
    {
        Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(Library.BookObject::getTitle)
                .forEach(log::info);
    }

    public void getAveragePrice(Library.BookObject[] books)
    {
        double averagePrice = Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);
        log.info("The Average price is " + averagePrice);
    }

    public void getHighestPrice (Library.BookObject[] books)
    {
        int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
        Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice)
                .forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));
    }

    public void getBookOfCategory (Library.BookObject[] books, String category)
    {   Arrays.stream(books)
            .filter(book -> Arrays.asList(book.getMetadata().getCategories()).contains(category))
            .map(Library.BookObject::getTitle)
            .forEach(log::info);
    }


}

