package library.resources;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;

import java.util.Arrays;
import java.util.List;


@Getter
@Setter

@Slf4j
public class Library extends SubscriberStatus{
    protected LibraryConstructor.BookObject[] libraryBooks;
    protected String libraryName;
    private  BookProcessor bookProcessor=new BookProcessor();

    public Library(String path, String libraryName)
    {   this.libraryName=libraryName;
        libraryBooks= LibraryConstructor.addBooksToLibrary(path);
    }


    public void retrieveAllBookData()
    {
        bookProcessor.bpDisplayBookInfo(libraryBooks);
    }

    public void retrieveAllBooksOfAnAuthor(String author) {
        List<String> allBooksOfAnAuthor = bookProcessor.bpGetAllBooksOfAnAuthor(author, libraryBooks);
        if (!allBooksOfAnAuthor.isEmpty())
            allBooksOfAnAuthor.forEach(log::info);
        else
            log.info("There are no book of the author "+author+" in this library");
    }
    public void retrieveAveragePrice()
    {log.info("The Average price is " + bookProcessor.bpGetAveragePrice(libraryBooks));}

    public void retrieveHighestPrice() {
        List<LibraryConstructor.BookObject> highestPrice = bookProcessor.bpGetHighestPrice(libraryBooks);
           if (!highestPrice.isEmpty())
               highestPrice.forEach(book -> log.info(book.getTitle() + " has the highest price, which is " + book.getMetadata().getPrice()));
           else
               log.info("Somehow there is no book with the highest price?");
    }

    public void  retrieveBooksOfACategory(String category) {
        List<String> booksOfCategory = bookProcessor.bpGetBookOfCategory(category,libraryBooks);
        booksOfCategory.forEach(log::info);
    }

    public void addBooksToLibrary(String pathToNewBooks) {
        LibraryConstructor.BookObject[] tempLibrary= LibraryConstructor.addBooksToLibrary(pathToNewBooks);
        String [] newBookNames=bookProcessor.bpReturnAllTitles(tempLibrary);
        libraryBooks= bookProcessor.bpBooksAdder(tempLibrary, libraryBooks);
        subscribedUsers.forEach(userObjects -> notifyBookWasAdded(userObjects, String.valueOf(Arrays.stream(newBookNames).toList())));
    }

    public void removeBookFromLibrary(String bookName)
    {
       libraryBooks = bookProcessor.bpBookRemover("A book", libraryBooks, libraryName);
       subscribedUsers.forEach(userObjects -> notifyBookRemoval(userObjects, bookName));
    }
    public void addSubscriber(UserObjects user)
    {
        addNewSubscription(user);
        user.notifier(null, libraryName,"Subscribed");
    }
    public void removeSubscriber (UserObjects user)
    { removeExistingSubscription(user);}

    public  void notifyBookWasAdded (UserObjects user, String bookName)
    { user.notifier(bookName, libraryName,"Added");}

    public  void notifyBookRemoval(UserObjects user, String bookName)
    {user.notifier(bookName, libraryName,"Removed");}


}

