package top.fivice.steam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        Stream<LocalDate> localDate = Stream.generate(new LocalDateSupplier());
        localDate.limit(10)
                .filter(ld->ld.getDayOfWeek() == DayOfWeek.SATURDAY||ld.getDayOfWeek()== DayOfWeek.SUNDAY)
                .forEach(System.out::println);

        Stream<Integer> nature = Stream.generate(new NatureSupplier());
        nature.map(integer -> integer*integer).limit(10).forEach(System.out::println);
    }
}
class NatureSupplier implements Supplier<Integer>{
    int n=0;
    @Override
    public Integer get() {
        return n++;
    }
}
class FbSupplier implements Supplier<Integer>{
    int n = 0;
    @Override
    public Integer get() {
        n++;
        return fb(n);
    }
    //提供斐波那契数
    private Integer fb(Integer n){
        if(n==2||n==1){
            return 1;
        }
        return fb(n-1)+fb(n-2);
    }
}
class LocalDateSupplier implements Supplier<LocalDate>{
    LocalDate start = LocalDate.now();
    int n = 0;
    @Override
    public LocalDate get() {
        return start.plusDays(n++);
    }
}