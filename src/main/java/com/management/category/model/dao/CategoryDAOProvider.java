package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {


        SQL sql = new SQL()
                .SELECT("I.CATEGORY_CODE"
                        , "C.CATEGORY_NAME"
                        , "COUNT(I.CATEGORY_CODE) AS PRODUCT_COUNT"
                )
                .FROM("PRODUCT_INFO I");
                if("allList".equals(parameter.get("option"))) {
                    sql.JOIN("PRODUCT_CATEGORY C ON (I.CATEGORY_CODE = C.CATEGORY_CODE)")
                            .GROUP_BY("C.CATEGORY_CODE")
                            .HAVING("PRODUCT_COUNT > 0");;
                }
                if("orderList".equals(parameter.get("option"))) {
                    sql.JOIN("PRODUCT_CATEGORY C ON (I.CATEGORY_CODE = C.CATEGORY_CODE)")
//                            .WHERE("C.CATEGORY_CODE")
                            .GROUP_BY("C.CATEGORY_CODE")
                            .HAVING("PRODUCT_COUNT > 0")
                            .ORDER_BY("PRODUCT_COUNT DESC, I.CATEGORY_CODE");
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

        SQL sql = new SQL()
                .UPDATE("PRODUCT_CATEGORY");

        if(category.getCategoryName() != null && !"".equals(category.getCategoryName())) {
            sql.SET("CATEGORY_NAME = #{ categoryName }");
        }

        sql.WHERE("CATEGORY_CODE = #{ categoryCode }");

        return sql.toString();
    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }")
                .toString();
    }
}
