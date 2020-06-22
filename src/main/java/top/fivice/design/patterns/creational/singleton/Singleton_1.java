package top.fivice.design.patterns.creational.singleton;


/**
 * 懒汉模式
 * @author wubin
 */
public class Singleton_1 {
    private static int count;
    private static Singleton_1 singleton_1 = null;

    private Singleton_1(){
        System.out.println("Singleton_1第"+(++count)+"次实例化");
    }

    public static Singleton_1 getSingleton(){
        if (singleton_1==null){
            singleton_1 = new Singleton_1();
        }
        return singleton_1;
    }


}
class TestSingleton_1 {
    public static void main(String[] args) {
        //验证懒汉模式不安全
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton_1 singleton_1 = Singleton_1.getSingleton();
            }).start();
        }
    }
}
