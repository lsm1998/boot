package test.service.impl;

import com.lsm1998.ibatis.session.MySqlSession;
import com.lsm1998.ibatis.session.MySqlSessionFactory;
import com.lsm1998.spring.aop.annotation.MyAspect;
import com.lsm1998.spring.aop.annotation.MyBefore;
import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.beans.annotation.MyService;
import test.domain.User;
import test.mapper.UserMapper;
import test.service.UserService;

/**
 * @作者：刘时明
 * @时间：2019/1/10-22:36
 * @说明：
 */
@MyService
@MyAspect
public class UserServiceImpl implements UserService
{
    @MyAutowired
    private MySqlSessionFactory sessionFactory;

    @Override
    @MyBefore(value = "args(执行登陆，用户名=#{0})")
    public User login(String userName, String passWord)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login(userName, passWord);
        sqlSession.close();
        return user;
    }

    @Override
    public User userNameValidate(String userName)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.userNameValidate(userName);
        sqlSession.close();
        return user;
    }

    @Override
    public int saveUser(User user)
    {
        MySqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.saveUser(user);
        sqlSession.close();
        return result;
    }
}
