package controller;

import bean.Order;
import bean.User;
import service.OderBeanService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2023--18-21:36
 */
public class OrderController {
    private OderBeanService oderBeanService;
    //结账
    public String checkout(HttpSession session){
        Order orderBean = new Order();
        Date now=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String nowStr = sdf.format(now);
        nowStr.split("-");
        orderBean.setOrderNo(UUID.randomUUID().toString()+nowStr);
        orderBean.setOrderDate(LocalDateTime.now());
        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        oderBeanService.addOrderBean(orderBean);
        return "index";
    }

    //查看订单列表
    public String getOrderList(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        List<Order> orderList = oderBeanService.getOrderBeanList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);
        return "order/order";

    }
}
