package library.resources;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class BookProcessor implements LibraryPerformable {
    LibraryConstructor.BookObject[] books;

 public BookProcessor(LibraryConstructor.BookObject[] books)
 { this.books=books;}
    public void displayBookInfo()
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


    public List<String> allBooksOfAnAuthor (String author)
    {   String pretext= "these are the book(s) of the author "+author;

         List<String>returnBooksOfAuthor= Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(LibraryConstructor.BookObject::getTitle)
                 .collect(toList());
          returnBooksOfAuthor.addFirst(pretext);
          return returnBooksOfAuthor;
    }

    public double getAveragePrice()
    {
       return Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);
    }

    public List<LibraryConstructor.BookObject> getHighestPrice ()
    {
         int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
            return Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice).toList();
    }

    public List<String> getBookOfCategory (String category)
    {    String pretext="these are the book(s) of the category "+category;
        List<String> returnBooksOfCategory= Arrays.stream(books)
            .filter(book -> Arrays.asList(book.getMetadata().getCategories()).contains(category))
            .map(LibraryConstructor.BookObject::getTitle).collect(toList());
         returnBooksOfCategory.addFirst(pretext);
         return returnBooksOfCategory;
    }

    public LibraryConstructor.BookObject[] addBookToLibrary(String filepathToNewBooks, Library library)
    {   BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary= library.associationOfLibrary;
        String libraryName=library.libraryName;

        LibraryConstructor tempLibraryConstructor = new LibraryConstructor();
        LibraryConstructor.BookObject[] newBooksToAdd = tempLibraryConstructor.addBooksToLibrary(filepathToNewBooks);
        String [] bookTitles= Arrays.stream(newBooksToAdd)
                            .map(LibraryConstructor.BookObject::getTitle)
                            .toArray(String[]::new);
        Stream<LibraryConstructor.BookObject> newLibrary= Stream.concat(Arrays.stream(associationOfLibrary.get(libraryName)),Arrays.stream(newBooksToAdd));

        library.subscribedUsers.forEach(userObjects -> library.notifyBookWasAdded(userObjects, String.valueOf(Arrays.stream(bookTitles).toList())));
        LibraryConstructor.BookObject[] finalBooks= newLibrary.toArray(LibraryConstructor.BookObject[]::new);
        books= finalBooks;
        return  finalBooks;
    }

    public LibraryConstructor.BookObject[] removeBookFromLibrary(String nameOfBookToRemove, Library library)
    {
        BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary= library.associationOfLibrary;
        String libraryName=library.libraryName;
        LibraryConstructor.BookObject[] newLibrary;
        if (Arrays.stream(associationOfLibrary.get(libraryName)).anyMatch(book -> book.getTitle().equals(nameOfBookToRemove)))
        { newLibrary = Arrays.stream(associationOfLibrary.get(libraryName))
                .filter(book -> !book.getTitle().equals(nameOfBookToRemove)).toArray(LibraryConstructor.BookObject[]::new);
        library.subscribedUsers.forEach(userObjects -> library.notifyBookRemoval(userObjects, nameOfBookToRemove));
            books= newLibrary;
            return newLibrary;}
        else
        {
            log.info("The book named "+ nameOfBookToRemove+" never existed in the library "+ libraryName);
            return books;}
    }

}
