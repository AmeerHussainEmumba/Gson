package LibraryActions;
import Objects.BookObject;
import java.util.Objects;

public class BookProcessor {


    public void displayBookInfo(BookObject[] books) {
        for (BookObject book : books)
        {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: " + book.getMetadata().getPrice());
            System.out.println("Categories: ");
            for (String category : book.getMetadata().getCategories())
                System.out.println("  - " + category);
            System.out.println("ISBN: " + book.getMetadata().getIsbn());
            System.out.println("Pages: " +book.getMetadata().getPages());
            System.out.println();
        }
    }

    public void allBooksOfAnAuthor (BookObject[] books, String Author)
    {
        String[] allBooks= new String[books.length];
        int index=0;
        for (BookObject book : books)
        {
            if (Objects.equals(book.getAuthor(), Author))
            {
                allBooks[index]=book.getTitle();
                index++;
            }
        }

        if (index==0)
        System.out.println("there are no books with this Author");
        else
        { for (int i=0; i<index;i++)
        System.out.println(allBooks[i]);
        }
    }

    public void getAveragePrice(BookObject[] books)
    {
        int Average=0;
        for (BookObject book: books)
            Average= Average+ book.getMetadata().getPrice();
        Average=Average/books.length;
        System.out.println("The Average price is "+Average);
    }

    public void getHighestPrice (BookObject[] books)
    {
        int highestPrice=0;
        for (BookObject book: books)
        {
            if (book.getMetadata().getPrice()>=highestPrice)
                highestPrice= book.getMetadata().getPrice();
        }
        for (BookObject book: books)
        {
            if (book.getMetadata().getPrice()==highestPrice)
                System.out.println(book.getTitle()+ " has the highest price, which is "+ book.getMetadata().getPrice());

        }
    }

    public void getBookOfCategory (BookObject[] books, String Category)
    {  String[] allBooks= new String[books.length];
        int index=0;
        for (BookObject book : books)
        {
            for (String categories:book.getMetadata().getCategories())
            {
                if (Objects.equals(categories, Category))
                {
                    allBooks[index]=book.getTitle();
                    index++;
                }
            }
        }
        if (index==0)
            System.out.println("There arent any books of this category in list");
        else
        {   for (int i=0; i<index;i++)
            System.out.println(allBooks[i]);
        }

    }
}
