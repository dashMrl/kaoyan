package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Grade;

public interface GradeRepo extends CrudRepository<Grade,Long> {
}
