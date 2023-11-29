package kg.java.todo.data;

import kg.java.todo.core.models.entities.PriorityEntity;
import kg.java.todo.core.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity,Long> {
    Optional<PriorityEntity> findPriorityEntityByName(String name);
    @Query("select p from PriorityEntity p " +
            "where p.user.firstName=:userName")
    List<PriorityEntity> findPriorityEntitiesByUserName(@Param("userName") String value);
}
