package gerasimenko.sortings.benchmarking.algorithms;

/**
 * Michael Gerasimenko
 * Date: 03.09.11
 * Time: 15:57
 */
public class BubbleSort extends AbstractSort {

    public BubbleSort() {
        sortingName = "BubbleSort";
    }

    @Override
    protected long[] sort1(long[] a) {
        long t;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) if (a[i] > a[j]) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        return a;
    }

}

