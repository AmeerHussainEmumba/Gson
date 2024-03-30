package library.resources;

import com.google.common.collect.BiMap;
import user.UserObjects;
import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo(LibraryConstructor.BookObject[] libraryOfBooks);
    List<String> allBooksOfAnAuthor (LibraryConstructor.BookObject[] libraryOfBooks, String author);
    double getAveragePrice(LibraryConstructor.BookObject[] libraryOfBooks);
    List<LibraryConstructor.BookObject> getHighestPrice (LibraryConstructor.BookObject[] libraryOfBooks);
    List<String> getBookOfCategory (LibraryConstructor.BookObject[] libraryOfBooks, String category);
    BiMap<String, LibraryConstructor.BookObject[]>  addBookToLibrary(String filepathToNewBooks, UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);
    BiMap<String, LibraryConstructor.BookObject[]> removeBookFromLibrary(String nameOfBookToRemove,UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);
    void subscribeNewUsers(UserObjects user, BiMap<String, LibraryConstructor.BookObject[]> associationMap,LibraryConstructor.BookObject[] booksInLibrary);
    void unsubscribeUsers(UserObjects user, BiMap<String, LibraryConstructor.BookObject[]> associationMap,LibraryConstructor.BookObject[] booksInLibrary);
}