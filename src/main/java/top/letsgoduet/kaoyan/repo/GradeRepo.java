package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;
import top.letsgoduet.kaoyan.model.Grade;
import top.letsgoduet.kaoyan.model.ReferenceBook;

import java.util.List;

public interface GradeRepo extends CrudRepository<Grade, Long> {
    List<Grade> findAllBySId(Long sId);
}
