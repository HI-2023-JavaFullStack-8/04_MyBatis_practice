package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    CategoryService categoryService = new CategoryService();
    CategoryPrint categoryPrint = new CategoryPrint();

    public void selectCategoryList(Map<String, String> parameter) {

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if (categoryList != null) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("allList");
        }

    }

    public void registNewCategory(CategoryDTO category) {

        boolean result = categoryService.registNewCategory(category);
        if (result) {
            categoryPrint.printSuccessMessage("insert");
        } else {
            categoryPrint.printErrorMessage("insert");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {

        boolean result = categoryService.modifyCategoryName(category);
        if (result) {
            categoryPrint.printSuccessMessage("update");
        } else {
            categoryPrint.printErrorMessage("update");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

        // 5. 제품분류 정보를 삭제하는 메소드
        //    (조건 1) Service 객체를 호출하여 수정을 수행하고, 결과를 boolean 값으로 return 받으세요.
        boolean result = categoryService.deleteCategory(parameter);
        if (result) {
            categoryPrint.printSuccessMessage("delete");
        } else {
            categoryPrint.printErrorMessage("delete");
        }
        //    (조건 2) delete가 정상적으로 수행된 경우, Print 객체를 통해 삭제 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) delete가 정상적으로 수행되지 않은 경우, Print 객체를 통해 삭제 실패했다는 오류 메세지를 출력하세요.

    }
}
