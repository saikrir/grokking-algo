package ds.algo;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectionSort {
    private Random random = new Random();
    private static final int SIZE = 10;

    protected void printArray(int[] aIntegers) {
        System.out.print("{");
        for (int i = 0; i < aIntegers.length; i++) {
            System.out.print(aIntegers[i]);
            if (aIntegers.length - 1 != i) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    protected int[] selectionSort(int[] aArray) {
        for (int i = 0; i < aArray.length; i++) {
            int smallest = aArray[i];
            int smallestElementIndex = i;
            // Find smallest in reminder of the array
            for (int j = i + 1; j < aArray.length; j++) {
                if (smallest > aArray[j]) {
                    smallest = aArray[j];
                    smallestElementIndex = j;
                }
            }
            int temp = aArray[i];
            aArray[i] = smallest;
            aArray[smallestElementIndex] = temp;
        }

        return aArray;
    }

    protected int binarySearch(int[] aArray, int search) {
        int fIndex = -1;
        int low = 0;
        int high = aArray.length;

        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (search == aArray[mid]) {
                fIndex = mid;
                break;
            } else if (search > aArray[mid]) {
                low = mid;
            } else {
                high = mid + 1;
            }
        }

        return fIndex;
    }

    protected IntStream randomIntStream() {
        return Stream.generate(() -> random.nextInt(100))
                .distinct()
                .mapToInt(Integer::intValue);
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] anArray = selectionSort.randomIntStream().limit(10).toArray();
        System.out.println("Before sort");
        selectionSort.printArray(anArray);
        System.out.println("After Sort");
        selectionSort.printArray(selectionSort.selectionSort(anArray));
        int rIndex = new Random().nextInt(SIZE);
        System.out.printf("Will look for %d ", anArray[rIndex]);
        System.out.println(selectionSort.binarySearch(anArray, anArray[rIndex]));
    }
}
