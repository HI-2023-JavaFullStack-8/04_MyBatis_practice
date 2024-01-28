package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // * 주석을 지우고 다음 세 가지 메소드를 작성하세요.

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {


            System.out.println(parameter.get("option")+"조건 조회입니다.");
            for(CategoryDTO list : categoryList){
                System.out.println(list);
            }


        // 1. 조회한 목록 출력하는 메소드
        //    (조건 1) HashMap 타입의 매개변수로 받아온 값을 기준으로 전체 목록 조회인지, 순위별 제품분류 조회인지 구분하여 출력하세요.
        //    (조건 2) List<CategoryDTO>로 받아온 데이터 목록을 전체 출력하세요.

    }

    public void printSuccessMessage(String successCode) {
        String message = "";

        switch (successCode){

            case "regist" : message = "카테고리 추가에 성공하였습니다"; break;
            case "update" : message = "카테고리 수정에 성공하였습니다"; break;
            case "delete" : message = "카테고리 삭제에 성공하였습니다."; break;
        }

        System.out.println(message);



    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectAllProductList" : errorMessage = "카테고리 조회에 실패했습니다." ; break;

            case "insert" : errorMessage = "신규 카테고리 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "카테고리 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "카테고리 삭제에 실패하였습니다."; break;
        }

        System.out.println(errorMessage);

    }

}
