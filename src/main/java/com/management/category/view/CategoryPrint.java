package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        System.out.println("============ 조회 목록 ============");
        System.out.println(parameter.get("option"));

        for (CategoryDTO category : categoryList) {
            System.out.println(category);
        }
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch (successCode) {
            case "insert":
                successMessage = "신규 제품 분류 등록을 성공하였습니다.";
                break;
            case "update":
                successMessage = "제품 분류 수정을 성공하였습니다.";
                break;
            case "delete":
                successMessage = "제품 분류 삭제를 성공하였습니다."; break;

        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "select":
                errorMessage = "조회 결과가 존재하지 않습니다.";
                break;
            case "insert":
                errorMessage = "신규 제품 분류 등록에 실패하였습니다.";
                break;
            case "update":
                errorMessage = "제품 분류 수정에 실패하였습니다.";
                break;
            case "delete":
                errorMessage = "제품 분류 삭제에 실패하였습니다."; break;
        }

        System.out.println(errorMessage);

    }
}
