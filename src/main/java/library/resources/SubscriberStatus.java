package library.resources;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import user.UserObjects;

import java.util.ArrayList;

@Slf4j
@Getter
@Setter
public abstract class SubscriberStatus {
    boolean subscriptionStatus=false;
    ArrayList<UserObjects> subscribedUsers= new ArrayList<>();

    public void addNewSubscription(UserObjects user)
    {   if (checkSubscriptionStatus(user))
            log.info("user is already subscribed to this library");
        else
        subscribedUsers.add(user);

    }

    public void removeExistingSubscription(UserObjects user)
    {
        if (!checkSubscriptionStatus(user))
            log.info("user was never subscribed to this library");
        else
            subscribedUsers.remove(user);
    }

    public boolean checkSubscriptionStatus(UserObjects user)
    {
        return subscribedUsers.stream().anyMatch(existingUsers -> existingUsers.equals(user));
    }

    public void printSubscriptionStats(UserObjects user)
    {
        if (checkSubscriptionStatus(user))
            log.info(user.getUserName()+" is subscribed to the library");
        else
            log.info(user.getUserName()+" user is not subscribed to the library");
    }

    public abstract  void notifyBookWasAdded (UserObjects user, String bookName);

    public abstract void notifyBookRemoval(UserObjects user, String bookName);


}
