package Tasks;

import Objects.BookObject;

import java.awt.print.Book;
import java.util.Objects;

public class BookProcessor {


    public void displayBookInfo(BookObject[] books) {

        for (BookObject book : books) {
            book.displayBookData();
        }
    }

    public void allBooksOfAnAuthor (BookObject[] books, String Author)
    {
        String[] allBooks= new String[books.length];
        int index=0;
        for (BookObject book : books)
        {
            if (Objects.equals(book.authorName(), Author))
            {
                allBooks[index]=book.title;
                index++;
            }
        }

        if (index==0)
        {
            System.out.println("there are no books with this Author");
        }
        else
        { for (int i=0; i<index;i++)
        {
            System.out.println(allBooks[i]);
        }
        }
    }
}
