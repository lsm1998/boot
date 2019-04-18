package test.mapper;

import com.lsm1998.ibatis.annotation.MyInsert;
import com.lsm1998.ibatis.annotation.MyParam;
import com.lsm1998.ibatis.annotation.MySelect;
import test.domain.User;

/**
 * @作者：刘时明
 * @时间：2019/1/10-23:53
 * @说明：
 */
public interface UserMapper
{
    @MySelect("select * from boot_user where userName=#{name} and passWord=#{pass}")
    User login(@MyParam("name") String userName, @MyParam("pass") String passWord);

    @MySelect("select * from boot_user where userName=#{name}")
    User userNameValidate(@MyParam("name") String userName);

    @MyInsert("insert into boot_user(userName,passWord,nickName) values(#{user.userName},#{user.passWord},#{user.nickName})")
    int saveUser(@MyParam("user") User user);
}
