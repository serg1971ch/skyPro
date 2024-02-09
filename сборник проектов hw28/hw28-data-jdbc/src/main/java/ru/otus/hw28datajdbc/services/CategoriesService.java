package ru.otus.hw28datajdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw28datajdbc.dtos.CreateOrUpdateCategoryDtoRq;
import ru.otus.hw28datajdbc.entities.Category;
import ru.otus.hw28datajdbc.repositories.CategoriesRepository;
//import ru.otus.hw28_jdbc.dtos.CreateOrUpdateCategoryDtoRq;
//import ru.otus.hw28_jdbc.entities.Category;
//import ru.otus.hw28_jdbc.repositories.CategoriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

    public Optional<Category> findByTitle(String title) {
        return categoriesRepository.findByTitle(title);
    }

    public Optional<Category> findById(Long id) {
        return categoriesRepository.findById(id);
    }

    public void deleteById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public void createNewCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Category newCategory = new Category(createOrUpdateCategoryDtoRq.getId(), createOrUpdateCategoryDtoRq.getTitle());
        categoriesRepository.save(newCategory);
    }

    public void fullUpdateCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Category updatedCategory = new Category(createOrUpdateCategoryDtoRq.getId(), createOrUpdateCategoryDtoRq.getTitle());
        categoriesRepository.save(updatedCategory);
    }
}
