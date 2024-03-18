package org.example;

import library.resources.Library;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
public class MainApp {
    public static void main(String[] args) {
        Library library= new Library();
        Library.BookObject[] booksInLibrary= library.addBooksToLibrary("src/main/resources/books.json");
        {
            //Display AllBooks
           List<Library.BookObject> allBookData=library.getBookProcessor().displayBookInfo(booksInLibrary);
            allBookData.forEach(book -> {
                log.info("Title: " + book.getTitle());
                log.info("Author: " + book.getAuthor());
                log.info("Price: " + book.getMetadata().getPrice());
                log.info("Categories: ");
                for (String category : book.getMetadata().getCategories())
                    log.info("  - " + category);
                log.info("ISBN: " + book.getMetadata().getIsbn());
                log.info("Pages: " +book.getMetadata().getPages());
                log.info("--------");
            });

         //Get All books of an Author xyz
             List<String> allBooksOfAnAuthor=library.getBookProcessor().allBooksOfAnAuthor(booksInLibrary, "An Author");
             allBooksOfAnAuthor.forEach(log::info);

         //Get Average price
            log.info("The Average price is " +library.getBookProcessor().getAveragePrice(booksInLibrary));

         //Get book with the highest price
            List<Library.BookObject> highestPrice =library.getBookProcessor().getHighestPrice(booksInLibrary);
            highestPrice.forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));

       //Get books with certain category
            List<String> booksOfCategory= library.getBookProcessor().getBookOfCategory(booksInLibrary, "Thriller");
            booksOfCategory.forEach(log::info);
        }
}
}