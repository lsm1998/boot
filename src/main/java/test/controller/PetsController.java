package test.controller;

import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.web.annotation.MyController;
import com.lsm1998.spring.web.annotation.MyJson;
import com.lsm1998.spring.web.annotation.MyRequestMapping;
import com.lsm1998.spring.web.annotation.MyRequestParam;
import test.service.PetsService;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:50
 * @说明：
 */
@MyController
@MyRequestMapping("pets")
public class PetsController
{
    @MyAutowired
    private PetsService petsService;

    @MyRequestMapping("get")
    @MyJson
    public Object get()
    {
        return petsService.getSimplePetsAll();
    }

    @MyRequestMapping("info")
    @MyJson
    public Object info(@MyRequestParam("id") Long id)
    {
        return petsService.getPetsById(id);
    }
}
