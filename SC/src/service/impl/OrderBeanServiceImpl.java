package service.impl;

import bean.CartItem;
import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.CartItemDAO;
import dao.OrderBeanDAO;
import dao.OrderItemDAO;
import service.OderBeanService;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2023-'-18-21:12
 */
public class OrderBeanServiceImpl implements OderBeanService {
    private OrderBeanDAO orderBeanDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(Order orderBean) {
        //订单表添加一条记录
        //订单详情表添加7条记录
        //购物车项表中需要删除对应的记录
        //1/
        orderBeanDAO.addOderBean(orderBean); //执行完这一步id是有值的哟

        //2/
        //orderItemLis为null，我们应该根据购物车项填满orderItemList
        User currUSer = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUSer.getCart().getCartItemMap();
        for(CartItem cartItem:cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }


        //3/
        for(CartItem cartItem:cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }

    }

    @Override
    public List<Order> getOrderBeanList(User user) {
        List<Order> orderList = orderBeanDAO.getOrderList(user);
        for (Order order : orderList){
            Integer totalBookCount = orderBeanDAO.getOrderTotalBookCount(order);
            order.setTotalBookCount(totalBookCount);
        }
        return orderList;
    }
}
