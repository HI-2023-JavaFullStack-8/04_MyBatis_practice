package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {


    private final ProductService productService;
    private final ProductPrint productPrint;

    public ProductController() {
        productService = new ProductService();
        productPrint = new ProductPrint();
    }
    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();

        if(productList != null) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("selectList");
        }


    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);


        if (!productList.isEmpty()) {
            productPrint.printProductList(productList,searchCondition);
        } else {
            productPrint.printErrorMessage("selectOne");
        }




    }

    public void registNewProduct(ProductDTO product) {


        String releaseDate = product.getReleaseDate();

        String resultReleaseDate = releaseDate.replaceAll("[-]", "");

        product.setReleaseDate(resultReleaseDate);
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");

        if(productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("insert");
        } else {
            productPrint.printErrorMessage("insert");
        }



    }

    public void modifyProductInfo(ProductDTO product) {

        String releaseDate = product.getReleaseDate();

        String resultReleaseDate = releaseDate.replaceAll("[-]", "");
        product.setReleaseDate(resultReleaseDate);

        if (productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("update");
        } else {
            productPrint.printErrorMessage("update");
        }



    }

    public void deleteProduct(Map<String, String> parameter) {



        if (productService.deleteProduct(parameter)){
            productPrint.printSuccessMessage("delete");
        } else {
            productPrint.printErrorMessage("delete");
        }

    }
}
