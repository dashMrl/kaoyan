package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Grade;
import top.letsgoduet.kaoyan.model.ReferenceBook;

import javax.validation.constraints.Null;
import java.util.List;

public interface ReferenceBookRepo extends CrudRepository<ReferenceBook,Long> {
    List<ReferenceBook> findAllBySId(Long sId);
}
