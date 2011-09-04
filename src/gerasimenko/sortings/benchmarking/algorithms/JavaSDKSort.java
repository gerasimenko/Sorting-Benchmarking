package gerasimenko.sortings.benchmarking.algorithms;

import java.util.Arrays;

/**
 * Michael Gerasimenko
 * Date: 03.09.11
 * Time: 20:14
 */
public class JavaSDKSort extends AbstractSort{

    public JavaSDKSort() {
        sortingName = "Java SDK Sort Implementation";
    }

    @Override
    protected long[] sort1(long[] a) {
        Arrays.sort(a);
        return a;
    }
}
