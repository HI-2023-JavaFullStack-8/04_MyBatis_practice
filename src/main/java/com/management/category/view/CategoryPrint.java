package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        if ("orderList".equals(parameter.get("option"))){
            System.out.println("순위별 제품분류 조회");
        }else{
            System.out.println("전체 목록 조회");
        }
        for(CategoryDTO category : categoryList){
            System.out.println(category);
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode){
            case "insertCategory" : successMessage = "등록 성공"; break;
            case "updateCategory" : successMessage = "변경 성공"; break;
            case "deleteCategory" : successMessage = "삭제 성공"; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode){
            case "selectList" : errorMessage = "조회 실패"; break;
            case "insertCategory" : errorMessage = "등록 실패"; break;
            case "updateCategory" : errorMessage = "변경 실패"; break;
            case "deleteCategory" : errorMessage = "삭제 실패"; break;
        }
        System.out.println(errorMessage);
    }
}
