package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductController {
    private final ProductService productService;
    private final ProductPrint productPrint;

    public ProductController() {
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> allProductList = productService.selectAllProductList();

        if (allProductList != null) {
            productPrint.printAllProductList(allProductList);
        } else {
            productPrint.printErrorMessage("selectList");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if (productList != null && productList.size() > 0) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("selectOne");
        }
    }

    public void registNewProduct(ProductDTO product) {

        product.setReleaseDate(product.getReleaseDate().replace("-", ""));

        if (productService.registNewProduct(product)) {
            productPrint.printSuccessMessage("insert");
        } else {
            productPrint.printErrorMessage("insert");
        }

    }

    public void modifyProductInfo(ProductDTO product) {

        product.setReleaseDate(product.getReleaseDate().replace("-", ""));

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
