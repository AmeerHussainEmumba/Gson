package Tasks;

import Objects.BookObject;


import java.math.BigInteger;
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

    public void getAveragePrice(BookObject[] books)
    {
        int Average=0;
        for (BookObject book: books)
        {
            Average= Average+ book.price();
        }
        Average=Average/books.length;
        System.out.println("The Average price is "+Average);
    }

    public void getHighestPrice (BookObject[] books)
    {
        int highestPrice=0;
        for (BookObject book: books)
        {
            if (book.price()>=highestPrice)
            {
                highestPrice= book.price();
            }
        }
        for (BookObject book: books)
        {
            if (book.price()==highestPrice)
            {
                System.out.println(book.title+ " has the highest price, which is "+ book.price());
            }
        }
    }

    public void getBookOfCategory (BookObject[] books, String Category)
    {  String[] allBooks= new String[books.length];
        int index=0;
        for (BookObject book : books)
        {
            for (String categories:book.categories())
            {
                if (Objects.equals(categories, Category))
                {
                    allBooks[index]=book.title;
                    index++;
                }
            }
        }
        if (index==0)
        {
            System.out.println("There arent any books of this category in list");
        }

        else

        {   for (int i=0; i<index;i++)
            System.out.println(allBooks[i]);
        }


    }
}
