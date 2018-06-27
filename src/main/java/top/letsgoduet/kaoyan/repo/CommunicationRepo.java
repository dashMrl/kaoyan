package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Communication;

public interface CommunicationRepo extends CrudRepository<Communication,Long> {
}
