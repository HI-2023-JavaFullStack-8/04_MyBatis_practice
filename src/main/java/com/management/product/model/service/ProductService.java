package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    private ProductDAO mapper;

    public List<ProductDTO> selectAllProductList() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> allProductList = mapper.selectAllProductList();

        sqlSession.close();

        return allProductList;
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> productList = mapper.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productList;
    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ProductDAO.class);
        int result = mapper.insertProduct(product);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ProductDAO.class);
        int result = mapper.updateProduct(product);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ProductDAO.class);
        int result = mapper.deleteProduct(parameter);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }
}
