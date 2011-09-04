package gerasimenko.sortings.benchmarking;

import gerasimenko.sortings.benchmarking.algorithms.*;
import gerasimenko.sortings.benchmarking.utils.ArrayGenerator;
import gerasimenko.sortings.benchmarking.utils.SortTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Benchmarking {
    public static final int ARRAY_SIZE = 1000000;
    public static final int RANGE = 300000;

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator(ARRAY_SIZE, RANGE);
        long[] sortedTestData;
        long[] testRandomData = arrayGenerator.getRandomArray();
//        long[] testRandomData = arrayGenerator.getNonDecreasingArray();
//        long[] testRandomData = arrayGenerator.getNonIncreasingArray();

        ArrayList<AbstractSort> sortAlgorithms = new ArrayList<AbstractSort>();
//        sortAlgorithms.add(new InsertionSort());
//        sortAlgorithms.add(new SelectionSort());
//        sortAlgorithms.add(new BubbleSort());
        sortAlgorithms.add(new MergeSortRecursive());
        sortAlgorithms.add(new MergeSortNonRecursive());
        sortAlgorithms.add(new JavaSDKSort());


//        System.out.println(ArrayGenerator.getStringPresentation(testRandomData));

        System.out.println("Array Size: " + ARRAY_SIZE);
        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            SortTest.testNonSorted(testRandomData);
            sortedTestData = sortAlgorithm.sort(testRandomData);
            SortTest.testNonDecreasing(sortedTestData);

            System.out.printf("%,20d ns.", sortAlgorithm.getExecutionTime());
            System.out.print(" - " + sortAlgorithm.getSortingName());
            System.out.println();
//            System.out.println(ArrayGenerator.getStringPresentation(sortedTestData));
        }

    }
}
