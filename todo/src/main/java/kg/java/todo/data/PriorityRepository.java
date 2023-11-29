package kg.java.todo.data;

import kg.java.todo.core.models.entities.PriorityEntity;
import kg.java.todo.core.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity,Long> {
    Optional<PriorityEntity> findPriorityEntityByName(String name);
}
