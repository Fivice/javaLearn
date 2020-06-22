package top.fivice.design.patterns.creational.singleton;

/**
 * 饿汉模式
 */
public class Singleton_3 {
    private static final Singleton_3 INSTANCE = new Singleton_3();
    private static int count;
    private Singleton_3() {
        System.out.println("Singleton_3第"+(++count)+"次实例化");
    }

    public static Singleton_3 getInstance(){
        return INSTANCE;
    }
}
class TestSingleton_3{
    public static void main(String[] args) {
        //验证饿汉模式的线程安全性
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                Singleton_3 singleton_3 = Singleton_3.getInstance();
            }).start();
        }
    }
}
