package com.management.product.model.dao;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductDAO {

    // * 주석을 지우고 Mapper interface(= DAO class) 역할을 하도록 내용을 작성하세요.

    List<ProductDTO> selectAllProductList();

    List<ProductDTO> selectProductByCondition(SearchCondition searchCondition);

    boolean registNewProduct(ProductDTO product);

    boolean modifyProductInfo(ProductDTO product);

    boolean deleteProduct(Map<String, String> parameter);


}
