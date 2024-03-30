package library.resources;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
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

    public BiMap<String, LibraryConstructor.BookObject[]> addBookToLibrary(String filepathToNewBooks, UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary)
    {   String libraryName=associationOfLibrary.keySet().iterator().next();
        LibraryConstructor tempLibraryConstructor = new LibraryConstructor();
        LibraryConstructor.BookObject[] newBooksToAdd = tempLibraryConstructor.addBooksToLibrary(filepathToNewBooks);
        String [] bookTitles= Arrays.stream(newBooksToAdd)
                            .map(bookObject -> bookObject.getTitle())
                            .toArray(String[]::new);
        Stream<LibraryConstructor.BookObject> newLibrary= Stream.concat(Arrays.stream(associationOfLibrary.get(libraryName)),Arrays.stream(newBooksToAdd));

        Arrays.stream(allUsers).filter(userObjects -> userObjects.checkSubscriptionExistence(libraryName)).filter(userObjects -> userObjects.checkSubsciptionStatus(libraryName))
                .forEach(user -> log.info(user.getUserName() +" now knows that "+ Arrays.stream(bookTitles).toList()+" have/have been added"));
        BiMap<String, LibraryConstructor.BookObject[]> biMap= HashBiMap.create();
        LibraryConstructor.BookObject[] biMapObject= newLibrary.toArray(LibraryConstructor.BookObject[]::new);
        biMap.put(libraryName,biMapObject);
        return biMap;
    }

    public BiMap<String, LibraryConstructor.BookObject[]> removeBookFromLibrary(String nameOfBookToRemove, UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary)
    {
        String libraryName=associationOfLibrary.keySet().iterator().next();
        LibraryConstructor.BookObject[] newLibrary;
        List<LibraryConstructor.BookObject> remainingBooksList = Arrays.stream(associationOfLibrary.get(libraryName))
                .filter(book -> !book.getTitle().equals(nameOfBookToRemove))
                .collect(Collectors.toList());
        newLibrary = remainingBooksList.toArray(new LibraryConstructor.BookObject[0]);
        Arrays.stream(allUsers).filter(userObjects -> userObjects.checkSubscriptionExistence(libraryName)).filter(userObjects -> userObjects.checkSubsciptionStatus(libraryName))
                .forEach(user -> log.info(user.getUserName() +" now knows that "+nameOfBookToRemove+" book has been removed"));
        BiMap<String, LibraryConstructor.BookObject[]> biMap= HashBiMap.create();
        biMap.put(libraryName,newLibrary);
        return biMap;
    }

    public void subscribeNewUsers(UserObjects user, BiMap<String, LibraryConstructor.BookObject[]> associationMap,LibraryConstructor.BookObject[] booksInLibrary)
    {
       user.setNewSubscriptionStatus(associationMap,booksInLibrary, true);
    }
    public void unsubscribeUsers(UserObjects user, BiMap<String, LibraryConstructor.BookObject[]> associationMap,LibraryConstructor.BookObject[] booksInLibrary)
    {
        user.setNewSubscriptionStatus(associationMap,booksInLibrary, false);
    }
}

