package gerasimenko.sortings.benchmarking.utils;

import gerasimenko.sortings.benchmarking.exceptions.ArraySortedException;
import gerasimenko.sortings.benchmarking.exceptions.WrongSortException;

public class SortTest {

    public static void testNonDecreasing(long[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) throw new WrongSortException();
        }
    }

    public static void testNonIncreasing(long[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) throw new WrongSortException();
        }
    }

    public static void testNonSorted(long[] a) {
        if (a.length > 50) {
            //search for both kinds of inversions
            boolean decreasing = false;
            boolean increasing = false;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] < a[i]) increasing = true;
                if (a[i - 1] > a[i]) decreasing = true;
            }

            if (!(increasing && decreasing)) throw new ArraySortedException();
        }
    }

}
