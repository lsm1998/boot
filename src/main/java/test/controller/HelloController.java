package test.controller;

import com.lsm1998.spring.web.annotation.MyController;
import com.lsm1998.spring.web.annotation.MyJson;
import com.lsm1998.spring.web.annotation.MyRequestMapping;
import com.lsm1998.spring.web.enums.MyRequestMethod;
import test.util.JsonResultUtil;

/**
 * @作者：刘时明
 * @时间：2019/10/16-15:58
 * @说明：一个小测试
 */

@MyController
public class HelloController
{
    @MyRequestMapping(method = MyRequestMethod.GET,value = "has")
    @MyJson
    public Object has()
    {
        return JsonResultUtil.of("hello");
    }
}
