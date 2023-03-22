package dao;

import bean.Order;
import bean.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-20:41
 */
public interface OrderBeanDAO {
    //添加订单
    void addOderBean(Order order);
    //获取指定用户列表
    List<Order> getOrderList(User user);

    Integer getOrderTotalBookCount(Order orderBean);
}
