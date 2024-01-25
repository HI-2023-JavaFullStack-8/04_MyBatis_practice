package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {

    private final ProductService productService;
    private final ProductPrint productPrint;
    public ProductController(){
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {
        List<ProductDTO> productList = productService.selectAllProductList();

        if(productList != null){
            productPrint.printAllProductList(productList);
        }else{
            productPrint.printErrorMessage("selectAllList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if(productList != null){
            productPrint.printProductList(productList, searchCondition);
        }else {
            productPrint.printErrorMessage("searchCondition");
        }
    }

    public void registNewProduct(ProductDTO product) {
        product.setReleaseDate(product.getReleaseDate().replace("-",""));
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");

        if(productService.registNewProduct(product)){
            productPrint.printSuccessMessage("insertProduct");
        }else{
            productPrint.printErrorMessage("insertProduct");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        product.setReleaseDate(product.getReleaseDate().replace("-",""));

        if(productService.modifyProductInfo(product)){
            productPrint.printSuccessMessage("updateProduct");
        }else{
            productPrint.printErrorMessage("updateProduct");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)){
            productPrint.printSuccessMessage("deleteProduct");
        }else{
            productPrint.printErrorMessage("deleteProduct");
        }
    }
}
