package com.example.demo.services;

import com.example.demo.dtos.CategoryRecordDto;
import com.example.demo.dtos.CategoryResponseDto;
import com.example.demo.models.CategoryModel;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryModel save (CategoryRecordDto productRecordDto) {
        var categoryModel = new CategoryModel();
        BeanUtils.copyProperties(productRecordDto, categoryModel);

        return categoryRepository.save(categoryModel);
    }

    public List<CategoryResponseDto> findAll() {

        List<CategoryModel> products = categoryRepository.findAll();
        return products.stream()
                .map(product -> new CategoryResponseDto(product.getIdCategory(),
                        product.getName()))
                .toList();
    }
}
