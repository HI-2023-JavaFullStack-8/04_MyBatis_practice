package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("===== 조회한 제품 리스트 =====");

        for (ProductDTO product : allProductList) {
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        System.out.println("===== 검색 조건 =====");
        System.out.println(searchCondition);
        for (ProductDTO product : productList) {
            System.out.println(product);
        }
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode) {
            case "insert":
                successMessage = "신규 메뉴 등록을 성공하였습니다.";
                break;
            case "update":
                successMessage = "메뉴 수정을 성공하였습니다.";
                break;
            case "delete":
                successMessage = "메뉴 삭제를 성공하였습니다.";
        }
        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectList":
                errorMessage = "전체 메뉴 목록 조회에 실패했습니다.";
                break;
            case "selectCondition":
                errorMessage = "조건과 일치하는 목록 조회에 실패했습니다.";
                break;
            case "insert":
                errorMessage = "신규 메뉴 등록에 실패하였습니다.";
                break;
            case "update":
                errorMessage = "메뉴 수정에 실패하였습니다.";
                break;
            case "delete":
                errorMessage = "메뉴 삭제에 실패하였습니다.";
                break;
        }

        System.out.println(errorMessage);
    }

}
