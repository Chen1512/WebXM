package CL.Tools;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2023--26-14:38
 */
public class JDBC {
    private static DataSource dataSource;
    static {
        Properties properties=new Properties();
        //运用类的加载器加载出内容放入输入流中
        InputStream inputStream=JDBC.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //加载配置文件
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        return conn;
    }

    public static void releaseConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new RuntimeException(throwables);
            }
        }
    }
}
