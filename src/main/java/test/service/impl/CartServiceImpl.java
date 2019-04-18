package test.service.impl;

import com.lsm1998.ibatis.session.MySqlSession;
import com.lsm1998.ibatis.session.MySqlSessionFactory;
import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.beans.annotation.MyService;
import test.domain.Cart;
import test.domain.Pets;
import test.mapper.CartMapper;
import test.mapper.PetsMapper;
import test.service.CartService;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/14-11:23
 * @说明：
 */
@MyService
public class CartServiceImpl implements CartService
{
    @MyAutowired
    private MySqlSessionFactory sessionFactory;

    @Override
    public int saveCart(Cart cart)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        int result = cartMapper.saveCart(cart);
        sqlSession.close();
        return result;
    }

    @Override
    public List<Cart> getAllByUserId(Long id)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        List<Cart> result = cartMapper.getAllByUserId(id);
        sqlSession.close();
        return result;
    }

    @Override
    public int updateCart(Integer number, Double sum, Long id)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        int result = cartMapper.updateCart(number, sum, id);
        sqlSession.close();
        return result;
    }

    @Override
    public Cart cartValidate(Long userId, Long petsId)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        Cart result = cartMapper.cartValidate(userId,petsId);
        sqlSession.close();
        return result;
    }

    @Override
    public Cart getCartById(Long id)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        Cart result = cartMapper.getCartById(id);
        sqlSession.close();
        return result;
    }

    @Override
    public int deleteCartById(Long id)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        int result = cartMapper.deleteCartById(id);
        sqlSession.close();
        return result;
    }
}
