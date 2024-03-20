package code.main;

import library.resources.LibraryConstructor;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class MainApp {
    public static void main(String[] args) {
        LibraryConstructor libraryConstructorOfBooks = new LibraryConstructor();
        String userOneName= "First User";
        String userTwoName= "Second User";
        String userThreeName= "Third User";

        LibraryConstructor.BookObject[] booksInLibrary = libraryConstructorOfBooks.addBooksToLibrary("src/main/resources/books.json");
        UserObjects[] allUsers = Stream.of(userOneName, userTwoName, userThreeName)
                .map(UserObjects::new)
                .toArray(UserObjects[]::new);

        allUsers[0].setNewSubscriptionStatus(booksInLibrary, false);
        allUsers[1].setNewSubscriptionStatus(booksInLibrary,true);
        allUsers[2].setNewSubscriptionStatus(booksInLibrary,true);

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
          booksInLibrary = libraryConstructorOfBooks.bookProcessor.addBookToLibrary(booksInLibrary, "src/main/resources/booksToAdd.json",allUsers);
//        libraryConstructorOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);
//
//
//       Remove book from  library
          booksInLibrary =libraryConstructorOfBooks.bookProcessor.removeBookFromLibrary(booksInLibrary, "A book",allUsers);
          //libraryConstructorOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);
//
//


    }
}
