package test.service;

import test.domain.Cart;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-11:22
 * @说明：
 */
public interface CartService
{
    int saveCart(Cart cart);

    List<Cart> getAllByUserId(Long id);

    int updateCart(Integer number, Double sum, Long id);

    Cart cartValidate(Long userId, Long petsId);

    Cart getCartById(Long id);

    int deleteCartById(Long id);
}
