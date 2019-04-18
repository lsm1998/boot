package test.controller;

import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.web.annotation.MyController;
import com.lsm1998.spring.web.annotation.MyJson;
import com.lsm1998.spring.web.annotation.MyRequestMapping;
import com.lsm1998.spring.web.annotation.MyRequestParam;
import com.lsm1998.spring.web.enums.MyRequestMethod;
import com.lsm1998.spring.web.method.MyModelAndView;
import test.domain.User;
import test.service.UserService;
import test.util.JsonResultUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @作者：刘时明
 * @时间：2019/1/10-22:41
 * @说明：
 */
@MyController
@MyRequestMapping("user")
public class UserController
{
    @MyAutowired
    private UserService userService;

    @MyRequestMapping(value = "login", method = MyRequestMethod.POST)
    @MyJson
    public Object login(@MyRequestParam("name") String userName, @MyRequestParam("pass") String passWord, HttpServletRequest request)
    {
        User user = userService.login(userName, passWord);
        if (user == null)
        {
            return JsonResultUtil.error(0, "登录失败，账号或者密码错误");
        } else
        {
            request.getSession().setAttribute("user", user);
            return JsonResultUtil.susses(1, "登录成功");
        }
    }

    @MyRequestMapping("cart")
    public String cart(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            return  "/405";
        } else
        {
            return  "/cart";
        }
    }

    @MyRequestMapping("session")
    @MyJson
    public Object session(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("user") == null)
        {
            return JsonResultUtil.susses(0, "未登录");
        } else
        {
            User user = (User) request.getSession().getAttribute("user");
            return JsonResultUtil.of(1, "已登录", user);
        }
    }

    @MyRequestMapping(value = "save", method = MyRequestMethod.POST)
    @MyJson
    public Object save(User user)
    {
        User temp = userService.userNameValidate(user.getUserName());
        if (temp != null)
        {
            return JsonResultUtil.of(2, "", "用户名已经存在了");
        }
        userService.saveUser(user);
        return JsonResultUtil.of(1, "保存完成", "");
    }

    @MyRequestMapping(value = "out", method = MyRequestMethod.POST)
    @MyJson
    public Object out(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null)
        {
            request.getSession().setAttribute("user", null);
            return JsonResultUtil.of(1, "成功退出", "");
        }
        return JsonResultUtil.of(0, "未登录", "");
    }
}
