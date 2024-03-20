package library.resources;

import user.UserObjects;

import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo(LibraryConstructor.BookObject[] libraryOfBooks);
    List<String> allBooksOfAnAuthor (LibraryConstructor.BookObject[] libraryOfBooks, String author);
    double getAveragePrice(LibraryConstructor.BookObject[] libraryOfBooks);
    List<LibraryConstructor.BookObject> getHighestPrice (LibraryConstructor.BookObject[] libraryOfBooks);
    List<String> getBookOfCategory (LibraryConstructor.BookObject[] libraryOfBooks, String category);
    LibraryConstructor.BookObject[]  addBookToLibrary(LibraryConstructor.BookObject[] existingBookLibrary, String filepathToNewBooks,UserObjects[] allUsers);
    LibraryConstructor.BookObject[] removeBookFromLibrary(LibraryConstructor.BookObject[] libraryOfBooks, String nameOfBookToRemove,UserObjects[] allUsers);
    void subscribeNewUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks);
    void unsubscribeUsers(UserObjects user, LibraryConstructor.BookObject[] libraryOfBooks);
}