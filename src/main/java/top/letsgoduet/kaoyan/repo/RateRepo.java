package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Rate;

public interface RateRepo extends CrudRepository<Rate,Long> {
}
