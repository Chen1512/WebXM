package CL.DAO;

import CL.Bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--26-21:17
 */
public class FruitDAOImpl extends BaseDao<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList(Connection conn,String keyword,int pageNo) {
        return super.GetBeanList(conn,"select * from fruit where fname like ? or remark like ? limit ? , 5" ,"%"+keyword+"%","%"+keyword+"%", (pageNo-1)*5);
    }

    @Override
    public Fruit getFruitByFid(Connection conn,Integer fid) {
        return super.GetBean(conn,"select * from fruit where fid = ? " , fid);
    }

    @Override
    public void updateFruit(Connection conn,Fruit fruit) {
        String sql = "update fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ? " ;
        super.Update(conn,sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
    }

    @Override
    public void delFruit(Connection conn,Integer fid) {
        super.Update(conn,"delete from fruit where fid = ? " , fid) ;
    }

    @Override
    public void addFruit(Connection conn, Fruit fruit) {
        String sql = "insert into fruit values(0,?,?,?,?)";
        super.Update(conn,sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    @Override
    public int getFruitCount(Connection conn,String keyword) {
        return ((Long)super.ComplexQuery(conn,"select count(*) from fruit where fname like ? or remark like ?" , "%"+keyword+"%","%"+keyword+"%")).intValue();
    }
}
