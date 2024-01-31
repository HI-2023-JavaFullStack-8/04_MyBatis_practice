package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

//        return new SQL() {{
//            if (parameter.get("option").equals("orderList")) {
//                SELECT("c.CATEGORY_CODE, c.CATEGORY_NAME, COUNT(i.PRODUCT_CODE) AS PRODUCT_COUNT");
//                FROM("PRODUCT_CATEGORY c");
//                LEFT_OUTER_JOIN("PRODUCT_INFO i ON c.CATEGORY_CODE = i.CATEGORY_CODE");
//                GROUP_BY("c.CATEGORY_CODE, c.CATEGORY_NAME");
//                HAVING("COUNT(i.PRODUCT_CODE) > 0");
//                ORDER_BY("PRODUCT_COUNT DESC");
//            } else {
//                SELECT("CATEGORY_CODE, CATEGORY_NAME");
//                FROM("PRODUCT_CATEGORY");
//            }
//        }}.toString();


        SQL sql = new SQL();

        if("orderList".equals(parameter.get("option"))) {
            sql.SELECT("c.CATEGORY_CODE, c.CATEGORY_NAME ,COUNT(p.PRODUCT_CODE) AS PRODUCT_COUNT")
                 .FROM("PRODUCT_INFO p")
                 .JOIN("PRODUCT_CATEGORY c ON (CATEGORY_CODE c = CATEGORY_CODE p)")
             .GROUP_BY("c.CATEGORY_CODE")
             .ORDER_BY("c.CATEGORY_CODE DESC");
        }
        if("allList".equals(parameter.get("option"))) {
            sql.SELECT("c.CATEGORY_CODE", "c.CATEGORY_NAME")
                 .FROM("PRODUCT_INFO p")
                 .JOIN("PRODUCT_CATEGORY c ON (CATEGORY_CODE c = CATEGORY_CODE p)")
             .ORDER_BY("c.CATEGORY_CODE");
        }

        return sql.toString();
    }

    public String insertCategory(CategoryDTO category) {

        SQL sql = new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_CODE", "#{categoryCode}")
                .VALUES("CATEGORY_NAME", "#{categoryName}");

        return sql.toString();
    }

    public String updateCategory(CategoryDTO category) {

        SQL sql = new SQL()
                  .UPDATE("PRODUCT_CATEGORY")
                     .SET("CATEGORY_NAME = #{ categoryName}");
        return sql.toString();

    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
             .DELETE_FROM("PRODUCT_CATEGORY")
                   .WHERE("CATEGORY_CODE = #{categoryCode}")
                .toString();
    }
}
