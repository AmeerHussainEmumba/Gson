package user;
import com.google.common.collect.BiMap;
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
    Map<String,Boolean>subscriptionMap=new HashMap<>();

    public void setNewSubscriptionStatus(BiMap<String, LibraryConstructor.BookObject[]> associationMap,LibraryConstructor.BookObject[] booksInLibrary, boolean newStatus)
    {  String libraryName=associationMap.inverse().get(booksInLibrary);
        subscriptionMap.put(libraryName,newStatus);
        subscriptionStatus=newStatus;
        printSubscriptionStats(this.subscriptionStatus);
    }

    public boolean checkSubscriptionExistence(String booksInLibrary)
    {  if (subscriptionMap.containsKey(booksInLibrary))
        return true;
        else
            return false;
    }
    public boolean checkSubsciptionStatus (String booksInLibrary) {
            if (subscriptionMap.get(booksInLibrary).booleanValue())
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
