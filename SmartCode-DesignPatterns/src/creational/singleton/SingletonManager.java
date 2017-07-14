package creational.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例类的容器
 *
 * 在程序的初始，将多个单例类注入到统一的管理类中，使用时通过key获取对应类型的对象
 *
 * (这种方式可以方便我们管理单例类，但是在程序一开始就获取实例，没有实现懒加载，因此)
 *
 * Created by wangdongdong on 17/7/14.
 */
public class SingletonManager {
    private static Map<String, Object> objMap = new HashMap<>();

    public static void registerSingleton(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getSingleton(String key) {
        return objMap.get(key);
    }
}
