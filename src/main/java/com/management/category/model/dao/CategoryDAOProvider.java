package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {


    public String selectCategoryList(Map<String, String> parameter) {
        return new SQL() {{
            if (parameter.get("option").equals("orderList")) {
                SELECT("c.CATEGORY_CODE, c.CATEGORY_NAME, COUNT(i.PRODUCT_CODE) AS PRODUCT_COUNT");
                FROM("PRODUCT_CATEGORY c");
                LEFT_OUTER_JOIN("PRODUCT_INFO i ON c.CATEGORY_CODE = i.CATEGORY_CODE");
                GROUP_BY("c.CATEGORY_CODE, c.CATEGORY_NAME");
                HAVING("COUNT(i.PRODUCT_CODE) > 0");
                ORDER_BY("PRODUCT_COUNT DESC");
            } else {
                SELECT("CATEGORY_CODE, CATEGORY_NAME");
                FROM("PRODUCT_CATEGORY");
            }
        }}.toString();
    }

    public String insertCategory(CategoryDTO category) {

            return new SQL() {{
                INSERT_INTO("PRODUCT_CATEGORY");
                VALUES("CATEGORY_NAME", "#{categoryName}");
            }}.toString();
        }

    public String updateCategory(CategoryDTO category) {

        return new SQL() {{
            UPDATE("PRODUCT_CATEGORY");
            SET("CATEGORY_NAME = #{categoryName}");
            WHERE("CATEGORY_CODE = #{categoryCode}");
        }}.toString();

    }

    public String deleteCategory(Map<String, String> parameter) {

        return new SQL() {{
            DELETE_FROM("PRODUCT_CATEGORY");
            WHERE("CATEGORY_CODE = #{categoryCode}");
        }}.toString();

    }
}
