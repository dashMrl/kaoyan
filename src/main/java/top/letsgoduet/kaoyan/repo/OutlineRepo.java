package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Outline;

import java.util.List;

public interface OutlineRepo extends CrudRepository<Outline, Long> {
    List<Outline> findAllBySId(Long sId);
}
