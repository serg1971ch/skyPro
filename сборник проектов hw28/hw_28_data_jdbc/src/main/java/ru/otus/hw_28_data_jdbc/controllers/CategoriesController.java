package ru.otus.hw_28_data_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw_28_data_jdbc.dtos.CategoryDto;
import ru.otus.hw_28_data_jdbc.dtos.CreateOrUpdateCategoryDtoRq;
import ru.otus.hw_28_data_jdbc.dtos.SimplestPageDto;
import ru.otus.hw_28_data_jdbc.entities.Category;
import ru.otus.hw_28_data_jdbc.exceptions.ResourceNotFoundException;
import ru.otus.hw_28_data_jdbc.services.CategoriesService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;

    private static final Function<Category, CategoryDto> MAP_TO_DTO_FUNCTION = c -> new CategoryDto(c.getId(), c.getTitle());

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public String findAll(Model model) {
            Iterable<Category> categoriesIterable = categoriesService.findAll();
            List<Category> categories = new ArrayList<>();
            for(Category category : categoriesIterable) {
                categories.add(category);
            }
            model.addAttribute("categories", categories);
            model.addAttribute("categoriesCount", categories.size());
            return "/categories";
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return categoriesService.findById(id).map(MAP_TO_DTO_FUNCTION).orElseThrow(() -> new ResourceNotFoundException("Категория не найдена"));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoriesService.deleteById(id);
    }

    @PostMapping
    public void createNewCategory(@RequestBody CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        categoriesService.createNewCategory(createOrUpdateCategoryDtoRq);
    }

    @PutMapping
    public void updateCategory(@RequestBody CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        categoriesService.fullUpdateCategory(createOrUpdateCategoryDtoRq);
    }
}
