package ivanov312.firstTry.service;

import org.springframework.stereotype.Service;
import ivanov312.firstTry.dao.UserDao;
import ivanov312.firstTry.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public User showUser(Integer id) {
        return userDao.getOne(id);
    }


}
