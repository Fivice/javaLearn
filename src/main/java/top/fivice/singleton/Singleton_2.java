package top.fivice.singleton;

/**
 * 懒汉模式（加锁）
 */
public class Singleton_2 {
    private static int count;
    private static Singleton_2 Singleton_2 = null;

    private Singleton_2(){
        System.out.println("Singleton_2第"+(++count)+"次实例化");
    }

    public static synchronized Singleton_2 getSingleton(){
        if (Singleton_2==null){
            Singleton_2 = new Singleton_2();
        }
        return Singleton_2;
    }
}
class TestSingleton_2 {
    public static void main(String[] args) {
        //验证加锁后的懒汉
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton_2 singleton_2 = Singleton_2.getSingleton();
            }).start();
        }
    }
}
