package gerasimenko.sortings.benchmarking;

import gerasimenko.sortings.benchmarking.algorithms.AbstractSort;
import gerasimenko.sortings.benchmarking.algorithms.BubbleSort;
import gerasimenko.sortings.benchmarking.algorithms.InsertionSort;
import gerasimenko.sortings.benchmarking.algorithms.SelectionSort;
import gerasimenko.sortings.benchmarking.utils.ArrayGenerator;
import gerasimenko.sortings.benchmarking.utils.SortTest;

import java.util.ArrayList;

public class Benchmarking {


    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator(10000, 300000);
        long[] testRandomData = arrayGenerator.getRandomArray();
//        long[] testRandomData = arrayGenerator.getNonDecreasingArray();
//        long[] testRandomData = arrayGenerator.getNonIncreasingArray();

        ArrayList<AbstractSort> sortAlgorithms = new ArrayList<AbstractSort>();
        sortAlgorithms.add(new InsertionSort());
        sortAlgorithms.add(new SelectionSort());
        sortAlgorithms.add(new BubbleSort());

        long[] sortedTestData;
        System.out.println(ArrayGenerator.getStringPresentation(testRandomData));

        for (AbstractSort sortAlgorithm : sortAlgorithms) {
            SortTest.testNonSorted(testRandomData);
            sortedTestData = sortAlgorithm.sort(testRandomData);
            SortTest.testNonDecreasing(sortedTestData);

            System.out.print(sortAlgorithm.getSortingName() + ": ");
            System.out.println(sortAlgorithm.getExecutionTime());
            System.out.println(ArrayGenerator.getStringPresentation(sortedTestData));
        }

    }
}
