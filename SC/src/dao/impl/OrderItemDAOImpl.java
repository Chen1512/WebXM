package dao.impl;

import bean.OrderItem;

import dao.OrderItemDAO;
import myssm.basedao.BaseDAO;


/**
 * @author shkstart
 * @create 2023--18-20:56
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("INSERT INTO t_order_item VALUES(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
    }
}
