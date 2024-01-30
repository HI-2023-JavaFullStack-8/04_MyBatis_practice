package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {
    @Results(id="ResultMap", value = {
            @Result(id = true, property = "CATEGORY_CODE", column = "categoryCode"),
            @Result(property = "CATEGORY_NAME", column = "categoryName")
    })
    @SelectProvider(type = CategoryDAOProvider.class, method = "selectCategoryList")
    List<CategoryDTO> selectCategoryList(Map<String, String> parameter);

    @ResultMap("ResultMap")
    @InsertProvider(type = CategoryDAOProvider.class, method = "registNewProduct")
    int registNewProduct(CategoryDTO category);

    @ResultMap("ResultMap")
    @UpdateProvider(type = CategoryDAOProvider.class, method = "modifyCategoryName")
    int modifyCategoryName(CategoryDTO category);

    @ResultMap("ResultMap")
    @DeleteProvider(type = CategoryDAOProvider.class, method = "deleteCategory")
    int deleteCategory(@Param("categoryCode") Map<String, String> parameter);
}
