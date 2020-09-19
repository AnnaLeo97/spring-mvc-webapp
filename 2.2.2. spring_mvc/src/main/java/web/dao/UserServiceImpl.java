package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User get(int id) {
        return repo.findById((long)id).get();
    }

    @Override
    public void delete(int id) {
        repo.deleteById((long)id);
    }

}