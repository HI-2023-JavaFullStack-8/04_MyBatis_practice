package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CategoryService {

    private CategoryDAO categoryDAO;

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        // 2. 제품분류 목록을 조회하는 로직을 작성하세요.
        SqlSession sqlSession = getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);
        List<CategoryDTO> categoryList = categoryDAO.selectCategoryList(parameter);

        sqlSession.close();

        return categoryList;
    }

    public boolean registNewCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();

        categoryDAO = sqlSession.getMapper(CategoryDAO.class);
        int result = categoryDAO.registNewProduct(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result > 0? true : false;
    }

    public boolean modifyCategoryName(CategoryDTO category) {

        // 4. 제품분류명을 수정하는 로직을 작성하세요.
        // 　　아래 작성된 return false 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return false;

    }

    public boolean deleteCategory(Map<String, String> parameter) {

        // 5. 제품분류 정보를 삭제하는 로직을 작성하세요.
        // 　　아래 작성된 return false 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return false;

    }
}
