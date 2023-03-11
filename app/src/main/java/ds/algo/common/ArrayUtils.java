package ds.algo.common;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayUtils {
    private static Random random = new Random();

    protected static IntStream randomIntStream() {
        return Stream.generate(() -> random.nextInt(100))
                .distinct()
                .mapToInt(Integer::intValue);
    }

    public static void printArray(int[] aIntegers) {
        System.out.print("{");
        for (int i = 0; i < aIntegers.length; i++) {
            System.out.print(aIntegers[i]);
            if (aIntegers.length - 1 != i) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void printList(List<Integer> input) {
        Integer[] aIntegers = new Integer[input.size()];
        input.toArray(aIntegers);
        System.out.print("{");
        for (int i = 0; i < aIntegers.length; i++) {
            System.out.print(aIntegers[i]);
            if (aIntegers.length - 1 != i) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
    public static int[] arrayOfSize(int size) {
        return randomIntStream().limit(size).toArray();
    }

    public static List<Integer> listOfSize(int size) {
        return randomIntStream().limit(size).boxed().collect(Collectors.toList());
    }
}
