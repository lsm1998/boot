package test.service.impl;

import test.domain.Order;
import test.service.OrderService;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-12:59
 * @说明：
 */
public class OrderServiceImpl implements OrderService
{
    @Override
    public int saveOrder(Order order)
    {
        return 0;
    }

    @Override
    public List<Order> getOrderByUserId(Long userId)
    {
        return null;
    }
}
