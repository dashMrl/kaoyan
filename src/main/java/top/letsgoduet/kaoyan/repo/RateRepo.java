package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Grade;
import top.letsgoduet.kaoyan.model.Rate;

import java.util.List;

public interface RateRepo extends CrudRepository<Rate, Long> {
    List<Rate> findAllBySId(Long sId);
}
