package behavioral.singleton;

/**
 * Created by wangdongdong on 17/7/12.
 */
public class LazySingletonNotSafe {
    private static LazySingletonNotSafe sInstance;

    private LazySingletonNotSafe() {
    }

    public static LazySingletonNotSafe getInstance() {
        if (sInstance == null) {
            sInstance = new LazySingletonNotSafe();
        }
        return sInstance;
    }

    public int getOne() {
        return 1;
    }
}


