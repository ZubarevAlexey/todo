package kg.java.todo.data;

import kg.java.todo.core.models.entities.CategoryEntity;
import kg.java.todo.core.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findCategoryEntityByName(String name);
}
