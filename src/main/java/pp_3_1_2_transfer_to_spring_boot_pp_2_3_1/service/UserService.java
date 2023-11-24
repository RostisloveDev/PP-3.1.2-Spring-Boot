package pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.service;

import pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updeteUser);

    void delete(long id);
}
