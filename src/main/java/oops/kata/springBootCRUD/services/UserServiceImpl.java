package oops.kata.springBootCRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oops.kata.springBootCRUD.dao.UserDao;
import oops.kata.springBootCRUD.model.User;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> getListOfUsers() {
        return userDao.findAll();
    }

    public void addNewUser(User user) {
        userDao.save(user);
    }

    public void removeUser(Long id) {
        userDao.deleteById(id);
    }

    public void changeUser(User updUser) {
        userDao.save(updUser);
    }

    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        return userDao.findById(userId).orElse(null);
    }
}

