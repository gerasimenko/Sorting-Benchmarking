package gerasimenko.sortings.benchmarking.algorithms;

import java.util.Arrays;

/**
 * Michael Gerasimenko
 * Date: 03.09.11
 * Time: 20:54
 */
public class MergeSortNonRecursive extends AbstractSort {
    long[] b;
    public MergeSortNonRecursive() {
        sortingName = "Merge Sort Non Recursive Implementation";
    }

    @Override
    protected long[] sort1(long[] a) {
        b = a;
        int blockSize = 1;
        while (blockSize < b.length) {
            int i = 0;
            int left = 2 * i * blockSize;
            int right = left + blockSize;
            while (right < a.length) {
                merge(left, right - 1, Math.min(right + blockSize - 1, a.length - 1));
                i++;
                left = 2 * i * blockSize;
                right = left + blockSize;
            }
            blockSize *= 2;
        }
        return a;
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
