package test.service;

import com.lsm1998.ibatis.annotation.MyParam;
import test.domain.User;

/**
 * @作者：刘时明
 * @时间：2019/1/10-22:35
 * @说明：
 */
public interface UserService
{
    User login(String userName, String passWord);

    User userNameValidate(@MyParam("name") String userName);

    int saveUser(User user);
}
