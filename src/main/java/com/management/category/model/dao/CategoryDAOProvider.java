package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

        SQL sql = new SQL();

        if("orderList".equals(parameter.get("option"))) {
            sql.SELECT("p.PRODUCT_CODE","p.PRODUCT_NAME","p.ORIGIN_COST","p.RELEASE_DATE","p.DISCOUNT_RATE","p.SALES_QUANTITY","p.STOCK_QUANTITY", "p.CATEGORY_CODE", "p.PRODUCTION_STATUS", "COUNT(p.STOCK_QUANTITY)")
                 .FROM("PRODUCT_INFO p")
                 .JOIN("PRODUCT_CATEGORY c ON (CATEGORY_CODE c = CATEGORY_CODE p)")
             .GROUP_BY("c.CATEGORY_CODE")
             .ORDER_BY("c.CATEGORY_CODE");
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

        // 2. Provider를 활용하여 제품분류를 등록하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return null;

    }

    public String updateCategory(CategoryDTO category) {

        // 3. Provider를 활용하여 제품분류명을 수정하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return null;

    }

    public String deleteCategory(Map<String, String> parameter) {

        // 4. Provider를 활용하여 제품분류를 삭제하는 코드를 작성하세요.
        //    아래 작성된 return null은 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        return null;

    }
}
