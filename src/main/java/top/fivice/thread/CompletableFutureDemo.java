package top.fivice.thread;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

/**
 * 异步编程
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        //任务一 订购航班
        CompletableFuture<String> orderAirplane = CompletableFuture.supplyAsync(()->{
            System.out.println("查询航班信息");
            try {
                Thread.sleep(1000);
                System.out.println("订购航班");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "航班信息";
        });
        //任务二 订购酒店
        CompletableFuture<String> orderHotel = CompletableFuture.supplyAsync(()->{
            System.out.println("查询酒店信息");
            try {
                Thread.sleep(1000);
                System.out.println("订购酒店");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "酒店信息";
        });
        //任务三 订购出租车 ，必须任务一二都玩成才能执行
        CompletableFuture<String> orderCar = orderHotel.thenCombine(orderAirplane,(airplane,hotel)->{
            System.out.println("航班："+airplane);
            System.out.println("酒店："+hotel);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "租车信息";
        });

        System.out.println(orderCar.join());
    }

}
