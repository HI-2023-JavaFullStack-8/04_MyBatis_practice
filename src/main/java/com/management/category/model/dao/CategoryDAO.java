package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

    // * 주석을 지우고 Mapper interface(= DAO class) 역할을 하도록 내용을 작성하세요.
    // (조건 1) java 어노테이션을 활용하여 CategoryDTO 객체와 PRODUCT_CATEGORY 테이블을 매핑시키는 ResultMap을 작성하세요.
    // (조건 2) java provider어노테이션을 활용하여 작성하세요.
    @Results(id = "categoryResultMap", value = {
            @Result(id = true, property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "categoryName", column = "CATEGORY_NAME"),

    })
    @SelectProvider(type = CategoryDAOProvider.class, method = "selectAllCategory")
    List<CategoryDTO> selectAllCategory();

    @InsertProvider(type = CategoryDAOProvider.class, method = "registCategory")
    int registCategory(CategoryDTO category);

    @UpdateProvider(type = CategoryDAOProvider.class, method = "updateCategory")
    int modifyCategory(CategoryDTO modifyCategory);

    @DeleteProvider (type = CategoryDAOProvider.class, method = "deleteCategory")
    int deleteCategory(int categoryCode);



}
