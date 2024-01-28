package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductController {

    private final ProductService productService;
    private final ProductPrint productPrint;

    public ProductController() {
        this.productService = new ProductService();
        this.productPrint = new ProductPrint();
    }

    public void selectAllProductList() {


        List<ProductDTO> productList = productService.selectAllProductList();
        if (productList != null) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("selectList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        if (productList != null) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("selectOne");
        }

    }

    public void registNewProduct(ProductDTO product) {

        String releaseDate = product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");
        Boolean result = productService.registNewProduct(product);
        if (result) {
            productPrint.printSuccessMessage("insert");
        } else {
            productPrint.printErrorMessage("insert");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        String releaseDate= product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);
        boolean result = productService.modifyProductInfo(product);
        if (result) {
            productPrint.printSuccessMessage("modify");
        } else {
            productPrint.printErrorMessage("modify");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        boolean result = productService.deleteProduct(parameter);
        if (result) {
            productPrint.printSuccessMessage("delete");
        } else {
            productPrint.printErrorMessage("delete");
        }

    }
}
