package kg.java.todo.data;

import kg.java.todo.core.models.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    Optional<TaskEntity> findTaskEntityByName(String name);
    @Query("select  t from TaskEntity t " +
            "where t.user.firstName=:userName")
    List<TaskEntity> findTasksByUserName(@Param("userName")String username);
}
