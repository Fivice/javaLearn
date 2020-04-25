package top.fivice.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton_1 = Singleton.getInstance();

        Singleton singleton_2 = Singleton.getInstance();
        singleton_1.setName("wubin");
        System.out.println(singleton_1);
        System.out.println(singleton_2);

        System.out.println(singleton_1.getName());
        System.out.println(singleton_2.getName());
    }

}
class Singleton {
    private static Singleton instance;
    private String name;

    private Singleton(){}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
