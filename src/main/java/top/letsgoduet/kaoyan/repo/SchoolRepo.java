package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.School;

public interface SchoolRepo extends CrudRepository<School,Long> {
}
