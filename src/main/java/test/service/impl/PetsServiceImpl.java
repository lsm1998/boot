package test.service.impl;

import com.lsm1998.ibatis.session.MySqlSession;
import com.lsm1998.ibatis.session.MySqlSessionFactory;
import com.lsm1998.spring.beans.annotation.MyAutowired;
import com.lsm1998.spring.beans.annotation.MyService;
import test.domain.Pets;
import test.mapper.PetsMapper;
import test.service.PetsService;

import java.util.List;

/**
 * @作者：刘时明
 * @时间：2019/1/13-11:49
 * @说明：
 */
@MyService
public class PetsServiceImpl implements PetsService
{
    @MyAutowired
    private MySqlSessionFactory sessionFactory;

    @Override
    public List<Pets> getSimplePetsAll()
    {
        MySqlSession sqlSession=sessionFactory.openSession();
        PetsMapper petsMapper=sqlSession.getMapper(PetsMapper.class);
        List<Pets> result=petsMapper.getSimplePetsAll();
        sqlSession.close();
        return result;
    }

    @Override
    public Pets getPetsById(Long id)
    {
        MySqlSession sqlSession=sessionFactory.openSession();
        PetsMapper petsMapper=sqlSession.getMapper(PetsMapper.class);
        Pets result=petsMapper.getPetsById(id);
        sqlSession.close();
        return result;
    }
}
