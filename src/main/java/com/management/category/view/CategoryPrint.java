package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parmeter) {

        if(parmeter.get("option").equals("allList")) {
            System.out.println("all 출력가능?");
            System.out.println(parmeter);

        } else if (parmeter.get("option").equals("orderList")) {
            System.out.println("order 출력가능?");
            System.out.println(parmeter);
        }

        if(categoryList != null && categoryList.size() > 0) {
            for (CategoryDTO category : categoryList) {
                System.out.println(category);
            }

        } else {
            System.out.println("조회 결과가 존재하지 않습니다.");
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode) {
            case "insert" : successMessage = "신규 메뉴 등록에 성공하였습니다."; break;
            case "update" : successMessage = "메뉴 수정을 성공하였습니다."; break;
            case "delete" : successMessage = "메뉴 삭제를 성공하였습니다."; break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectCategoryList" : errorMessage = "메뉴 목록 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "메뉴 수정을 실패하였습니다."; break;
            case "delete" : errorMessage = "메뉴 삭제를 실패하였습니다."; break;
        }

        System.out.println(errorMessage);
    }
}
