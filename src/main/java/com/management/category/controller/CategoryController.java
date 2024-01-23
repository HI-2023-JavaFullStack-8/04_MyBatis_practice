package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    CategoryService categoryService;
    CategoryPrint categoryPrint;

    public CategoryController(){
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(!categoryList.isEmpty()){

            categoryPrint.printTeamList(categoryList, parameter);
        }
        else{
            categoryPrint.printErrorMessage("selectCategory");
        }

    }

    public void registNewCategory(CategoryDTO category) {

         boolean result = categoryService.registNewCategory(category);
        
         if(result == true){
            
            categoryPrint.printSuccessMessage("registCategory");
        }
         else
        {
            categoryPrint.printErrorMessage("registCategory");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {

        boolean result = categoryService.modifyCategoryName(category);

        if(result == true){
            categoryPrint.printSuccessMessage("modifyCategory");
        }
        else{
            categoryPrint.printErrorMessage("modifyCategory");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

         boolean result = categoryService.deleteCategory(parameter);
         if(result == true){
            categoryPrint.printSuccessMessage("deleteCategory");
        }
        else{
            categoryPrint.printErrorMessage("deleteCategory");
        }

    }
}
