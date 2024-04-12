package library.resources;


import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class BookProcessor implements LibraryPerformable {

    public String [] bpReturnAllTitles (LibraryConstructor.BookObject[] books)
    {
        return Arrays.stream(books)
                .map(LibraryConstructor.BookObject::getTitle)
                .toArray(String[]::new);
    }
    public void bpDisplayBookInfo(LibraryConstructor.BookObject[] books)
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


    public List<String> bpGetAllBooksOfAnAuthor (String author,LibraryConstructor.BookObject[] books)
    {   String pretext= "these are the book(s) of the author "+author;

         List<String>returnBooksOfAuthor= Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(LibraryConstructor.BookObject::getTitle)
                 .collect(toList());
          returnBooksOfAuthor.addFirst(pretext);
          return returnBooksOfAuthor;
    }

    public double bpGetAveragePrice(LibraryConstructor.BookObject[] books)
    {
       return Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);
    }

    public List<LibraryConstructor.BookObject> bpGetHighestPrice (LibraryConstructor.BookObject[] books)
    {
         int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
            return Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice).toList();
    }

    public List<String> bpGetBookOfCategory (String category,LibraryConstructor.BookObject[] books)
    {    String pretext="these are the book(s) of the category "+category;
         List<String> returnBooksOfCategory= Arrays.stream(books)
            .filter(book -> Arrays.asList(book.getMetadata().getCategories()).contains(category))
            .map(LibraryConstructor.BookObject::getTitle).collect(toList());
         returnBooksOfCategory.addFirst(pretext);
         return returnBooksOfCategory;
    }

    public LibraryConstructor.BookObject[] bpBooksAdder(LibraryConstructor.BookObject[] newBooksData, LibraryConstructor.BookObject[] books)
    {
         Stream<LibraryConstructor.BookObject> newLibrary= Stream.concat(Arrays.stream(books),Arrays.stream(newBooksData));
         return newLibrary.toArray(LibraryConstructor.BookObject[]::new);
    }


    public LibraryConstructor.BookObject[] bpBookRemover(String nameOfBookToRemove, LibraryConstructor.BookObject[] books, String libraryName)
    {
        if (Arrays.stream(books).anyMatch(book -> book.getTitle().equals(nameOfBookToRemove)))
        { return Arrays.stream(books)
                .filter(book -> !book.getTitle().equals(nameOfBookToRemove)).toArray(LibraryConstructor.BookObject[]::new);
        }
        else
        {  log.info("The book named "+ nameOfBookToRemove+" never existed in the library "+ libraryName);
           return books;}
    }

}
