package behavioral.observer.basicimpl;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类
 *
 * 需要实现Observer接口的{@link Observer#update(Observable, Object)}方法
 *
 * Created by wangdongdong on 17/7/14.
 */
public class Coder implements Observer {

    public String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者 Coder name:"+ name + ", 被观察者发布的变化: " + arg);
    }
}
