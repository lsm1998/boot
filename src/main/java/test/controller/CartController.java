package test.controller;

import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.web.annotation.MyController;
import com.lsm1998.spring.web.annotation.MyJson;
import com.lsm1998.spring.web.annotation.MyRequestMapping;
import com.lsm1998.spring.web.annotation.MyRequestParam;
import com.lsm1998.spring.web.enums.MyRequestMethod;
import test.domain.Cart;
import test.domain.Pets;
import test.domain.User;
import test.service.CartService;
import test.service.PetsService;
import test.util.JsonResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-11:25
 * @说明：
 */
@MyController
@MyRequestMapping("cart")
public class CartController
{
    @MyAutowired
    private CartService cartService;
    @MyAutowired
    private PetsService petsService;

    @MyRequestMapping(value = "save", method = MyRequestMethod.POST)
    @MyJson
    public Object save(HttpServletRequest request, @MyRequestParam("id") Long petsId)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            return JsonResultUtil.of(0, "", "你还没有登录");
        }
        User user = (User) request.getSession().getAttribute("user");
        Pets pets = petsService.getPetsById(petsId);
        Cart temp = cartService.cartValidate(user.getId(), petsId);
        if (temp == null)
        {
            Cart cart = new Cart();
            cart.setUserId(user.getId());
            cart.setNumber(1);
            cart.setSum(pets.getPrice() * cart.getNumber());
            cart.setPetsId(pets.getId());
            cartService.saveCart(cart);
            return JsonResultUtil.of(1, "已经加入了购物车", "");
        } else
        {
            temp.setNumber(temp.getNumber() + 1);
            temp.setSum(temp.getNumber() * pets.getPrice());
            cartService.updateCart(temp.getNumber(), temp.getSum(), temp.getId());
            return JsonResultUtil.of(1, "购物车已经存在了，数量+1", "");
        }
    }

    @MyRequestMapping("get")
    @MyJson
    public Object get(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        return cartService.getAllByUserId(user.getId());
    }

    @MyRequestMapping("update")
    @MyJson
    public Object update(@MyRequestParam("type") String type, @MyRequestParam("id") Long id, HttpServletRequest request)
    {
        Cart cart = cartService.getCartById(id);
        double price = cart.getSum() / cart.getNumber();
        if (type.equals("add"))
        {
            cart.setNumber(cart.getNumber() + 1);
            cart.setSum(cart.getNumber() * price);
            cartService.updateCart(cart.getNumber(), cart.getSum(), id);
        } else
        {
            if (cart.getNumber() == 1)
            {
                cartService.deleteCartById(id);
            } else
            {
                cart.setNumber(cart.getNumber() - 1);
                cart.setSum(cart.getNumber() * price);
                cartService.updateCart(cart.getNumber(), cart.getSum(), id);
            }
        }
        User user = (User) request.getSession().getAttribute("user");
        return cartService.getAllByUserId(user.getId());
    }

    @MyRequestMapping("accounts")
    @MyJson
    public Object accounts(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        List<Cart> cartList = cartService.getAllByUserId(user.getId());
        return null;
    }
}
