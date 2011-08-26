package gerasimenko.sortings.benchmarking.algorithms;


public class SelectionSort extends AbstractSort {

    public SelectionSort() {
        sortingName = "Selection Sort";
    }

    @Override
    protected long[] sort1(long[] a) {
        for (int i = 0; i < a.length; i++) {
            long min = a[i];
            int minPosition = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minPosition = j;
                }
            }

            long t = a[i];
            a[i] = a[minPosition];
            a[minPosition] = t;

        }

        return a;
    }
}
