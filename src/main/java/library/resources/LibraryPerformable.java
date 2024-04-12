package library.resources;


import java.util.List;

public interface LibraryPerformable {

    String [] bpReturnAllTitles (LibraryConstructor.BookObject[] books);
    void bpDisplayBookInfo(LibraryConstructor.BookObject[] books);
    List<String> bpGetAllBooksOfAnAuthor (String author,LibraryConstructor.BookObject[] books);
    double bpGetAveragePrice(LibraryConstructor.BookObject[] books);
    List<LibraryConstructor.BookObject> bpGetHighestPrice (LibraryConstructor.BookObject[] books);
    List<String> bpGetBookOfCategory (String category,LibraryConstructor.BookObject[] books);
    public LibraryConstructor.BookObject[] bpBooksAdder(LibraryConstructor.BookObject[] newBooksData, LibraryConstructor.BookObject[] books);
    public LibraryConstructor.BookObject[] bpBookRemover (String nameOfBookToRemove, LibraryConstructor.BookObject[] books, String libraryName);
}