package web.dao;


import java.util.List;
import web.model.User;

public interface UserService {
    List<User> listAll();
    void save(User user);
    User get(int id);
    void delete(int id);
}
