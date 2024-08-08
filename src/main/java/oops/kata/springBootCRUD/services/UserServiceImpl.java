package oops.kata.springBootCRUD.services;

import java.util.List;
import org.springframework.stereotype.Service;
import oops.kata.springBootCRUD.dao.UserDao;
import oops.kata.springBootCRUD.model.User;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getListOfUsers() {
        return userDao.allUsers();
    }

    public void addNewUser(User user) {
        userDao.saveUser(user);
    }

    public void removeUser(Long id) {
        userDao.deleteUserDaoById(id);
    }

    public void changeUser(User updUser) {
        userDao.changeUserDaoById(updUser);
    }

    public User getUserById(Long userId) {
        return userDao.findUserById(userId);
    }
}

