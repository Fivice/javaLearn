package top.fivice.design.patterns.creational.singleton;

public enum Singleton_6 {
    INSTANCE(1,"wubin");

    public final Integer n;
    public final String name;
    Singleton_6(Integer n, String name){
        this.n = n;
        this.name = name;
        System.out.println("Singleton_6实例化");
    }
}
class TestSingleton_6{
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
           new Thread(()->{
               Singleton_6 singleton_6 = Singleton_6.INSTANCE;
           }).start();
        }
    }
}
