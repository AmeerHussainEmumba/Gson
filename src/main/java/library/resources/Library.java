package library.resources;

import com.google.common.collect.BiMap;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;


@Getter
@Setter

@Slf4j
public class Library extends SubscriberStatus{
    public LibraryConstructor.BookObject[] libraryBooks;
    public String libraryName;
    public BiMap<String, LibraryConstructor.BookObject[]> associationOfLibrary;
    public  BookProcessor bookProcessor;

    public Library(String path, String libraryName)
    {   this.libraryName=libraryName;
        libraryBooks= LibraryConstructor.addBooksToLibrary(path);
        this.associationOfLibrary=LibraryConstructor.createLibraryNameAssociation(libraryName,libraryBooks);
        bookProcessor= new BookProcessor(libraryBooks);
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

