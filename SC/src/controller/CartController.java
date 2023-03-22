package controller;

import bean.Book;
import bean.Cart;
import bean.CartItem;
import bean.User;
import com.google.gson.Gson;
import service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author shkstart
 * @create 2023--18-15:20
 */
public class CartController {
    private CartItemService cartItemService;
    //加载当前用户的购物车信息
    public String index(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";
    }
    public String addCart(Integer bookId, HttpSession session){
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());
        return "redirect:cart.do";
    }
    public String editCart(Integer cartItemId,Integer buyCount){
        cartItemService.upadteCartItem(new CartItem(cartItemId,buyCount));
        return "json:";
    }
    public String cartInfo(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        cart.getTotalCount();
        cart.getTotalMoney();
        Gson gson=new Gson();
        String cartJsonStr = gson.toJson(cart);
        return "json:"+cartJsonStr;
    }
}
