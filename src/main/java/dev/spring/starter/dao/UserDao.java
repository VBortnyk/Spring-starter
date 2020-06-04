package dev.spring.starter.dao;

import dev.spring.starter.model.User;
import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

}
