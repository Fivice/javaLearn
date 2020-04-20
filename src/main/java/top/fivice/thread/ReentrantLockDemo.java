package top.fivice.thread;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        Thread t1 = new Thread(()->{
            for (var i=0;i<10;i++){
                taskQueue.addTask("t1-"+i);
            }
        });
        Thread t2 = new Thread(()->{
            for (var i=0;i<10;i++){
                taskQueue.getTask();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(taskQueue.toString());
    }
}
class TaskQueue{
    Queue<String> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    public void addTask(String s){
        try{
            lock.lock();
            System.out.println("添加任务："+s);
            this.queue.add(s);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public String getTask(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                System.out.println("空任务队列等待...");
                condition.await();
            }
            System.out.println("获取任务："+queue.peek());
            return queue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}