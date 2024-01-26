package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        System.out.println("========== " + "조회 목록" + " ==========");
        System.out.println(parameter.get("option"));
        System.out.println("-----------------------------------");
        for(CategoryDTO list : categoryList) {
            System.out.println(list);
        }

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch(successCode) {
            case "registNewCategory" : successMessage = "새로운 분류 코드 생성을 성공하였습니다."; break;
            case "modifyCategoryName" : successMessage = "제품분류 정보 수정을 성공했습니다."; break;
            case "deleteCategory" : successMessage = "제품분류 삭제를 성공했습니다."; break;
        }

        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch(errorCode) {
            case "selectCategoryList" : errorMessage = "조회 결과가 존재하지 않습니다."; break;
            case "registNewCategory" : errorMessage = "새로운 분류 코드 생성을 실패했습니다."; break;
            case "modifyCategoryName" : errorMessage = "제품분료 정보 수정을 실패했습니다."; break;
            case "deleteCategory" : errorMessage = "제품분류 삭제를 실패했습니다."; break;
        }

        System.out.println(errorMessage);

    }

}
