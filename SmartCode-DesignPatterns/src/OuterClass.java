/**
 * Created by wangdongdong on 17/7/12.
 */
public class OuterClass {

    /**
     * 普通内部类
     */
    class InnerClass {
        private static age; //普通内部类不能定义静态成员或静态方法， 只有静态内部类才可以
        public String name;
        public static int getAge() { //inner classes cannot have static declarations
            return 20;
        }
    }

    //外部类可以访问静态内部类的私有静态成员和私有静态方法

    /**
     * 静态内部类
     */
    public static class StaticInnerClass {
        public String name;
        private static int age = 10;
        public static int age2 = 11;
        private int h = 110;

        private static String getName() {
            return "mazouri";
        }
    }

    public void innerClassMethod() {
        class MethodInnerClass {
            private int number = 2;
            public int getNumber() {
                return number;
            }
        }
    }

    public void getAge() {
        //普通内部类
        String name = new InnerClass().name;

        //静态内部类
        String staticName = StaticInnerClass.getName();
        int h = StaticInnerClass.h;
        int age3 = StaticInnerClass.age;
    }

}
