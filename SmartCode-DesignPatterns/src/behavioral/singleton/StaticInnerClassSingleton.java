package behavioral.singleton;

/**
 * Created by wangdongdong on 17/7/12.
 */
public class StaticInnerClassSingleton {
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton sInstance = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.sInstance; //外部类可以访问静态内部类的静态成员和静态方法
    }
}
