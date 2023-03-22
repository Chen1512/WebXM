package CL.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--26-15:22
 */
public class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    // 定义一个变量来接收泛型的类型
    private Class<T> type;
    // 获取T的Class对象，获取泛型的类型，泛型是在被子类继承时才确定
    public BaseDao() {
// 获取子类的类型
        Class clazz = this.getClass();
// 获取父类的类型
// getGenericSuperclass()用来获取当前类的父类的类型
// ParameterizedType表示的是带泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
// 获取具体的泛型类型 getActualTypeArguments获取具体的泛型的类型
// 这个方法会返回一个Type的数组
        Type[] types = parameterizedType.getActualTypeArguments();
// 获取具体的泛型的类型·
        this.type = (Class<T>) types[0];
    }
    public int Update(Connection conn,String sql, Object...param){
        int update = 0;
        try {
            update = queryRunner.update(conn, sql, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
    public T GetBean(Connection conn,String sql,Object...param){
        T bean = null;
        try {
            bean = queryRunner.query(conn, sql, new BeanHandler<>(type), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
    public List<T> GetBeanList(Connection conn,String sql,Object...param){
        List<T> beanlist = null;
        try {
            beanlist = queryRunner.query(conn, sql, new BeanListHandler<>(type), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return beanlist;
    }
    public Object ComplexQuery(Connection conn,String sql,Object...param) {

        Object query = null;
        try {
            query = queryRunner.query(conn, sql, new ScalarHandler(), param);
            long li=(long)query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }
}
