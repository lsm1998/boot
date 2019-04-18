package test.service;

import test.domain.Order;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-12:57
 * @说明：
 */
public interface OrderService
{
    int saveOrder(Order order);

    List<Order> getOrderByUserId(Long userId);
}
