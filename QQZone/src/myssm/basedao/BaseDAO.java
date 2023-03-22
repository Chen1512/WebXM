package myssm.basedao;


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
 * @create 2023--10-11:57
 */
public abstract class BaseDAO<T>{
    Connection conn=ConnUtil.getConn();
    private QueryRunner queryRunner=new QueryRunner();
    private Class<T> type;
    public BaseDAO(){
        Class clazz=this.getClass();
         ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        this.type= (Class<T>) types[0];
    }
    public int Update(String sql,Object...param){
        int update = 0;
        try {
            update = queryRunner.update(conn, sql, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
    public T GetBean(String sql,Object...param){
        T bean = null;
        try {
            bean = queryRunner.query(conn, sql, new BeanHandler<>(type), param);
            //要利用type用反射造对象
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bean;
    }
    public List<T> GetBeanList(String sql,Object...param){
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<>(type), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  list;
    }
    public Object ComplexQuery(String sql,Object...param){
        Object query = null;
        try {
            query = queryRunner.query(conn, sql, new ScalarHandler<>(), param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }
}
