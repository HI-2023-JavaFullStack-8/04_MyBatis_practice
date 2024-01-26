package com.management.category.model.dao;

import com.common.SearchCondition;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {
    public String selectCategoryList(Map<String, String> parameter) {


        SQL sql = new SQL();
        if("orderList".equals(parameter.get("option")))
        {
                sql.SELECT("p.category_code", "c.category_name")
                    .SELECT("count(p.product_code)")
                    .FROM("product_info p")
                    .JOIN("product_category c ON p.category_code = c.category_code")
                    .GROUP_BY("c.category_code")
                    .ORDER_BY("count(p.product_code) desc");
        }
        if("allList".equals(parameter.get("option"))){

                sql.SELECT("c.category_code", "c.category_name")
                    .SELECT("count(p.product_code)")
                    .FROM("product_category c")
                    .LEFT_OUTER_JOIN("product_info p ON p.category_code = c.category_code")
                    .GROUP_BY("c.category_code");
        }
         return sql.toString();
    }

    public String insertCategory(CategoryDTO category) {

         return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{ category_name }")
                .toString();
    }

    public String updateCategory(CategoryDTO category) {

        SQL sql =  new SQL()
                .UPDATE("PRODUCT_CATEGORY");
                if(category.getCategory_name() != null && !"".equals(category.getCategory_name()))
                {
                    sql.SET("CATEGORY_NAME = #{ category_name }");
                }

                sql.WHERE("CATEGORY_CODE = #{ category_code }");

        return sql.toString();

    }

    public String deleteCategory(Map<String, String> parameter) {

         return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{ categoryCode }")
                .toString();
    }
}
