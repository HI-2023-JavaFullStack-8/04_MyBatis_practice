package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CategoryService {

    private CategoryDAO mapper;


    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryList = mapper.selectCategoryList(parameter);
        sqlSession.close();
        return categoryList;

    }

    public boolean registNewCategory(CategoryDTO category) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);
        boolean result = mapper.insertCategory(category);
        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;

    }

    public boolean modifyCategoryName(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);
        boolean result = mapper.updateCategory(category);
        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;

    }

    public boolean deleteCategory(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);
        boolean result = mapper.deleteCategory(parameter);
        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }
}
