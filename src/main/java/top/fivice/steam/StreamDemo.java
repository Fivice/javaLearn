package top.fivice.steam;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        stringStream.forEach(System.out::println);
        Stream<String> stream2 = Arrays.asList("X", "Y", "Z").stream();
    }
}

class NatureSupplier implements Supplier<Integer>{

    @Override
    public Integer get() {
        return null;
    }
}