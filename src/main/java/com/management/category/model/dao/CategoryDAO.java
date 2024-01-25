package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

    // * 주석을 지우고 Mapper interface(= DAO class) 역할을 하도록 내용을 작성하세요.
    // (조건 1) java 어노테이션을 활용하여 CategoryDTO 객체와 PRODUCT_CATEGORY 테이블을 매핑시키는 ResultMap을 작성하세요.
    // (조건 2) java provider어노테이션을 활용하여 작성하세요.
    @Results(id = "categoryMap", value = {
            @Result(id = true, property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "categoryName", column = "CATEGORY_NAME")

    })

    @SelectProvider(type= CategoryDAOProvider.class, method = "selectCategoryList")
    List<CategoryDTO> selectCategoryList(Map<String, String> parameter);

    public String insertCategory(CategoryDTO category) ;

    public String updateCategory(CategoryDTO category);

    public String deleteCategory(Map<String, String> parameter);

}
