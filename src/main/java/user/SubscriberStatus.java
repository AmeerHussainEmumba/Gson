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
    Map<LibraryConstructor.BookObject[],Boolean>subscriptionMap=new HashMap<>();

    public void setNewSubscriptionStatus(LibraryConstructor.BookObject[] booksInLibrary, boolean newStatus)
    {
        subscriptionMap.put(booksInLibrary,newStatus);
        subscriptionStatus=newStatus;
        printSubscriptionStats(this.subscriptionStatus);
    }
    public boolean checkSubsciptionStatus (LibraryConstructor.BookObject[] booksInLibrary)
    {
        if (subscriptionMap.get(booksInLibrary  ).booleanValue())
        return true;
        else
        return false;
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
