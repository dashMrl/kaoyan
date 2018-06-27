package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Outline;

public interface OutlineRepo extends CrudRepository<Outline,Long> {
}
