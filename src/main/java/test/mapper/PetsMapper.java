package test.mapper;

import com.lsm1998.ibatis.annotation.MyParam;
import com.lsm1998.ibatis.annotation.MySelect;
import test.domain.Pets;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:45
 * @说明：
 */
public interface PetsMapper
{
    //@MySelect("select id,name,info,img from boot_pets")
    @MySelect("select * from boot_pets")
    List<Pets> getSimplePetsAll();

    @MySelect("select * from boot_pets where id=#{id}")
    Pets getPetsById(@MyParam("id") Long id);
}
