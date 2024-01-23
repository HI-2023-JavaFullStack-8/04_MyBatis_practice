package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

    @Results(id="categoryResultMap", value = {
            @Result(id = true, property = "category_code", column = "category_code"),
            @Result(property = "category_name", column = "category_name"),
            @Result(property = "category_count", column = "count(p.product_code)")
    })
    @SelectProvider(type = CategoryDAOProvider.class, method = "selectCategoryList")
    List<CategoryDTO> selectCategoryList(Map<String, String> parameter);


    @InsertProvider(type = CategoryDAOProvider.class, method = "insertCategory")
    int insertCategory(CategoryDTO categoryDTO);

    @UpdateProvider(type = CategoryDAOProvider.class, method = "updateCategory")
    int updateCategory(CategoryDTO categoryDTO);

    @DeleteProvider(type = CategoryDAOProvider.class, method = "deleteCategory")
    int deleteCategory(Map<String, String> parameter);

}
