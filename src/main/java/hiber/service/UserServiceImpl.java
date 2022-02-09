package hiber.service;

import hiber.dao.UserDaoImpl;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional
    public void save(User user) {
        userDaoImpl.save(user);
    }

    @Transactional
    public List<User> show() {
        return userDaoImpl.show();
    }

    @Transactional
    public void edit(User user) {
        userDaoImpl.edit(user);
    }

    @Transactional
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Transactional
    public User get(int id) {
        return userDaoImpl.get(id);
    }


    @PostConstruct
    public void init() {
        save(new User("vova", "pupkin"));
        save(new User("vova", "pupkin"));
        save(new User("valera", "puchkin"));
        save(new User("volodimir", "polyshcyk"));
        save(new User("vikor", "popov"));
        save(new User("vasya", "petrenko"));
        save(new User("vadim", "prutckyi"));
    }
}
