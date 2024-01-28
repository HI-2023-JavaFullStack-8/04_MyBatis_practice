package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {


    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        if (parameter != null) {
            if (parameter.get("option").equals("orderList")) {
                System.out.println("순위별 제품분류 조회");
            }
            if (parameter.get("option").equals("allList")) {
                System.out.println("전체 목록 조회");
            }
        }

        if (categoryList != null) {
            for (CategoryDTO category : categoryList) {
                System.out.println(category.toString());
            }
        }

    }

    public void printSuccessMessage(String successCode) {

        // 2. 성공메시지를 출력하는 메소드
        String successMessage = "";

        switch (successCode) {
            case "insert":
                successMessage = "제품분류 정보 등록에 성공했습니다.";
                break;
            case "update":
                successMessage = "제품분류 정보 수정에 성공했습니다.";
                break;
                case "delete":
                successMessage = "제품분류 정보 삭제에 성공했습니다.";
                break;
        }

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "allList":
                errorMessage = "제품 조회에 실패했습니다.";
                break;
            case "insert":
                errorMessage = "제품분류 정보 등록에 실패했습니다.";
                break;
            case "update":
                errorMessage = "제품분류 정보 수정에 실패했습니다.";
                break;
                case "delete":
                errorMessage = "제품분류 정보 삭제에 실패했습니다.";
                break;
        }
    }

}
