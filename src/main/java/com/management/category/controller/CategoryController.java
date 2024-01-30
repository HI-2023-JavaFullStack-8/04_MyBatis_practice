package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;

    public CategoryController(CategoryService categoryService, CategoryPrint categoryPrint) {
        this.categoryService = categoryService;
        this.categoryPrint = categoryPrint;
    }


    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("select");
        }
    }

    public void registNewCategory(CategoryDTO category) {

        categoryService.registNewCategory(category);

        if(category != null) {
            categoryPrint.printSuccessMessage("register");
        } else {
            categoryPrint.printErrorMessage("register");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        categoryService.modifyCategoryName(category);

        if(categoryService.modifyCategoryName(category) == true) {
            categoryPrint.printSuccessMessage("modify");
        } else {
            categoryPrint.printErrorMessage("modify");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        String categoryCode = parameter.get("categoryCode");

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryCode(categoryCode);

        if(categoryService.deleteCategory(categoryDTO)) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
