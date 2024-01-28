package com.common;

import com.management.category.model.dao.CategoryDAO;
import com.management.product.model.dao.ProductDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class Template {

private static SqlSessionFactory sqlSessionFactory;
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/productcompany";
    private static String USER = "ohgiraffers";
    private static String PASSWODR = "ohgiraffers";

    public static SqlSession getSqlSession() {

        if (sqlSessionFactory == null) {
            Environment environment = new Environment("dev"
                    , new JdbcTransactionFactory()
                    , new PooledDataSource(DRIVER, URL, USER, PASSWODR));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(ProductDAO.class);
            configuration.addMapper(CategoryDAO.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        }
        return sqlSessionFactory.openSession(false);
    }

}
