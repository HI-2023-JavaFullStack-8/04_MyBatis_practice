package com.management.product.model.dao;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductDAO {

    List<ProductDTO> selectAllProductList();

    List<ProductDTO> selectProductByCondition(SearchCondition searchCondition);

    boolean insertProduct(ProductDTO product);

    boolean updateProduct(ProductDTO product);

    boolean deleteProduct(Map<String, String> parameter);
}
