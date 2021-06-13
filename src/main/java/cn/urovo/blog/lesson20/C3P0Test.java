package cn.urovo.blog.lesson20;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewProxyConnection;

import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-01-31 12:03
 **/
public class C3P0Test {

    public static void main(String[] args) throws PropertyVetoException, SQLException, NoSuchFieldException, IllegalAccessException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setMaxPoolSize(1);
        dataSource.setInitialPoolSize(1);
        dataSource.setJdbcUrl("jdbc:mysql://192.168.19.120:3306/testdb?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false");
        Connection connection = dataSource.getConnection();
        Object inner1 = getInner(connection);
        System.out.println(inner1);
//        connection.close();
        Connection connection2 = dataSource.getConnection();
        Object inner2 = getInner(connection2);
        System.out.println(inner2);

    }

    private static Object getInner(Connection connection) throws NoSuchFieldException, IllegalAccessException {
        Field field = connection.getClass().getDeclaredField("inner");
        field.setAccessible(true);
        return field.get(connection);
    }

}
