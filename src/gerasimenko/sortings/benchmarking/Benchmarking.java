package gerasimenko.sortings.benchmarking;

import gerasimenko.sortings.benchmarking.algorithms.AbstractSort;
import gerasimenko.sortings.benchmarking.algorithms.InsertionSort;
import gerasimenko.sortings.benchmarking.algorithms.SelectionSort;
import gerasimenko.sortings.benchmarking.utils.RandomArray;
import gerasimenko.sortings.benchmarking.utils.SortTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Benchmarking {


    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(1000, 300000);
        long[] testData = randomArray.getRandomArray();

        ArrayList<AbstractSort> sortAlgorithms = new ArrayList<AbstractSort>();
        sortAlgorithms.add(new InsertionSort());
        sortAlgorithms.add(new SelectionSort());

        long[] sortedTestData;
        System.out.println(RandomArray.getStringPresentation(testData));

        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            SortTest.testNonSorted(testData);
            sortedTestData = sortAlgorithm.sort(testData);
            SortTest.testNonDecreasing(sortedTestData);

            System.out.println(sortAlgorithm.getExecutionTime());
            System.out.println(RandomArray.getStringPresentation(sortedTestData));
        }

    }
}
