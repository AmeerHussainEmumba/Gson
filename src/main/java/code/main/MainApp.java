package code.main;


import library.resources.Library;
import library.resources.LibraryConstructor;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class MainApp {
    public static void main(String[] args) {

        String userOneName= "First User";
        String userTwoName= "Second User";
        String userThreeName= "Third User";


        Library libraryPrime=new Library("src/main/resources/books.json", "Library Prime");

        UserObjects[] allUsers = Stream.of(userOneName, userTwoName, userThreeName)
                .map(UserObjects::new)
                .toArray(UserObjects[]::new);

        libraryPrime.addSubscriber(allUsers[1]);
        libraryPrime.printSubscriptionStats(allUsers[0]);
        libraryPrime.printSubscriptionStats(allUsers[1]);
        libraryPrime.printSubscriptionStats(allUsers[2]);


           //Display AllBooks
           libraryPrime.bookProcessor.displayBookInfo();

           //Get All books of an Author xyz
           List<String> allBooksOfAnAuthor = libraryPrime.getBookProcessor().allBooksOfAnAuthor("An Author");
           allBooksOfAnAuthor.forEach(log::info);

           //Get Average price
           log.info("The Average price is " + libraryPrime.getBookProcessor().getAveragePrice());

           //Get book with the highest price
           List<LibraryConstructor.BookObject> highestPrice = libraryPrime.getBookProcessor().getHighestPrice();
           highestPrice.forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));

           //Get books with certain category
           List<String> booksOfCategory = libraryPrime.getBookProcessor().getBookOfCategory("Thriller");
           booksOfCategory.forEach(log::info);

           //Add book from  library
             libraryPrime.libraryBooks= libraryPrime.bookProcessor.addBookToLibrary("src/main/resources/booksToAdd.json", libraryPrime);
             libraryPrime.bookProcessor.displayBookInfo();

          //Remove book from  library
             libraryPrime.libraryBooks = libraryPrime.bookProcessor.removeBookFromLibrary("A book", libraryPrime);
             libraryPrime.bookProcessor.displayBookInfo();

    }
}
