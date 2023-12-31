package pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.dao;

import pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();

    Optional<User> findOne(long id);

    void save(User user);

    void update(long id, User updeteUser);

    void delete(long id);
}
