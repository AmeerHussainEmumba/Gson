package library.resources;

import java.awt.print.Book;
import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo(Library.BookObject[] books);
     List<String> allBooksOfAnAuthor (Library.BookObject[] books, String author);
    double getAveragePrice(Library.BookObject[] books);
    List<Library.BookObject> getHighestPrice (Library.BookObject[] books);
    List<String> getBookOfCategory (Library.BookObject[] books, String category);
    Library.BookObject[]  addBookToLibrary(Library.BookObject[] existingBookLibrary, String filepathToNewBooks);
   Library.BookObject[] removeBookFromLibrary(Library.BookObject[] books, String nameOfBookToRemove);
}