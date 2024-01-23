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
        System.out.println("검색조건 : " + searchCondition.getOption());
        System.out.println("검색어 : " + searchCondition.getValue());

        for(ProductDTO product : productList){
            System.out.println(product);
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode){
            case "insertProduct" : successMessage = "추가 성공"; break;
            case "updateProduct" : successMessage = "변경 성공"; break;
            case "deleteProduct" : successMessage = "삭제 성공"; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch(errorCode){
            case "selectAllList" : errorMessage = "조회 실패"; break;
            case "searchCondition" : errorMessage = "조건에 맞는 결과가 없습니다."; break;
            case "insertProduct" : errorMessage = "추가 실패"; break;
            case "updateProduct" : errorMessage = "변경 실패"; break;
            case "deleteProduct" : errorMessage = "삭제 실패"; break;
        }
        System.out.println(errorMessage);
    }
}
