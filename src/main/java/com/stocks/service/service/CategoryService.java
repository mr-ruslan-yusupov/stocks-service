package com.stocks.service.service;

import com.stocks.service.model.Category;
import com.stocks.service.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryService {
    final private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category saveOrUpdate(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

}
