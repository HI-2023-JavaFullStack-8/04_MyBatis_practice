package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {
    private ProductService productService;
    private ProductPrint productPrint;

    public ProductController() {
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> allProductList = productService.selectAllProductList();

        if(allProductList != null) {
            productPrint.printAllProductList(allProductList);
        }else {
            productPrint.printErrorMessage("selectAllProductList");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productByConditionList = productService.selectProductByCondition(searchCondition);

        if(productByConditionList != null) {
            productPrint.printProductList(productByConditionList, searchCondition);
        }else {
            productPrint.printErrorMessage("selectProductByCondition");
        }

    }

    public void registNewProduct(ProductDTO product) {

        String releaseDate = product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);
        product.setProductionStatus("y");
        product.setSalesQuantity("0");

        if(productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("registNewProduct");
        }else {
            productPrint.printErrorMessage("registNewProduct");
        }

    }

    public void modifyProductInfo(ProductDTO product) {

        String releaseDate = product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);

        if(productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("modifyProductionInfo");
        }else {
            productPrint.printErrorMessage("modifyProductionInfo");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("deleteProduct");
        }else {
            productPrint.printErrorMessage("deleteProduct");
        }

    }
}
