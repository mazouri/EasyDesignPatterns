package creational.singleton;

/**
 * 枚举的方式，即使反序列化时也不会重新创建对象
 *
 * 实现单例的核心在于private私有化类中的构造方法，在枚举中的构造方法必须是私有的，这就为枚举来实现单例奠定了基础。
 *
 * Created by wangdongdong on 17/7/13.
 */
public enum  EnumSingleton {
    INSTANCE;    //public static final creational.singleton.EnumSingleton INSTANCE;
    public void doSomethiing() {

    }
}
