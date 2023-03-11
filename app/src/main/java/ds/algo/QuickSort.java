package ds.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static ds.algo.common.ArrayUtils.*;

public class QuickSort {

    public static List<Integer> qSort(List<Integer> inputArray) {

        if (inputArray.size() < 2) { //Base Case
            return inputArray;
        }

        int pivotElement = inputArray.get(inputArray.size() / 2);
        List<Integer> smallerElements = new ArrayList<>(inputArray.size());
        List<Integer> largerElements = new ArrayList<>(inputArray.size());
        for (int i = 0; i < inputArray.size(); i++) {
            int currentElement = inputArray.get(i);
            if (currentElement == pivotElement)
                continue;

            boolean x = currentElement > pivotElement ? largerElements.add(currentElement)
                            : smallerElements.add(currentElement);
        }
        return merge(qSort(smallerElements), pivotElement, qSort(largerElements));
    }

    protected static List<Integer> merge(List<Integer> left, Integer pivot, List<Integer> right) {
        List<Integer> retList = new ArrayList<>();
        retList.addAll(left);
        retList.add(pivot);
        retList.addAll(right);
        return retList;
    }

    public static void main(String[] args) {
        List<Integer> arr = listOfSize(10);
        System.out.println("Before Sort");
        printList(arr);
        List<Integer> qSortedList = qSort(arr);
        System.out.println("After Sort");
        printList(qSortedList);
    }
}
