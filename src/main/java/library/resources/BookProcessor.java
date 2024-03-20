package library.resources;

import lombok.extern.slf4j.Slf4j;
import user.UserObjects;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class BookProcessor implements LibraryPerformable {

    public void displayBookInfo(LibraryConstructor.BookObject[] books)
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


    public List<String> allBooksOfAnAuthor (LibraryConstructor.BookObject[] books, String author)
    {   String pretext= "these are the book(s) of the author "+author;

         List<String>returnBooksOfAuthor= Arrays.stream(books)
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .map(LibraryConstructor.BookObject::getTitle)
                 .collect(toList());
          returnBooksOfAuthor.addFirst(pretext);
          return returnBooksOfAuthor;
    }

    public double getAveragePrice(LibraryConstructor.BookObject[] books)
    {
       return Arrays.stream(books)
                .mapToDouble(book -> book.getMetadata().getPrice())
                .average()
                .orElse(0);
    }

    public List<LibraryConstructor.BookObject> getHighestPrice (LibraryConstructor.BookObject[] books)
    {
         int highestPrice = Arrays.stream(books)
                .mapToInt(book -> book.getMetadata().getPrice())
                .max()
                .orElse(0);
            return Arrays.stream(books)
                .filter(book -> book.getMetadata().getPrice() == highestPrice).toList();
    }

    public List<String> getBookOfCategory (LibraryConstructor.BookObject[] books, String category)
    {    String pretext="these are the book(s) of the category "+category;
        List<String> returnBooksOfCategory= Arrays.stream(books)
            .filter(book -> Arrays.asList(book.getMetadata().getCategories()).contains(category))
            .map(LibraryConstructor.BookObject::getTitle).collect(toList());
         returnBooksOfCategory.addFirst(pretext);
         return returnBooksOfCategory;
    }

    public LibraryConstructor.BookObject[] addBookToLibrary(LibraryConstructor.BookObject[] existingBookLibrary, String filepathToNewBooks, UserObjects[] allUsers)
    {   LibraryConstructor tempLibraryConstructor = new LibraryConstructor();
        LibraryConstructor.BookObject[] newBooksToAdd = tempLibraryConstructor.addBooksToLibrary(filepathToNewBooks);
        Stream<LibraryConstructor.BookObject> newLibrary= Stream.concat(Arrays.stream(existingBookLibrary),Arrays.stream(newBooksToAdd));
        Arrays.stream(allUsers).filter(userObjects -> userObjects.checkSubsciptionStatus(existingBookLibrary))
                .forEach(user -> log.info(user.getUserName() +" now knows kay nai book dal gai hay"));

        return newLibrary.toArray(LibraryConstructor.BookObject[]::new);

    }

    public LibraryConstructor.BookObject[] removeBookFromLibrary(LibraryConstructor.BookObject[] books, String nameOfBookToRemove, UserObjects[] allUsers)
    {   LibraryConstructor.BookObject[] newLibrary;
        List<LibraryConstructor.BookObject> remainingBooksList = Arrays.stream(books)
                .filter(book -> !book.getTitle().equals(nameOfBookToRemove))
                .collect(Collectors.toList());
        newLibrary = remainingBooksList.toArray(new LibraryConstructor.BookObject[0]);
        Arrays.stream(allUsers).filter(userObjects -> userObjects.checkSubsciptionStatus(books))
                .forEach(user -> log.info(user.getUserName() +" now knows kay book nikal gai"));
        return newLibrary;
    }

    public void subscribeNewUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks)
    {

    }
    public void unsubscribeUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks)
    {

    }
}

