package pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.dao.UserDao;
import pp_3_1_2_transfer_to_spring_boot_pp_2_3_1.model.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional(readOnly = true)
    public User findOne(long id) {
        return userDao.findOne(id).get();
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(long id, User updeteUser) {
        userDao.update(id,updeteUser);
    }

    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
}
