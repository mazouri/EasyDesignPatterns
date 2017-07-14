package creational.singleton;

/**
 * Created by wangdongdong on 17/7/12.
 */
public class LazySingletonSafe {
    private static LazySingletonSafe sInstance;
    private LazySingletonSafe(){}

    public static synchronized LazySingletonSafe getInstance() {
        if (sInstance == null) {
            sInstance = new LazySingletonSafe();
        }
        return sInstance;
    }
}
