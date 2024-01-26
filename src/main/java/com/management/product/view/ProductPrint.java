package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {



    public void printAllProductList(List<ProductDTO> allProductList) {

        for(ProductDTO product : allProductList){
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

         System.out.println("검색 조건 : " + searchCondition.getOption());
       for(ProductDTO product : productList)
       {
           System.out.println(product);
       }

    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
         switch (successCode){
            case "insertProduct" : successMessage = "제품 등록에 성공하였습니다."; break;
            case "modifyProduct" : successMessage = "제품 정보 수정에 성공하였습니다."; break;
            case "deleteProduct" : successMessage = "제품 삭제를 성공하였습니다."; break;
        }

        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch(errorCode){
            case "selectList" : errorMessage = "전체 메뉴 목록 조회에 실패하였습니다."; break;
            case "selectOne" : errorMessage = "메뉴 조회를 실패하였습니다."; break;
            case "insertProduct" : errorMessage = "제품 등록에 실패하였습니다."; break;
            case "modifyProduct" : errorMessage = "제품 정보 수정에 실패하였습니다.";  break;
            case "deleteProduct" : errorMessage = "제품 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

}
