package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        if ("1".equals(parameter.get("option"))) {
            System.out.println("========== 전체 목록 조회 ==========");
            for(CategoryDTO category : categoryList) {
                System.out.println(category);
            }
        } else {
            System.out.println("========== 순위별 제품분류 조회 ==========");
            for (CategoryDTO category : categoryList) {
                System.out.println(category);
            }
        }
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "register": successMessage = "카테고리 신설에 성공하였습니다."; break;
            case "modify": successMessage = "카테고리 수정에 성공하였습니다."; break;
            case "delete": successMessage = "카테고리 삭제에 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "select" : errorMessage = "메뉴 조회에 실패했습니다."; break;
            case "register" : errorMessage = "카테고리 신설에 실패했습니다."; break;
            case "modify": errorMessage = "카테고리 수정에 실패하였습니다."; break;
            case "delete": errorMessage = "카테고리 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }
}
