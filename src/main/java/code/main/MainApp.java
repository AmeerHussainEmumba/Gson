package code.main;

import com.google.common.collect.BiMap;
import library.resources.LibraryConstructor;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;

import java.util.stream.Stream;

@Slf4j
public class MainApp {
    public static void main(String[] args) {
        LibraryConstructor libraryConstructorOfBooks = new LibraryConstructor();
        String userOneName= "First User";
        String userTwoName= "Second User";
        String userThreeName= "Third User";

        LibraryConstructor.BookObject[] booksInLibrary = libraryConstructorOfBooks.addBooksToLibrary("src/main/resources/books.json");
        BiMap<String, LibraryConstructor.BookObject[]> associationOfLibraryOne=libraryConstructorOfBooks.createLibraryNameAssociation("Library Prime", booksInLibrary);
        UserObjects[] allUsers = Stream.of(userOneName, userTwoName, userThreeName)
                .map(UserObjects::new)
                .toArray(UserObjects[]::new);
        libraryConstructorOfBooks.bookProcessor.subscribeNewUsers(allUsers[1],associationOfLibraryOne,booksInLibrary);
        libraryConstructorOfBooks.bookProcessor.subscribeNewUsers(allUsers[2],associationOfLibraryOne,booksInLibrary);
        libraryConstructorOfBooks.bookProcessor.unsubscribeUsers(allUsers[0],associationOfLibraryOne,booksInLibrary);


//        //Display AllBooks
//        libraryConstructorOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);
//
//
//        //Get All books of an Author xyz
//        List<String> allBooksOfAnAuthor = libraryConstructorOfBooks.getBookProcessor().allBooksOfAnAuthor(booksInLibrary, "An Author");
//        allBooksOfAnAuthor.forEach(log::info);
//
//        //Get Average price
//        log.info("The Average price is " + libraryConstructorOfBooks.getBookProcessor().getAveragePrice(booksInLibrary));
//
//        //Get book with the highest price
//        List<LibraryConstructor.BookObject> highestPrice = libraryConstructorOfBooks.getBookProcessor().getHighestPrice(booksInLibrary);
//        highestPrice.forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));
//
//        //Get books with certain category
//        List<String> booksOfCategory = libraryConstructorOfBooks.getBookProcessor().getBookOfCategory(booksInLibrary, "Thriller");
//        booksOfCategory.forEach(log::info);
//
//        Add book from  library
          associationOfLibraryOne = libraryConstructorOfBooks.bookProcessor.addBookToLibrary("src/main/resources/booksToAdd.json",allUsers, associationOfLibraryOne);
          //libraryConstructorOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);

//       Remove book from  library
         associationOfLibraryOne = libraryConstructorOfBooks.bookProcessor.removeBookFromLibrary("A book",allUsers, associationOfLibraryOne);
         //libraryConstructorOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);
//
//


    }
}
