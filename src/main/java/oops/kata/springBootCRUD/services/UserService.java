package oops.kata.springBootCRUD.services;

import java.util.List;
import oops.kata.springBootCRUD.model.User;

public interface UserService {
    void addNewUser(User var1);

    void removeUser(Long var1);

    void changeUser(User var1);

    List<User> getListOfUsers();

    User getUserById(Long var1);
}

