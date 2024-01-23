package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        if(parameter.get("option").equals("orderList"))
        {
            System.out.println("순위별 제품 분류를 조회합니다.");
            for(CategoryDTO category : categoryList)
            {
                System.out.println(category.toString());
            }
         }
        else if(parameter.get("option").equals("allList"))
        {
             System.out.println("전체 제품 분류를 조회합니다.");
            for(CategoryDTO category : categoryList)
            {
                System.out.println(category.toString());
            }
         }
        else{
            System.out.println("parameter.get("+ "option" +") : " + parameter.get("option"));

        }


    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

         switch(successCode){
            case "registCategory" : successMessage = "새로운 카테고리륻 등록 완료했습니다."; break;
            case "modifyCategory" : successMessage = "성공적으로 카테고리를 변경하였습니다."; break;
            case "deleteCategory" : successMessage = "성공적으로 카테고리를 삭제하였습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
          switch (errorCode){
            case "selectCategory" : errorMessage = "제품 정보 조회를 실패하였습니다."; break;
            case "registCategory" : errorMessage = "새로운 카테고리 등록을 실패하였습니다."; break;
            case "modifyCategory" : errorMessage = "카테고리 변경에 실패하였습니다."; break;
            case "deleteCategory" : errorMessage = "카테고리 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

}
