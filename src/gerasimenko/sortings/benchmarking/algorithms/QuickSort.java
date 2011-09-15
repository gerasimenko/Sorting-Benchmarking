package gerasimenko.sortings.benchmarking.algorithms;

/**
 * Michael Gerasimenko
 * Date: 15.09.11
 * Time: 14:57
 */
public class QuickSort extends AbstractSort {

    long[] b;
    public QuickSort() {
        sortingName = "Quick Sort";
    }

    @Override
    protected long[] sort1(long[] a) {
        b = a;
        quickSort(0, b.length - 1);
        return b;
    }

    private void quickSort(int l, int r) {
        int i = l;
        int j = r;
        long t;
        long pivot = b[(l + r) / 2];
        do {
            while (b[i] < pivot) i++;
            while (b[j] > pivot) j--;
            if (i <= j) {
                t = b[i]; b[i] = b[j]; b[j] = t;
                i++;
                j--;
            }
        } while(i <= j);

        if (l < j) quickSort(l, j);
        if (i < r) quickSort(i, r);
    }
}
