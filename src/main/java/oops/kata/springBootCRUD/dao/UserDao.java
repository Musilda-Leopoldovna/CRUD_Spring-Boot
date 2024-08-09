package oops.kata.springBootCRUD.dao;

import oops.kata.springBootCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
