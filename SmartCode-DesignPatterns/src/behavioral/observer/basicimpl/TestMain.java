package behavioral.observer.basicimpl;


/**
 *
 * 测试类
 *
 * Created by wangdongdong on 17/7/14.
 */
public class TestMain {

    public static void main(String[] args) {
        Coder 马化腾 = new Coder("马化腾");
        Coder 李彦宏 = new Coder("李彦宏");
        Coder 周鸿祎 = new Coder("周鸿祎");

        DevTechBBS devTechBBS = new DevTechBBS();
        devTechBBS.addObserver(马化腾);
        devTechBBS.addObserver(李彦宏);
        devTechBBS.addObserver(周鸿祎);

        devTechBBS.postNewPublication("关于人工智能不得不说的事儿！男默女泪！");

        /* 输出
        观察者 Coder name:周鸿祎, 被观察者发布的变化: 关于人工智能不得不说的事儿！男默女泪！
        观察者 Coder name:李彦宏, 被观察者发布的变化: 关于人工智能不得不说的事儿！男默女泪！
        观察者 Coder name:马化腾, 被观察者发布的变化: 关于人工智能不得不说的事儿！男默女泪！
         */
    }
}
