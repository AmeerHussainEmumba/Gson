package library.resources;


import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo();
    List<String> allBooksOfAnAuthor (String author);
    double getAveragePrice();
    List<LibraryConstructor.BookObject> getHighestPrice ();
    List<String> getBookOfCategory (String category);
    public LibraryConstructor.BookObject[] addBookToLibrary(String filepathToNewBooks, Library library);
    public LibraryConstructor.BookObject[] removeBookFromLibrary(String nameOfBookToRemove, Library library);
}