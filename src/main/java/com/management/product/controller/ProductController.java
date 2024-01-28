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

        List<ProductDTO> productList = productService.selectAllProductList();

        if(productList != null) {
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
            productPrint.printErrorMessage("selectNon");
        }

    }

    public void registNewProduct(ProductDTO product) {

        String newReleaseDate = product.getReleaseDate().replace("-", "");

        product.setReleaseDate(newReleaseDate);
        product.setProductionStatus("Y");
        product.setSalesQuantity(String.valueOf(0));

        if(productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("insert");

        } else {
            productPrint.printErrorMessage("insert");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        String newReleaseDate = product.getReleaseDate();

        if(newReleaseDate != null) {
            newReleaseDate = newReleaseDate.replace("-", "");
        }

        if(productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("update");

        } else {
            productPrint.printErrorMessage("update");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("delete");

        } else {
            productPrint.printErrorMessage("delete");
        }
    }
}
