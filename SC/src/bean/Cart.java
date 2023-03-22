package bean;

import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2023--18-15:53
 */
public class Cart {
    private Map<Integer,CartItem> cartItemMap;//购物车中购物车项的集合，key是book的id
    private Double totalMoney;//购物车的总金额
    private Integer totalCount;//购物车中购物项的数量

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney=0.0;
        if (cartItemMap!=null&&cartItemMap.size()>0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry:entries){
                CartItem cartItem = cartItemEntry.getValue();
                totalMoney=totalMoney+cartItem.getXj();
            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount=0;
        if (cartItemMap!=null&&cartItemMap.size()>0){
            totalCount=cartItemMap.size();
        }
        return totalCount;
    }
}
