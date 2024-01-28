package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductPrint {
    private ProductDAO productDAO;

    public void printAllProductList(List<ProductDTO> allProductList) {

        for(ProductDTO product : allProductList) {
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println(searchCondition.getOption());

        if(productList != null && searchCondition.getValue() != null){
            for(ProductDTO product : productList) {
                System.out.println(product);
            }

        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "insert" : successMessage = "신규 메뉴 등록을 성공하였습니다."; break;
            case "update" : successMessage = "메뉴 수정을 성공하였습니다."; break;
            case "delete" : successMessage = "메뉴 삭제를 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "selectList" : errorMessage = "전체 메뉴 목록 조회에 실패하였습니다."; break;
            case "selectNon" : errorMessage = "선택한 메뉴 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "메뉴 수정에 실패하였습니다."; break;
            case "delete" : errorMessage = "메뉴 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }
}
