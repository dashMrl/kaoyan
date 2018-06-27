package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.User;

public interface UserRepo extends CrudRepository<User,Long> {
}
