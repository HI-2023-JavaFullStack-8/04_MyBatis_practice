package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllProductList(List<ProductDTO> allProductList) {
        System.out.println("========== 조회한 메뉴 리스트 ==========");

        for(ProductDTO list : allProductList){
            System.out.println(list);
        }


    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println(" "+searchCondition.getOption()+" 으로 검색한 결과입니다.");
        for(ProductDTO list : productList){
            System.out.println(list);
        }



        // 2. 조건에 따라 조회한 목록을 출력하는 메소드
        //    (조건 1) SearchCondition 객체로 검색 조건이 무엇인지 출력하세요.
        //    (조건 2) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.

    }

    public void printSuccessMessage(String successCode) {
        String message = "";

        switch (successCode){

            case "registNewProduct" : message = "제품 추가에 성공하였습니다"; break;
            case "update" : message = "제품 수정에 성공하였습니다"; break;
            case "delete" : message = "제품 삭제에 성공하였습니다."; break;
        }

        System.out.println(message);


    }
    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectAllProductList" : errorMessage = "메뉴 조회에 실패했습니다." ; break;
            case "selectProductByCondition" : errorMessage = "전체 메뉴 목록 조회에 실패하였습니다."; break;
            case "selectOne" : errorMessage = "선택한 메뉴 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "메뉴 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "메슈 삭제에 실패하였습니다."; break;
        }

        System.out.println(errorMessage);

    }

}
