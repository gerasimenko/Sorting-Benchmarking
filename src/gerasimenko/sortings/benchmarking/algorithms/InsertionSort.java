package gerasimenko.sortings.benchmarking.algorithms;


public class InsertionSort extends AbstractSort {

    public InsertionSort() {
        sortingName = "Insertion Sort";
    }

    @Override
    protected long[] sort1(long[] a) {
        for (int i = 1; i < a.length; i++) {
            long key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

}
