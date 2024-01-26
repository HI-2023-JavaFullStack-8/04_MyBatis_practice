package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import jdk.jfr.Category;

import java.util.List;
import java.util.Map;

public class CategoryController {

    // * 주석을 지우고 Controller 역할에 해당하는 내용을 작성하세요.

    // 1. 자주 사용할 Service와 Print 객체를 선언하고, Controller 객체 생성 시 생성되도록 작성하세요.

    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;

    public CategoryController () {

        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }


    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if (categoryList != null) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("selectList");
        }

    }

    public void registNewCategory(CategoryDTO category) {

        if (categoryService.registNewCategory(category)) {
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {


        if (categoryService.modifyCategoryName(category)) {
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

        if (categoryService.deleteCategory(parameter)) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
    }
}
