package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public User save(User user) {
        entityManager.getTransaction().begin();
        User newUser = entityManager.merge(user);
        entityManager.getTransaction().commit();
        return newUser;
    }

    public List<User> show() {
        TypedQuery<User> query = entityManager.createQuery
                ("select u from User u", User.class);
        return query.getResultList();
    }

    public void edit(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    public User get(int id) {
        return entityManager.find(User.class, id);
    }
}
