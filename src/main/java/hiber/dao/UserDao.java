package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> show();
    void edit(User user);
    void delete(int id);
    User get(int id);
}
