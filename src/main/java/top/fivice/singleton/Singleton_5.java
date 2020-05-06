package top.fivice.singleton;


import java.util.logging.Logger;

public class Singleton_5 {

    private static class LazyHolder{
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    public Singleton_5() {
        System.out.println("Singleton_5()构造函数");
    }
    public static final Singleton_5 getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        //Singleton_5 singleton1 = Singleton_5.getInstance();
        //Singleton_5 singleton2 = Singleton_5.getInstance();
        //System.out.println(singleton1);
        //System.out.println(singleton2);
    }
}
