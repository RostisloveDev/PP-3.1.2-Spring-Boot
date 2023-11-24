package pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.dao;

import org.springframework.stereotype.Component;
import pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImp() {}

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public Optional<User> findOne(long id) {
        return Optional.of(Optional.ofNullable(entityManager.find(User.class, id)).orElseThrow());
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updeteUser) {
        entityManager.merge(updeteUser);
    }

    @Override
    public void delete(long id) {
        try {
            entityManager.remove(findOne(id).get());
        } catch (NoSuchElementException ignored) {}
    }
}
