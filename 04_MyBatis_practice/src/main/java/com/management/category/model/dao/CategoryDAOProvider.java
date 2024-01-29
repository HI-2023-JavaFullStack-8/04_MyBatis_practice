package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {
        String option = parameter.get("option");
        SQL sql = new SQL();

        if (option.equals("allList")) {
            sql
                    .SELECT("*")
                    .FROM("PRODUCT_CATEGORY");
        }
        if (option.equals("orderList")){
            sql
                    .SELECT("c.CATEGORY_CODE, c.CATEGORY_NAME")
                    .FROM("PRODUCT_CATEGORY c")
                    .RIGHT_OUTER_JOIN("PRODUCT_INFO i ON (i.CATEGORY_CODE = c.CATEGORY_CODE)")
                    .GROUP_BY("c.CATEGORY_CODE")
                    .ORDER_BY("COUNT(c.CATEGORY_CODE) DESC");
        }
        return sql.toString();
    }

    public String insertCategory(CategoryDTO category) {
        return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{ categoryName }")
                .toString();
    }

    public String updateCategory(CategoryDTO category) {
        SQL sql = new SQL().UPDATE("PRODUCT_CATEGORY");

        if(category.getCategoryCode() > 0) {
            sql.SET("CATEGORY_CODE = #{ categoryCode");
        }

        if(category.getCategoryName() != null) {
            sql.SET("CATEGORY_NAME = #{ categoryName");
        }
        return sql.toString();
    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }")
                .toString();
    }
}
