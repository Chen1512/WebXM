package CL.service;

import CL.Bean.Fruit;
import CL.DAO.FruitDAO;
import CL.DAO.FruitDAOImpl;
import CL.Tools.JDBC;
import com.alibaba.druid.util.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--05-15:56
 */
public class FruitServiceImpl implements FruitService{
    private FruitDAO fruitDAO = null;
    Connection conn=JDBC.getConnection();
    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        List<Fruit> fruitList = fruitDAO.getFruitList(conn, keyword, pageNo);
        return fruitList;
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(conn,fruit);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        Fruit fruitByFid = fruitDAO.getFruitByFid(conn, fid);
        return fruitByFid;
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(conn,fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int count = fruitDAO.getFruitCount(conn, keyword);
        int pageCount = (count+5-1)/5 ;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(conn,fruit);
    }
}
