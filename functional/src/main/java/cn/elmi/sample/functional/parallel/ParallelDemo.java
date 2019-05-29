package cn.elmi.sample.functional.parallel;

import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ParallelDemo {

    public static final int N = 100000000;

    public static Map<Integer, Double> parallelDiceRolls(int times) {
        double fraction = 0.00000001;
        return IntStream.range(0, times)
                .parallel()
                .mapToObj(x -> new Random().nextInt(6))
                .collect(groupingBy(x -> x, summingDouble(n -> fraction)));
    }

    public static void main(String[] args) {
        System.out.println(parallelDiceRolls(N));
    }


}
