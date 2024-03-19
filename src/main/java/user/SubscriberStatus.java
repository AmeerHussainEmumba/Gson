package user;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Getter
@Setter
public abstract class SubscriberStatus {
    boolean isSubscribed=false;

    public void setSubscribed(boolean status)
    {
        this.isSubscribed=status;
        printSubscriptionStats(this.isSubscribed);
    }
    public void printSubscriptionStats(boolean status)
    {
        if (status)
            log.info("user has subscribed to the library");
        else
            log.info("user is not subscribed to the library");
    }

}
