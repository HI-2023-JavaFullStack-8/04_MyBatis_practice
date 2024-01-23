package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProductController {

    ProductService productService;
    ProductPrint productPrint;

    public ProductController (){
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> listAllProduct = productService.selectAllProductList();
        if(listAllProduct != null){
            productPrint.printAllProductList(listAllProduct);
        }
        else{
            productPrint.printErrorMessage("selectList");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productListCondition = productService.selectProductByCondition(searchCondition);

        if(!productListCondition.isEmpty()){
            productPrint.printProductList(productListCondition, searchCondition);
        }
        else{
            productPrint.printErrorMessage("selectOne");
        }
    }

    public void registNewProduct(ProductDTO product) {

        String[] date = product.getRelease_date().split("-");

        String year = date[0];
        String month = date[1];
        String day = date[2];
        String ReleaseDate = "" + year + month + day;
        product.setRelease_date(ReleaseDate);
        product.setProduction_status("Y");
        product.setSales_quantity("0");


         boolean result = productService.registNewProduct(product);
        if(result == true){
            productPrint.printSuccessMessage("insertProduct");
        }
        else{
            productPrint.printErrorMessage("insertProduct");
        }

    }

    public void modifyProductInfo(ProductDTO product) {

        String[] date = product.getRelease_date().split("-");

        String year = date[0];
        String month = date[1];
        String day = date[2];
        String ReleaseDate = "" + year + month + day;
        product.setRelease_date(ReleaseDate);
        boolean result = productService.modifyProductInfo(product);
        if(result == true){
            productPrint.printSuccessMessage("modifyProduct");
        }
        else{
            productPrint.printErrorMessage("modifyProduct");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        boolean result = productService.deleteProduct(parameter);
        if(result == true){
            productPrint.printSuccessMessage("deleteProduct");
        }
        else{
            productPrint.printErrorMessage("deleteProduct");
        }

    }
}
