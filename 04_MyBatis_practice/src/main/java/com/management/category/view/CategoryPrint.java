package com.management.category.view;

import com.management.category.model.dao.CategoryDAOProvider;
import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // * 주석을 지우고 다음 세 가지 메소드를 작성하세요.
    CategoryDAOProvider categoryDAOProvider;

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        if (parameter.get("option").equals("allList")) {
        }
        else if (parameter.get("option").equals("orderList")) {
        }
            for (CategoryDTO category : categoryList) {
                System.out.println(category);
            }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode) {
            case "insert" : successMessage = "신규 제품 분유 정보 등록에 성공하셨습니다"; break;
            case "update" : successMessage = "제품분류명 수정에 성공하셨습니다"; break;
            case "delete" : successMessage = "메뉴 삭제에 성공하셨습니다"; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectList" : errorMessage = "제품 조회에 실패하였습니다"; break;
            case "insert" : errorMessage = "신규 제품 분유 정보 등록에 실패하였습니다"; break;
            case "update" : errorMessage = "제품분류명 수정에 실패하였습니다"; break;
            case "delete" : errorMessage = "메뉴 삭제에 실패하였습니다"; break;
        }
        System.out.println(errorMessage);
    }
}
