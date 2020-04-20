package top.fivice.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(()->{

                counter.getCounts();
            });
            thread.start();
            thread.join();
        }
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.inc(i);
            }
        });
        thread.start();
        thread.join();
        System.out.println(Arrays.toString(counter.getCounts()));
    }
}
class Counter{
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock rLock = readWriteLock.readLock();
    private final Lock wLock = readWriteLock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index){
        wLock.lock();
        try{
            counts[index]+=index;
            System.out.println("写入数据-index="+index+":"+counts[index]);
        }finally {
            wLock.unlock();
        }
    }

    public int[] getCounts() {
        rLock.lock();
        try{
            System.out.println("读取数据："+ Arrays.toString(counts));
            return Arrays.copyOf(counts,counts.length);
        }finally {
            rLock.unlock();
        }
    }
}
