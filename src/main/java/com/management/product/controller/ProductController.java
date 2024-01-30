package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {
    private final ProductService productService;
    private final ProductPrint printResult;

    public ProductController() {
        productService = new ProductService();
        printResult = new ProductPrint();
    }
    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();
        if(productList != null) {
            printResult.printAllProductList(productList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        if(productList != null) {
            printResult.printProductList(productList, searchCondition);
        } else {
            printResult.printErrorMessage("selectCondition");
        }
    }

    public void registNewProduct(ProductDTO product) {
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");
        if(productService.registNewProduct(product)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyProductInfo(ProductDTO product) {
        String salesQuantity = product.getSalesQuantity();
        String productionStatus = product.getProductionStatus();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setSalesQuantity(salesQuantity);
        productDTO.setProductionStatus(productionStatus);

        if(productService.modifyProductInfo(productDTO) == true) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {
        if(productService.deleteProduct(parameter)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}
