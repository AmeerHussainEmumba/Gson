package user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter

@Slf4j
public class UserObjects extends SubscriberStatus {
    String userName;

    public UserObjects (String userName)
    {this.userName=userName;}

    public  void notifyBookWasAdded (String bookName)
    {log.info(this.userName +" knows that "+bookName+" was added to the library!");}

    public  void notifyBookRemoval(String bookName)
    {log.info(this.userName +" knows that "+bookName+" was removed from the library");}
}

