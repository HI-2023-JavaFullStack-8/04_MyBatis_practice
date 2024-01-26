package com.management.product.model.dao;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductDAO {



    List<ProductDTO> selectAllProductList();

    List<ProductDTO> selectProductByCondition(SearchCondition searchCondition);

    int insertProduct(ProductDTO product);

    int updateProduct(ProductDTO product);

    boolean deleteProduct(Map<String, String> parameter);

}
