package dao.impl;

import bean.CartItem;
import bean.User;

import dao.CartItemDAO;
import myssm.basedao.BaseDAO;
;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--18-15:24
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        int i = super.executeUpdate("INSERT INTO t_cart_item VALUES(0,?,?,?)", cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        int i = super.executeUpdate("UPDATE t_cart_item SET buyCount=? WHERE id=?", cartItem.getBuyCount(), cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> itemList = super.executeQuery("select* from t_cart_item where userBean=?", user.getId());
        return itemList;
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("DELETE FROM t_cart_item WHERE id=?",cartItem.getId());
    }
}
