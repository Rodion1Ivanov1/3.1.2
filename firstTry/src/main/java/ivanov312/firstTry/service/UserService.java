package ivanov312.firstTry.service;

import ivanov312.firstTry.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> listUsers();

    User updateUser(User user);

    void deleteUser(Integer id);

    User showUser(Integer id);






}
