package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dao.CategoryDAOProvider;
import com.management.category.model.dto.CategoryDTO;
import jdk.jfr.Category;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> catelist = categoryDAO.selectCategoryList(parameter);
        sqlSession.close();

        return catelist;

    }

    public boolean registNewCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.insertCategory(category);

        if( result > 0){
            sqlSession.commit();
        }
        else{
            sqlSession.rollback();
        }
        sqlSession.close();

        System.out.println("Service : 카테고리 등록 성공 여부 : " + result);
        return result > 0 ? true : false;

    }

    public boolean modifyCategoryName(CategoryDTO category) {

         SqlSession sqlSession = getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);
        int result = categoryDAO.updateCategory(category);

        if(result > 0){
            sqlSession.commit();
        }
        else {
            sqlSession.rollback();
        }

        sqlSession.close();

         return result > 0 ? true : false;
    }

    public boolean deleteCategory(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        int result = categoryDAO.deleteCategory(parameter);

        if(result > 0){
            sqlSession.commit();
        }
        else {
            sqlSession.rollback();
        }

        sqlSession.close();

         return result > 0 ? true : false ;

    }
}
