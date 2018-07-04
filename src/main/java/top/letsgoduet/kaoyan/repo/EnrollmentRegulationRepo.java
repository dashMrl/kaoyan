package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.EnrollmentRegulation;

import java.util.List;

public interface EnrollmentRegulationRepo extends CrudRepository<EnrollmentRegulation, Long> {
    List<EnrollmentRegulation> findAllBySId(Long sId);
}
