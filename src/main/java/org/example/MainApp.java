package org.example;
import Tasks.*;
import Objects.*;

public class MainApp {
    public static void main(String[] args) {
        CreateLibrary library= new CreateLibrary();
        BookProcessor tasks=new BookProcessor();


        BookObject[] books= library.createLibrary("src/main/resources/books.json");
        //Display AllBooks
        //tasks.displayBookInfo(books);

        //Get All books of an Author xyz
        tasks.allBooksOfAnAuthor(books,"An Author");

}
}