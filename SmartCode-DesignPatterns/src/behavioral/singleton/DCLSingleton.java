package behavioral.singleton;

/**
 *
 * 双重检查锁：与安全懒汉的区别；
 *      主要解决安全懒汉使用synchronized带来的效率问题
 *
 * Created by wangdongdong on 17/7/12.
 */
public class DCLSingleton {
    private static volatile DCLSingleton sInstance; //volatile有什么作用？
    private DCLSingleton(){}

    public static DCLSingleton getInstance() {
        if (sInstance == null) {
            synchronized (DCLSingleton.class) {  //synchronized代码块；为什么用类实例锁，类锁与对象锁的区别？
                if (sInstance == null) {
                    sInstance = new DCLSingleton();
                }
            }
        }
        return sInstance;
    }
}


/***************** 满满的知识点 ************************
1.为什么两次判空？以及volatile有什么作用？
答：两次判空，首先代码块中的判空是一定要的，是为了在null的情况下创建实例；
 假如此处不判空，当多个线程想执行代码块时，只能先由一个执行，执行后实例就创建了；
 此时释放锁，另外一个线程持有锁执行代码块，不判空的话，会再次实例化，这样就创建了两个实例。就不是单例了。

 第一次判空是为了避免每次不必要的同步，如果不判空，每次都同步，和安全懒汉模式还有什么区别呢！

 volatile的作用：
 因为使用了synchronized，因此同时执行代码块的只能是一个线程；
         if (sInstance == null) {
            sInstance = new DCLSingleton();
         }
对于一个线程A，当它执行语句sInstance = new DCLSingleton()时，这段代码不是原子性的，它会被编译成多条汇编指令，
 主要做如下三件事：
 （1）给Singleton的实例分配内存
 （2）调用Singleton的构造函数，初始化成员成员
 （3）将sInstance对象指向分配的内存空间（此时sInstance就不是null了）
 但是Java编译器允许乱序执行，步骤（2）和（3）的执行顺序无法保证。
 也就是可能是1-2-3这样执行，也可能是1-3-2这样执行。
 如果是1-3-2这样执行，当sInstance指向分配的内存空间时，sInstance就不是null了，
 假如这时切换到线程B，由于sInstance已经不是null了，因此会直接取走这个sInstance，但是由于A中还没有执行步骤2，肯定要出错

 使用volatile后，可以保证sInstance每次都是从主内存中读取，因此保证DCL单例。

 2.synchronized关键字
 synchronized代码块的执行过程有以下6步：
         1. 获得同步锁；
         2. 清空工作内存；
         3. 从主内存拷贝对象副本到工作内存；
         4. 执行代码(计算或者输出等)；
         5. 刷新主内存数据；
         6. 释放同步锁。

 所以，synchronized既保证了多线程的并发有序性，又保证了多线程的内存可见性。

 ******************************************************/


