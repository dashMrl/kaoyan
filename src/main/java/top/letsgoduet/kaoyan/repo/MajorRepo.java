package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Major;

import java.util.List;

public interface MajorRepo extends CrudRepository<Major, Long> {
    List<Major> findAllBySId(Long sId);
}
