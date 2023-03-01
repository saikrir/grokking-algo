package ds.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();

    @Test
    public void testSelectionSort() {
        int[] aArray = selectionSort.randomIntStream().limit(10).toArray();
        int[] sortedArray = Arrays.copyOf(aArray, aArray.length);
        Arrays.sort(sortedArray);
        assertArrayEquals(selectionSort.selectionSort(aArray), sortedArray);
    }

    @Test
    public void testBinarySearch() {
        int[] sortedArray = selectionSort.randomIntStream().limit(10).sorted().toArray();
        int randomArrIndex = new Random().nextInt(10);
        assertEquals(selectionSort.binarySearch(sortedArray, sortedArray[randomArrIndex]), randomArrIndex);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] sortedArray = selectionSort.randomIntStream().limit(10).sorted().toArray();
        assertEquals(selectionSort.binarySearch(sortedArray, 101), -1);
    }
}
