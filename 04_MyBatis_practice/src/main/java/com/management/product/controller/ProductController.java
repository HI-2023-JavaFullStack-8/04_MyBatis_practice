package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.text.Format;
import java.text.SimpleDateFormat;
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

        if (productList != null) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("selectAllList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if (productList != null) {
            productPrint.printSuccessMessage("selectByCondition");
        } else {
            productPrint.printErrorMessage("selectByCondition");
        }
    }

    public void registNewProduct(ProductDTO product) {

        String releaseDate = product.getReleaseDate();
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        String date = formatter.format(releaseDate);
        product.setReleaseDate(date);
        product.setProductionStatus("Y");
        product.setSalesQuantity("0");

        if (productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("insert");
        } else {
            productPrint.printSuccessMessage("insert");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        String releaseDate = product.getReleaseDate();
        Format formatter = new SimpleDateFormat("yyyyMMdd");
        String date = formatter.format(releaseDate);
        product.setReleaseDate(date);

        if (productService.modifyProductInfo(product)) {
            productPrint.printSuccessMessage("update");
        } else {
            productPrint.printSuccessMessage("update");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {
        if (productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("delete");
        } else {
            productPrint.printErrorMessage("delete");
        }
    }
}
