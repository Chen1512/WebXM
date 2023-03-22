package service;

import bean.Order;
import bean.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-20:41
 */
public interface OderBeanService {
    void addOrderBean(Order orderBean);
    List<Order> getOrderBeanList(User user);
}
