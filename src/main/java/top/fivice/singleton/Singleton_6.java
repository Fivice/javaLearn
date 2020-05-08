package top.fivice.singleton;

public enum Singleton_6 {
    INSTANCE;
    public void whateverMethod() {
        System.out.println("Singleton_6.whateverMethod");
    }
}
class TestSingleton_6{
    public static void main(String[] args) {
        System.out.println(Singleton_6.class.getSuperclass());
        System.out.println(Singleton_6.INSTANCE.getDeclaringClass());

    }
}
