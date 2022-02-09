package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> show();
    void edit(User user);
    void delete(int id);
    User get(int id);
}
