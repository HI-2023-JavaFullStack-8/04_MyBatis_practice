package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {
        SQL sql = new SQL()
                .SELECT("c.category_code")
                .SELECT("c.category_name")
                .FROM("product_category c");
        if ("orderList".equals(parameter.get("option"))){
            sql.RIGHT_OUTER_JOIN("product_info i ON (c.category_code = i.category_code)")
                    .GROUP_BY("c.category_code")
                    .ORDER_BY("COUNT(c.category_code) DESC");
        }
        return sql.toString();
    }

    public String insertCategory(CategoryDTO category) {
        SQL sql = new SQL()
                .INSERT_INTO("product_category")
                .VALUES("category_name", "#{ categoryName }");

        return sql.toString();
    }

    public String updateCategory(CategoryDTO category) {

        SQL sql = new SQL()
                .UPDATE("product_category")
                .SET("category_name = #{ categoryName }")
                .WHERE("category_code = #{ categoryCode }");

        return sql.toString();
    }

    public String deleteCategory(Map<String, String> parameter) {

        SQL sql = new SQL()
                .DELETE_FROM("product_category")
                .WHERE("category_code = #{ categoryCode }");

        return sql.toString();
    }
}
