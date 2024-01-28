package com.management.category.model.dao;

import com.common.SearchCondition;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

        SQL sql = new SQL()
                .SELECT("C.CATEGORY_CODE");
        if(parameter.get("option") == "allList") {
            sql.SELECT("C.CATEGORY_NAME");
        }
        if(parameter.get("option") == "orderList") {
            sql.SELECT("C.CATEGORY_NAME, COUNT(*) AS CATEGORY_COUNT");
        }
        sql.FROM("PRODUCT_CATEGORY C");
        if(parameter.get("option") == "orderList") {
            sql.JOIN("PRODUCT_INFO I ON C.CATEGORY_CODE = I.CATEGORY_CODE")
                    .GROUP_BY("I.CATEGORY_CODE")
                    .ORDER_BY("CATEGORY_COUNT");
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

        return new SQL()
                .UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_CODE = #{ categoryCode }"
                        ,"CATEGORY_NAME = #{ categoryName }")
                .WHERE("CATEGORY_CODE = #{ categoryCode }")
                .toString();
    }

    public String deleteCategory(Map<String, String> parameter) {

        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }")
                .toString();
    }
}
