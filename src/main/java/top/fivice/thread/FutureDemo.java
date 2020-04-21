package top.fivice.thread;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> task = new Tasks();
        Future<String> future =executorService.submit(task);
        String result = future.get();
        System.out.println(result);
    }

}

class Tasks implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "Hello";
    }
}
