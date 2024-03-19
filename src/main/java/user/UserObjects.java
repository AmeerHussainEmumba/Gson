package user;

import lombok.*;
@Setter
@Getter

public class UserObjects extends SubscriberStatus {
    String userName;

    public UserObjects (String userName)
    {
        this.userName=userName;
    }
}

