package az.onbir.tv.dao;

import az.onbir.tv.entity.Man;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManDao extends CrudRepository<Man, Integer> {
    Iterable<Man> findAllByInfoContaining(@Param("info") String info);
}
