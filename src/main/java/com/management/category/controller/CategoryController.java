package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;

    public CategoryController() {
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null && categoryList.size() > 0) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("select");
        }
    }

    public void registNewCategory(CategoryDTO category) {

        if(categoryService.registNewCategory(category)) {
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        if(categoryService.modifyCategoryName(category)) {
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        if(categoryService.deleteCategory(parameter)) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
