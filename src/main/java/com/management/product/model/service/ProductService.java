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
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> allProductList = productDAO.selectAllProductList();

        sqlSession.close();

        return allProductList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productByConditionList = productDAO.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productByConditionList;

    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.registNewProduct(product);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;

    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int result = productDAO.modifyProductInfo(product);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;

    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        int deleteCode = Integer.parseInt(parameter.get("productCode"));

        int result = productDAO.deleteProduct(deleteCode);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;

    }
}
