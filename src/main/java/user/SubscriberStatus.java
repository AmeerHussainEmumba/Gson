package user;
import library.resources.LibraryConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
public abstract class SubscriberStatus {
    boolean subscriptionStatus=false;

    public void setNewSubscriptionStatus(LibraryConstructor.BookObject[] booksInLibrary, boolean status)
    {
        Map<LibraryConstructor.BookObject[],Boolean>subscriptionMap=new HashMap<>();
        subscriptionMap.put(booksInLibrary,status);
        printSubscriptionStats(this.subscriptionStatus);
    }
    public void printSubscriptionStats(boolean status)
    {
        if (status)
            log.info("user has subscribed to the library");
        else
            log.info("user is not subscribed to the library");
    }
    public abstract  void notifyBookWasAdded (String bookName);

    public abstract void notifyBookRemoval(String bookName);



}
