package org.example;

import LibraryActions.Library;
public class MainApp {
    public static void main(String[] args) {
        Library library= new Library();
        Library.BookObject[] booksInLibrary= library.addBooksToLibrary("src/main/resources/books.json");
        {
            //Display AllBooks
            library.getBookProcessor().displayBookInfo(booksInLibrary);

            //Get All books of an Author xyz
            library.getBookProcessor().allBooksOfAnAuthor(booksInLibrary, "An Author");
//
//          //Get Average price
            library.getBookProcessor().getAveragePrice(booksInLibrary);
//
//          //Get book with the highest price
            library.getBookProcessor().getHighestPrice(booksInLibrary);
//
//          //Get books with certain category
            library.getBookProcessor().getBookOfCategory(booksInLibrary, "Thriller");
        }
}
}