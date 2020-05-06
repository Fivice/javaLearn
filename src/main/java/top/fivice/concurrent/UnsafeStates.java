package top.fivice.concurrent;

/**
 * 内部可变状态逸出
 */
public class UnsafeStates {
    private String[] states = new String[]{"AK", "AL", "AJ"};

    public String[] getStates() {
        return states;
    }

    @Override
    public String toString() {
        return states[0] + "," + states[1] + "," + states[2];
    }
    public static void main(String[] args) {
        UnsafeStates us = new UnsafeStates();
        System.out.println(us);
        String[] str = us.getStates();
        str[0] = "yangyun";
        System.out.println(us);
    }
}
