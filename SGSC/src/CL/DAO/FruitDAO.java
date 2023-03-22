package CL.DAO;

import CL.Bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--26-21:17
 */
public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList(Connection conn,String keyword,int pageNo);

    //根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Connection conn,Integer fid);

    //修改指定的库存记录
    void updateFruit(Connection conn,Fruit fruit);

    //根据fid删除指定的库存记录
    void delFruit(Connection conn,Integer fid);

    //添加新库存记录

    void addFruit(Connection conn, Fruit fruit);

    int getFruitCount(Connection conn,String keyword );
}
