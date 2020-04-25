package top.fivice.thread;

import java.time.LocalTime;

/**
 * 守护线程
 */
public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("DaemonThreadDemo.main exit");
        }));
        Thread t = new TimerThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(4000);
    }
}
class TimerThread extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}