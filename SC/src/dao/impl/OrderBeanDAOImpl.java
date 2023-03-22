package dao.impl;

import bean.Order;
import bean.User;
import myssm.basedao.BaseDAO;
import dao.OrderBeanDAO;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-20:47
 */
public class OrderBeanDAOImpl extends BaseDAO<Order> implements OrderBeanDAO {
    @Override
    public void addOderBean(Order order) {
        int orderBeanId = super.executeUpdate("INSERT INTO t_order VALUES(0,?,?,?,?,?)", order.getOrderNo(), order.getOrderDate(), order.getOrderUser().getId(), order.getOrderMoney(), order.getOrderStatus());
        order.setId(orderBeanId);
    }

    @Override
    public List<Order> getOrderList(User user) {
        List<Order> orderList = super.executeQuery("SELECT * FROM t_order WHERE orderUser=?", user.getId());


        return orderList;
    }

    @Override
    public Integer getOrderTotalBookCount(Order orderBean) {
        String sql="SELECT SUM(c.buyCount) AS totalBookCount\n" +
                "FROM (SELECT a.`id`,b.`buyCount`,b.`orderBean` FROM t_order AS a,t_order_item AS b \n" +
                "WHERE a.`id`=b.`orderBean` AND a.`orderUser`=?) AS c\n" +
                "GROUP BY c.orderBean\n" +
                "HAVING c.orderBean=?";
        Object[] objects = super.executeComplexQuery(sql, orderBean.getOrderUser().getId(),orderBean.getId());
        return ((BigDecimal)(objects[0])).intValue();
    }
}
