package test.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/1/12-15:01
 * @说明：
 */
public class JsonResultUtil
{
    public static Map<String, Object> susses(int code, String susses)
    {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("susses", susses);
        return map;
    }

    public static Map<String, Object> error(int code, String error)
    {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("error", error);
        return map;
    }

    public static Map<String, Object> of(Object data)
    {
        Map<String, Object> map = new HashMap();
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> of(int code, String susses, String error)
    {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("susses", susses);
        map.put("error", error);
        return map;
    }

    public static Map<String, Object> of(int code, String susses, Object data)
    {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("susses", susses);
        map.put("data", data);
        return map;
    }
}
