package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;

public class CategoryDAOProvider {

    // * 주석을 지우고 Provider 활용하여 내용을 작성하세요.

    public String selectCategoryList(Map<String, String> parameter) {


        String option = parameter.get("option");
        SQL sql = new SQL();

        if ("allList".equals(option)) {
            sql
                    .SELECT("CATEGORY_CODE", "CATEGORY_NAME")
                    .FROM("PRODUCT_CATEGORY");

        } else {
            sql
                    .SELECT("COUNT(B.CATEGORY_CODE) AS CATEGORY_CODE", "A.CATEGORY_NAME")
                    .FROM("PRODUCT_CATEGORY A")
                    .RIGHT_OUTER_JOIN("PRODUCT_INFO B ON (A.CATEGORY_CODE = B.CATEGORY_CODE)")
                    .GROUP_BY("B.CATEGORY_CODE")
                    .ORDER_BY("CATEGORY_CODE DESC");

        }

        return sql.toString();
    }

        public String insertCategory (CategoryDTO category){


            return new SQL ()
                    .INSERT_INTO("PRODUCT_CATEGORY")
                    .VALUES("CATEGORY_CODE", "#{categoryCode}")
                    .VALUES("CATEGORY_NAME", "#{categoryName}")
                    .toString();

        }

        public String updateCategory (CategoryDTO category){


            SQL sql = new SQL()
                    .UPDATE("PRODUCT_CATEGORY");

            if (category.getCategoryName() != null && !"".equals(category.getCategoryName())) {
                sql.SET("CATEGORY_NAME = #{ categoryName }");
            }
            sql.WHERE("CATEGORY_CODE = #{categoryCode}");

            return sql.toString();
        }

        public String deleteCategory (Map < String, String > parameter){


            return new SQL()
                    .DELETE_FROM("PRODUCT_CATEGORY")
                    .WHERE("CATEGORY_CODE = #{categoryCode}")
                    .toString();
    }
}

