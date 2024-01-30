package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

        SQL sql = new SQL();

        if("orderList".equals(parameter.get("option"))) {
            sql.SELECT("p.PRODUCT_CODE","p.PRODUCT_NAME","p.ORIGIN_COST","p.RELEASE_DATE","p.DISCOUNT_RATE","p.SALES_QUANTITY","p.STOCK_QUANTITY", "p.CATEGORY_CODE", "p.PRODUCTION_STATUS", "COUNT(p.STOCK_QUANTITY)")
                 .FROM("PRODUCT_INFO p")
                 .JOIN("PRODUCT_CATEGORY c ON (CATEGORY_CODE c = CATEGORY_CODE p)")
             .GROUP_BY("c.CATEGORY_CODE")
             .ORDER_BY("c.CATEGORY_CODE DESC");
        }
        if("allList".equals(parameter.get("option"))) {
            sql.SELECT("p.PRODUCT_CODE","p.PRODUCT_NAME","p.ORIGIN_COST","p.RELEASE_DATE","p.DISCOUNT_RATE","p.SALES_QUANTITY","p.STOCK_QUANTITY", "p.CATEGORY_CODE", "p.PRODUCTION_STATUS")
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

        return toString();
    }

    public String updateCategory(CategoryDTO category) {

        SQL sql = new SQL()
                  .UPDATE("PRODUCT_CATEGORY")
                     .SET("PRODUCT_NAME = #{ productName}");
        return toString();

    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
             .DELETE_FROM("PRODUCT_CATEGORY")
                   .WHERE("CATEGORY_CODE = #{categoryCode}")
                .toString();
    }
}
