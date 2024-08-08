package oops.kata.springBootCRUD.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import oops.kata.springBootCRUD.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public void saveUser(User user) {
        em.persist(user);
    }

    public void deleteUserDaoById(Long userId) {
        User user = em.find(User.class, userId);
        if (user != null) {
            this.em.remove(user);
        }
    }

    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public User findUserById(Long userId) {
        return em.find(User.class, userId);
    }

    public void changeUserDaoById(User updUser) {
        em.merge(updUser);
    }
}

