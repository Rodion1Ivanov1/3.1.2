package ivanov312.firstTry.dao;

import ivanov312.firstTry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {


}

