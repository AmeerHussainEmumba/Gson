package library.resources;

import user.UserObjects;

import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo(LibraryConstructor.BookObject[] books);
    List<String> allBooksOfAnAuthor (LibraryConstructor.BookObject[] books, String author);
    double getAveragePrice(LibraryConstructor.BookObject[] books);
    List<LibraryConstructor.BookObject> getHighestPrice (LibraryConstructor.BookObject[] books);
    List<String> getBookOfCategory (LibraryConstructor.BookObject[] books, String category);
    LibraryConstructor.BookObject[]  addBookToLibrary(LibraryConstructor.BookObject[] existingBookLibrary, String filepathToNewBooks);
    LibraryConstructor.BookObject[] removeBookFromLibrary(LibraryConstructor.BookObject[] books, String nameOfBookToRemove);
    void subscribeNewUsers(UserObjects user);
    void unsubscribeUsers(UserObjects user);
}