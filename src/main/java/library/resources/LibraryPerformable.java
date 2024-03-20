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
    BiMap<String, LibraryConstructor.BookObject[]>  addBookToLibrary(LibraryConstructor.BookObject[] existingBookLibrary, String filepathToNewBooks, UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);
    BiMap<String, LibraryConstructor.BookObject[]> removeBookFromLibrary(LibraryConstructor.BookObject[] libraryOfBooks, String nameOfBookToRemove,UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);
    void subscribeNewUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks);
    void unsubscribeUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks);
}