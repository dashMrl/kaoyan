package top.letsgoduet.kaoyan.repo;

import org.springframework.data.repository.CrudRepository;
import top.letsgoduet.kaoyan.model.Communication;

import java.util.List;

public interface CommunicationRepo extends CrudRepository<Communication, Long> {
    List<Communication> findAllByUId(Long uId);
}
