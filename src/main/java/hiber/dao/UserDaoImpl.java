package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public List<User> show() {
        return entityManager.createQuery
                ("select u from User u", User.class).getResultList();
    }

    public void edit(User user) {
        entityManager.merge(user);
    }

    public void delete(int id) {
        TypedQuery<User> query = entityManager.createQuery
                ("delete from User where id=:id", User.class);
        query.executeUpdate();
    }
    public User get(int id) {
        return entityManager.find(User.class, id);
    }
}
