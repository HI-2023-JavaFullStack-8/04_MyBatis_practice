package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CategoryService {

    // * 주석을 지우고 Service 역할에 해당하는 메소드를 작성하세요.
    CategoryDAO categoryDAO;
    // 1. 자주 사용할 DAO 객체를 선언하세요.

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryList = categoryDAO.selectCategoryList(parameter);

        if (categoryList != null) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return categoryList;
    }

    public boolean registNewCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        boolean result = categoryDAO.insertCategory(category);

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
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        boolean result = categoryDAO.updateCategory(category);

        if (result) {
//            System.out.println(" 제품명 변경에 성공하였습니다.");
            sqlSession.commit();
        } else {
//            System.out.println("제품명 변경에 실패하였습니다.");
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public boolean deleteCategory(Map<String, String> parameter) {
        SqlSession sqlSession = getSqlSession();
        categoryDAO = sqlSession.getMapper(CategoryDAO.class);

        boolean result = categoryDAO.deleteCategory(parameter);

        if (result) {
//            System.out.println("제품 삭제에 성공하였습니다");
            sqlSession.commit();
        } else {
//            System.out.println("제품 삭제에 실패하였습니다");
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
