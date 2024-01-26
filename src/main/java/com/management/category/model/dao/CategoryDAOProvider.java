package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

        SQL sql = new SQL()
                .SELECT("c.category_code");
        if(parameter.get("option") == "allList") {
            sql.SELECT("c.category_name");
        }
        if(parameter.get("option") == "orderList") {
            sql.SELECT("c.category_name, COUNT(*) AS 'count'");
        }
        sql.FROM("product_category c");
        if(parameter.get("option") == "orderList") {
            sql.JOIN("product_info i ON c.category_code = i.category_code")
                    .GROUP_BY("i.category_code")
                    .ORDER_BY("count");
        }

        return sql.toString();

    }

    public String insertCategory(CategoryDTO category) {

        return new SQL()
                .INSERT_INTO("product_category")
                .VALUES("category_name", "#{categoryName}")
                .toString();

    }

    public String updateCategory(CategoryDTO category) {

        SQL sql = new SQL()
                .UPDATE("product_category")
                .SET("category_name = #{categoryName}")
                .WHERE("category_code = #{categoryCode}");

        return sql.toString();

    }

    public String deleteCategory(Map<String, String> parameter) {

        return new SQL()
                .DELETE_FROM("product_category")
                .WHERE("category_code = #{categoryCode}")
                .toString();

    }
}
