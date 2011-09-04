package gerasimenko.sortings.benchmarking.algorithms;

import java.util.Arrays;

/**
 * Michael Gerasimenko
 * Date: 03.09.11
 * Time: 16:10
 */
public class MergeSortRecursive extends AbstractSort{
    long[] b;

    public MergeSortRecursive() {
        sortingName = "Merge Sort Recursive Implementaion";
    }

    @Override
    protected long[] sort1(long[] a) {
        b = a;
        mergeSort(0, b.length - 1);
        return b;
    }

    private void mergeSort(int l, int r) {
        if (l >= r) return;
        int middle = l + (r - l) / 2;

        mergeSort(l, middle);
        mergeSort(middle + 1, r);
        merge(l, middle, r);
    }

    private void merge(int l, int m, int r) {
        if (l >= r) return;
        int leftSize = m - l + 1;
        int rightSize = r - m ;

        long[] left = Arrays.copyOfRange(b, l, l + leftSize + 1);
        left[leftSize] = Long.MAX_VALUE;

        long[] right = Arrays.copyOfRange(b, m + 1, m + rightSize + 2);
        right[rightSize] = Long.MAX_VALUE;

        int leftPointer = 0;
        int rightPointer = 0;
        for (int i = 0; i < leftSize + rightSize; i++) {
            if (left[leftPointer] < right[rightPointer]) {
                b[l + i] = left[leftPointer];
                leftPointer++;
            } else {
                b[l + i] = right[rightPointer];
                rightPointer++;
            }
        }
    }
}
