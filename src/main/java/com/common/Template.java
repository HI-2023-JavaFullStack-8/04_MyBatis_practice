package com.common;

import com.management.category.model.dao.CategoryDAO;
import com.management.product.model.dao.ProductDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            String resource = "config/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory.getConfiguration().addMapper(ProductDAO.class);
            sqlSessionFactory.getConfiguration().addMapper(CategoryDAO.class);
        }
        return sqlSessionFactory.openSession(false);
    }
}
