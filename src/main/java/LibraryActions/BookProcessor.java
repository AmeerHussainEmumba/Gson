package LibraryActions;
import Objects.BookObject;
import java.util.Arrays;
import java.util.Objects;


public class BookProcessor {


    public void displayBookInfo(BookObject[] books) {
        for (BookObject book : books)
        {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: " + book.getMetadata().getPrice());
            System.out.println("Categories: ");
            for (String category : book.getMetadata().getCategories())
                System.out.println("  - " + category);
            System.out.println("ISBN: " + book.getMetadata().getIsbn());
            System.out.println("Pages: " +book.getMetadata().getPages());
            System.out.println();
        }
    }

    public void allBooksOfAnAuthor (BookObject[] books, String author)
    {
        Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(BookObject::getTitle)
                .forEach(System.out::println);
    }

    public void getAveragePrice(BookObject[] books)
    {
        double averagePrice = Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);
        System.out.println("The Average price is " + averagePrice);
    }

    public void getHighestPrice (BookObject[] books)
    {
        int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
        Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice)
                .forEach(book -> System.out.println(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));
    }

    public void getBookOfCategory (BookObject[] books, String category)
    {   Arrays.stream(books)
            .filter(book -> Arrays.stream(book.getMetadata().getCategories()).anyMatch(category::equals))
            .map(BookObject::getTitle)
            .forEach(System.out::println);
    }
}
