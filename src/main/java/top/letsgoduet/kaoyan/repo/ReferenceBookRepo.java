package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.ReferenceBook;

public interface ReferenceBookRepo extends CrudRepository<ReferenceBook,Long> {
}
