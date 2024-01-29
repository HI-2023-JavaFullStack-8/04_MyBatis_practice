package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    // * 주석을 지우고 Controller 역할에 해당하는 내용을 작성하세요.


    // 1. 자주 사용할 Service와 Print 객체를 선언하고, Controller 객체 생성 시 생성되도록 작성하세요.

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
        //    (조건 1) Service 객체를 호출하여 수정을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 2) update가 정상적으로 수행된 경우, Print 객체를 통해 수정 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) update가 정상적으로 수행되지 않은 경우, Print 객체를 통해 수정 실패했다는 오류 메세지를 출력하세요.

    }

    public void deleteCategory(Map<String, String> parameter) {

        // 5. 제품분류 정보를 삭제하는 메소드
        //    (조건 1) Service 객체를 호출하여 수정을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 2) delete가 정상적으로 수행된 경우, Print 객체를 통해 삭제 성공했다는 성공 메세지를 출력하세요.
        //    (조건 3) delete가 정상적으로 수행되지 않은 경우, Print 객체를 통해 삭제 실패했다는 오류 메세지를 출력하세요.

    }
}
