package LibraryActions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookProcessor {


    public List<Library.BookObject> displayBookInfo(Library.BookObject[] books) {

        return Arrays.stream(books).toList();
    }

    public List<String> allBooksOfAnAuthor (Library.BookObject[] books, String author)
    {   String pretext= "these are the book(s) of the author "+author;
         List<String>returnBooksOfAuthor= Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(Library.BookObject::getTitle)
                 .collect(Collectors.toList());
          returnBooksOfAuthor.addFirst(pretext);
          return returnBooksOfAuthor;
    }

    public double getAveragePrice(Library.BookObject[] books)
    {
       return Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);

    }

    public List<Library.BookObject> getHighestPrice (Library.BookObject[] books)
    {
         int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
            return Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice).toList();
    }

    public List<String> getBookOfCategory (Library.BookObject[] books, String category)
    {    String pretext="these are the book(s) of the category "+category;
        List<String> returnBooksOfCategory= Arrays.stream(books)
            .filter(book -> Arrays.asList(book.getMetadata().getCategories()).contains(category))
            .map(Library.BookObject::getTitle).collect(Collectors.toList());
         returnBooksOfCategory.addFirst(pretext);
         return returnBooksOfCategory;
    }
}

