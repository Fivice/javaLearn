package top.fivice.singleton;


/**
 * 静态内部类
 */
public class Singleton_5 {
    private static int count;
    private static class LazyHolder{
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    public Singleton_5() {
        System.out.println("Singleton_5第"+(++count)+"次实例化");
    }
    public static Singleton_5 getInstance() {
        return LazyHolder.INSTANCE;
    }

}
class TestSingleton_5 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton_5 singleton_5 = Singleton_5.getInstance();
            }).start();
        }
    }
}
