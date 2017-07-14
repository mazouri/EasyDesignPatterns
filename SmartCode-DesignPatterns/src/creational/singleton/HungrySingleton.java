package creational.singleton;

/**
 * 饿汉单例模式
 * <p>
 * Created by wangdongdong on 17/7/12.
 */
public class HungrySingleton {
    private static HungrySingleton sInstance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return sInstance;
    }

    public int getOne() {
        return 1;
    }
}
