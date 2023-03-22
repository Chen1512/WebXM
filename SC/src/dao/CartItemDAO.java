package dao;

import bean.CartItem;
import bean.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-15:23
 */
public interface CartItemDAO {
    //添加购物车项
    void addCartItem(CartItem cartItem);
    //修改购物车项
    void updateCartItem(CartItem cartItem);
    //获取特定用户的所有购物车项
    List<CartItem> getCartItemList(User user);
    //删除指定的购物车项
    void delCartItem(CartItem cartItem);
}
