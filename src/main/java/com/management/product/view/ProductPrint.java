package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("========== 제품 전체 조회 목록 ==========");
        for(ProductDTO list : allProductList) {
            System.out.println(list);
        }

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println("========== " + "조건부 제품 목록" + " ==========");
        System.out.println("검색 조건 : " + searchCondition.getOption());
        System.out.println("-----------------------------------");
        for(ProductDTO list : productList) {
            System.out.println(list);
        }

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch(successCode) {
            case "registNewProduct" : successMessage = "새로운 제품 등록을 성공했습니다."; break;
            case "modifyProductionInfo" : successMessage = "제품 수정을 성공했습니다."; break;
            case "deleteProduct" : successMessage = "제품 삭제를 성공했습니다."; break;
        }

        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch(errorCode) {
            case "selectAllProductList" : errorMessage = "전체 메뉴 조회를 실패했습니다."; break;
            case "selectProductByCondition" : errorMessage = "조건에 부합한 목록 조회를 실패했습니다."; break;
            case "registNewProduct" : errorMessage = "새로운 제품 등록을 실패했습니다."; break;
            case "modifyProductionInfo" : errorMessage = "제품 수정을 실패했습니다."; break;
            case "deleteProduct" : errorMessage = "제품 삭제를 성공했습니다."; break;
        }

        System.out.println(errorMessage);

    }

}
