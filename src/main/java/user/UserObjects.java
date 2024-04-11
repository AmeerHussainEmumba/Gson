package user;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Setter
@Getter

@Slf4j
public class UserObjects {
    String userName;

    public UserObjects (String userName)
    {this.userName=userName;}


    public void notifier(String bookName, String libraryName, String statusType)
    {   if (Objects.equals(statusType, "Subscribed"))
            log.info(userName+ " is informed that they're subscribed to the library "+ libraryName);
        if (Objects.equals(statusType, "Unsubscribed"))
            log.info(userName+ " is informed that they're unsubscribed to the library "+ libraryName);
       if (Objects.equals(statusType, "Added"))
            log.info(userName+" has been informed that "+ bookName+" has been added to the library "+ libraryName);
       if (Objects.equals(statusType, "Removed"))
            log.info(userName+" has been informed that "+ bookName+" has been removed from the library "+ libraryName);
    }
}

