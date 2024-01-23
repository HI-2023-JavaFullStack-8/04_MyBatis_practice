package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlsession;

public class ProductService {
    private ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {
        SqlSession sqlSession = getSqlsession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectAllProductList();

        sqlSession.close();

        return productList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlsession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = productDAO.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productList;
    }

    public boolean registNewProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlsession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        boolean result = productDAO.insertProduct(product);

        if(result){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }

    public boolean modifyProductInfo(ProductDTO product) {
        SqlSession sqlSession = getSqlsession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        boolean result = productDAO.updateProduct(product);

        if(result){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }

    public boolean deleteProduct(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlsession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        boolean result = productDAO.deleteProduct(parameter);

        if(result){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }
}
