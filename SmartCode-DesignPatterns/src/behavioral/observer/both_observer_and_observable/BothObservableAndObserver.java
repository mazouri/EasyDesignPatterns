package behavioral.observer.both_observer_and_observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 即是观察者，又是被观察者
 *
 * Created by wangdongdong on 17/7/14.
 */
class MultA extends Observable implements Observer{

    public void publishSomething(String content) {
        setChanged();
        notifyObservers(content);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}

class MultB extends Observable implements Observer{

    public void publishSomething(String content) {
        setChanged();
        notifyObservers(content);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);

        setChanged();
        notifyObservers("你跟我说的是：" + arg + ", 对吗？");
    }
}

class TestMain {
    public static void main(String[] args) {
        MultA multA = new MultA();
        MultB multB = new MultB();

        multA.addObserver(multB);
        multB.addObserver(multA);

        multA.publishSomething("世界很大，我想去看看");

        //B收到A通知的消息后，立刻通知它的观察者，也就是A，A收到消息

        /*
        世界很大，我想去看看
        你跟我说的是：世界很大，我想去看看, 对吗？
         */
    }
}


