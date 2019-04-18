package test.mapper;

import com.lsm1998.ibatis.annotation.MyInsert;
import com.lsm1998.ibatis.annotation.MyParam;
import com.lsm1998.ibatis.annotation.MySelect;
import test.domain.Order;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-12:39
 * @说明：
 */
public interface OrderMapper
{
    @MySelect("select * from boot_order where user_id=#{id}")
    List<Order> getOrderByUserId(@MyParam("id") Long userId);

    @MyInsert("insert into boot_order(user_id,pets_id,number,sum) value(#{order.userId},#{order.petsId},#{order.number},#{order.sum})")
    int saveOrder(@MyParam("order") Order order);
}
