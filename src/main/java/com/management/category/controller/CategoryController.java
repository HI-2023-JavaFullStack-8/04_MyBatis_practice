package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {
    private CategoryService categoryService;
    private CategoryPrint categoryPrint;

    public CategoryController() {

        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();

    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> list = categoryService.selectCategoryList(parameter);

        if(list != null) {
            categoryPrint.printTeamList(list, parameter);
        }else {
            categoryPrint.printErrorMessage("selectCategoryList");
        }

    }

    public void registNewCategory(CategoryDTO category) {

        if(categoryService.registNewCategory(category)) {
            categoryPrint.printSuccessMessage("registNewCategory");
        }else {
            categoryPrint.printErrorMessage("registNewCategory");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {

        if(categoryService.modifyCategoryName(category)) {
            categoryPrint.printSuccessMessage("modifyCategoryName");
        }else {
            categoryPrint.printErrorMessage("modifyCategoryName");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

        if(categoryService.deleteCategory(parameter)) {
            categoryPrint.printSuccessMessage("deleteCategory");
        }else {
            categoryPrint.printErrorMessage("deleteCategory");
        }

    }
}
