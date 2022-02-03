package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }
    @Transactional
    public List<User> show() {
        return userDao.show();
    }
    @Transactional
    public void edit(User user){
        userDao.edit(user);
    }
    @Transactional
    public void delete(int id){
        userDao.delete(id);
    }
    @Transactional
    public User get(int id){
        return userDao.get(id);
    }


    @PostConstruct
    public void init(){
        save(new User("vova","pupkin"));
        save(new User("vova","pupkin"));
        save(new User("valera","puchkin"));
        save(new User("volodimir","polyshcyk"));
        save(new User("vikor","popov"));
        save(new User("vasya","petrenko"));
        save(new User("vadim","prutckyi"));
    }
}
