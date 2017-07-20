package behavioral.observer.basicimpl;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 *
 * 继承自Observable，有3个重要方法,如下:
 * {@link Observable#setChanged()},
 * {@link Observable#notifyObservers()}
 * {@link Observable#addObserver(Observer)}
 *
 * 发生变化时要调用setChanged方法，否则没法通知到观察者。
 *
 * Observable和Observer的关系
 *
 * Created by wangdongdong on 17/7/14.
 */
public class DevTechBBS extends Observable {

    public void postNewPublication(String content) {
        setChanged();

        notifyObservers(content);
    }
}
