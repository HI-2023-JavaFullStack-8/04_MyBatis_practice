package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    private ProductDAO productDAO;


    public List<ProductDTO> selectAllProductList() {
        SqlSession sqlSession = getSqlSession();
        List<ProductDTO> productList = productDAO.selectAllProductList(sqlSession);
        sqlSession.close();
        return productList;
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class); // mapper를 쓰겠다고 선언

        List<ProductDTO> productList = productDAO.selectProductByCondition(searchCondition);


        if (productList != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return productList;
    }

    public boolean registNewProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        boolean result = productDAO.registNewProduct(product);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return result;
    }

    public boolean modifyProductInfo(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        boolean result = productDAO.modifyProductInfo(product);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return result;
    }

    public boolean deleteProduct(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        boolean result = productDAO.deleteProduct(parameter);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return result;
    }
}
