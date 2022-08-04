package ch.tom.api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public User add(User user) {
        return this.userRepository.save(user);
    }

    public User getUser(@NonNull String uuid) {
        LOG.debug("--> UUID={}", uuid);
        final User user= userRepository.findUserByUUID(uuid).orElseThrow(() -> new UserNotFoundException("User with UUID: " + uuid + " not found!"));
        LOG.debug("<-- findPlayerByUUID Player={}", user);
        return user;
    }

    public List<User> getList() {
        return userRepository.findAll();
    }


    public List<User> update(@NonNull List<User> player) {
        return this.userRepository.saveAll(player);
    }

    public User update(@NonNull User player) {
        if (player.getUUID() == null)
            throw new IllegalArgumentException("Player must have a UUID");
        return this.userRepository.save(player);
    }
}
