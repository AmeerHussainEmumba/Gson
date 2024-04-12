package code.main;


import library.resources.Library;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;
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


//           //Display AllBooks
           libraryPrime.retrieveAllBookData();

           //Get All books of an Author xyz
           libraryPrime.retrieveAllBooksOfAnAuthor("An Author");

           //Get Average price
           libraryPrime.retrieveAveragePrice();

           //Get book with the highest price

           libraryPrime.retrieveHighestPrice();

           //Get books with certain category
           libraryPrime.retrieveBooksOfACategory("Thriller");


           //Add book from  library
             libraryPrime.addBooksToLibrary("src/main/resources/booksToAdd.json");
             libraryPrime.retrieveAllBookData();

          //Remove book from  library
             libraryPrime.removeBookFromLibrary("A book");
             libraryPrime.retrieveAllBookData();

    }
}
