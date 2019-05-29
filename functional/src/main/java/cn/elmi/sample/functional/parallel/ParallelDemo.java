package cn.elmi.sample.functional.parallel;

import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ParallelDemo {

    public static final int N = 1000000000;
    public static final Random random = new Random();

    public static Map<Integer, Double> parallelDiceRolls(int times) {
        double fraction = 0.000000001;
        return IntStream.range(0, times)
                .parallel()
                .mapToObj(x -> random.nextInt(6))
                .collect(groupingBy(x -> x, summingDouble(n -> fraction)));
    }

    public static Map<Integer, Double> sequenceDiceRolls(int times) {
        double fraction = 0.000000001;
        return IntStream.range(0, times)
                .mapToObj(x -> random.nextInt(6))
                .collect(groupingBy(x -> x, summingDouble(n -> fraction)));
    }

    public static void main(String[] args) {

        long begin = System.currentTimeMillis();
        System.out.println(sequenceDiceRolls(N));
        long parallelEnd = System.currentTimeMillis();
        System.out.println(parallelEnd - begin);

        System.out.println(parallelDiceRolls(N));
        long sequenceEnd = System.currentTimeMillis();
        System.out.println(sequenceEnd - parallelEnd);


    }

}
