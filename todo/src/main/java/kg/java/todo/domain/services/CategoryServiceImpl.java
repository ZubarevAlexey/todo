package kg.java.todo.domain.services;

import jakarta.transaction.Transactional;
import kg.java.todo.core.contracts.services.CategoryService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.mappers.CategoryMapper;
import kg.java.todo.core.models.dtos.category.*;
import kg.java.todo.data.CategoryRepository;
import kg.java.todo.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final UserRepository userRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper,
                               UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.userRepository = userRepository;
    }

    @Override
    public CategoryDto register(CreateCategoryDto model) throws EntityDuplicateException, EntityNotFoundException {
        var category = categoryRepository.findCategoryEntityByName(model.getName());
        if (category.isPresent()) throw new EntityDuplicateException();
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = categoryMapper.fromDomain(model);
        entity.setUser(user);
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var entity = category.builder()
                .id(model.getId())
                .name(model.getName())
                .user(user)
                .build();
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        categoryRepository.delete(category);
        return HttpStatus.OK;
    }

    @Override
    public CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.toDomain(category);
    }

    @Override
    public List<CategoryDto> findByUserId(FindByUserId model) throws EntityNotFoundException {
        var categories = categoryRepository.findCategories(model.getUserId());
        return categories.stream()
                .map(categoryMapper::toDomain)
                .toList();
    }
}
