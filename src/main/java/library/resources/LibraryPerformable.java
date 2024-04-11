package library.resources;

import com.google.common.collect.BiMap;
import user.UserObjects;
import java.util.List;

public interface LibraryPerformable {

    void displayBookInfo();
    List<String> allBooksOfAnAuthor (String author);
    double getAveragePrice();
    List<LibraryConstructor.BookObject> getHighestPrice ();
    List<String> getBookOfCategory (String category);
//    BiMap<String, LibraryConstructor.BookObject[]>  addBookToLibrary(String filepathToNewBooks, UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);
//    BiMap<String, LibraryConstructor.BookObject[]> removeBookFromLibrary(String nameOfBookToRemove,UserObjects[] allUsers, BiMap<String,LibraryConstructor.BookObject[]> associationOfLibrary);

}