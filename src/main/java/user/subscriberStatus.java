package user;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public abstract class subscriberStatus {
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
            log.info("user has unsubscribed from the library");
    }


}
