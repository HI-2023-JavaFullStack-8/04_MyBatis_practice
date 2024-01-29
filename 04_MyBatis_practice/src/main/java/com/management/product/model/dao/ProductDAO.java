package com.management.product.model.dao;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    List<ProductDTO> selectAllProductList(SqlSession sqlSession);

    List<ProductDTO> selectProductByCondition(SearchCondition searchCondition);

    boolean registNewProduct(ProductDTO product);

    boolean modifyProductInfo(ProductDTO product);

    boolean deleteProduct(Map<String, String> parameter);


    // * 주석을 지우고 Mapper interface(= DAO class) 역할을 하도록 내용을 작성하세요.

}
