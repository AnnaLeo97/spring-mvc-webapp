package web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import web.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}