package top.fivice.singleton;

/**
 * 双检锁
 */
public class Singleton_4 {
    private static volatile Singleton_4 singleton_4;
    private static int count;
    private Singleton_4(){
        System.out.println("Singleton_4第"+(++count)+"次实例化");
    }
    public static Singleton_4 getInstance(){
        if (singleton_4 == null){
            synchronized (Singleton_4.class){
                if (singleton_4 == null){
                    singleton_4 = new Singleton_4();
                }
            }
        }
        return singleton_4;
    }
}
class TestSingleton_4{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton_4 singleton_4 = Singleton_4.getInstance();
            }).start();
        }
    }

}
