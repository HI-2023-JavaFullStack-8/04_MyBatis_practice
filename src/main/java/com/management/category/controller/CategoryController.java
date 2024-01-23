package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;
    public CategoryController(){
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null){
            categoryPrint.printTeamList(categoryList, parameter);
        }else{
            categoryPrint.printErrorMessage("selectList");
        }
    }

    public void registNewCategory(CategoryDTO category) {

        if(categoryService.registNewCategory(category)){
            categoryPrint.printSuccessMessage("insertCategory");
        }else{
            categoryPrint.printErrorMessage("insertCategory");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {

        if(categoryService.modifyCategoryName(category)){
            categoryPrint.printSuccessMessage("updateCategory");
        }else{
            categoryPrint.printErrorMessage("updateCategory");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        if(categoryService.deleteCategory(parameter)){
            categoryPrint.printSuccessMessage("deleteCategory");
        }else{
            categoryPrint.printErrorMessage("deleteCategory");
        }
    }
}
