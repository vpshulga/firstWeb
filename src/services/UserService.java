package services;

import entities.User;
import java.io.Serializable;

public interface UserService {
    User save(User user);

    User get(Serializable id);

    void update(User doctor);

    int delete(Serializable id);
}
