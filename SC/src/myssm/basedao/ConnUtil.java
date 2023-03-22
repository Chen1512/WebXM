package myssm.basedao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2023--10-11:58
 */
public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    private static DataSource dataSource;
    /**
     * @Description:给dataSouce初始化值
     * @return:
     * @author: chen
     * @date: 2023/3/10 16:53
     */
    static{
        Properties properties = new Properties();
        InputStream is = ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description:利用数据库连接池和本地线程变量获取连接
     * @return: java.sql.Connection
     * @author: chen
     * @date: 2023/3/10 16:53
     */
    public static Connection getConn()  {
        Connection conn=threadLocal.get();
        if (conn==null){
            try {
                conn=dataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }
    /**
     * @Description:关闭连接，关闭本地线程变量
     * @return: void
     * @author: chen
     * @date: 2023/3/10 16:54
     */
    public static void closeConn(){
        Connection conn=threadLocal.get();
        if (conn==null){
            return;
        }
        try {
            if (!conn.isClosed()){
                    conn.close();
                threadLocal.set(null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
