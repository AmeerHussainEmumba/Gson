package code.main;

import library.resources.Library;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class MainApp {
    public static void main(String[] args) {
        Library libraryOfBooks = new Library();
        Library.BookObject[] booksInLibrary = libraryOfBooks.addBooksToLibrary("src/main/resources/books.json");

        //Display AllBooks
        // libraryOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);


        //Get All books of an Author xyz
//        List<String> allBooksOfAnAuthor = libraryOfBooks.getBookProcessor().allBooksOfAnAuthor(booksInLibrary, "An Author");
//        allBooksOfAnAuthor.forEach(log::info);
//
//        //Get Average price
//        log.info("The Average price is " + libraryOfBooks.getBookProcessor().getAveragePrice(booksInLibrary));
//
//        //Get book with the highest price
//        List<Library.BookObject> highestPrice = libraryOfBooks.getBookProcessor().getHighestPrice(booksInLibrary);
//        highestPrice.forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));
//
//        //Get books with certain category
//        List<String> booksOfCategory = libraryOfBooks.getBookProcessor().getBookOfCategory(booksInLibrary, "Thriller");
//        booksOfCategory.forEach(log::info);


        //Remove book from  library
           booksInLibrary =libraryOfBooks.getBookProcessor().removeBookFromLibrary(booksInLibrary, "A book");
            //libraryOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);

        //Add book from  library
        booksInLibrary = libraryOfBooks.bookProcessor.addBookToLibrary(booksInLibrary, "src/main/resources/booksToAdd.json");
        libraryOfBooks.getBookProcessor().displayBookInfo(booksInLibrary);

    }
}
