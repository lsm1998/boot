package test.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @作者：刘时明
 * @时间：2019/1/12-15:01
 * @说明：
 */
public class JsonResultUtil
{
    private static Map<String,Object> map=new ConcurrentHashMap<>();
    private static Lock lock=new ReentrantLock();

    public static Map<String,Object> susses(int code,String susses)
    {
        try
        {
            lock.lock();
            map.clear();
            map.put("code",code);
            map.put("susses",susses);
            return map;
        }finally
        {
            lock.unlock();
        }
    }

    public static Map<String,Object> error(int code,String error)
    {
        try
        {
            lock.lock();
            map.clear();
            map.put("code",code);
            map.put("error",error);
            return map;
        }finally
        {
            lock.unlock();
        }
    }

    public static Map<String,Object> of(Object data)
    {
        try
        {
            lock.lock();
            map.clear();
            map.put("data",data);
            return map;
        }finally
        {
            lock.unlock();
        }
    }

    public static Map<String,Object> of(int code,String susses,String error)
    {
        try
        {
            lock.lock();
            map.clear();
            map.put("code",code);
            map.put("susses",susses);
            map.put("error",error);
            return map;
        }finally
        {
            lock.unlock();
        }
    }

    public static Map<String,Object> of(int code, String susses,Object data)
    {
        try
        {
            lock.lock();
            map.clear();
            map.put("code",code);
            map.put("susses",susses);
            map.put("data",data);
            return map;
        }finally
        {
            lock.unlock();
        }
    }
}
