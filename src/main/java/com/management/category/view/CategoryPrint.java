package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // * 주석을 지우고 다음 세 가지 메소드를 작성하세요.
    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        // 1. 조회한 목록 출력하는 메소드

        if ("1".equals(parameter.get("yourKey"))) {
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

        //    (조건 1) HashMap 타입의 매개변수로 받아온 값을 기준으로 전체 목록 조회인지, 순위별 제품분류 조회인지 구분하여 출력하세요.
        //    (조건 2) List<CategoryDTO>로 받아온 데이터 목록을 전체 출력하세요.

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
