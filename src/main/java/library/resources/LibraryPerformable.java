package library.resources;

import java.util.List;

public interface LibraryPerformable {

    List<Library.BookObject> displayBookInfo(Library.BookObject[] books);
     List<String> allBooksOfAnAuthor (Library.BookObject[] books, String author);
    double getAveragePrice(Library.BookObject[] books);
    List<Library.BookObject> getHighestPrice (Library.BookObject[] books);
    List<String> getBookOfCategory (Library.BookObject[] books, String category);
}
