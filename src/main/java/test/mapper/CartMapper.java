package test.mapper;

import com.lsm1998.ibatis.annotation.*;
import test.domain.Cart;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-11:11
 * @说明：
 */
public interface CartMapper
{
    @MyInsert("insert into boot_cart(user_id,pets_id,number,sum) values(#{cart.userId},#{cart.petsId},#{cart.number},#{cart.sum})")
    int saveCart(@MyParam("cart") Cart cart);

    @MySelect("select * from boot_cart where user_id=#{id}")
    List<Cart> getAllByUserId(@MyParam("id") Long id);

    @MyUpdate("update boot_cart set number=#{number},sum=#{sum} where id=#{id}")
    int updateCart(@MyParam("number") Integer number, @MyParam("sum") Double sum, @MyParam("id") Long id);

    @MySelect("select * from boot_cart where user_id=#{userId} and pets_id=#{petsId}")
    Cart cartValidate(@MyParam("userId") Long userId, @MyParam("petsId") Long petsId);

    @MySelect("select * from boot_cart where id=#{id}")
    Cart getCartById(@MyParam("id") Long id);

    @MyDelete("delete from boot_cart where id=#{id}")
    int deleteCartById(@MyParam("id") Long id);
}
