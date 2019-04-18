package test;

import com.lsm1998.spring.aop.annotation.MyEnableAspectJAutoProxy;
import com.lsm1998.springboot.MySpringApplication;
import com.lsm1998.springboot.annotation.MySpringBootApplication;

/**
 * @作者：刘时明
 * @时间：2019/1/10-10:42
 * @说明：启动类
 */
//@MySpringBootApplication(exclude = MybatisAutoconfigure.class)
@MySpringBootApplication
@MyEnableAspectJAutoProxy
public class MyApp
{
    public static void main(String[] args)
    {
        MySpringApplication.run(MyApp.class, args);
    }
}
