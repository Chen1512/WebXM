package service;

import bean.Cart;
import bean.CartItem;
import bean.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-15:49
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void upadteCartItem(CartItem cartItem);
    void  addOrUpdateCartItem(CartItem cartItem, Cart cart);
    //获取指定用户购物车项的列表，会把book完整设置进cartItem
    List<CartItem> getCartItemList(User user);
    //加载特定用户的购物车信息
    Cart getCart(User user);
}
