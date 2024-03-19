package library.resources;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class BookProcessor implements LibraryPerformable {

    public void displayBookInfo(Library.BookObject[] books)
    {
        Arrays.stream(books).toList().forEach(book -> {
        log.info("Title: " + book.getTitle());
        log.info("Author: " + book.getAuthor());
        log.info("Price: " + book.getMetadata().getPrice());
        log.info("Categories: ");
        for (String category : book.getMetadata().getCategories())
            log.info("  - " + category);
        log.info("ISBN: " + book.getMetadata().getIsbn());
        log.info("Pages: " + book.getMetadata().getPages());
        log.info("--------");
        });
    }


    public List<String> allBooksOfAnAuthor (Library.BookObject[] books, String author)
    {   String pretext= "these are the book(s) of the author "+author;

         List<String>returnBooksOfAuthor= Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(Library.BookObject::getTitle)
                 .collect(toList());
          returnBooksOfAuthor.addFirst(pretext);
          return returnBooksOfAuthor;
    }

    public Library.BookObject[] removeBookFromLibrary(Library.BookObject[] books, String nameOfBookToRemove)
    {   Library.BookObject[] newLibrary;
        List<Library.BookObject> remainingBooksList = Arrays.stream(books)
                .filter(book -> !book.getTitle().equals(nameOfBookToRemove))
                .collect(Collectors.toList());
        newLibrary = remainingBooksList.toArray(new Library.BookObject[0]);
        return newLibrary;
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
            .map(Library.BookObject::getTitle).collect(toList());
         returnBooksOfCategory.addFirst(pretext);
         return returnBooksOfCategory;
    }

    public Library.BookObject[] addBookToLibrary(Library.BookObject[] existingBookLibrary, String filepathToNewBooks)
    {   Library tempLibrary= new Library();
        Library.BookObject[] newBooksToAdd =tempLibrary.addBooksToLibrary(filepathToNewBooks);
        Stream<Library.BookObject> newLibrary= Stream.concat(Arrays.stream(existingBookLibrary),Arrays.stream(newBooksToAdd));
        return newLibrary.toArray(Library.BookObject[]::new);
    }


}

