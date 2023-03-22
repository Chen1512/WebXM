package service.impl;

import bean.Book;
import bean.Cart;
import bean.CartItem;
import bean.User;
import dao.CartItemDAO;
import service.BookService;
import service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2023--18-15:51
 */
 public class CartItemServiceImpl implements CartItemService {
    private CartItemDAO cartItemDAO;
    private BookService bookService;
    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void upadteCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        //判断当前用户的购物车中是否有这本书的cartitem
        //将指定图书添加到购物车中
        //已经存在数量加以，否则购物车新增一个cartItem，数量为1
        if (cart!=null){
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap==null){
                cartItemMap=new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
                upadteCartItem(cartItemTemp);
            }else {
                addCartItem(cartItem);
            }
        }else{
            addCartItem(cartItem);
        }

    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for (CartItem cartItem:cartItemList){
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
            cartItem.getXj();
        }
        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemList(user);

        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem:cartItemList){
            cartItemMap.put(cartItem.getBook().getId(),cartItem);
        }
        Cart cart = new Cart(cartItemMap);
        return cart;
    }
}
