package ch.tom.api.user;

import com.sun.istack.NotNull;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(@NotNull String uuid) {
        super("User not found: " + uuid);
    }
}
